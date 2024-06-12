package com.market.backend.market.service;


import com.market.backend.market.api.model.ProductRequestBody;
import com.market.backend.market.model.Product;
import com.market.backend.market.model.dao.ProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getProducts(){
        return productDAO.findAll();
    }

    @Transactional
    public Product addProduct(ProductRequestBody productRequest) {
        Product product = new Product();
        product.setProduct_name(productRequest.getProduct_name());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setPhoto(productRequest.getPhoto());

        return productDAO.save(product);
    }
}
