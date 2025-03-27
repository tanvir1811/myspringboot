package com.example.website.controller;

import com.example.website.model.DriveInfo;
import com.example.website.service.DriveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "https://myspringboot-10.onrender.com", "https://tanvir1811.github.io" }) // Allow frontend requests
@RestController  // Defines this as a REST API controller
@RequestMapping("/api/driveinfo")  // API will be available at http://localhost:8080/api/driveinfo
public class DriveInfoController {

    @Autowired
    private DriveInfoService driveInfoService;

    // Fetch all drive info records
    @GetMapping
    public List<DriveInfo> getAllDriveInfo() {
        return driveInfoService.getAllDriveInfo();
    }

    // Fetch a single drive info record by uniqueId
    @GetMapping("/unique/{uniqueId}")
    public Optional<DriveInfo> getDriveInfoByUniqueId(@PathVariable String uniqueId) {
        return driveInfoService.getDriveInfoByUniqueId(uniqueId);
    }

    // Create a new drive info record
    @PostMapping
    public DriveInfo createDriveInfo(@RequestBody DriveInfo driveInfo) {
        return driveInfoService.saveDriveInfo(driveInfo);
    }
}
