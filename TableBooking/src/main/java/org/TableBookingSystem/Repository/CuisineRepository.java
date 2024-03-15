package org.TableBookingSystem.Repository;

import org.TableBookingSystem.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    // You can add custom query methods here if needed
}