package co.com.megury.service.mapper;

import co.com.megury.domain.Item;
import co.com.megury.service.dto.ItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
}
