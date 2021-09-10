package ru.gb.products;

//import org.apache.el.stream.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import lombok.RequiredArgsConstructor;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import ru.gb.products.controllers.ProductController;
import ru.gb.products.entities.Product;
import ru.gb.products.entities.ProductDto;
import ru.gb.products.repository.specifications.ProductRepository;
import ru.gb.products.services.ProductService;


import java.util.Optional;

import static org.springframework.boot.origin.OriginTrackedValue.of;

@SpringBootTest(classes = { ProductService.class})
//@ActiveProfiles("Test")
public class ServicesTest {
    @Autowired
    ProductService productService;
    @MockBean
    ProductRepository productRepository;

    @Test
    public void Test_PR() {
        Product dp = new Product();
        dp.setName("Bread");
        dp.setPrice(66);
        dp.setId(24L);

        Mockito
                .doReturn(Optional.of(dp))
                .when(productRepository)
                .findById(24L);

        ProductDto p = productService.findProductDtoById(24L).get();
        //  get() возвращает   ...Dto
        Mockito.verify(productRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(24L));
        //  Dto-шноу объекту пришлось сделать етод GetName  ??? для соответствия тому что было на лекции
        Assertions.assertEquals("Bread", p.getName());
    }
}
