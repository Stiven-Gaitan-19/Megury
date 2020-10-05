package co.com.megury.web.rest;

import co.com.megury.service.OwnerService;
import co.com.megury.service.dto.ItemDTO;
import co.com.megury.service.dto.OwnerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OwnerResource {

    private OwnerService ownerService;

    OwnerResource(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @PostMapping("/owners")
    public ResponseEntity<OwnerDTO> save(@RequestBody OwnerDTO ownerDTO) throws URISyntaxException {
        OwnerDTO result = ownerService.save(ownerDTO);
        return ResponseEntity.created(new URI("/api/owners/"+result.getId())).body(result);
    }

    @PutMapping("/owners")
    public ResponseEntity update(@RequestBody OwnerDTO ownerDTO){
        ownerService.save(ownerDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/owners")
    public ResponseEntity<List<OwnerDTO>> getAll(){
        List<OwnerDTO> result = ownerService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<OwnerDTO> getOne(@PathVariable Long id){
        Optional<OwnerDTO> result = ownerService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/owners/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        ownerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
