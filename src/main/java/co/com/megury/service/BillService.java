package co.com.megury.service;

import co.com.megury.repository.BillRepository;
import co.com.megury.service.dto.BillDTO;
import co.com.megury.service.mapper.BillMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class BillService {

    private BillRepository billRepository;
    private BillMapper billMapper;

    BillService(BillRepository billRepository, BillMapper billMapper){
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }

    public BillDTO save(BillDTO dto){
        return billMapper.toDto(billRepository.save(billMapper.toEntity(dto)));
    }

    public List<BillDTO> findAll(){
        return billMapper.toDtoList(billRepository.findAll());
    }

    public Optional<BillDTO> findById(Long id){
        return billRepository.findById(id).map(billMapper::toDto);
    }

    public void delete(BillDTO dto){
        billRepository.delete(billMapper.toEntity(dto));
    }

}
