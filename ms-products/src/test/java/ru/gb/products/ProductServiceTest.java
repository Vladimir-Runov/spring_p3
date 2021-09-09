package ru.gb.products;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import ru.gb.products.controllers.ProductController;
import ru.gb.products.entities.Product;
import ru.gb.products.repository.specifications.ProductRepository;

import java.util.List;

@DataJpaTest
//@ActiveProfiles("Test")
public class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void initDbTest() {
        List<Product> lst = productRepository.findAll();
        System.out.println(lst.size());
        Assertions.assertEquals(17, lst.size());

    }

}
