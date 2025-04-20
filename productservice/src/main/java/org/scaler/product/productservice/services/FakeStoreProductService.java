package org.scaler.product.productservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.scaler.product.productservice.dtos.FakeStoreProductDto;
import org.scaler.product.productservice.dtos.ProductDto;
import org.scaler.product.productservice.models.Category;
import org.scaler.product.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductService implements IProductService{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(Long id) {

        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto =
                restTemplate.getForEntity("http://fakestoreapi.com/products/{id}",
                        FakeStoreProductDto.class,id);



        if(fakeStoreProductDto.getBody() != null &&
                fakeStoreProductDto.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return from(fakeStoreProductDto.getBody());
        }

        return null;

    }
    @Override
    public List<Product> getAllproducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=
                restTemplate.getForEntity("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class,"");
List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:response.getBody()){
            Product product=from(fakeStoreProductDto);
            products.add(product);
        }
        return  products;

    }

    public Product updateProduct(Product product ,Long id){

        FakeStoreProductDto input=from(product);
        FakeStoreProductDto output= requestForEntity("http://fakestoreapi.com/products/{id}",HttpMethod.PUT,input,
                FakeStoreProductDto.class,id).getBody();
        return from(output);

    }


    @Override
    public Product replaceProduct(Product product,Long id) {
        FakeStoreProductDto input=from(product);
        FakeStoreProductDto output=
                requestForEntity("http://fakestoreapi.com/products/{id}",HttpMethod.PUT,input,
                        FakeStoreProductDto.class,id).getBody();
        return from(output);

    }

    @Override
    public Boolean deleteProduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        Category category = new Category();
        category.setName(String.valueOf(product.getCategory()));
        fakeStoreProductDto.setCategory(String.valueOf(category));
        return fakeStoreProductDto;
    }
        private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }



    public <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request, Class<T> responseType,
                                               Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate =  restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.POST, requestCallback, responseExtractor, uriVariables);
    }


    public <T> ResponseEntity<T> requestForEntity(String url,HttpMethod httpMethod
            ,@Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }



    public <T> ResponseEntity<T> requestForEntities(String url,HttpMethod httpMethod
            ,@Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {

        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    public  <T> ResponseEntity<T> req(String url,HttpMethod httpMethod,@Nullable Object requestBody,Class<T>responseType,
                                      Optional<Object> pathVariable) throws  RestClientException{
        RestTemplate restTemplate=restTemplateBuilder.build();

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity=new HttpEntity<>(requestBody,headers);

        ObjectMapper objectMapper=new ObjectMapper();
        byte[] reqBodyBytes ;
        try {
            reqBodyBytes= objectMapper.writeValueAsBytes(requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RequestCallback requestCallback=request-> {
            entity.getHeaders()
                    .forEach((header, values)->values.forEach(value ->request.getHeaders().add(header,value)));
            request.getBody().write(reqBodyBytes);

        };

   ResponseExtractor<ResponseEntity<T>> responseExtractor=restTemplate.responseEntityExtractor(responseType);
   if(pathVariable.isPresent()){
       return  restTemplate.execute(url,httpMethod,requestCallback,responseExtractor,pathVariable);
   }
   else {
       return  restTemplate.execute(url,httpMethod,requestCallback,responseExtractor);
   }
    }
    public <T> ResponseEntity<T> reqForEntity(String url, HttpMethod method, Object requestBody,
                                                  Class<T> responseType, Optional<Object> pathVariable) {

        RestTemplate restTemplate = restTemplateBuilder.build();
// URL formatting if path variable is present

// Prepare the request entity (headers + body)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

// Define a RequestCallback to set up the request
// Use Jackson's ObjectMapper to convert request body to byte arrayrr
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] requestBodyBytes;
        try {
            requestBodyBytes = objectMapper.writeValueAsBytes(requestBody);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing request body", e);
        }

// Define a RequestCallback for setting up the request
        RequestCallback requestCallback = request -> {
// Set the headers
            entity.getHeaders()
                    .forEach((header, values) -> values.forEach(value -> request.getHeaders().add(header, value)));
// Write the body to the request's output stream
            request.getBody().write(requestBodyBytes);
        };

// Define a ResponseExtractor to extract the response body
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);

// Execute the request and get the response
        if (pathVariable.isPresent()) {
            return restTemplate.execute(url, method, requestCallback, responseExtractor, pathVariable);
        } else {
            return restTemplate.execute(url, method, requestCallback, responseExtractor);
        }
    }
}
