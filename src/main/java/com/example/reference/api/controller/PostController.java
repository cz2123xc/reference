package com.example.reference.api.controller;

import com.example.reference.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class PostController {

    @PostMapping ("/posts")
    public String get(@RequestBody PostCreate postCreate) {

        log.info("postCreate: {}", postCreate.toString());


        return "Hello World!";
    }


}
