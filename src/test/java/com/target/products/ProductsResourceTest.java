package com.target.products;

import com.target.products.document.Price;
import com.target.products.document.Products;
import com.target.products.exception.ProductNotfoundException;
import com.target.products.repository.ProductRepository;
import com.target.products.resource.ProductsResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductsResourceTest {

    private ProductsResource productsResource;
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productsResource = new ProductsResource(productRepository);
        Products product = new Products("1", "Peter", new Price(2.5f, "$"));
        Mockito.when(productRepository.findOne(product.getId())).thenReturn(product);
    }

    @Test
    public void testGetProductById() throws Exception
    {
        ResponseEntity response = productsResource.getBy("1");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdateProductById() throws Exception
    {
        Products product = new Products("1", "Peter", new Price(3.5f, "$"));
        ResponseEntity response = productsResource.updateUser("1", product);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testProductNotFoundExceptionForWrongId() throws Exception
    {
        Products product = new Products("1", "Peter", new Price(3.5f, "$"));
        boolean thrown = false;
        try {
            productsResource.updateUser("2", product);
        }
        catch (ProductNotfoundException ex) {
          thrown = true;
        }
        Assert.assertTrue(thrown);
    }
}
