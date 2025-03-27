package com.example.website.repository;

import com.example.website.model.DriveInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriveInfoRepository extends JpaRepository<DriveInfo, Long> {

    // Fetch drive info by uniqueId
    Optional<DriveInfo> findByUniqueId(String uniqueId);
}
