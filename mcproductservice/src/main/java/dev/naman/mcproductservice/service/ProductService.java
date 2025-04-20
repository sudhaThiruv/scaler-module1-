package dev.naman.mcproductservice.service;

import dev.naman.mcproductservice.Models.Product;
import dev.naman.mcproductservice.dtos.GetProductDetailsRequestDTO;
import dev.naman.mcproductservice.dtos.UserServiceVerifyUserDto;
import dev.naman.mcproductservice.repository.ProductRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private  RestTemplate restTemplate;


    public ProductService(ProductRepository productRepository
    ,RestTemplate restTemplate){
        this.productRepository=productRepository;

        this.restTemplate=restTemplate;
    }
private  boolean autheticate(String email,String password){

    UserServiceVerifyUserDto dto=new UserServiceVerifyUserDto();
    dto.setEmail(email);
    dto.setPassword(password);
    ResponseEntity<Boolean> response=restTemplate.postForEntity("http://userservice/users/verify",dto,Boolean.class);
    boolean answer=response.getBody();

    return  answer;
}

   public Product getProductDetails(Long productId , String email, String password){

       //Product getproduct=productRepository.getById(productId);

       Optional<Product> getproduct =productRepository.findById(productId);
       if (getproduct.isEmpty()){

       }
       return getproduct.get();
   }

   public Product createProduct(Product product,String email,String password){

       if(!autheticate(email,password)){
           return  null;
       }
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }


}
