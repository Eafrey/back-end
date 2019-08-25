package com.eafrey.backend.controller;

import com.eafrey.backend.entity.ArticleEntity;
import com.eafrey.backend.enums.ResponseCodeEnum;
import com.eafrey.backend.exception.BadRequestException;
import com.eafrey.backend.model.ArticleRequest;
import com.eafrey.backend.model.BaseResponse;
import com.eafrey.backend.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public BaseResponse saveArticle(@RequestBody ArticleRequest articleReuqest) throws BadRequestException {
        ArticleEntity articleEntity = articleService.saveArticle(articleReuqest);
        return new BaseResponse(ResponseCodeEnum.SUCCESS, articleEntity);
    }

    @GetMapping("/{articleId}")
    public BaseResponse getArticle(@PathVariable Long articleId) {
        ArticleEntity article = articleService.getArticle(articleId);
        return new BaseResponse(ResponseCodeEnum.SUCCESS, article);
    }

    @GetMapping("/catalogs")
    public BaseResponse getAllTags() {
        List<String> allCatalogs = articleService.getAllCatalogs();
        return new BaseResponse(ResponseCodeEnum.SUCCESS, allCatalogs);
    }

    @GetMapping()
    public BaseResponse getArticles(Pageable pageable) {
        Page<ArticleEntity> articles = articleService.getArticles(pageable);
        return new BaseResponse(ResponseCodeEnum.SUCCESS, articles);
    }
}
