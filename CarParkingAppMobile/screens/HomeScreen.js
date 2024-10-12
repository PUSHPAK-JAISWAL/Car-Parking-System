// screens/HomeScreen.js

import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, ScrollView, ActivityIndicator, Alert } from 'react-native';
import ParkingSlotCard from '../components/ParkingSlotCard';

export default function HomeScreen() {
  const [parkingSlots, setParkingSlots] = useState([]);
  const [loading, setLoading] = useState(true);

  // Replace with your actual computer's IP address
  const API_URL = 'http://192.168.131.190:8080/api/parking/slots'; // Example IP

  useEffect(() => {
    fetchParkingSlots();

    // Optional: Polling every 10 seconds for real-time updates
    const interval = setInterval(() => {
      fetchParkingSlots();
    }, 10000); // 10 seconds

    return () => clearInterval(interval); // Cleanup on unmount
  }, []);

  const fetchParkingSlots = async () => {
    try {
      console.log(`Fetching data from: ${API_URL}`); // Log the API URL
      const response = await fetch(API_URL, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      console.log(`Response Status: ${response.status}`); // Log response status

      if (!response.ok) {
        Alert.alert('Error', `Failed to fetch data. Status Code: ${response.status}`);
        setLoading(false);
        return;
      }

      const data = await response.json();
      console.log('Fetched Data:', data); // Log fetched data
      setParkingSlots(data);
      setLoading(false);
    } catch (error) {
      Alert.alert('Error', 'An error occurred while fetching data.');
      setLoading(false);
      console.error('Fetch Error:', error); // Log the error
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Parking Slots</Text>
      {loading ? (
        <ActivityIndicator size="large" color="#ffffff" />
      ) : (
        <ScrollView contentContainerStyle={styles.scrollContainer}>
          {parkingSlots.length > 0 ? (
            parkingSlots.map((slot) => (
              <ParkingSlotCard key={slot.slotName} slotName={slot.slotName} isEmpty={slot.empty} />
            ))
          ) : (
            <Text style={styles.noDataText}>No parking slots available.</Text>
          )}
        </ScrollView>
      )}
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
    alignItems: 'center',
    paddingBottom: 20,
  },
  noDataText: {
    color: '#888888',
    fontSize: 16,
  },
});
