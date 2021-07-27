package org.example.org.example.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.example.HttpBin;
import org.testng.annotations.Test;

public class TestHttpBin {

    HttpBin httpBin = new HttpBin();

    @Test
    public void testGetIPAddress() throws JsonProcessingException {
        Response ipAddress = httpBin.getStatus("ip");
        System.out.println("ip address is: " + ipAddress);
    }
}
