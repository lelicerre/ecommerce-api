package br.com.ecommerce.mappers;

import br.com.ecommerce.models.Product;
import br.com.ecommerce.models.dto.ProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductRequestDTO dto);

    ProductRequestDTO toDTO(Product product);
}