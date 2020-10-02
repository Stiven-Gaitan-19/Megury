package co.com.megury.service.mapper;

import co.com.megury.domain.Brand;
import co.com.megury.service.dto.BrandDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper extends EntityMapper<BrandDTO, Brand>{
}
