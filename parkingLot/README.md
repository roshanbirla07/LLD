# Parking System - Low Level Design (LLD)

## Overview
This is a comprehensive Low Level Design (LLD) for a Parking System that demonstrates various design patterns including Factory Pattern, Strategy Pattern, and SOLID principles.

## System Architecture

The parking system is designed with the following main components:

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           PARKING SYSTEM LLD                               │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐  │
│  │   Vehicle   │    │   Ticket    │    │  Payment   │    │ ExitGate   │  │
│  │             │    │             │    │             │    │             │  │
│  │ -vehicleNum │    │ -ticketId   │    │ -amount    │    │ -exitTime  │  │
│  │ -vehicleType│    │ -entryTime  │    │ -method    │    │ -calculate │  │
│  │ +getVNum() │    │ -exitTime   │    │ +process() │    │ +process() │  │
│  │ +getVType()│    │ +generate() │    │             │    │             │  │
│  └─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘  │
│         │                   │                   │                   │      │
│         │                   │                   │                   │      │
│         ▼                   ▼                   ▼                   ▼      │
│  ┌─────────────────────────────────────────────────────────────────────┐  │
│  │                    ENTRANCE GATE                                    │  │
│  │                                                                     │  │
│  │  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐ │  │
│  │  │ parkingSpot     │    │ parkingSpot     │    │ parkingSpot     │ │  │
│  │  │ Factory         │    │ Manager         │    │                 │ │  │
│  │  │                 │    │                 │    │ -spotId        │ │  │
│  │  │ +getPSManager() │    │ -parkingSpots   │    │ -isEmpty       │ │  │
│  │  │                 │    │ -parkingStrategy│    │ -price         │ │  │
│  │  │                 │    │ +findSpot()     │    │ -vehicle       │ │  │
│  │  │                 │    │ +parkVehicle()  │    │ +addVehicle()  │ │  │
│  │  │                 │    │ +removeVehicle()│    │ +removeVehicle()│ │  │
│  │  └─────────────────┘    └─────────────────┘    └─────────────────┘ │  │
│  │                                                                     │  │
│  │  ┌─────────────────┐    ┌─────────────────┐                        │  │
│  │  │ TWO_WHEELER_    │    │ FOUR_WHEELER_   │                        │  │
│  │  │ PSManager       │    │ PSManager       │                        │  │
│  │  │                 │    │                 │                        │  │
│  │  │ extends         │    │ extends         │                        │  │
│  │  │ parkingSpotMgr  │    │ parkingSpotMgr  │                        │  │
│  │  └─────────────────┘    └─────────────────┘                        │  │
│  └─────────────────────────────────────────────────────────────────────┘  │
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐  │
│  │                    PARKING STRATEGY                                 │  │
│  │                                                                     │  │
│  │  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐ │  │
│  │  │ parkingStrategy │    │ findNearEntrance│    │ findCheapest    │ │  │
│  │  │ (Interface)     │    │                 │    │                 │ │  │
│  │  │                 │    │ implements      │    │ implements      │ │  │
│  │  │ +findParkingSpot│    │ parkingStrategy │    │ parkingStrategy │ │  │
│  │  │ (Vehicle, int)  │    │                 │    │                 │ │  │
│  │  └─────────────────┘    └─────────────────┘    └─────────────────┘ │  │
│  └─────────────────────────────────────────────────────────────────────┘  │
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐  │
│  │                    COST COMPUTATION                                 │  │
│  │                                                                     │  │
│  │  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐ │  │
│  │  │ costComputation │    │ TWO_WHEELER_    │    │ FOUR_WHEELER_   │ │  │
│  │  │ (Abstract)      │    │ CostComputation │    │ CostComputation │ │  │
│  │  │                 │    │                 │    │                 │ │  │
│  │  │ #priceStrategy  │    │ extends         │    │ extends         │ │  │
│  │  │ #ticket         │    │ costComputation │    │ costComputation │ │  │
│  │  │ +calculate()    │    │                 │    │                 │ │  │
│  │  └─────────────────┘    └─────────────────┘    └─────────────────┘ │  │
│  │                                                                     │  │
│  │  ┌─────────────────┐    ┌─────────────────┐                        │  │
│  │  │ costComputation │    │ priceStrategy   │                        │  │
│  │  │ Factory         │    │ (Interface)     │                        │  │
│  │  │                 │    │                 │                        │  │
│  │  │ +getCostComp()  │    │ +calculate()    │                        │  │
│  │  └─────────────────┘    └─────────────────┘                        │  │
│  └─────────────────────────────────────────────────────────────────────┘  │
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐  │
│  │                      PAYMENT                                        │  │
│  │                                                                     │  │
│  │  ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐ │  │
│  │  │    Payment      │    │   UPI_Payment   │    │  Card_Payment   │ │  │
│  │  │ (Abstract)      │    │                 │    │                 │ │  │
│  │  │                 │    │ extends         │    │ extends         │ │  │
│  │  │ -amount         │    │ Payment         │    │ Payment         │ │  │
│  │  │ -method         │    │                 │    │                 │ │  │
│  │  │ +process()      │    │ +process()      │    │ +process()      │ │  │
│  │  └─────────────────┘    └─────────────────┘    └─────────────────┘ │  │
│  └─────────────────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────────────────┘
```

## Design Patterns Used

### 1. Factory Pattern
- **parkingSpotFactory**: Creates appropriate parking spot managers based on vehicle type
- **costComputationFactory**: Creates appropriate cost computation objects based on vehicle type

### 2. Strategy Pattern
- **parkingStrategy**: Interface for different parking spot finding strategies
- **findNearEntrance**: Concrete strategy for finding spots near entrance
- **priceStrategy**: Interface for different pricing strategies

### 3. Template Method Pattern
- **costComputation**: Abstract class defining the algorithm structure
- Concrete implementations for different vehicle types

## Key Components

### Vehicle Management
- **Vehicle**: Base class with vehicle number and type
- **VehicleType**: Enum for TWO_WHEELER and FOUR_WHEELER

### Parking Management
- **parkingSpot**: Individual parking spot with vehicle and occupancy status
- **parkingSpotManager**: Manages parking spots and operations
- **TWO_WHEELER_PSManager/FOUR_WHEELER_PSManager**: Specific managers for vehicle types

### Strategy Implementation
- **parkingStrategy**: Interface for parking algorithms
- **findNearEntrance**: Strategy to find spots near entrance

### Cost Computation
- **costComputation**: Abstract base class for cost calculation
- **TWO_WHEELER_CostComputation/FOUR_WHEELER_CostComputation**: Specific implementations

### Payment System
- **Payment**: Abstract base class for payment processing
- **UPI_Payment**: Concrete UPI payment implementation

### Ticket Management
- **Ticket**: Manages entry/exit times and parking details

### Gate Management
- **entranceGate**: Handles vehicle entry and spot allocation
- **exitGate**: Handles vehicle exit and payment processing

## SOLID Principles Implementation

1. **Single Responsibility**: Each class has a single, well-defined responsibility
2. **Open/Closed**: System is open for extension (new strategies) but closed for modification
3. **Liskov Substitution**: Subtypes can be used in place of their base types
4. **Interface Segregation**: Clients only depend on methods they use
5. **Dependency Inversion**: High-level modules don't depend on low-level modules

## Usage Flow

1. **Vehicle Entry**: Vehicle arrives at entrance gate
2. **Spot Allocation**: Factory creates appropriate manager, strategy finds spot
3. **Ticket Generation**: Ticket is generated with entry time
4. **Parking**: Vehicle is parked in allocated spot
5. **Exit Process**: Vehicle exits, cost is calculated, payment is processed

## Benefits

- **Extensible**: Easy to add new vehicle types, strategies, and payment methods
- **Maintainable**: Clear separation of concerns and well-defined interfaces
- **Testable**: Each component can be tested independently
- **Scalable**: Architecture supports adding new features without modifying existing code

## Future Enhancements

- Add more parking strategies (findCheapest, findLargest)
- Implement different pricing strategies (hourly, daily, monthly)
- Add support for more payment methods (credit card, cash)
- Implement reservation system for parking spots
- Add real-time monitoring and analytics 