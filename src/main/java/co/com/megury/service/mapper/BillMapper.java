package co.com.megury.service.mapper;

import co.com.megury.domain.Bill;
import co.com.megury.service.dto.BillDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper extends EntityMapper<BillDTO, Bill>{


}
