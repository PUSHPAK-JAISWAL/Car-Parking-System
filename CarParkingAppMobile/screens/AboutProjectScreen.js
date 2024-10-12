// screens/AboutProjectScreen.js

import React from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';

export default function AboutProjectScreen() {
  const projectDetails = `
Project Overview:

The Car Parking System is an innovative solution designed to streamline parking management in busy areas. Leveraging modern hardware and software technologies, the system provides real-time updates on parking slot availability, enhancing user experience and optimizing space utilization.

Features:
- Real-time parking slot status updates.
- User-friendly mobile interface.
- Efficient hardware integration with Arduino and NodeMCU.
- Secure and scalable backend using Spring Boot.

Technology Stack:
- **Frontend:** React Native with Expo
- **Backend:** Spring Boot, RESTful APIs
- **Hardware:** Arduino, NodeMCU
- **Networking:** Fetch API for HTTP requests
`;

  return (
    <View style={styles.container}>
      <Text style={styles.header}>About the Project</Text>
      <ScrollView contentContainerStyle={styles.scrollContainer}>
        <Text style={styles.text}>{projectDetails}</Text>
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#121212',
    padding: 16,
  },
  header: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#ffffff',
    marginBottom: 16,
    textAlign: 'center',
  },
  scrollContainer: {
    paddingBottom: 20,
  },
  text: {
    color: '#ffffff',
    fontSize: 16,
    lineHeight: 24,
  },
});
