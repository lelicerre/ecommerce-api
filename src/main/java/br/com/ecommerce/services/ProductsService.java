package br.com.ecommerce.services;

import br.com.ecommerce.mappers.ProductMapper;
import br.com.ecommerce.models.Product;
import br.com.ecommerce.models.dto.ProductRequestDTO;
import br.com.ecommerce.repositorys.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ProductsService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductRequestDTO productRequestDTO) {
        return productRepository.save(productMapper.toEntity(productRequestDTO));
    }

    public Product updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toEntity(productRequestDTO);
        product.setId(id);
        return productRepository.save(product);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAllByStatus(true, pageable);
    }

    public Product delete(Long id) {
        Product referenceById = productRepository.getReferenceById(id);
        referenceById.setStatus(false);
        return productRepository.save(referenceById);
    }

}
