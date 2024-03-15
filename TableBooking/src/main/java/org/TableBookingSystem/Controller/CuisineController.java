package org.TableBookingSystem.Controller;

import java.util.List;

import org.TableBookingSystem.Service.CuisineService;
import org.TableBookingSystem.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cuisine")
public class CuisineController {

    private final CuisineService cuisineService;

    @Autowired
    public CuisineController(CuisineService cuisineService) {
        this.cuisineService = cuisineService;
    }

    @GetMapping("/list")
    public String listCuisines(Model model) {
        List<Cuisine> cuisines = cuisineService.getAllCuisines();
        model.addAttribute("cuisines", cuisines);
        return "cuisine/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {	
        Cuisine cuisine = new Cuisine();
        model.addAttribute("cuisine", cuisine);
        return "cuisine/form";
    }

    @PostMapping("/saveCuisine")
    public String saveCuisine(@ModelAttribute("cuisine") Cuisine cuisine) {
        cuisineService.saveCuisine(cuisine);
        return "redirect:/cuisine/list";
    }
    
    @PostMapping("/{id}/update")
    public String updateCuisine(@PathVariable Long id, Cuisine cuisine) {
        cuisine.setCuisineId(id); // Ensure the correct ID is set for update
        cuisineService.updateCuisine(cuisine);
        return "redirect:/cuisines"; // Redirect to the list of all cuisines
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("cuisineId") Long cuisineId, Model model) {
        Cuisine cuisine = cuisineService.getCuisineById(cuisineId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cuisine Id:" + cuisineId));
        model.addAttribute("cuisine", cuisine);
        return "cuisine/form";
    }

    @GetMapping("/delete")
    public String deleteCuisine(@RequestParam("cuisineId") Long cuisineId) {
        cuisineService.deleteCuisine(cuisineId);
        return "redirect:/cuisine/list";
    }
}