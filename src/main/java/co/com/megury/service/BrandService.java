package co.com.megury.service;

import co.com.megury.repository.BrandRepository;
import co.com.megury.service.dto.BrandDTO;
import co.com.megury.service.mapper.BrandMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private BrandMapper brandMapper;

    BrandService(BrandRepository brandRepository, BrandMapper brandMapper){
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    public BrandDTO save(BrandDTO dto){
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(dto)));
    }

    public List<BrandDTO> findAll(){
        return brandMapper.toDtoList(brandRepository.findAll());
    }

    public Optional<BrandDTO> findById(Long id){
        return brandRepository.findById(id).map(brandMapper::toDto);
    }

    public void delete(Long id){
        brandRepository.deleteById(id);
    }
}
