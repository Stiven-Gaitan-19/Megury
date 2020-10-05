package co.com.megury.web.rest;

import co.com.megury.service.GeneralGroupService;
import co.com.megury.service.dto.FrequentCustomerDTO;
import co.com.megury.service.dto.GeneralGroupDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GeneralGroupResource {

    private GeneralGroupService generalGroupService;

    GeneralGroupResource(GeneralGroupService generalGroupService){
        this.generalGroupService = generalGroupService;
    }

    @PostMapping("/general-groups")
    public ResponseEntity<GeneralGroupDTO> save(@RequestBody GeneralGroupDTO generalGroupDTO) throws URISyntaxException {
        GeneralGroupDTO result = generalGroupService.save(generalGroupDTO);
        return ResponseEntity.created(new URI("/api/general-groups/"+result.getId())).body(result);
    }

    @PutMapping("/general-groups")
    public ResponseEntity update(@RequestBody GeneralGroupDTO generalGroupDTO){
        generalGroupService.save(generalGroupDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/general-groups")
    public ResponseEntity<List<GeneralGroupDTO>> getAll(){
        List<GeneralGroupDTO> result = generalGroupService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/general-groups/{id}")
    public ResponseEntity<GeneralGroupDTO> getOne(@PathVariable Long id){
        Optional<GeneralGroupDTO> result = generalGroupService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/general-groups/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        generalGroupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
