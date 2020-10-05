package co.com.megury.web.rest;

import co.com.megury.service.SpecificGroupService;
import co.com.megury.service.dto.ProductDTO;
import co.com.megury.service.dto.SpecificGroupDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SpecificGroupResource {

    private SpecificGroupService specificGroupService;

    SpecificGroupResource(SpecificGroupService specificGroupService){
        this.specificGroupService = specificGroupService;
    }

    @PostMapping("/specific-groups")
    public ResponseEntity<SpecificGroupDTO> save(@RequestBody SpecificGroupDTO specificGroupDTO) throws URISyntaxException {
        SpecificGroupDTO result = specificGroupService.save(specificGroupDTO);
        return ResponseEntity.created(new URI("/api/specific-groups/"+result.getId())).body(result);
    }

    @PutMapping("/specific-groups")
    public ResponseEntity update(@RequestBody SpecificGroupDTO specificGroupDTO){
        specificGroupService.save(specificGroupDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/specific-groups")
    public ResponseEntity<List<SpecificGroupDTO>> getAll(){
        List<SpecificGroupDTO> result = specificGroupService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/specific-groups/{id}")
    public ResponseEntity<SpecificGroupDTO> getOne(@PathVariable Long id){
        Optional<SpecificGroupDTO> result = specificGroupService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/specific-groups/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        specificGroupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
