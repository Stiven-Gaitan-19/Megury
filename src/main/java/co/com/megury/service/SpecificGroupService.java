package co.com.megury.service;

import co.com.megury.repository.SpecificGroupRepository;
import co.com.megury.service.dto.SpecificGroupDTO;
import co.com.megury.service.mapper.SpecificGroupMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecificGroupService {

    private SpecificGroupRepository specificGroupRepository;
    private SpecificGroupMapper specificGroupMapper;

    SpecificGroupService(SpecificGroupRepository specificGroupRepository, SpecificGroupMapper specificGroupMapper){
        this.specificGroupRepository = specificGroupRepository;
        this.specificGroupMapper = specificGroupMapper;
    }

    public SpecificGroupDTO save(SpecificGroupDTO dto){
        return specificGroupMapper.toDto(specificGroupRepository.save(specificGroupMapper.toEntity(dto)));
    }

    public List<SpecificGroupDTO> findAll(){
        return specificGroupMapper.toDtoList(specificGroupRepository.findAll());
    }

    public Optional<SpecificGroupDTO> findById(Long id){
        return specificGroupRepository.findById(id).map(specificGroupMapper::toDto);
    }

    public void delete(SpecificGroupDTO dto){
        specificGroupRepository.delete(specificGroupMapper.toEntity(dto));
    }
}
