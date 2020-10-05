package co.com.megury.web.rest;

import co.com.megury.service.ProductService;
import co.com.megury.service.dto.OwnerDTO;
import co.com.megury.service.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private ProductService productService;

    ProductResource(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        ProductDTO result = productService.save(productDTO);
        return ResponseEntity.created(new URI("/api/products/"+result.getId())).body(result);
    }

    @PutMapping("/products")
    public ResponseEntity update(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<ProductDTO> result = productService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getOne(@PathVariable Long id){
        Optional<ProductDTO> result = productService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
