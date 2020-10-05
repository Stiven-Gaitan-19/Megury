package co.com.megury.web.rest;

import co.com.megury.service.BrandService;
import co.com.megury.service.dto.BrandDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BrandResource {

    private BrandService brandService;

    BrandResource(BrandService brandService){
        this.brandService = brandService;
    }

    @PostMapping("/brands")
    public ResponseEntity<BrandDTO> save(@RequestBody BrandDTO brandDTO) throws URISyntaxException {
        BrandDTO result = brandService.save(brandDTO);
        return ResponseEntity.created(new URI("/api/brands/"+result.getId())).body(result);
    }

    @PutMapping("/brands")
    public ResponseEntity update(@RequestBody BrandDTO brandDTO){
        brandService.save(brandDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandDTO>> getAll(){
        List<BrandDTO> result = brandService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<BrandDTO> getOne(@PathVariable Long id){
        Optional<BrandDTO> result = brandService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
