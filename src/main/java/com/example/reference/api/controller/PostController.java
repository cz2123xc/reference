package com.example.reference.api.controller;

import com.example.reference.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Slf4j
public class PostController {

    @PostMapping ("/posts")
    public Map<String, String> get(@RequestBody @Valid PostCreate postCreate) {
        return Map.of();
    }


}
