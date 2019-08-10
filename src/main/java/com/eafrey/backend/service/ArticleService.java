package com.eafrey.backend.service;

import com.eafrey.backend.entity.Article;
import com.eafrey.backend.entity.Catalog;
import com.eafrey.backend.model.ArticleRequest;
import com.eafrey.backend.repository.ArticleRepository;
import com.eafrey.backend.repository.CatalogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CatalogRepository catalogRepository;

    public ArticleService(ArticleRepository articleRepository, CatalogRepository catalogRepository) {
        this.articleRepository = articleRepository;
        this.catalogRepository = catalogRepository;
    }

    public Article saveArticle(ArticleRequest articleReuqest) {
        Long catalogId = getCatalogId(articleReuqest);
        Article article = articleReuqest.toArticle();
        article.setCatalogId(catalogId);
        return articleRepository.save(article);
    }

    private Long getCatalogId(ArticleRequest articleReuqest) {
        String catalogName = articleReuqest.getCatalogName();
        Optional<Catalog> catalog = catalogRepository.findByCatalogName(catalogName);
        if (catalog.isPresent()) {
            return catalog.get().getId();
        } else {
            return catalogRepository.save(new Catalog(catalogName)).getId();

        }
    }

    public List<String> getAllCatalogs() {
        List<Catalog> tags = catalogRepository.findAll();
        return tags.stream().map(Catalog::getCatalogName).collect(Collectors.toList());
    }

    public Page<Article> getArticles(Pageable pageable) {
        System.out.println();
        return articleRepository.findAll(pageable);
    }

    public Article getArticle(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        return Optional.ofNullable(article.get()).orElse(null);
    }
}
