# Car-Parking-System
# IoT-Based Smart Parking System

This project began as an **IoT-based Smart Parking System** developed in my first year of engineering for the **Engineering Exploration subject** at **CSMSS College, Chh. Sambhaji Nagar**. Over time, it has evolved into a full-stack, cross-platform solution aimed at solving parking management issues, particularly for valet services, users, and security personnel.

## Project Evolution

### First Year:
- **Hardware Components:**
  - **Arduino NodeMCU**: Handled communication and control for the system.
  - **Servo Motor**: Automated the opening and closing of the gate.
  - **IR Sensor**: Detected car/object presence for parking space availability.
  - **LCD Screen**: Later integrated to show real-time parking slot statuses (empty or filled).

- **First API**:
  - Initially developed an API for managing parking slots, but it had some issues in design and data handling.

### Second Year - Upgrades:
- The project has been **upgraded** into a **full-stack solution** with:
  - **Spring Boot** for the backend API.
  - **React** for the web-based frontend.
  - **Swing** for the desktop application.
  - **Expo (React Native)** for the mobile application.

- **Cross-Platform Functionality**:
  - Real-time parking slot status is displayed across platforms, including web, desktop, and mobile.
  - Slots are shown as **cards** on the interface:
    - **Green** cards represent empty slots.
    - **Red** cards represent filled slots.

- **Improved API**:
  - A second API was built based on the first version to fix the initial mistakes and handle the parking slots more effectively.

## Current Status:
- While I’ve implemented a logic to display filled slots in **red** and empty ones in **green** on all platforms, I haven't been able to fully test it due to submitting the hardware components to the college.
- Testing was done only via API calls, and everything is working in theory. Let’s hope it works when connected to the hardware! 🤞

## Project Demo:
- You can find demo videos of the project and its various stages across platforms.

## Tech Stack:
- **Frontend**: React, Swing, React Native (Expo)
- **Backend**: Spring Boot (Java)
- **Hardware**: Arduino NodeMCU, Servo Motor, IR Sensor, LCD

## Future Enhancements:
- Complete the testing phase when the hardware becomes available.
- Continue refining the APIs for smoother real-time communication between the server and hardware.

---
