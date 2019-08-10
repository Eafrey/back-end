package com.eafrey.backend.controller;

import com.eafrey.backend.entity.Article;
import com.eafrey.backend.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleApi {

    private final ArticleService articleService;

    public ArticleApi(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public Article saveArticle(@RequestBody Article articleReuqest) {
        return articleService.saveArticle(articleReuqest);
    }

    @GetMapping("/tags")
    public List<String> getAllTags() {
        return articleService.getAllTags();
    }

    @GetMapping()
    public Page<Article> getArticles(Pageable pageable) {
        return articleService.getArticles(pageable);
    }
}
