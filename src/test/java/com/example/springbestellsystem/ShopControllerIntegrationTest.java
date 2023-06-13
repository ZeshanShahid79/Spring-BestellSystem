package com.example.springbestellsystem;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllProductsExpectStatus200AndExpectedList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/products")).andExpect(status().isOk()).andExpect(content().json("""
                [
                    {
                      "id" : "1",
                       "name" : "Banana"
                    },
                    {
                    "id" : "2",
                     "name" : "Pineapple"
                    }
                ]
                """));

    }

    @Test
    void getProductByIdAndExpectStatus200AndExpectedProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/shop/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(
                        """
                                {
                                "id": "1",
                                "name": "Banana"
                                }
                                """
                ));
    }

    @DirtiesContext
    @Test
    void deleteProductByIdAndExpectStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/shop/products/1"))
                .andExpect(status().isOk());

    }

    // wir müssen DirtiesContext hinzufügen damit nicht wirklich unsere Liste bearbeitet wird
    @DirtiesContext
    @Test
    void addOrderAndExpectStatus200AndExpectedOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/shop").contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                 [
                                 "1",
                                 "2"
                                 ]
                                """
                        ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                            {
                            "orderList": [    {
                          "id" : "1",
                           "name" : "Banana"
                        },
                        {
                        "id" : "2",
                         "name" : "Pineapple"
                        }]
                            }
                            """))
                .andExpect(jsonPath("id").isNotEmpty());
    }


    @Test
    void getAllOrdersExpectStatus200AndExpectedList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/orders")).andExpect(status().isOk()).andExpect(content().json("""
                                        [
                            {
                             "id":"1",
                              "orderList":
                                            [
                                                {
                                                "id":"1",
                                                "name":"Banana"
                                                }
                                            ]
                                              },
                      {
                      "id":"2",
                      "orderList":
                                     [
                                        {
                                        "id":"2",
                                        "name":"Pineapple"
                                        }
                                      ]
                      }
                ]
                        """));

    }

    @Test
    void getOrderByIdAndExpectStatus200AndExpectedOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/orders/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                                
                            {
                             "id":"1",
                              "orderList":
                                            [
                                                {
                                                "id":"1",
                                                "name":"Banana"
                                                }
                                            ]
                              }

                                                
                        """));

    }
}
