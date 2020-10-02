package co.com.megury.service;

import co.com.megury.repository.UserSystemRepository;
import co.com.megury.service.dto.UserSystemDTO;
import co.com.megury.service.mapper.UserSystemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSystemService {

    private UserSystemRepository userSystemRepository;
    private UserSystemMapper userSystemMapper;

    UserSystemService(UserSystemRepository userSystemRepository, UserSystemMapper userSystemMapper){
        this.userSystemRepository = userSystemRepository;
        this.userSystemMapper = userSystemMapper;
    }

    public UserSystemDTO save(UserSystemDTO dto){
        return userSystemMapper.toDto(userSystemRepository.save(userSystemMapper.toEntity(dto)));
    }

    public List<UserSystemDTO> findAll(){
        return userSystemMapper.toDtoList(userSystemRepository.findAll());
    }

    public Optional<UserSystemDTO> findById(Long id){
        return userSystemRepository.findById(id).map(userSystemMapper::toDto);
    }

    public void delete(UserSystemDTO dto){
        userSystemRepository.delete(userSystemMapper.toEntity(dto));
    }
}
