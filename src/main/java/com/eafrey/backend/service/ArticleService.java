package com.eafrey.backend.service;

import com.eafrey.backend.entity.Article;
import com.eafrey.backend.entity.Tag;
import com.eafrey.backend.repository.ArticleRepository;
import com.eafrey.backend.repository.ArticleTagRepository;
import com.eafrey.backend.repository.TagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleTagRepository articleTagRepository;
    private final TagRepository tagRepository;

    public ArticleService(ArticleRepository articleRepository, ArticleTagRepository articleTagRepository, TagRepository tagRepository) {
        this.articleRepository = articleRepository;
        this.articleTagRepository = articleTagRepository;
        this.tagRepository = tagRepository;
    }


    public Article saveArticle(Article articleReuqest) {
        return articleRepository.save(articleReuqest);
    }

    public List<String> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream().map(Tag::getTagName).collect(Collectors.toList());
    }

    public Page<Article> getArticles(Pageable pageable) {
        System.out.println();
        return articleRepository.findAll(pageable);
    }
}
