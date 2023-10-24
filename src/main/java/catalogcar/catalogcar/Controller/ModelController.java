package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.ModelDTO;
import catalogcar.catalogcar.Service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> getModelById(@PathVariable UUID id) {
        ModelDTO modelDTO = modelService.getModelById(id);
        return modelDTO != null
                ? ResponseEntity.ok(modelDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<ModelDTO>> getAllModels() {
        List<ModelDTO> models = modelService.getAllModels();
        return ResponseEntity.ok(models);
    }

    @PostMapping("/{brandId}")
    public ResponseEntity<ModelDTO> createModel(@PathVariable UUID brandId, @RequestBody ModelDTO modelDTO) {
        ModelDTO createdModel = modelService.createModel(modelDTO, brandId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable UUID id, @RequestBody ModelDTO modelDTO) {
        ModelDTO updatedModel = modelService.updateModel(id, modelDTO);
        return updatedModel != null
                ? ResponseEntity.ok(updatedModel)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable UUID id) {
        modelService.deleteModel(id);
        return ResponseEntity.noContent().build();
    }
}