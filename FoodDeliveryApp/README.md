# Food Delivery App - Low Level Design (LLD)

## Overview
This is a simplified Food Delivery App demonstrating core LLD concepts (Singleton, Strategy) with a small runnable demo.

## System Architecture

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           FOOD DELIVERY APP LLD                             │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌──────────────┐      ┌──────────────┐                                     │
│  │     Main     │ ───► │     App      │                                     │
│  │ (entrypoint) │      │ (demo flow)  │                                     │
│  └──────────────┘      └──────────────┘                                     │
│             │                       │                                      │
│             │                       ▼                                      │
│             │             ┌───────────────────────┐                         │
│             │             │  RestaurantManager    │                         │
│             │             │  (Singleton)          │                         │
│             │             │  - restaurants        │                         │
│             │             │  + addRestaurant()    │                         │
│             │             │  + searchByLocation() │                         │
│             │             └───────────────────────┘                         │
│             │                                                              │
│             ▼                                                              │
│  ┌─────────────────────┐     owns       ┌─────────────────────┐            │
│  │        User         │ ─────────────► │         Cart         │            │
│  │ - id, name, address │                │ - restaurant, items  │            │
│  │ + getCart()         │                │ - total              │            │
│  │ + addItemtoCart()   │                │ + addRestaurant()    │            │
│  │ + addRestaurant...  │                │ + addToCart()        │            │
│  └─────────────────────┘                │ + getItems(), clear()│            │
│                                         └─────────────────────┘            │
│                                                │                           │
│                                                ▼                           │
│                                      ┌─────────────────────┐               │
│                                      │     Restaurant      │               │
│                                      │ - id, name, address │               │
│                                      │ - menu: MenuItem[]  │               │
│                                      │ + addMenuItem()     │               │
│                                      └─────────────────────┘               │
│                                                │                           │
│                                                ▼                           │
│                                      ┌─────────────────────┐               │
│                                      │      MenuItem       │               │
│                                      │ - code, name, price │               │
│                                      └─────────────────────┘               │
│                                                                             │
│  ┌─────────────────────┐        implements        ┌──────────────────────┐  │
│  │       Order         │ ◄──────────────────────► │   PaymentStrategy    │  │
│  │ (abstract)          │                          │ (abstract)           │  │
│  │ - orderId           │                          │ + pay(amount)        │  │
│  │ - restaurant, items │                          └──────────────────────┘  │
│  │ - user, total       │                            ▲                ▲      │
│  │ + processPayment()  │                            │                │      │
│  └─────────▲───────────┘                    ┌──────────────┐  ┌─────────────┐│
│            │                                │    UPI        │  │  CreditCard ││
│   ┌────────┴─────────┐                      │ (strategy)    │  │ (strategy)  ││
│   │   DeliveryOrder  │                      └──────────────┘  └─────────────┘│
│   │   PickUpOrder    │                                                       │
│   └──────────────────┘                                                       │
│                                                                             │
│  ┌─────────────────────┐                                                    │
│  │     Notification    │                                                    │
│  │ + notify(order,user)│  (prints order confirmation)                       │
│  └─────────────────────┘                                                    │
└─────────────────────────────────────────────────────────────────────────────┘
```

## Design Patterns Used
- **Singleton**: `RestaurantManager` provides a single shared instance.
- **Strategy**: `PaymentStrategy` with concrete `UPIPaymentStrategy`, `CreditCardPaymentStrategy`.

## Runtime Flow
1. `Main` starts `App` which seeds sample restaurants and menus.
2. `App.searchByLocation("Delhi")` uses `RestaurantManager` to filter restaurants by address.
3. User selects a restaurant; `Cart` is associated with that restaurant.
4. Items are added to the `Cart`; `total` is updated.
5. `App.checkout(user)` creates a `DeliveryOrder`, sets payment strategy (UPI), and calls `processPayment()`.
6. On success, `Notification.notify(order, user)` prints a confirmation and the `Cart` is cleared.

## How to Run
- Compile
```bash
javac -d out FoodDeliveryApp/**/*.java
```
- Run
```bash
java -cp out FoodDeliveryApp.Main
```

## Notes
- `OrderFactory` (`NowOrder`, `ScheduleOrder`) are present as stubs and not used in the demo.
- You can switch to `CreditCardPaymentStrategy` inside `App.checkout()` if desired. 