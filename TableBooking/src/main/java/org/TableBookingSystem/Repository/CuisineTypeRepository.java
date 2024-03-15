package org.TableBookingSystem.Repository;

import org.TableBookingSystem.model.CuisineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineTypeRepository extends JpaRepository<CuisineType, Long> {
    // You can add custom query methods here if needed
}