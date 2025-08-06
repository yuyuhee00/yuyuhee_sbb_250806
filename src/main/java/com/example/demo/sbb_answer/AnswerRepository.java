package com.example.demo.sbb_answer;

import com.example.demo.sbb_article.Article;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    List<Answer> getAnswersByArticle(Article article);

}
