package com.project.demo.logic.entity.product;

import com.project.demo.logic.entity.category.Category;
import com.project.demo.logic.entity.category.CategoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/*
@Order(3)
@Component
public class ProductSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {this.createProduct();}

    private void createProduct() {

        Category newCategory = new Category();
        newCategory.setName("Accesories");
        newCategory.setDescription("Peripherals and complementary items for computers");
        Category savedCategory = categoryRepository.save(newCategory);


        Product newProduct = new Product();
        newProduct.setName("T");
        newProduct.setDescription("");
        newProduct.setPrice(2135.5);
        newProduct.setStockAmount(5);
        newProduct.setCategory(savedCategory);

    }
}
*/