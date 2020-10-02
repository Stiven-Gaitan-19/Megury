package co.com.megury.service.mapper;

import co.com.megury.domain.FrequentCustomer;
import co.com.megury.service.dto.FrequentCustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FrequentCustomerMapper extends EntityMapper<FrequentCustomerDTO, FrequentCustomer>{
}
