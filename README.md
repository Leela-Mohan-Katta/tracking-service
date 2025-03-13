# Tracking Service - Spring Boot Application

## Overview
The **Tracking Service** is a Spring Boot-based REST API that allows users to manage and retrieve tracking information for shipments. It provides endpoints for fetching tracking details based on a single tracking number or multiple tracking numbers, with optional user email verification.

## Package Structure

```
com.example.tracking
│
├── controller
│   └── TrackingController.java
├── entity
│   └── TrackingDetails.java
├── service
│   └── TrackingService.java
└── repository
    └── TrackingRepository.java
```

## Endpoints

### 1. Get Tracking Information by Tracking Number

**Endpoint:** `GET /api/tracking/{trackingNumber}`

**Parameters:**
- `trackingNumber` (Path Variable): The tracking number to fetch details for.
- `userEmail` (Query Parameter): The email of the user to verify tracking details.

**Response:**
- Returns tracking details if the tracking number and user email match.
- Returns `404 Not Found` if the details are not available.

**Example Request:**
```
GET /api/tracking/123456?userEmail=user@example.com
```

### 2. Get Tracking Details for Multiple Tracking Numbers

**Endpoint:** `POST /api/tracking/multiple`

**Request Body:**
```json
["123456", "654321", "789012"]
```

**Response:**
- Returns a list of tracking details for the provided tracking numbers.

**Example Request:**
```
POST /api/tracking/multiple
```

### 3. Save Single Tracking Record (Commented Out in Code)

**Endpoint:** `POST /api/tracking`

**Request Body:**
```json
{
  "trackingNumber": "123456",
  "status": "In Transit",
  "userEmail": "user@example.com"
}
```

**Response:**
- Returns the saved tracking details.

### 4. Save Multiple Tracking Records (Commented Out in Code)

**Endpoint:** `POST /api/tracking/bulk`

**Request Body:**
```json
[
  {
    "trackingNumber": "123456",
    "status": "In Transit",
    "userEmail": "user@example.com"
  },
  {
    "trackingNumber": "654321",
    "status": "Delivered",
    "userEmail": "user@example.com"
  }
]
```

**Response:**
- Returns a list of saved tracking details.

## Key Components

### 1. TrackingController
- Handles incoming HTTP requests.
- Interacts with the `TrackingService` to process business logic.

### 2. TrackingService
- Contains the core business logic for fetching and saving tracking information.
- Interacts with the repository layer to retrieve data from the database.

### 3. TrackingDetails Entity
- Represents the tracking details entity in the database.

### 4. TrackingRepository
- Interface for database interaction (not shown in the provided code).

## How to Run the Application

1. Clone the repository.
2. Ensure you have JDK and Maven installed.
3. Navigate to the project directory and run:
```bash
mvn spring-boot:run
```
4. Access the API at `http://localhost:8080/api/tracking`

## Conclusion
This Tracking Service API provides efficient endpoints to manage and retrieve shipment tracking details. It supports single and bulk operations with optional user verification for secure access.

