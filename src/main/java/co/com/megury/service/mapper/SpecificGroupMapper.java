package co.com.megury.service.mapper;

import co.com.megury.domain.SpecificGroup;
import co.com.megury.service.dto.SpecificGroupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecificGroupMapper extends EntityMapper<SpecificGroupDTO, SpecificGroup>{
}
