package org.TableBookingSystem.Service;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Repository.CuisineTypeRepository;
import org.TableBookingSystem.model.CuisineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuisineTypeService {

	@Autowired
    private  CuisineTypeRepository cuisineTypeRepository;

    
    
    public CuisineType saveOrUpdateCuisineType(CuisineType cuisineType) {
        return cuisineTypeRepository.save(cuisineType);
    }

    public void deleteCuisineType(Long cuisineTypeId) {
        cuisineTypeRepository.deleteById(cuisineTypeId);
    }

    public Optional<CuisineType> getCuisineTypeById(Long cuisineTypeId) {
        return cuisineTypeRepository.findById(cuisineTypeId);
    }

    public List<CuisineType> getAllCuisineTypes() {
        return cuisineTypeRepository.findAll();
    }
}