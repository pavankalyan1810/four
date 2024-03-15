package org.TableBookingSystem.Controller;

import java.util.List;

import org.TableBookingSystem.Service.CuisineTypeService;
import org.TableBookingSystem.model.CuisineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cuisineType")
public class CuisineTypeController {

    private final CuisineTypeService cuisineTypeService;

    @Autowired
    public CuisineTypeController(CuisineTypeService cuisineTypeService) {
        this.cuisineTypeService = cuisineTypeService;
    }

    @GetMapping("/list")
    public String listCuisineTypes(Model model) {
        List<CuisineType> cuisineTypes = cuisineTypeService.getAllCuisineTypes();
        model.addAttribute("cuisineTypes", cuisineTypes);
        return "cuisineType/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        CuisineType cuisineType = new CuisineType();
        model.addAttribute("cuisineType", cuisineType);
        return "cuisineType/form";
    }

    @PostMapping("/saveCuisineType")
    public String saveCuisineType(@ModelAttribute("cuisineType") CuisineType cuisineType) {
        cuisineTypeService.saveOrUpdateCuisineType(cuisineType);
        return "redirect:/cuisineType/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("cuisineTypeId") Long cuisineTypeId, Model model) {
        CuisineType cuisineType = cuisineTypeService.getCuisineTypeById(cuisineTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cuisineType Id:" + cuisineTypeId));
        model.addAttribute("cuisineType", cuisineType);
        return "cuisineType/form";
    }

    @GetMapping("/delete")
    public String deleteCuisineType(@RequestParam("cuisineTypeId") Long cuisineTypeId) {
        cuisineTypeService.deleteCuisineType(cuisineTypeId);
        return "redirect:/cuisineType/list";
    }
}