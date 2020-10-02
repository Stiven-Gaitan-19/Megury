package co.com.megury.service;

import co.com.megury.repository.DepartmentRepository;
import co.com.megury.service.dto.DepartmentDTO;
import co.com.megury.service.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper){
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentDTO save(DepartmentDTO dto){
        return departmentMapper.toDto(departmentRepository.save(departmentMapper.toEntity(dto)));
    }

    public List<DepartmentDTO> findAll(){
        return departmentMapper.toDtoList(departmentRepository.findAll());
    }

    public Optional<DepartmentDTO> findById(Long id){
        return departmentRepository.findById(id).map( departmentMapper::toDto);
    }

    public void delete(DepartmentDTO dto){
        departmentRepository.delete(departmentMapper.toEntity(dto));
    }
}
