package com.example.reference.api.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    
    @Builder // 빌더 패턴 사용
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
