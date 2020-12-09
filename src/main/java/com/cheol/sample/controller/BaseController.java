package com.cheol.sample.controller;

import com.cheol.sample.domain.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class BaseController {

    @Value("${zone}")
    String zone;

    @GetMapping("/")
    public String base() {
        log.debug("{}", zone);
        return zone;
    }

    @GetMapping("/get")
    public Player getPlayer() {
        return Player.builder().userId("cheol-200712").code("home").build();
    }

    @GetMapping("/header")
    public ResponseEntity<String> checkHeader(String name, HttpServletRequest httpServletRequest) {
        log.debug("Hello,{} - authentication={}", name, httpServletRequest.getHeader("Authentication"));
        return new ResponseEntity<>("Success Response", HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postForEntity(String contents) {
        log.debug("body : {}", contents);
        return new ResponseEntity<>("Success Response", HttpStatus.OK);
    }

}
