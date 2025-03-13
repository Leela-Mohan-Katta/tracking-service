package com.example.tracking.repository;

import com.example.tracking.entity.TrackingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TrackingDetailsRepository extends JpaRepository<TrackingDetails, Long> {
    Optional<TrackingDetails> findByTrackingNumber(String trackingNumber);
}
