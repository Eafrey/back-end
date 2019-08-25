package com.eafrey.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean gender;
    private String userName;
    private String userPassword;
    private String avatar;
    private String email;
    private String phoneNumber;

    @CreatedDate
    @Column(name = "creation_time", nullable = false, updatable = false, insertable = false)
    private ZonedDateTime creationTime;

    @LastModifiedDate
    @Column(name = "modification_time", nullable = false, insertable = false)
    private ZonedDateTime modificationTime;
}
