package co.com.megury.web.rest;

import co.com.megury.domain.Bill;
import co.com.megury.service.BillService;
import co.com.megury.service.dto.BillDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BillResource {

    private BillService billService;

    BillResource(BillService billService){
        this.billService = billService;
    }

    @PostMapping("/bills")
    public ResponseEntity<BillDTO> save(@RequestBody BillDTO billDTO) throws URISyntaxException {
        BillDTO result = billService.save(billDTO);
        return ResponseEntity.created( new URI("/api/bills"+result.getId()) ).body(result);
    }

    @PutMapping("/bills")
    public ResponseEntity<BillDTO> update(@RequestBody BillDTO billDTO){
        if(billDTO.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        BillDTO result = billService.save(billDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bills")
    public ResponseEntity<List<BillDTO>> update(){
        List<BillDTO> result = billService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<BillDTO> getOne(@PathVariable Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        Optional<BillDTO> result = billService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/bills/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        billService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
