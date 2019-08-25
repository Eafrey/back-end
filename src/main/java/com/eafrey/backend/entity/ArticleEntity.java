package com.eafrey.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "article")
@EntityListeners(AuditingEntityListener.class)
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private String userName;
    private Long catalogId;
    private Long userId;
    @OneToOne
    @JoinColumn(name = "id")
    private UserEntity userInfo;
    @OneToOne
    @JoinColumn(name = "id")
    private CatalogEntity catalogInfo;

    private Long viewCount;
    private Long commentsCount;
    private Long likeCount;

    private String tags;

    @CreatedDate
    @Column(name = "creation_time", nullable = false, updatable = false, insertable = false)
    private Date creationTime;

    @LastModifiedDate
    @Column(name = "modification_time", nullable = false, insertable = false)
    private Date modificationTime;
}
