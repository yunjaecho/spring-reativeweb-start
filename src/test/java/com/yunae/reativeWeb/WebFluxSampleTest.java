package com.yunae.reativeWeb;

import com.yunae.reativeWeb.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebFluxTest
public class WebFluxSampleTest {

    @Autowired
    WebTestClient client;

    @MockBean
    SampleService sampleService;

    @Test
    public void testMessage() {
        given(sampleService.message()).willReturn("Yunjae");

        client.get().uri("/message").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Yunjae");
    }


}
