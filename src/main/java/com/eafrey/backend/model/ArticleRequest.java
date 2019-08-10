package com.eafrey.backend.model;

import com.eafrey.backend.entity.Article;
import lombok.Data;

@Data
public class ArticleRequest {
    private String title;
    private Long authorId;
    private String content;

    private Long viewCount;
    private Long commentsCount;
    private Long likeCount;

    private String tags;

    private String catalogName;

    public Article toArticle() {
        Article article = new Article();
        article.setTitle(title);
        article.setAuthorId(authorId);
        article.setContent(content);
        article.setViewCount(viewCount);
        article.setCommentsCount(commentsCount);
        article.setLikeCount(likeCount);
        article.setTags(tags);
        return article;
    }
}
