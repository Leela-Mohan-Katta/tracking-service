package com.example.tracking.repository;

import com.example.tracking.entity.TrackingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, Long> {
}
