package com.shouxin.yy.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.XML;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wang.jingyu
 * @date 2018年10月20日下午1:17:47
 */
@Slf4j
public class HttpClientUtils {

    static PoolingHttpClientConnectionManager manager = null;

    static CloseableHttpClient httpClient = null;

    public static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            // 注册访问协议相关的Socket工厂
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", SSLConnectionSocketFactory.getSystemSocketFactory()).build();
            // HttpConnnection工厂:配置写请求/解析响应处理器
            HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                    DefaultHttpRequestWriterFactory.INSTANCE, DefaultHttpResponseParserFactory.INSTANCE);
            // DNS解析器
            DnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;
            // 创建池化连接管理器
            manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry, connFactory, dnsResolver);
            // 默认Socket配置
            SocketConfig defaultSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
            manager.setDefaultSocketConfig(defaultSocketConfig);
            // 设置整个连接池的最大数
            manager.setMaxTotal(1000);
            // 每个路由的默认最大连接，每个路由实际最大连接数默认为DafaultMaxPerRoute控制，而MaxRoute是控制整个池子最大数
            // 设置过小无法支持大并发(ConnectionPoolTimeoutException:Timeout waiting for connection
            // from pool)
            // 路由是对maxTotal的细分
            manager.setDefaultMaxPerRoute(1000);
            // 在从连接池获取连接时，连接不活跃多长时间后需要进行一次验证，默认为2s
            manager.setValidateAfterInactivity(5000);
            // 默认请求配置
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    // 设置连接超时时间
                    .setConnectionRequestTimeout(2000)
                    // 设置等待数据超时时间
                    .setSocketTimeout(45000)
                    // 设置从连接池获取连接的等待超时时间
                    .setConnectionRequestTimeout(2000).build();
            // 创建HttpClient
            httpClient = HttpClients.custom().setConnectionManager(manager)
                    // 连接池不是共享模式
                    .setConnectionManagerShared(false)
                    // 定期回收空闲连接
                    .evictIdleConnections(60, TimeUnit.SECONDS)
                    // 定期回收过期连接
                    .evictExpiredConnections()
                    // 连接存活时间，如果不设置，则根据长连接信息决定
                    .setConnectionTimeToLive(60, TimeUnit.SECONDS)
                    // 设置默认请求配置
                    .setDefaultRequestConfig(defaultRequestConfig)
                    // 连接重用策略,即是否能keepAlive
                    .setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)
                    // 长连接配置,即获取长连接生产多长时间
                    .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                    // 设置重试次数,默认是3次;当前是禁用掉,可根据需要开启
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true)).build();
            // JVM停止或重启时,关闭连接池释放掉连接
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        httpClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return httpClient;
    }

    public static JSONObject invokePostWithFormData(String url, Map<String, Object> paramsMap) {
        log.info("请求三方接口 url: {}, 参数：{}", url, JSON.toJSONString(paramsMap));
        JSONObject json = new JSONObject();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
            response = getHttpClient().execute(post);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
            log.info("请求三方接口 返回: {}", json);
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    log.error("请求三方接口失败: url: {}, 参数：{}, 原因: {}", url, JSON.toJSONString(paramsMap), e.getMessage());
                }
            }
        }
        return json;
    }

    public static JSONObject invokePostWithUrlParam(String url, Map<String, String> paramsMap) {
        JSONObject json = new JSONObject();
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpPost post = new HttpPost(builder.build());
            response = getHttpClient().execute(post);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    public static byte[] invokeGetMethodWithMap(String url, Map<String, String> paramsMap) {
        byte[] fileBytes = null;
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpGet get = new HttpGet(builder.build());
            response = getHttpClient().execute(get);
            InputStream inputStream = response.getEntity().getContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024 * 10];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            fileBytes = byteArrayOutputStream.toByteArray();
            inputStream.close();
            byteArrayOutputStream.close();
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileBytes;
    }

    public static byte[] invokeGetMethodWithOutMap(String url) {
        byte[] fileBytes = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet get = new HttpGet(url);
            response = getHttpClient().execute(get);
            System.out.println(JSONObject.toJSONString(response));
            InputStream inputStream = response.getEntity().getContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024 * 10];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            fileBytes = byteArrayOutputStream.toByteArray();
            inputStream.close();
            byteArrayOutputStream.close();
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileBytes;
    }

    /**
     * 发送GET请求
     *
     * @param url
     *            目的地址
     * @return 远程响应结果
     */
    public static byte[] sendGet(String url) {
        try(ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            // 创建URL对象
            URL connURL = new URL(url);
            // 打开URL连接(建立了一个与服务器的tcp连接,并没有实际发送http请求！)
            URLConnection urlConnection=connURL.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
            // 设置通用请求属性(如果已存在具有该关键字的属性，则用新值改写其值。)
            httpConn.setRequestProperty("Host","booleandata.cn");
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 建立实际的连接(远程对象变为可用。远程对象的头字段和内容变为可访问)
            httpConn.connect();
            // 响应头部获取
            log.info("sendGet response : {}",httpConn.getResponseCode());
            InputStream stream = httpConn.getInputStream();
            byte[] buffer = new byte[1024*4];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            return output.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get url 参数
     *
     * @param url       url
     * @param paramsMap 参数映射
     * @return {@code JSONObject}
     */
    public static JSONObject invokeGetWithMap(String url, Map<String, String> paramsMap) {
        JSONObject json = new JSONObject();
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpGet get = new HttpGet(builder.build());
            response = getHttpClient().execute(get);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    log.error("invokeGetWithMap error: {}", e.toString());
                }
            }
        }
        return json;
    }

    public static JSONObject invokePostWithMap(String url, Map<String, Object> paramsMap) {
        JSONObject json = new JSONObject();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(paramsMap), "UTF-8");
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            post.setEntity(stringEntity);
            response = getHttpClient().execute(post);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    public static JSONObject invokeWithXml(String urlStr, String params, String type) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(type);
            conn.setRequestProperty("Content-type", "application/xml");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");

            // 当outputStr不为null时向输出流写数据
            if (null != params) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(params.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            conn.disconnect();
        } catch (ConnectException ce) {
            log.error("http xml 连接超时: {}", ce.toString());
        } catch (Exception e) {
            log.error("http xml 连接异常: {}", e.toString());
        }
        log.info("http xml 返回结果: {}", buffer.toString());

        cn.hutool.json.JSONObject jsonObject = XML.toJSONObject(buffer.toString());

        return JSONObject.parseObject(jsonObject.toString());
    }

    public static JSONObject invokeGetWithHeader(String url, Map<String, String> paramsMap,Map<String,String> headerMap) {
        JSONObject json = new JSONObject();
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if (!CollectionUtils.isEmpty(paramsMap)) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpGet get = new HttpGet(builder.build());
            if (!CollectionUtils.isEmpty(paramsMap)) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    get.setHeader(entry.getKey(),entry.getValue());
                }
            }
            response = getHttpClient().execute(get);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    public static JSONObject invokePostWithMapAndFile(String url, Map<String, Object> paramsMap, File file) {
        JSONObject json = new JSONObject();
        HttpPost post = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.setCharset(Consts.UTF_8);
        builder.setContentType(ContentType.MULTIPART_FORM_DATA);
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            builder.addTextBody(entry.getKey(), entry.getValue().toString(), ContentType.TEXT_PLAIN);
        }
        if (paramsMap.containsKey("motions") && null != file) {
            builder.addBinaryBody("liveness_data_file", file);
        } else if (!paramsMap.containsKey("motions")){
            builder.addBinaryBody("file", file);
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(builder.build());
            response = getHttpClient().execute(post);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    public static JSONObject invokePostWithIdcardCredit(String url, Map<String, String> paramsMap) {
        log.info("请求三方接口 url: {}", url);
        log.info("请求三方接口 请求参数: {}", paramsMap);
        JSONObject json = new JSONObject();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
            response = getHttpClient().execute(post);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            log.info("请求三方接口 返回结果: {}", json);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            log.error("请求三方接口 错误: {}", ex.getMessage());
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    log.error("请求三方接口 错误: {}", e.getMessage());
                }
            }
        }
        return json;
    }

    public static String invokePostFormString(String url, Map<String, String> paramsMap) {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        String result = "";
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpPost post = new HttpPost(builder.build());
            response = getHttpClient().execute(post);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static JSONObject invokePostWithMap(String url, Map<String, Object> paramsMap, Map<String,String> headerMap) {
        JSONObject json = new JSONObject();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(paramsMap), "UTF-8");
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            post.setEntity(stringEntity);
            //增加header
            if (CollectionUtil.isNotEmpty(headerMap)) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    post.addHeader(entry.getKey(),entry.getValue());
                }
            }
            response = getHttpClient().execute(post);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            json = JSONObject.parseObject(result);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                EntityUtils.consume(response.getEntity());
            }
        } catch (Exception ex) {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    /**
     *
     * @param url
     * @return
     */
    public static String httpGetRequest(String url) {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static String getResult(HttpRequestBase request) {
        CloseableHttpClient httpClient = getHttpClient();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                response.close();
                return result;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return "";
    }
}