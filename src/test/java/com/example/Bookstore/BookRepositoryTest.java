package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    // Kirjan haku listalta
    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("Emma");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Jane Austen");
    }
    
    // Kirjan lisääminen
    @Test
    public void createNewBook() {
    	Book book= new Book ("Mansfield Park", "Jane Austen", "1814", " 978-951-98548-5-5", "21,90", new Category("Drama"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }  
    
    // Kirjan poistaminen
    @Test
    public void deleteBook() {
    	Book book= new Book ("Persuasion", "Jane Austen", "1817", " 978-951-98548-5-5", "21,90", new Category("Drama"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    	
    	repository.deleteById(book.getId());
    	assertThat(book.getId()).isNull();
    	
    }  
    

}