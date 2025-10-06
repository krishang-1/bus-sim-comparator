# Bus-Sim Comparator

## Overview
This project simulates bus routes and stops for comparing transport systems. The primary goal is to build a backend that manages bus routes and stops, which can later be extended for machine learning-based transport simulations. 

The project focuses on:
- Creating and managing bus routes and stops
- Providing RESTful APIs for backend interaction
- Preparing for future ML simulation using real transport data

---

## Current Features

### Backend
- **Bus Routes**
  - Create, read, and list bus routes
  - Each route can have multiple stops
  - Tracks creation and update timestamps

- **Bus Stops**
  - Create, read, and list bus stops
  - Associate stops with a bus route
  - Tracks creation and update timestamps

### REST API Endpoints

**BusController**
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/bus/status` | Returns `Bus Simulation Running` |

**BusRouteController**
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/routes` | Get all bus routes |
| GET    | `/api/routes/{id}` | Get a specific bus route by ID |
| POST   | `/api/routes` | Create a new bus route |
| GET    | `/api/routes/{id}/stops` | Get all stops for a specific route |

**BusStopController**
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/stops` | Get all bus stops |
| GET    | `/api/stops/{id}` | Get a specific stop by ID |
| POST   | `/api/stops` | Create a new bus stop |
| GET    | `/api/stops/route/{routeId}` | Get stops for a specific route |

---

## Technologies Used
- Java 24
- Spring Boot 3.5.6
- JPA / Hibernate
- PostgreSQL (configured via HikariCP)
- Maven for build and dependency management
- Jackson for JSON serialization

---

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/krishang-1/bus-sim-comparator.git
   cd bus-sim-comparator
