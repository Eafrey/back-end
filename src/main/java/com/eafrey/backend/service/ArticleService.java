package com.eafrey.backend.service;

import com.eafrey.backend.entity.ArticleEntity;
import com.eafrey.backend.entity.CatalogEntity;
import com.eafrey.backend.entity.UserEntity;
import com.eafrey.backend.exception.BadRequestException;
import com.eafrey.backend.model.ArticleRequest;
import com.eafrey.backend.repository.ArticleRepository;
import com.eafrey.backend.repository.CatalogRepository;
import com.eafrey.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CatalogRepository catalogRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CatalogRepository catalogRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.catalogRepository = catalogRepository;
        this.userRepository = userRepository;
    }

    public ArticleEntity saveArticle(ArticleRequest articleReuqest) throws BadRequestException {
        Long catalogId = getCatalogId(articleReuqest);

        Long userId = getUserId(articleReuqest);
        if (userId == null) {
            throw new BadRequestException("use id is not correct");
        }

        checkExists(articleReuqest);

        ArticleEntity articleEntity = articleReuqest.toArticleEntity();
        articleEntity.setCatalogId(catalogId);
        return articleRepository.save(articleEntity);
    }

    private void checkExists(ArticleRequest articleReuqest) throws BadRequestException {
        String titile = articleReuqest.getTitle();
        if (articleRepository.findByTitle(titile).isPresent()) {
            throw new BadRequestException("article is already exists for the same title");
        }
    }

    private Long getUserId(ArticleRequest articleReuqest) {
        Long id = articleReuqest.getUserId();
        if (articleReuqest.getUserId() != null && !userRepository.findById(id).isPresent()) {
            return null;
        }

        if (articleReuqest.getUserName() != null) {
            Optional<UserEntity> userEntity = userRepository.findByUserName(articleReuqest.getUserName());
            return Optional.ofNullable(userEntity.get().getId()).orElse(null);
        }
        return null;
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
