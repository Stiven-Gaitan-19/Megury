package co.com.megury.service;

import co.com.megury.repository.OwnerRepository;
import co.com.megury.service.dto.OwnerDTO;
import co.com.megury.service.mapper.OwnerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerMapper ownerMapper;

    OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper){
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    public OwnerDTO save(OwnerDTO dto){
        return ownerMapper.toDto(ownerRepository.save(ownerMapper.toEntity(dto)));
    }

    public List<OwnerDTO> findAll(){
        return ownerMapper.toDtoList(ownerRepository.findAll());
    }

    public Optional<OwnerDTO> findById(Long id){
        return ownerRepository.findById(id).map(ownerMapper::toDto);
    }

    public void delete(OwnerDTO dto){
        ownerRepository.delete(ownerMapper.toEntity(dto));
    }
}
