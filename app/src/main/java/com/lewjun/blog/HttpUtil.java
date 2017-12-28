package com.lewjun.blog;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;


/**
 * 网络工具类
 * Created by LewJun on 2017/12/28.
 */
public class HttpUtil {
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final int TIMEOUT = 5 * 1000;
    private static final String CHARSET = "UTF-8";
    private static final String SERVER_URL = "http://your/api";

    private HttpUtil() {
    }

    /**
     * post 请求
     *
     * @param paramsMap
     * @param typeOfT
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T post(Map<String, String> paramsMap, Type typeOfT) throws Exception {
        String data = joinParams(paramsMap);
        // 打印出请求
        HttpURLConnection connection = getPostConnection();
        connection.setRequestProperty("Content-Length", String.valueOf(data.getBytes().length));
        connection.connect();
        OutputStream os = connection.getOutputStream();
        os.write(data.getBytes());
        os.flush();
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 获取响应的输入流对象
            InputStream is = connection.getInputStream();
            // 创建字节输出流对象
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 定义读取的长度
            int len = 0;
            // 定义缓冲区
            byte[] buffer = new byte[1024];
            // 按照缓冲区的大小，循环读取
            while ((len = is.read(buffer)) != -1) {
                // 根据读取的长度写入到os对象中
                baos.write(buffer, 0, len);
            }
            // 释放资源
            is.close();
            baos.close();
            connection.disconnect();
            // 返回字符串
            final String result = new String(baos.toByteArray());
            // 打印出结果
            System.out.println(result);
            Gson gson = new Gson();
            return gson.fromJson(result, typeOfT);
        } else {
            String responseMessage = connection.getResponseMessage();
            System.out.println("responseMessage: " + responseMessage);
            connection.disconnect();
            throw new IOException(responseCode + ":" + responseMessage);
        }
    }

    /**
     * 获取connection
     *
     * @return HttpURLConnection
     */
    private static HttpURLConnection getPostConnection() {
        HttpURLConnection connection = null;
        // 初始化connection
        try {
            // 根据地址创建URL对象
            URL url = new URL(SERVER_URL);
            // 根据URL对象打开链接
            connection = (HttpURLConnection) url.openConnection();
            // 设置请求的方式
            connection.setRequestMethod(POST);
            // 发送POST请求必须设置允许输入，默认为true
            connection.setDoInput(true);
            // 发送POST请求必须设置允许输出
            connection.setDoOutput(true);
            // 设置不使用缓存
            connection.setUseCaches(false);
            // 设置请求的超时时间
            connection.setReadTimeout(TIMEOUT);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Response-Type", "json");
            connection.setChunkedStreamingMode(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 拼接参数列表
     *
     * @param paramsMap
     * @return
     */
    private static String joinParams(Map<String, String> paramsMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : paramsMap.keySet()) {
            stringBuilder.append(key);
            stringBuilder.append("=");
            try {
                stringBuilder.append(URLEncoder.encode(paramsMap.get(key), CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            stringBuilder.append("&");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
