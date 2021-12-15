package io.github.niltonurias.specificationspringjpaexample.endpoint;

import io.github.niltonurias.specificationspringjpaexample.domain.BookEntity;
import io.github.niltonurias.specificationspringjpaexample.domain.BookRepository;
import io.github.niltonurias.specificationspringjpaexample.domain.BookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public record BookService(BookRepository repository) {

    public Page<BookEntity> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<BookEntity> findFiltered(BookEntity book, Pageable pageable) {
        return this.repository.findAll(new BookSpecification(book).createWhere(), pageable);
    }
}
