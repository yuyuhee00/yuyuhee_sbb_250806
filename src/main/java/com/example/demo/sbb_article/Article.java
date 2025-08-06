package com.example.demo.sbb_article;

import com.example.demo.sbb_answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany (mappedBy = "article", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Answer> answerList;
}


