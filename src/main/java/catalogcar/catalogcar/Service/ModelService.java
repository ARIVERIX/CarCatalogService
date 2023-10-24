package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.ModelDTO;

import java.util.List;
import java.util.UUID;

public interface ModelService {

    ModelDTO getModelById(UUID id);

    List<ModelDTO> getAllModels();

    ModelDTO createModel(ModelDTO modelDTO, UUID brandId);

    ModelDTO updateModel(UUID id, ModelDTO modelDTO);

    void deleteModel(UUID id);
}