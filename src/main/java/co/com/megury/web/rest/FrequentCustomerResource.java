package co.com.megury.web.rest;

import co.com.megury.service.FrequentCustomerService;
import co.com.megury.service.dto.DepartmentDTO;
import co.com.megury.service.dto.FrequentCustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FrequentCustomerResource {

    private FrequentCustomerService frequentCustomerService;

    FrequentCustomerResource(FrequentCustomerService frequentCustomerService){
        this.frequentCustomerService = frequentCustomerService;
    }

    @PostMapping("/frequent-customers")
    public ResponseEntity<FrequentCustomerDTO> save(@RequestBody FrequentCustomerDTO frequentCustomerDTO) throws URISyntaxException {
        FrequentCustomerDTO result = frequentCustomerService.save(frequentCustomerDTO);
        return ResponseEntity.created(new URI("/api/frequent-customers/"+result.getId())).body(result);
    }

    @PutMapping("/frequent-customers")
    public ResponseEntity update(@RequestBody FrequentCustomerDTO frequentCustomerDTO){
        frequentCustomerService.save(frequentCustomerDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/frequent-customers")
    public ResponseEntity<List<FrequentCustomerDTO>> getAll(){
        List<FrequentCustomerDTO> result = frequentCustomerService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/frequent-customers/{id}")
    public ResponseEntity<FrequentCustomerDTO> getOne(@PathVariable Long id){
        Optional<FrequentCustomerDTO> result = frequentCustomerService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/frequent-customers/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        frequentCustomerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
