package com.example.website.service;

import com.example.website.model.DriveInfo;
import com.example.website.repository.DriveInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriveInfoService {

    @Autowired
    private DriveInfoRepository driveInfoRepository;

    public List<DriveInfo> getAllDriveInfo() {
        return driveInfoRepository.findAll();  // Fetch all records from database
    }

    public DriveInfo saveDriveInfo(DriveInfo driveInfo) {
        return driveInfoRepository.save(driveInfo);  // Save new drive info
    }

    public Optional<DriveInfo> getDriveInfoByUniqueId(String uniqueId) {
        return driveInfoRepository.findByUniqueId(uniqueId);  // Fetch record by uniqueId
    }
}
