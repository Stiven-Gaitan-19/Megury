package co.com.megury.service.mapper;

import co.com.megury.domain.Owner;
import co.com.megury.service.dto.OwnerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends EntityMapper<OwnerDTO, Owner>{
}
