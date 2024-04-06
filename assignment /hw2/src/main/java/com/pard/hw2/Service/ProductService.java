package com.pard.hw2.Service;

import com.pard.hw2.ProductDto.ProductDto;
import com.pard.hw2.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public void saveProduct(ProductDto productDto) { productRepository.save(productDto);}

    public ProductDto findById(Integer id) { return productRepository.findById(id); }

    public List<ProductDto> findAll() {return productRepository.findAll();}

    public void update(Integer id, ProductDto productDto) {productRepository.update(id, productDto);}

    public  void delete(Integer id) { productRepository.delete(id); }
}
