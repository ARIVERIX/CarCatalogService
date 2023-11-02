package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.ModelDTO;
import catalogcar.catalogcar.Service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> getModelById(@PathVariable UUID id) {
        ModelDTO modelDTO = modelService.getModelById(id);
        if (modelDTO != null) {
            return ResponseEntity.ok(modelDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public List<ModelDTO> getAllModels() {
        return modelService.getAllModels();
    }

    @PostMapping("/{brandId}")
    public ResponseEntity<ModelDTO> createModel(@RequestBody ModelDTO modelDTO, @PathVariable UUID brandId) {
        ModelDTO createdModel = modelService.createModel(modelDTO, brandId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable UUID id, @RequestBody ModelDTO modelDTO) {
        ModelDTO updatedModel = modelService.updateModel(id, modelDTO);
        if (updatedModel != null) {
            return ResponseEntity.ok(updatedModel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable UUID id) {
        modelService.deleteModel(id);
        return ResponseEntity.noContent().build();
    }
}
