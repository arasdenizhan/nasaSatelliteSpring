package org.example.demo;

import org.assertj.core.api.Assertions;
import org.example.demo.client.NasaApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootTest
class NasaApiClientTest {

    @Autowired
    NasaApiClient nasaApiClient;

    @Test
    void givenNothing_whenUpdateApiData_thenShouldGetApiData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method updateApiData = nasaApiClient.getClass().getDeclaredMethod("updateApiData");
        updateApiData.setAccessible(true);
        updateApiData.invoke(nasaApiClient);
        Assertions.assertThat(nasaApiClient.getApiData()).isNotEmpty();
    }

}
