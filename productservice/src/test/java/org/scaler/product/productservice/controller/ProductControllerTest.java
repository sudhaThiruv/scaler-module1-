package org.scaler.product.productservice.controller;







import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.scaler.product.productservice.dtos.ProductDto;
import org.scaler.product.productservice.models.Product;
import org.scaler.product.productservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {
    @Mock
    private IProductService productService;

    @InjectMocks
    private  ProductController productController;
@Captor
    private ArgumentCaptor<Long> idCaptor;

@Test
    public void TestGetProductDetails_withValidProductId_RunSuccessfully(){
        Long id=2L;
        Product product=new Product();
        product.setId(2L);
        product.setName("iphone");
        when(productService.getProductById(id)).thenReturn(product);

        ProductDto productDto= productController.getProductDetails(id);
        assertEquals(productDto.getId(),id);
        assertNotNull(productDto);
    }
@Test
    public void TestGetProductDetails_withInValidProductId_ThrowException(){
    assertThrows(IllegalArgumentException.class,
            ()->productController.getProductDetails(-1L));
    }
@Test
    public  void TestGetProductDetailsBYId_ProductServiceCalledArguments_Runsuccessfully(){

    Long productId = 1L;
    Product product = new Product();
    product.setId(productId);
    product.setName("Macbook");
    when(productService.getProductById(productId)).thenReturn(product);

    //Act
    productController.getProductDetails(productId);

    //Assert
    verify(productService).getProductById(idCaptor.capture());
    assertEquals(productId,idCaptor.getValue());

    }
}
