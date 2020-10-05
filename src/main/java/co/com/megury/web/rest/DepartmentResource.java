package co.com.megury.web.rest;

import co.com.megury.service.DepartmentService;
import co.com.megury.service.dto.DepartmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentResource {

    private DepartmentService departmentService;

    DepartmentResource(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDTO> save(@RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {
        DepartmentDTO result = departmentService.save(departmentDTO);
        return ResponseEntity.created(new URI("/api/departments/"+result.getId())).body(result);
    }

    @PutMapping("/departments")
    public ResponseEntity update(@RequestBody DepartmentDTO departmentDTO){
        departmentService.save(departmentDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDTO>> getAll(){
        List<DepartmentDTO> result = departmentService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> getOne(@PathVariable Long id){
        Optional<DepartmentDTO> result = departmentService.findById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
