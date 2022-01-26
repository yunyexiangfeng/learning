package com.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class TransportClientConfig extends ElasticsearchConfigurationSupport {


    //Example 52. Transport Client
    @Bean()
    public Client elasticsearchClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", "tencent-c")
//                .put("cluster.username", "elastic")
//                .put("cluster.password", "1NRz0n4QNWhm7rK6")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        try {
            client.addTransportAddress(new TransportAddress(InetAddress.getByName("10.66.224.161"), 9200));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.95.0.95"), 9300))
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.95.0.96"), 9300))
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.95.0.97"), 9300))
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.95.0.98"), 9300))
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.95.0.99"), 9300));
        return client;
    }

    @Bean(name = {"elasticsearchOperation", "elasticsearchTemplate"})
    public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(elasticsearchClient());
    }

}
