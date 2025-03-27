package com.example.website.repository;

import com.example.website.model.DriveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriveInfoRepository extends JpaRepository<DriveInfo, Long> {
    Optional<DriveInfo> findByUniqueId(String uniqueId); // Find a record by uniqueId
}
