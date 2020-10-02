package co.com.megury.service;

import co.com.megury.repository.ItemRepository;
import co.com.megury.service.dto.ItemDTO;
import co.com.megury.service.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    private ItemService(ItemRepository itemRepository, ItemMapper itemMapper){
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTO save(ItemDTO dto){
        return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(dto)));
    }

    public List<ItemDTO> findAll(){
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    public Optional<ItemDTO> findById(Long id){
        return itemRepository.findById(id).map(itemMapper::toDto);
    }

    public void delete(ItemDTO dto){
        itemRepository.delete(itemMapper.toEntity(dto));
    }
}
