package com.example.demo.sbb_answer;

import com.example.demo.sbb_article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Article article, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setArticle(article);
        this.answerRepository.saveAndFlush(answer);
    }

    public List<Answer> getListByArticle(Article article) {
        return this.answerRepository.getAnswersByArticle(article);
    }

    public Answer getAnswerById(Integer id) {
        return this.answerRepository.getOne(id);
    }

    public void delete(Integer id) {
        this.answerRepository.deleteById(id);
    }
}
