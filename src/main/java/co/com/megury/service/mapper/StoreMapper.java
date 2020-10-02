package co.com.megury.service.mapper;

import co.com.megury.domain.Store;
import co.com.megury.service.dto.StoreDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapper extends EntityMapper<StoreDTO, Store> {
}
