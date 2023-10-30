package com.nxhung.bookservice.repository;

import com.nxhung.bookservice.dtos.BookQueryParams;
import com.nxhung.bookservice.entities.BookEntity;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT b from BookEntity b WHERE " +
            "(:#{#params.isReady} IS NULL OR b.isReady = :#{#params.isReady}) AND" +
            "(:#{#params.name} IS NULL OR lower(b.name) LIKE '%'||lower(:#{#params.name})||'%') AND" +
            "(:#{#params.authorName} IS NULL OR lower(b.authorName) LIKE '%'||lower(:#{#params.authorName})||'%')")
    Collection<BookEntity> getBookByQueryParams(@Param("params") BookQueryParams params);
}
