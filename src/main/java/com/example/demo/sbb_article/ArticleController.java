package com.example.demo.sbb_article;

import com.example.demo.sbb_answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

//    @GetMapping("/list")
//    @ResponseBody
//    public String showHello() {
//        return "Hello World!";
//    }


    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);
        return "article_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Article article = this.articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/create")
    public String questionCreate(ArticleForm articleForm) {
        return "article_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid ArticleForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        this.articleService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/article/list";
    }
}
