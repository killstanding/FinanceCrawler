package com.jerry.financecrawler.visitor;

import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class HtmlRequest {

    public byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }catch (IOException ex){
            bos.close();
            throw ex;
        }finally {
            bos.close();
        }
        return bos.toByteArray();
    }

    public  String getHtmlData(String rurl, String charset) throws IOException{
        URL url = new URL(rurl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        InputStream inputStream = null;
        String data = "";
        try{
            inputStream = conn.getInputStream();   //通过输入流获得网站数据
            byte[] getData = readInputStream(inputStream);     //获得网站的二进制数据
            data = new String(getData,charset);
        }catch (IOException ex){
            if(inputStream != null)inputStream.close();
            throw ex;
        }finally {
            if(inputStream != null)inputStream.close();
        }
        return data;
    }

}
