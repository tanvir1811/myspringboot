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

    // Fetch all drive info records
    public List<DriveInfo> getAllDriveInfo() {
        return driveInfoRepository.findAll();
    }

    // Fetch drive info by uniqueId
    public Optional<DriveInfo> getDriveInfoByUniqueId(String uniqueId) {
        return driveInfoRepository.findByUniqueId(uniqueId); // Assuming you have a findByUniqueId method in the repository
    }

    // Save a new drive info record
    public DriveInfo saveDriveInfo(DriveInfo driveInfo) {
        return driveInfoRepository.save(driveInfo);
    }
}
