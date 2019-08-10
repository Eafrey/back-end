package com.eafrey.backend.repository;

import com.eafrey.backend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
