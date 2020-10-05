package co.com.megury.web.rest;

import co.com.megury.service.ItemService;
import co.com.megury.service.dto.GeneralGroupDTO;
import co.com.megury.service.dto.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemResource {

    private ItemService itemService;

    ItemResource(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDTO> save(@RequestBody ItemDTO generalGroupDTO) throws URISyntaxException {
        ItemDTO result = itemService.save(generalGroupDTO);
        return ResponseEntity.created(new URI("/api/items/"+result.getId())).body(result);
    }

    @PutMapping("/items")
    public ResponseEntity update(@RequestBody ItemDTO generalGroupDTO){
        itemService.save(generalGroupDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAll(){
        List<ItemDTO> result = itemService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDTO> getOne(@PathVariable Long id){
        Optional<ItemDTO> result = itemService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
