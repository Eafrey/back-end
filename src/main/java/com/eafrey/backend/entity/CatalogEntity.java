package com.eafrey.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Table(name = "catalog")
@EntityListeners(AuditingEntityListener.class)
public class CatalogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String catalogName;

    public CatalogEntity(String catalogName) {
        this.catalogName = catalogName;
    }
}
