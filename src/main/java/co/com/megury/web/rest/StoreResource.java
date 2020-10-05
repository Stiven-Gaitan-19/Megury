package co.com.megury.web.rest;

import co.com.megury.service.StoreService;
import co.com.megury.service.dto.SpecificGroupDTO;
import co.com.megury.service.dto.StoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StoreResource {

    private StoreService storeService;

    StoreResource(StoreService storeService){
        this.storeService = storeService;
    }

    @PostMapping("/stores")
    public ResponseEntity<StoreDTO> save(@RequestBody StoreDTO storeDTO) throws URISyntaxException {
        StoreDTO result = storeService.save(storeDTO);
        return ResponseEntity.created(new URI("/api/stores/"+result.getId())).body(result);
    }

    @PutMapping("/stores")
    public ResponseEntity update(@RequestBody StoreDTO storeDTO){
        storeService.save(storeDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stores")
    public ResponseEntity<List<StoreDTO>> getAll(){
        List<StoreDTO> result = storeService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreDTO> getOne(@PathVariable Long id){
        Optional<StoreDTO> result = storeService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        storeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
