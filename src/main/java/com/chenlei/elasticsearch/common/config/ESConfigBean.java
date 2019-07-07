package com.chenlei.elasticsearch.common.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by chenlei on 2019/6/24.
 */
@Configuration
public class ESConfigBean {

    @Value("${es.host}")
    private String host;
    @Value("${es.port}")
    private int port;
    private String schema = "http";
    @Value("${es.connectTimeOut}")
    private int connectTimeOut;
    @Value("${es.socketTimeOut}")
    private int socketTimeOut;
    @Value("${es.connectionRequestTimeOut}")
    private int connectionRequestTimeOut;
    @Value("${es.maxConnectNum}")
    private int maxConnectNum;
    @Value("${es.maxConnectPerRoute}")
    private int maxConnectPerRoute;
    private HttpHost httpHost;
    @Value("${es.uniqueConnectTimeConfig}")
    private boolean uniqueConnectTimeConfig;
    @Value("${es.uniqueConnectNumConfig}")
    private boolean uniqueConnectNumConfig;
    private RestClientBuilder builder;
    private RestHighLevelClient client;

    @Value("${es.username}")
    private String username;

    @Value("${es.password}")
    private String password;


    /**
     * Bean name default  函数名字
     *
     * @return
     */
    @Bean(name = "restHighLevelClient")
    public RestHighLevelClient restHighLevelClient() {

        /*final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(username, password));
        httpHost= new HttpHost(host, port, schema);
        builder = RestClient.builder(httpHost);
        builder = RestClient.builder(httpHost);
        if (uniqueConnectTimeConfig) {
            setConnectTimeOutConfig();
        }
        if (uniqueConnectNumConfig) {
            setMutiConnectConfig();
        }
        builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                httpClientBuilder.disableAuthCaching();
                return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            }
        });

        client =new RestHighLevelClient(builder);
        return client;*/


        httpHost= new HttpHost(host, port, schema);
        builder = RestClient.builder(httpHost);
        if (uniqueConnectTimeConfig) {
            setConnectTimeOutConfig();
        }
        if (uniqueConnectNumConfig) {
            setMutiConnectConfig();
        }
        client = new RestHighLevelClient(builder);
        return client;
    }


    /**
     * 异步httpclient的连接延时配置
     */
    public void setConnectTimeOutConfig() {
        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                requestConfigBuilder.setConnectTimeout(connectTimeOut);
                requestConfigBuilder.setSocketTimeout(socketTimeOut);
                requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeOut);
                return requestConfigBuilder;
            }
        });
    }

    /**
     * 异步httpclient的连接数配置
     */
    public void setMutiConnectConfig() {
        builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                httpClientBuilder.setMaxConnTotal(maxConnectNum);
                httpClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
                return httpClientBuilder;
            }
        });
    }

    /**
     * 关闭连接
     */
    public void close() {
        if (client != null) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
