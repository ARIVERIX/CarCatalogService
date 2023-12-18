package catalogcar.catalogcar.Controller;


import catalogcar.catalogcar.DTO.AddModelsDto;
import catalogcar.catalogcar.DTO.ShowModelInfoDto;
import catalogcar.catalogcar.Service.NewModelsServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private final NewModelsServices newModelsServices;

    public ModelController(NewModelsServices newModelsServices) {
        this.newModelsServices = newModelsServices;
    }

    @ModelAttribute("modelModel")
    public AddModelsDto initModel(){
        return new AddModelsDto();
    }

    @GetMapping("/add")
    public String addModel(){
        return "model-add";
    }

    @PostMapping("/add")
    public String addModel(@Valid AddModelsDto modelModel, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("modelModel", modelModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelModel", bindingResult);
            return "redirect:/models/add";
        }

        newModelsServices.addModels(modelModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllModels(Model model) {
        List<ShowModelInfoDto> sortedModels = newModelsServices.allModels()
                .stream()
                .sorted(Comparator.comparingInt(ShowModelInfoDto::getStart_year).reversed())
                .collect(Collectors.toList());

        model.addAttribute("ModelInfo", sortedModels);
        return "model-all";
    }

    @GetMapping("/model-details/{model-name}")
    public  String modelDetails(@PathVariable("model-name") String name, Model model){
        model.addAttribute("modelsDetails", newModelsServices.modelsDetails(name));
        return "model-details";
    }

    @GetMapping("/model-delete/{model-name}")
    public String deleteModel(@PathVariable("model-name") String modelName){
        newModelsServices.removeModel(modelName);
        return "redirect:/models/all";
    }
}
