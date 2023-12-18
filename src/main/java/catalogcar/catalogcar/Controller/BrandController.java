package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.AddBrandsDto;
import catalogcar.catalogcar.Service.NewBrandsServices;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private final NewBrandsServices newBrandService;

    public BrandController(NewBrandsServices newBrandService) {
        this.newBrandService = newBrandService;
    }

    @ModelAttribute("brandModel")
    public AddBrandsDto initCompany() {
        return new AddBrandsDto();
    }

    @GetMapping("/add")
    public String addBrand(){
        return "brand-add";
    }

    @PostMapping("/add")
    public String addBrand(@Valid AddBrandsDto brandModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel", bindingResult);
            return "redirect:/brands/add";
        }
        newBrandService.addBrands(brandModel);

        return "redirect:/";
    }


    @ModelAttribute("brandModel")
    public AddBrandsDto initBrand(){
        return new AddBrandsDto();
    }

    @GetMapping("/all")
    public String showAllBrands(Model model){
        model.addAttribute("BrandInfo", newBrandService.allBrands());
        return  "brand-all";
    }

    @GetMapping("/brand-details/{brand-name}")
    public  String brandsDetails(@PathVariable("brand-name") String brandName, Model model){
        model.addAttribute("brandsDetails", newBrandService.brandsDetails(brandName));
        return "brand-details";
    }

    @GetMapping("/brand-delete/{brand-name}")
    public String deleteBrand(@PathVariable("brand-name") String brandName) {
        newBrandService.removeBrands(brandName);
        return "redirect:/brands/all";
    }

}
