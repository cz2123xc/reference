package com.example.reference.api.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC) // 기본생성자 자동생성
public class Post {

    // 엔티티는 Setter 사용금지, 객체에 바로 주입도 금지 주의

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
