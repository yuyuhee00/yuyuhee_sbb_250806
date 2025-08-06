package com.example.demo;

import com.example.demo.sbb_article.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YuyuheeSbb250806ApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테 스 트 데 이 터 입 니 다 :[%03d]", i);
            String content = "내 용 무";
            this.articleService.create(subject, content);
        }
    }

}
