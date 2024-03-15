package org.TableBookingSystem.Controller;

import java.util.List;

import org.TableBookingSystem.Service.TableService;
import org.TableBookingSystem.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/tables")
    public String getAllTables(Model model) {
        List<Table> tables = tableService.getAllTables();
        model.addAttribute("tables", tables);
        return "tableList"; // HTML view name for listing tables
    }

    @GetMapping("/tables/available")
    public String getAvailableTables(Model model) {
        List<Table> availableTables = tableService.getAvailableTables();
        model.addAttribute("availableTables", availableTables);
        return "availableTableList"; // HTML view name for listing available tables
    }

    @GetMapping("/tables/{tableId}")
    public String getTableById(@PathVariable Long tableId, Model model) {
        Table table = tableService.getTableByTableId(tableId);
        model.addAttribute("table", table);
        return "tableDetails"; // HTML view name for displaying single table details
    }

    @PostMapping("/tables/add")
    public String addTable(Table table) {
        tableService.addTable(table);
        return "redirect:/tables"; // Redirect to the list of all tables
    }

    @PostMapping("/tables/{tableId}/set-available")
    public String setTableAsAvailable(@PathVariable Long tableId) {
        tableService.setTableAsAvailable(tableId);
        return "redirect:/tables/available"; // Redirect to the list of available tables
    }
    @PostMapping("/tables/update/{tableId}")
    public String updateTable(@PathVariable Long tableId, Table updatedTable) {
        String message = tableService.updateTable(tableId, updatedTable);
        // Assuming you have a view to display messages, you can pass the message to it
        return "messageViewupate"; // Replace "messageView" with your actual view name
    }

    @PostMapping("/tables/delete/{tableId}")
    public String deleteTable(@PathVariable Long tableId) {
        String message = tableService.deleteTable(tableId);
        // Assuming you have a view to display messages, you can pass the message to it
        return "messageViewdelete"; // Replace "messageView" with your actual view name
    }
}