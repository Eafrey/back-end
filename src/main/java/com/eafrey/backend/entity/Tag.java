package com.eafrey.backend.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Entity
@Getter
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;

    @Column(name = "creation_time", nullable = false, updatable = false, insertable = false)
    private ZonedDateTime creationTime;

    @Column(name = "modification_time", nullable = false, insertable = false)
    private ZonedDateTime modificationTime;
}
