package com.cheol.sample.controller;

import com.cheol.sample.component.SampleHttpComponent;
import com.cheol.sample.domain.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@Slf4j
@SpringBootTest
class BaseControllerTest {

    @Autowired
    SampleHttpComponent httpComponent;

    @Test
    void Test() {
        ResponseEntity<String> test = httpComponent.getBase();
        log.debug(test.getBody());
    }

    @Test
    void post() {
        ResponseEntity<String> test = httpComponent.postTest();
        log.debug(test.getBody());
    }

    @Test
    void checkHeader() {
        ResponseEntity<String> test = httpComponent.checkHeaderTest("test-1234");
        log.debug(test.getBody());
    }

    @Test
    void player() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Player player = httpComponent.getPlayer();
        log.debug("{}", mapper.writeValueAsString(player));
    }

}
