package me.abel.elasticsearch.client;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import org.junit.Test;

public class JestServiceTest {

    @Test
    public void jestTest(){
        JestClient jestClient = JestService.getJestClient();
        try {
            JestResult result = JestService.search(jestClient, "vehicletype_qas", "doc", "{\"modelyear\":\"2018\"}");
            System.out.println(result.getJsonString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}