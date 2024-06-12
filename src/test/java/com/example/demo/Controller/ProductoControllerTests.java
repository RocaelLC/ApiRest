package com.example.demo.Controller;

import com.example.demo.model.Producto;
import com.example.demo.Service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebMvcTest(ProductoController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class ProductoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    public void setup() {
        producto = new Producto();
        producto.setId("1");
        producto.setNombre("Producto 1");
        producto.setPrecio(10.0);
    }

    @Test
    public void testGetAllProductos() throws Exception {
        given(productoService.findAll()).willReturn(Arrays.asList(producto));

        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk())
                .andDo(document("get-all-productos",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    // otras pruebas de documentación
}
