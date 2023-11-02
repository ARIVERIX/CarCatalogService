package catalogcar.catalogcar.Service.Impl;

import catalogcar.catalogcar.DTO.ModelDTO;
import catalogcar.catalogcar.Model.Brand;
import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.Repository.ModelRepository;
import catalogcar.catalogcar.Service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDTO getModelById(UUID id) {
        Model model = modelRepository.findById(id).orElse(null);
        if (model == null) {
            return null;
        }
        return modelMapper.map(model, ModelDTO.class);
    }

    @Override
    public List<ModelDTO> getAllModels() {
        List<Model> models = modelRepository.findAll();
        return models.stream()
                .map(model -> modelMapper.map(model, ModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ModelDTO createModel(ModelDTO modelDTO, UUID brandId) {
        Model model = modelMapper.map(modelDTO, Model.class);

        Brand brand = new Brand();
        brand.setId(brandId);
        model.setBrand(brand);

        model.setCreated(LocalDateTime.now());
        model.setModified(LocalDateTime.now());
        model.setId(UUID.randomUUID());

        Model savedModel = modelRepository.save(model);
        return modelMapper.map(savedModel, ModelDTO.class);
    }

    @Override
    public ModelDTO updateModel(UUID id, ModelDTO modelDTO) {
        Model existingModel = modelRepository.findById(id).orElse(null);
        if (existingModel == null) {
            return null;
        }
        modelMapper.map(modelDTO, existingModel);
        existingModel.setModified(LocalDateTime.now());
        Model updatedModel = modelRepository.save(existingModel);
        return modelMapper.map(updatedModel, ModelDTO.class);
    }

    @Override
    public void deleteModel(UUID id) {
        modelRepository.deleteById(id);
    }
}
