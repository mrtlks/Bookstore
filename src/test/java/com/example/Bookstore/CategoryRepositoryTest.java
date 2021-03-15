package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest  {

    @Autowired
    private CategoryRepository repository;

    // Kategorian haku listalta
    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Category> categories = repository.findByCategoryname("Horror");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryName()).isEqualTo("Horror");
    }
    
    // Kategorian lisääminen
    
    @Test
    public void createNewCategory() {
    	Category category= new Category ("Thriller");
    	repository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }  
   
}