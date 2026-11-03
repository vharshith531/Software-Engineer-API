
package com.harshith;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoftwareEngineerServices {

    private final SoftwareEngineerRepo softwareEngineerRepo;

    public SoftwareEngineerServices(SoftwareEngineerRepo softwareEngineerRepo) {
        this.softwareEngineerRepo = softwareEngineerRepo;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepo.findAll();
    }

    // GET by ID
    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    // POST
    public SoftwareEngineer insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        return softwareEngineerRepo.save(softwareEngineer);
    }
}
