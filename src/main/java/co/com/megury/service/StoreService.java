package co.com.megury.service;

import co.com.megury.repository.StoreRepository;
import co.com.megury.service.dto.StoreDTO;
import co.com.megury.service.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private StoreRepository storeRepository;
    private StoreMapper storeMapper;

    StoreService(StoreRepository storeRepository, StoreMapper storeMapper){
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    public StoreDTO save(StoreDTO dto){
        return storeMapper.toDto(storeRepository.save(storeMapper.toEntity(dto)));
    }

    public List<StoreDTO> findAll(){
        return storeMapper.toDtoList(storeRepository.findAll());
    }

    public Optional<StoreDTO> findById(Long id){
        return storeRepository.findById(id).map(storeMapper::toDto);
    }

    public void delete(Long id){
        storeRepository.deleteById(id);
    }
}
