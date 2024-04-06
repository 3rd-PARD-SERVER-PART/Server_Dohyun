package com.pard.hw2.Repository;

import com.pard.hw2.Product;
import com.pard.hw2.ProductDto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepository {
    private static final Map<Integer, Product> productList = new HashMap<>();
    private Integer idNumber= 1;

    public void save(ProductDto productDto){
        productDto.setId(idNumber);
        Product product = Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .prize(productDto.getPrize())
                .amount(productDto.getAmount())
                .build();
        productList.put(productDto.getId(), product);
        idNumber += 1;
    }

    public ProductDto findById(Integer id){
        Product product = productList.get(id);
        assert product != null;
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .prize(product.getPrize())
                .amount(product.getAmount())
                .build();
    }

    public List<ProductDto> findAll(){
        return productList.values().stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .prize(product.getPrize())
                        .amount(product.getAmount())
                        .build()
                ).toList();
    }

    public void update(Integer id, ProductDto productDto){
        Product product = productList.get(id);
        product.setName(productDto.getName());
        product.setPrize(product.getPrize());
        product.setAmount(product.getAmount());
    }

    public void delete(Integer id){ productList.remove(id); }
}
