package com.yunae.reativeWeb;

import com.yunae.reativeWeb.service.RestSampleService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseActions;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(RestSampleService.class)
public class RestClientSampleTest {

    @Autowired
    RestSampleService restSampleService;

    @Autowired
    MockRestServiceServer server;

    @Test
    public void testJson() {
        ResponseActions responseActions = server.expect(requestTo("/message"));
        responseActions.andRespond(withSuccess("yunaje", MediaType.TEXT_PLAIN));

        String name = restSampleService.getName();
        Assertions.assertThat(name).isEqualTo("yunaje");
    }
}
