package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.Repository.ProductoRepository;
import com.example.demo.Service.ProductoService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SuppressWarnings("unused")
@SpringBootTest
public class ProductoServiceTests {

    @Autowired
    private ProductoService productoService;

    @MockBean
    private ProductoRepository productoRepository;

    @Test
    public void testFindAll() {
        Producto producto = new Producto();
        producto.setId("1");
        producto.setNombre("Producto 1");
        producto.setPrecio(10.0);

        List<Producto> expectedProductos = Arrays.asList(producto);

        given(productoRepository.findAll()).willReturn(expectedProductos);

        List<Producto> actualProductos = productoService.findAll();

        assertEquals(expectedProductos, actualProductos);
    }

    // otras pruebas
}