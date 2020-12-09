package com.cheol.sample.component;

import com.cheol.sample.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class SampleHttpComponent {

    private final RestTemplate restTemplate;

    @Autowired
    public SampleHttpComponent(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getBase() {
        return restTemplate.getForEntity("http://localhost:8080", String.class);
    }

    public ResponseEntity<String> postTest() {
        return restTemplate.postForEntity("http://localhost:8080/post", "post", String.class);
    }

    public ResponseEntity<String> checkHeaderTest(String key) {

        // header setting
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authentication", key);

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);

        Map<String, String> params = new HashMap<>();
        params.put("name", "cheol");

        return restTemplate.exchange("http://localhost:8080/header?name={name}",
                HttpMethod.GET,
                httpEntity,
                String.class,
                params);

    }

    public Player getPlayer() {
        return restTemplate.getForObject("http://localhost:8080/get", Player.class);
    }

}
