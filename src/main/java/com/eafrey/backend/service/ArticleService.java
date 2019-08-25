package com.eafrey.backend.service;

import com.eafrey.backend.entity.ArticleEntity;
import com.eafrey.backend.entity.CatalogEntity;
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

    public ArticleEntity saveArticle(ArticleRequest articleReuqest) {
        Long catalogId = getCatalogId(articleReuqest);
        ArticleEntity articleEntity = articleReuqest.toArticleEntity();
        articleEntity.setCatalogId(catalogId);
        return articleRepository.save(articleEntity);
    }

    private Long getCatalogId(ArticleRequest articleReuqest) {
        String catalogName = articleReuqest.getCatalogName();
        Optional<CatalogEntity> catalog = catalogRepository.findByCatalogName(catalogName);
        if (catalog.isPresent()) {
            return catalog.get().getId();
        } else {
            return catalogRepository.save(new CatalogEntity(catalogName)).getId();

        }
    }

    public List<String> getAllCatalogs() {
        List<CatalogEntity> tags = catalogRepository.findAll();
        return tags.stream().map(CatalogEntity::getCatalogName).collect(Collectors.toList());
    }

    public Page<ArticleEntity> getArticles(Pageable pageable) {
        System.out.println();
        return articleRepository.findAll(pageable);
    }

    public ArticleEntity getArticle(Long articleId) {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(articleId);
        return Optional.ofNullable(articleEntity.get()).orElse(null);
    }
}
