//package com.example.netflixprojext.migrations.configurations;
//
//import com.example.netflixprojext.entities.Category;
//import com.example.netflixprojext.entities.Movie;
//import com.example.netflixprojext.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class CategoryConfig implements CommandLineRunner {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        Category category1 = new Category("action");
//        Category category2 = new Category("romance");
//        Category category3 = new Category("animation");
//        Category category4 = new Category("horror");
//
//        categoryRepository.saveAll(List.of(category1, category2, category3, category4));
//
//    }
//}
