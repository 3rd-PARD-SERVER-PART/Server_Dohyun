package com.pard.hw2.Controller;

import com.pard.hw2.ProductDto.ProductDto;
import com.pard.hw2.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/find")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/find/{productId}")
    public ProductDto findById(@PathVariable Integer productId) {
        return productService.findById(productId);
    }

    @PatchMapping("/update/{productId}")
    public void update(@PathVariable Integer productId,@RequestBody ProductDto productDto) {
        productService.update(productId, productDto);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable Integer productId){
        productService.delete(productId);
    }
}
