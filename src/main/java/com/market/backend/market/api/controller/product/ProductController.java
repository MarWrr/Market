package com.market.backend.market.api.controller.product;

import com.market.backend.market.api.model.ProductRequestBody;
import com.market.backend.market.model.Product;
import com.market.backend.market.model.Users;
import com.market.backend.market.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductRequestBody productRequest,
                              @AuthenticationPrincipal Users user) {
        return productService.addProduct(productRequest, user);
    }
}
