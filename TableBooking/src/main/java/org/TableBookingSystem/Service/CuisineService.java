package org.TableBookingSystem.Service;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Repository.CuisineRepository;
import org.TableBookingSystem.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuisineService {

    private final CuisineRepository cuisineRepository;

    @Autowired
    public CuisineService(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    public Cuisine saveCuisine(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }

    public void deleteCuisine(Long cuisineId) {
        cuisineRepository.deleteById(cuisineId);
    }

    public void updateCuisine(Cuisine cuisine) {
        // Check if the cuisine exists
        if (cuisineRepository.existsById(cuisine.getCuisineId())) {
            cuisineRepository.save(cuisine);
        }
    }
    
    public Optional<Cuisine> getCuisineById(Long cuisineId) {
        return cuisineRepository.findById(cuisineId);
    }

    public List<Cuisine> getAllCuisines() {
        return cuisineRepository.findAll();
    }
}