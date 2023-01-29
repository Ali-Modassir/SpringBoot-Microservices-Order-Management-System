package com.productservice;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

    //Mongodb configuration
    @Container
    static MongoDBContainer mongoDBContainer = new
            MongoDBContainer("mongo:6.0.3") ;

    @Autowired
    private MockMvc mockMvc ;

    private ObjectMapper objectMapper = new ObjectMapper() ;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri",
                mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private ProductRepository productRepository ;

    //Tests
    @Test
    void shouldCreateProduct() throws Exception {

        ProductRequest productRequest = getProductRequest() ;
        String productRequestString = objectMapper.writeValueAsString(productRequest) ;

         mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                 .contentType("application/json")
                 .content(productRequestString))
                 .andExpect(status().isCreated()) ;
        Assertions.assertEquals(1, productRepository.findAll().size());
    }

    @Test
    void shouldfetchAllProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/allProducts")
                        .accept("application/json"))
                .andExpect(status().isOk()) ;
    }

    private ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name("iphone 13")
                .description("iphone 13 mini")
                .price(BigDecimal.valueOf(500000))
                .build() ;
    }



}
