package com.eafrey.backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long authorId;
    private String content;
    private Long catalogId;

    private Long viewCount;
    private Long commentsCount;
    private Long likeCount;

    private String tags;

    @Column(name = "creation_time", nullable = false, updatable = false, insertable = false)
    private ZonedDateTime creationTime;

    @Column(name = "modification_time", nullable = false, insertable = false)
    private ZonedDateTime modificationTime;
}
