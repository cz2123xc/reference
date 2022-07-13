package com.example.reference.api.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * {
 *     "code": "400",
 *     "message": "타이틀을 입력해주세요."
 *     "validation": {
 *     "title": "타이틀을 입력해주세요."
 *     }
 * }
 */


@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final String code;
    private final String message;

    private Map<String, String> validation = new HashMap<>();

    public void addValidation(String fieldName, String message) {
        this.validation.put(fieldName, message);
    }



}
