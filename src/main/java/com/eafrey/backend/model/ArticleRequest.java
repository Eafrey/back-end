package com.eafrey.backend.model;

import com.eafrey.backend.entity.ArticleEntity;
import lombok.Data;

@Data
public class ArticleRequest {
    private String title;
    private Long userId;
    private String userName;
    private String content;

    private Long viewCount;
    private Long commentsCount;
    private Long likeCount;

    private String tags;

    private String catalogName;

    public ArticleEntity toArticleEntity() {
        ArticleEntity article = new ArticleEntity();
        article.setTitle(title);
        article.setUserId(userId);
        article.setUserName(userName);
        article.setContent(content);
        article.setViewCount(viewCount);
        article.setCommentsCount(commentsCount);
        article.setLikeCount(likeCount);
        article.setTags(tags);
        return article;
    }
}
