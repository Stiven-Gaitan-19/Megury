package co.com.megury.service;

import co.com.megury.repository.GeneralGroupRepository;
import co.com.megury.service.dto.GeneralGroupDTO;
import co.com.megury.service.mapper.GeneralGroupMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralGroupService {

    private GeneralGroupRepository generalGroupRepository;
    private GeneralGroupMapper generalGroupMapper;

    GeneralGroupService(GeneralGroupRepository generalGroupRepository, GeneralGroupMapper generalGroupMapper){
        this.generalGroupRepository = generalGroupRepository;
        this.generalGroupMapper = generalGroupMapper;
    }

    public GeneralGroupDTO save(GeneralGroupDTO dto){
        return generalGroupMapper.toDto(generalGroupRepository.save(generalGroupMapper.toEntity(dto)));
    }

    public List<GeneralGroupDTO> findAll(){
        return generalGroupMapper.toDtoList(generalGroupRepository.findAll());
    }

    public Optional<GeneralGroupDTO> findById(Long id){
        return generalGroupRepository.findById(id).map(generalGroupMapper::toDto);
    }

    public void delete(Long id){
        generalGroupRepository.deleteById(id);
    }
}
