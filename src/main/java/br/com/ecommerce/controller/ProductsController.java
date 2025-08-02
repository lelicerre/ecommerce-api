package br.com.ecommerce.controller;

import br.com.ecommerce.models.Product;
import br.com.ecommerce.models.dto.ProductRequestDTO;
import br.com.ecommerce.services.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> listAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Product> products = productsService.findAll(pageable);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid ProductRequestDTO product) {
        return ResponseEntity.ok(productsService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO product) {
        return ResponseEntity.ok(productsService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product delete = productsService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
