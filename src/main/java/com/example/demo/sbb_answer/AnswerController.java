package com.example.demo.sbb_answer;

import com.example.demo.sbb_article.Article;
import com.example.demo.sbb_article.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    // @Autowired
    private final ArticleService articleService;

    // @Autowired
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String answerCreate(Model model, @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Article article = this.articleService.getArticleById(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("article", article);
            return "article_detail";
        }
        this.answerService.create(article, answerForm.getContent());
        return String.format("redirect:/article/detail/%s", id);
    }
}
