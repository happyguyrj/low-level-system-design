package com.example.productRepo;

import com.example.productRepo.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//The @RestController annotation is used to define the RESTful web services. It serves JSON, XML and custom response
public class ProductRepoController {

    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    // GET API
    // @RequestMapping annotation is used to define the Request URI to access the REST Endpoints.
    // We can define Request method to consume and produce object. The default request method is GET.
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }

    // The @RequestBody annotation is used to define the request body content type.

    // POST API
    // The HTTP POST request is used to create a resource. This method contains the Request Body.
    // We can send request parameters and path variables to define the custom or dynamic URL.
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    // PUT API
    // The HTTP PUT request is used to update the existing resource. This method contains a Request Body.
    // We can send request parameters and path variables to define the custom or dynamic URL.
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    // The @PathVariable annotation is used to define the custom or dynamic request URI.

    // DELETE API
    // The HTTP Delete request is used to delete the existing resource. This method does not contain any Request Body.
    // We can send request parameters and path variables to define the custom or dynamic URL.
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

}
