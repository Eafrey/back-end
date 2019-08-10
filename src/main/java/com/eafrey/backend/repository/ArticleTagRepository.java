package com.eafrey.backend.repository;

import com.eafrey.backend.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Integer> {
}
