package com.nxhung.bookservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "books")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "author_name", nullable = false)
    private String authorName;
    @Builder.Default
    @Column(name = "is_ready", columnDefinition = "boolean default true", nullable = false)
    private Boolean isReady = true;
}
