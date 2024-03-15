package org.TableBookingSystem.Service;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Repository.TableRepository;
import org.TableBookingSystem.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public Table addTable(Table table) {
        return tableRepository.save(table);
    }

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Table getTableByTableId(Long tableId) {
        return tableRepository.findBytableId(tableId).orElse(null);
    }

    public List<Table> getAvailableTables() {
        return tableRepository.findByBookedFalse();
    }
    

    public String setTableAsAvailable(Long tableId) {
        Optional<Table> optionalTable = tableRepository.findBytableId(tableId);
        if (optionalTable.isPresent()) {
            Table table = optionalTable.get();
            if (table.isBooked()) {
                table.setBooked(false);
                tableRepository.save(table);
                return "Table set as available successfully";
            } else {
                return "Table is not yet booked";
            }
        }
        return "Table not found";
    }
    
    public String deleteTable(Long tableId) {
        Optional<Table> optionalTable = tableRepository.findBytableId(tableId);
        if (optionalTable.isPresent()) {
            tableRepository.deleteById(tableId);
            return "Table deleted successfully";
        }
        return "Table not found";
    }
    
    public String updateTable(Long tableId, Table updatedTable) {
        Optional<Table> optionalTable = tableRepository.findBytableId(tableId);
        if (optionalTable.isPresent()) {
            Table table = optionalTable.get();
            // Update properties of the table
            table.setCapacity(updatedTable.getCapacity());
            table.setBooked(updatedTable.isBooked());
            // Save the updated table
            tableRepository.save(table);
            return "Table updated successfully";
        }
        return "Table not found";
    }
    
}
