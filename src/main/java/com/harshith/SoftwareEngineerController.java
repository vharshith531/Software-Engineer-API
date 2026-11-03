
package com.harshith;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerServices softwareEngineerServices;

    public SoftwareEngineerController(SoftwareEngineerServices softwareEngineerServices) {
        this.softwareEngineerServices = softwareEngineerServices;
    }

    // GET all software engineers
    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerServices.getAllSoftwareEngineers();
    }

    // GET software engineer by ID
    @GetMapping("/{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return softwareEngineerServices.getSoftwareEngineerById(id);
    }

    // POST new software engineer
    @PostMapping
    public SoftwareEngineer addNewSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer) {
        return softwareEngineerServices.insertSoftwareEngineer(softwareEngineer);
    }
}
