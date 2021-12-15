package io.github.niltonurias.specificationspringjpaexample.endpoint;

import io.github.niltonurias.specificationspringjpaexample.domain.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RequestMapping("/book")
@RestController
public record BookEndpoint(BookService service) {

    @GetMapping
    public Page<BookEntity> findBy(Pageable pageable,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "author", required = false) String author,
                                   @RequestParam(value = "editor", required = false) String editor,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "releaseDate", required = false) LocalDate releaseDate,
                                   @RequestParam(value = "language", required = false) String language) {
        BookEntity book = new BookEntity();
        book.setName(name);
        book.setAuthor(author);
        book.setEditor(editor);
        book.setLanguage(language);
        book.setReleaseDate(releaseDate);

        return this.service.findFiltered(book, pageable);
    }
}
