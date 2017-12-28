package com.lewjun.blog;

import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口测试类
 * Created by LewJun on 2017/12/28.
 */
public class ApiUnitTest {

    @Test
    public void test_list() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("reqmethod", "list");

        Type type = new TypeToken<ResponseInfo<List<BlogEntity>>>() {
        }.getType();
        try {
            ResponseInfo<List<BlogEntity>> responseInfo = HttpUtil.post(paramsMap, type);
            if (responseInfo.isSuccess()) {
                List<BlogEntity> blogEntityList = responseInfo.getData();
                for (BlogEntity blogEntity : blogEntityList) {
                    System.out.println(blogEntity);
                }
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("SocketTimeoutException -------> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException -------> " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Other Exception -------> " + e.getMessage());
        }
    }

    @Test
    public void test_get() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("reqmethod", "get");

        Type type = new TypeToken<ResponseInfo<BlogEntity>>() {
        }.getType();
        try {
            ResponseInfo<BlogEntity> responseInfo = HttpUtil.post(paramsMap, type);
            if (responseInfo.isSuccess()) {
                BlogEntity blogEntity = responseInfo.getData();
                System.out.println(blogEntity);

            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("SocketTimeoutException -------> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException -------> " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Other Exception -------> " + e.getMessage());
        }
    }

    @Test
    public void test_add() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("reqmethod", "add");

        Type type = new TypeToken<ResponseInfo<Integer>>() {
        }.getType();
        try {
            ResponseInfo<Integer> responseInfo = HttpUtil.post(paramsMap, type);
            if (responseInfo.isSuccess()) {
                Integer id = responseInfo.getData();
                System.out.println(id);
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("SocketTimeoutException -------> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException -------> " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Other Exception -------> " + e.getMessage());
        }
    }

    @Test
    public void test_update() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("reqmethod", "update");

        Type type = new TypeToken<ResponseInfo<Void>>() {
        }.getType();
        try {
            ResponseInfo<Void> responseInfo = HttpUtil.post(paramsMap, type);
            if (responseInfo.isSuccess()) {
                String errmsg = responseInfo.getErrmsg();
                System.out.println(errmsg);
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("SocketTimeoutException -------> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException -------> " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Other Exception -------> " + e.getMessage());
        }
    }

    @Test
    public void test_delete() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("reqmethod", "delete");

        Type type = new TypeToken<ResponseInfo<Void>>() {
        }.getType();
        try {
            ResponseInfo<Void> responseInfo = HttpUtil.post(paramsMap, type);
            if (responseInfo.isSuccess()) {
                String errmsg = responseInfo.getErrmsg();
                System.out.println(errmsg);
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("SocketTimeoutException -------> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException -------> " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Other Exception -------> " + e.getMessage());
        }
    }

    @Test
    public void test_longtime() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("reqmethod", "longtime");

        Type type = new TypeToken<ResponseInfo<Integer>>() {
        }.getType();
        try {
            ResponseInfo<Integer> responseInfo = HttpUtil.post(paramsMap, type);
            if (responseInfo.isSuccess()) {
                String errmsg = responseInfo.getErrmsg();
                System.out.println(errmsg);
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("SocketTimeoutException -------> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException -------> " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Other Exception -------> " + e.getMessage());
        }
    }
}
