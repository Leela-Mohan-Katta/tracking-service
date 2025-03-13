package com.example.tracking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tracking_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "shipment_type")
    private String shipmentType;

    @Column(name = "search_timestamp")
    private LocalDateTime searchTimestamp;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
}
