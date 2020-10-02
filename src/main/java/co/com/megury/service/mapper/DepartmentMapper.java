package co.com.megury.service.mapper;

import co.com.megury.domain.Department;
import co.com.megury.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department>{
}
