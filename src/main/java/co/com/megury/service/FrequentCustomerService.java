package co.com.megury.service;

import co.com.megury.repository.FrequentCustomerRepository;
import co.com.megury.service.dto.FrequentCustomerDTO;
import co.com.megury.service.mapper.FrequentCustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrequentCustomerService {

    private FrequentCustomerRepository frequentCustomerRepository;
    private FrequentCustomerMapper frequentCustomerMapper;

    FrequentCustomerService(FrequentCustomerRepository frequentCustomerRepository, FrequentCustomerMapper frequentCustomerMapper){
        this.frequentCustomerMapper = frequentCustomerMapper;
        this.frequentCustomerRepository = frequentCustomerRepository;
    }

    public FrequentCustomerDTO save(FrequentCustomerDTO dto){
        return frequentCustomerMapper.toDto(frequentCustomerRepository.save(frequentCustomerMapper.toEntity(dto)));
    }

    public List<FrequentCustomerDTO> findAll(){
        return frequentCustomerMapper.toDtoList(frequentCustomerRepository.findAll());
    }

    public Optional<FrequentCustomerDTO> findById(Long id){
        return frequentCustomerRepository.findById(id).map(frequentCustomerMapper::toDto);
    }

    public void delete(Long id){
        frequentCustomerRepository.deleteById(id);
    }
}
