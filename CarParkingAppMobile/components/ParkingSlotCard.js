// components/ParkingSlotCard.js

import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

export default function ParkingSlotCard({ slotName, isEmpty }) {
  return (
    <View style={[styles.card, isEmpty ? styles.empty : styles.filled]}>
      <Text style={styles.slotName}>{slotName}</Text>
      <Text style={styles.status}>{isEmpty ? 'Empty' : 'Filled'}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    width: 150,
    height: 100,
    borderRadius: 10,
    padding: 10,
    margin: 10,
    justifyContent: 'center',
    alignItems: 'center',
    elevation: 3, // For Android shadow
    shadowColor: '#000', // For iOS shadow
    shadowOffset: { width: 0, height: 2 }, // For iOS shadow
    shadowOpacity: 0.25, // For iOS shadow
    shadowRadius: 3.84, // For iOS shadow
  },
  empty: {
    backgroundColor: '#2e7d32', // Green
  },
  filled: {
    backgroundColor: '#c62828', // Red
  },
  slotName: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#ffffff',
  },
  status: {
    fontSize: 14,
    color: '#ffffff',
    marginTop: 4,
  },
});
