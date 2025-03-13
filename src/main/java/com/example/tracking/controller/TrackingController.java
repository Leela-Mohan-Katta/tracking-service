package com.example.tracking.controller;

import com.example.tracking.entity.TrackingDetails;
import com.example.tracking.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    // Fetch tracking info for a single tracking number with user email verification
    @GetMapping("/{trackingNumber}")
    public ResponseEntity<?> getTrackingInfo(
            @PathVariable String trackingNumber,
            @RequestParam String userEmail) {

        Optional<TrackingDetails> tracking = trackingService.getTrackingDetails(trackingNumber, userEmail);
        return tracking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Fetch tracking details for multiple tracking numbers
    @PostMapping("/multiple")
    public ResponseEntity<List<TrackingDetails>> getMultipleTrackingDetails(
            @RequestBody List<String> trackingNumbers) {

        List<TrackingDetails> trackingDetailsList = trackingService.getMultipleTrackingDetails(trackingNumbers);
        return ResponseEntity.ok(trackingDetailsList);
    }

    // Save single tracking record
   /* @PostMapping
    public ResponseEntity<TrackingDetails> saveTrackingDetails(@RequestBody TrackingDetails trackingDetails) {
        TrackingDetails savedDetails = trackingService.saveTrackingDetails(trackingDetails);
        return ResponseEntity.ok(savedDetails);
    }

    // Save multiple tracking records
    @PostMapping("/bulk")
    public ResponseEntity<List<TrackingDetails>> saveMultipleTrackingDetails(@RequestBody List<TrackingDetails> trackingDetailsList) {
        List<TrackingDetails> savedDetails = trackingService.saveMultipleTrackingDetails(trackingDetailsList);
        return ResponseEntity.ok(savedDetails);
    }*/
}
