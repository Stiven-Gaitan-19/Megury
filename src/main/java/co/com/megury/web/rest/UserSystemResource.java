package co.com.megury.web.rest;

import co.com.megury.service.UserSystemService;
import co.com.megury.service.dto.UserSystemDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserSystemResource {

    private UserSystemService userSystemService;

    UserSystemResource(UserSystemService userSystemService){
        this.userSystemService = userSystemService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserSystemDTO> save(@RequestBody UserSystemDTO userSystemDTO) throws URISyntaxException {
        userSystemDTO.setCreatedAt(LocalDate.now());
        UserSystemDTO result = userSystemService.save(userSystemDTO);
        return ResponseEntity.created(new URI("/api/users"+result.getId()) ).body(result);
    }

    @PutMapping("/users")
    public ResponseEntity<UserSystemDTO> update (@RequestBody UserSystemDTO userSystemDTO) throws URISyntaxException {
        UserSystemDTO result = userSystemService.save(userSystemDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSystemDTO>> getUsers(){
        List<UserSystemDTO> result = userSystemService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserSystemDTO> getUserById(@PathVariable Long id){
        Optional<UserSystemDTO> result = userSystemService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userSystemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
