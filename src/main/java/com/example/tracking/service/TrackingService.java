package com.example.tracking.service;

import com.example.tracking.entity.TrackingDetails;
import com.example.tracking.entity.TrackingHistory;
import com.example.tracking.repository.TrackingDetailsRepository;
import com.example.tracking.repository.TrackingHistoryRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrackingService {

    private final TrackingDetailsRepository trackingDetailsRepository;
    private final TrackingHistoryRepository trackingHistoryRepository;

    public TrackingService(TrackingDetailsRepository trackingDetailsRepository, TrackingHistoryRepository trackingHistoryRepository) {
        this.trackingDetailsRepository = trackingDetailsRepository;
        this.trackingHistoryRepository = trackingHistoryRepository;
    }

    public Optional<TrackingDetails> getTrackingDetails(String trackingNumber, String userEmail) {
        Optional<TrackingDetails> tracking = trackingDetailsRepository.findByTrackingNumber(trackingNumber);

        tracking.ifPresent(detail -> {
            TrackingHistory history = TrackingHistory.builder()
                    .userEmail(userEmail)
                    .trackingNumber(detail.getTrackingNumber())
                    .carrier(detail.getCarrier())
                    .shipmentType(detail.getShipmentType())
                    .searchTimestamp(LocalDateTime.now())
                    .deliveryDate(detail.getEstimatedDeliveryDate())
                    .build();
            trackingHistoryRepository.save(history);
        });

        return tracking;
    }

    public List<TrackingDetails> getMultipleTrackingDetails(List<String> trackingNumbers) {
        return trackingDetailsRepository.findAllById(trackingNumbers.stream().map(Long::valueOf).toList());
    }
}