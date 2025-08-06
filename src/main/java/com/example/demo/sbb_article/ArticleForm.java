package com.example.demo.sbb_article;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {

    @NotEmpty(message="제 목 은 필 수 항 목 입 니 다.")
    @Size(max=100)
    private String subject;

    @NotEmpty(message="내 용 은 필 수 항 목 입 니 다.")
    private String content;
}
