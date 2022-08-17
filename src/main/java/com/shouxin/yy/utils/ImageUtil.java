package com.shouxin.yy.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * 图片操作工具类
 * 把图片加载到内存，给图片 贴图，给图片添加文字
 * @time 2022/8/1 1:49 下午
 * @Author feikong
 */
public class ImageUtil {

    /**
     * 解析本地图片或者http网络图片，并把图片加载到缓冲区
     * @param path 图片路径（本地路径或者网络图片http访问路径）
     * @throws IOException 抛出异常
     */
    public BufferedImage imageIoRead(String path) throws IOException {
        BufferedImage bufferedImage;
        if(path.contains("http")){
            //网络图片
            bufferedImage = ImageIO.read(new URL(path));
        }else{
            //本地图片
            bufferedImage = ImageIO.read(new File(path));
        }
        return bufferedImage;
    }

    /**
     * 给一张图片贴 图片，并生成新图片
     * @param bigPath  底图路径
     * @param smallPath 要贴的图片路径
     * @param outPath  合成输出图片路径
     * @param x 贴图的位置
     * @param y 贴图的位置
     * @param smallWidth 要贴的图片宽度
     * @param smallHeight 要贴的图片高度
     * @throws IOException 抛出io异常
     */
    public void mergeImage( String bigPath,
                            String smallPath,
                            String outPath,
                            String x,
                            String y,
                            int smallWidth,
                            int smallHeight ) throws IOException {
        try {
            //加载图片
            BufferedImage small = imageIoRead(smallPath);
            BufferedImage big = imageIoRead(bigPath);
            //得到2d画笔对象
            Graphics2D g = big.createGraphics();
            float fx = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int x_i = (int)fx;
            int y_i = (int)fy;
            g.drawImage(small, x_i, y_i,smallWidth,smallHeight, null);
            g.dispose();
            //输出图片
            ImageIO.write(big, "png", new File(outPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向画布上写多行文字文字，自动居中
     * @param filePath    原图路径
     * @param text        要添加的文字
     * @param outPath     输出图片路径
     * @param font        字体
     * @param x           坐标X
     * @param y           坐标y
     * @param color       字体颜色
     * @param fontheight  字体高度
     * @param maxWeight   每行字体最大宽度
     * @param center      是否居中
     * @param rate 		   字体间距
     * @return int  写了几行字
     */
    public int drawTextInImg( String filePath,
                              String text,
                              String outPath,
                              Font font,
                              int x,
                              int y,
                              Color color,
                              int maxWeight,
                              int fontheight,
                              boolean center,
                              double rate) {
        int row = 0;
        try {
            //图片加载到缓冲区
            BufferedImage bimage = imageIoRead(filePath);
            //得到2d画笔对象
            Graphics2D g = bimage.createGraphics();
            //设置填充颜色
            g.setPaint(color);
            //设置字体
            g.setFont(font);
            //调用写写文字方法
            row = drawString(g,font,text, x, y,maxWeight,fontheight,center,rate);
            g.dispose();
            //输出图片
            FileOutputStream out = new FileOutputStream(outPath);
            ImageIO.write(bimage, "png", out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
     * 写文字
     * @param g				2d画笔对象
     * @param font			字体
     * @param text			要添加的文字
     * @param x				坐标X
     * @param y				坐标y
     * @param maxWidth		每行字体最大宽度
     * @param height		字体高度
     * @param center		是否居中
     * @param rate			字体间距
     * @return int 写了几行字
     */
    public int drawString( Graphics2D g ,
                           Font font ,
                           String text ,
                           int x ,
                           int y ,
                           int maxWidth,
                           int height,
                           boolean center,
                           double rate) {
        int row = 1;
        JLabel label = new JLabel(text);
        label.setFont(font);
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int textH = height; //metrics.getHeight();
        int textW = metrics.stringWidth(label.getText()); //字符串的宽
        String tempText = text;
        //如果字符串长度大于最大宽度，执行循环
        while(textW > maxWidth) {
            int n = textW / maxWidth;
            int subPos = tempText.length() / n;
            String drawText = tempText.substring(0 , subPos);
            int subTxtW = metrics.stringWidth(drawText);
            while(subTxtW > maxWidth) {
                subPos--;
                drawText = tempText.substring(0 , subPos);
                subTxtW = metrics.stringWidth(drawText);
            }
            //g.drawString(drawText, x, y);  //不调整字体间距
            MyDrawString(drawText , x , y, rate, g);
            y += textH;
            textW = textW - subTxtW;
            tempText = tempText.substring(subPos);
            row++;
        }
        //居中
        if(center) {
            x = x + (maxWidth - textW) / 2;
        }
        //g.drawString(tempText, x, y);  //不调整字体间距
        MyDrawString(tempText , x , y, rate, g);
        return row;
    }

    /**
     * 一个字一个字写，控制字体间距
     * @param str 	要添加的文字
     * @param x 	坐标x
     * @param y 	坐标y
     * @param rate 	字体间距
     * @param g 	画笔
     */
    public void MyDrawString(String str,int x,int y,double rate,Graphics2D g){
        String tempStr= "";
        int orgStringWight = g.getFontMetrics().stringWidth(str);
        int orgStringLength = str.length();
        int tempx=x;
        int tempy=y;
        while(str.length()>0)
        {
            tempStr=str.substring(0, 1);
            str=str.substring(1, str.length());
            g.drawString(tempStr, tempx, tempy);
            tempx=(int)(tempx+(double)orgStringWight/(double)orgStringLength*rate);
        }
    }
}
