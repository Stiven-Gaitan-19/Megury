package co.com.megury.service.mapper;

import co.com.megury.domain.GeneralGroup;
import co.com.megury.service.dto.GeneralGroupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneralGroupMapper extends EntityMapper<GeneralGroupDTO, GeneralGroup>{
}
