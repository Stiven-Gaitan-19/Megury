package co.com.megury.service.mapper;

import co.com.megury.domain.Product;
import co.com.megury.service.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product>{
}
