package co.com.megury.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.megury.domain.UserSystem;
import co.com.megury.service.dto.UserSystemDTO;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserSystemMapper extends EntityMapper<UserSystemDTO, UserSystem>{
}
