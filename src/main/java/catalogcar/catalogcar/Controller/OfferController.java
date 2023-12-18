package catalogcar.catalogcar.Controller;


import catalogcar.catalogcar.DTO.AddOffersDto;
import catalogcar.catalogcar.Service.NewOffersServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private final NewOffersServices newOffersServices;

    public OfferController(NewOffersServices newOffersServices) {
        this.newOffersServices = newOffersServices;
    }


    @ModelAttribute("offerModel")
    public AddOffersDto initOffer(){
        return new AddOffersDto();
    }

    @GetMapping("/add")
    public String addOffer(){
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOffersDto offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/add";
        }
        newOffersServices.addOffer(offerModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllOffers(Model model){
        model.addAttribute("OfferInfo", newOffersServices.allOffers());
        return  "offer-all";
    }

    @GetMapping("/offer-details/{offer-description}")
    public  String offerDetails(@PathVariable("offer-description") String description, Model model){
        model.addAttribute("offersDetails", newOffersServices.offersDetails(description));
        return "offer-details";
    }

    @GetMapping("/offer-delete/{offer-description}")
    public String deleteOffer(@PathVariable("offer-description") String description){
        newOffersServices.removeOffer(description);
        return "redirect:/offers/all";
    }
}
