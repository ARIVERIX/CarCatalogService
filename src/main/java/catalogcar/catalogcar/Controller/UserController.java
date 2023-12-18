package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.AddUsersDto;
import catalogcar.catalogcar.Service.NewUsersServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final NewUsersServices newUsersServices;

    public UserController(NewUsersServices newUsersServices) {
        this.newUsersServices = newUsersServices;
    }

    @ModelAttribute("userModel")
    public AddUsersDto initUser(){
        return new AddUsersDto();
    }

    @GetMapping("/add")
    public String addUser(){
        return "user-add";
    }

    @PostMapping("/add")
    public String addUser(@Valid AddUsersDto userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/add";
        }
        newUsersServices.addUsers(userModel);

        System.out.println("Email: " + userModel.getEmail());
        System.out.println("Password: " + userModel.getPassword());

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllUsers(Model model){
        model.addAttribute("UserInfo", newUsersServices.allUsers());
        return  "user-all";
    }

    @GetMapping("/user-details/{user-name}")
    public  String userDetails(@PathVariable("user-name") String email, Model model){
        model.addAttribute("usersDetails", newUsersServices.usersDetails(email));
        return "user-details";
    }

    @GetMapping("/user-delete/{user-email}")
    public String deleteUser(@PathVariable("user-email") String email){
        newUsersServices.removeUser(email);
        return "redirect:/users/all";
    }
}
