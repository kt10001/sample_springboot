package com.shouxin.yy;

import com.alibaba.fastjson.JSONObject;
import com.shouxin.yy.exception.WorkingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author feikong
 * @time 2024/1/3 14:11
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class LogController {

    @RequestMapping(value = "/log/upload", method = RequestMethod.POST)
    public ApiResponse<Void> logUpload(@RequestParam("file") MultipartFile multipartFile) {
        File file = transToFile(multipartFile);
        readLog(file);
        return ApiResponse.success();
    }

    public void readLog(File file) {
        try {
            //BufferedReader是可以按行读取文件
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while((str = bufferedReader.readLine()) != null)
            {
                log.info(str);
            }

            //close
            inputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            throw new WorkingException(RespEnum.SW_RESP_CODE_SYSTEM_ERROR.getCode());
        }

    }

    public File transToFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String[] split = fileName.split("\\.");
        String fileFormat = split[split.length-1];
        // 上传oss备份
        if (!"log".equals(fileFormat)) {
            // 解压
            log.info("解压");
        }
        File file = new File("/tmp/" + fileName);
        try {
            multipartFile.transferTo(file);
        } catch (Exception e) {
            log.error("MultipartFile 转换成 File 失败。");
            throw new WorkingException(RespEnum.SW_RESP_CODE_SYSTEM_ERROR.getCode(), "文件读取失败，请重试。");
        }
        return file;
    }
}
