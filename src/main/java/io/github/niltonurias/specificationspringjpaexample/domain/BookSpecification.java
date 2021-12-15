package io.github.niltonurias.specificationspringjpaexample.domain;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public record BookSpecification(BookEntity book) {

    private Specification<BookEntity> name() {
        return (root, query, criteriaBuilder) ->
                !Objects.isNull(this.book.getName()) ? criteriaBuilder.like(root.get("name"), "%" + this.book.getName() + "%") : null;
    }

    private Specification<BookEntity> editor() {
        return (root, query, criteriaBuilder) ->
                !Objects.isNull(this.book.getEditor()) ? criteriaBuilder.like(root.get("editor"), "%" + this.book.getEditor() + "%") : null;
    }

    private Specification<BookEntity> author() {
        return (root, query, criteriaBuilder) ->
                !Objects.isNull(this.book.getAuthor()) ? criteriaBuilder.like(root.get("author"), "%" + this.book.getAuthor() + "%") : null;
    }

    private Specification<BookEntity> language() {
        return (root, query, criteriaBuilder) ->
                !Objects.isNull(this.book.getLanguage()) ? criteriaBuilder.like(root.get("language"), "%" + this.book.getLanguage() + "%") : null;
    }

    private Specification<BookEntity> releaseDate() {
        return (root, query, criteriaBuilder) ->
                !Objects.isNull(this.book.getReleaseDate()) ? criteriaBuilder.equal(root.get("releaseDate"), this.book.getReleaseDate()) : null;
    }

    public Specification<BookEntity> createWhere() {
        return Specification
                .where(name())
                .and(editor())
                .and(author())
                .and(language())
                .and(releaseDate());
    }
}
