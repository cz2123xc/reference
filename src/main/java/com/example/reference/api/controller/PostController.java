package com.example.reference.api.controller;

import com.example.reference.api.request.PostCreate;
import com.example.reference.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping ("/posts")
    public Map<String, String> get(@RequestBody @Valid PostCreate request) {
        postService.write(request);
        return Map.of();
    }


}
