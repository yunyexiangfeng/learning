package com.es;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class Test {

    @Resource
    private Client elasticsearchClient;

    private RestHighLevelClient highLevelClient;

    @org.junit.Test
    public void transportClientTest() throws ExecutionException, InterruptedException {

        GetRequest getRequest = new GetRequest("userprofile-localrecommend-recommend-k8s-loda.user-profile-api.20210303_dyn_1_0");
        GetResponse res = elasticsearchClient.get(getRequest).get();
        System.out.println(res.toString());
    }

}
