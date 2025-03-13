package com.example.tracking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tracking_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_number", unique = true, nullable = false)
    private String trackingNumber;

    @Column(name = "carrier", nullable = false)
    private String carrier;

    @Column(name = "shipment_type")
    private String shipmentType;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "estimated_delivery_date")
    private LocalDateTime estimatedDeliveryDate;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
