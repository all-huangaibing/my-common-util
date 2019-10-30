package com.huang.ai.bing;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
/**
 * 功能：
 *
 * @author huangaibing
 * @date 2019/10/9 11:54
 */
public class HttpClientUtil{
//全局参数
private static PoolingHttpClientConnectionManager connectionManager;


    //连接配置
    private static RequestConfig requestConfig;
//单例模式创建资源

    static {//bean初始化
        if (connectionManager == null) {
            connectionManager = new PoolingHttpClientConnectionManager();
            // 整个连接池最大连接数
            connectionManager.setMaxTotal(50);
            // 每路由最大连接数，默认值是2
            connectionManager.setDefaultMaxPerRoute(200);
            /** 管理 http连接池 */
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(600)
                    .setConnectTimeout(600).setSocketTimeout(600)
                    .build();
        }
    }

//下次获取httpClient的时候是这样的
    public static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(connectionManager)
          .setDefaultRequestConfig(requestConfig).build();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        test1();
    }

    public static void test( ) throws IOException {
        long start = System.currentTimeMillis();
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        CloseableHttpResponse execute = HttpClientUtil.getHttpClient().execute(httpGet);
        HttpEntity entity = execute.getEntity();
        String s = EntityUtils.toString(entity);
        EntityUtils.consume(entity);
        execute.close();
//        System.out.println("s = " + s);
        System.out.println("takeTime = " + (System.currentTimeMillis()-start));

    }

    public static void test1( ) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10000);
            new Thread(()-> {
                try {
                    test();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void test2() throws IOException {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }
}