package dev.erwin.samples.shopservice.controller;

import dev.erwin.samples.shopservice.dto.ProductDTO;
import dev.erwin.samples.shopservice.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testCreateProduct() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1);
        productDTO.setName("Python in Action");
        productDTO.setManufacturer("AMD");
        productDTO.setDescription("this is a product");

        String jsonBody = """
                {
                    "name": "Python in Action",
                    "manufacturer": "AMD",
                    "description": "this is a product"
                }
                """;
        when(productService.create(any(ProductDTO.class))).thenReturn(productDTO);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody);
        ResultActions actions = mockMvc.perform(requestBuilder);

        actions
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Python in Action"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("AMD"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("this is a product"));


    }
}