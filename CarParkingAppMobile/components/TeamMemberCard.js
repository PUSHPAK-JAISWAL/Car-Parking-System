// components/TeamMemberCard.js

import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

export default function TeamMemberCard({ name, role }) {
  const getInitials = (fullName) => {
    const names = fullName.split(' ');
    let initials = names[0].charAt(0);
    if (names.length > 1) {
      initials += names[names.length - 1].charAt(0);
    }
    return initials.toUpperCase();
  };

  return (
    <View style={styles.card}>
      <View style={styles.avatar}>
        <Text style={styles.initials}>{getInitials(name)}</Text>
      </View>
      <Text style={styles.name}>{name}</Text>
      <Text style={styles.role}>{role}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    width: 200,
    backgroundColor: '#1f1f1f',
    borderRadius: 10,
    padding: 16,
    alignItems: 'center',
    marginBottom: 20,
    elevation: 3, // For Android shadow
    shadowColor: '#000', // For iOS shadow
    shadowOffset: { width: 0, height: 2 }, // For iOS shadow
    shadowOpacity: 0.25, // For iOS shadow
    shadowRadius: 3.84, // For iOS shadow
  },
  avatar: {
    backgroundColor: '#4caf50', // Green background
    width: 80,
    height: 80,
    borderRadius: 40,
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 12,
  },
  initials: {
    color: '#ffffff',
    fontSize: 24,
    fontWeight: 'bold',
  },
  name: {
    color: '#ffffff',
    fontSize: 18,
    fontWeight: '600',
  },
  role: {
    color: '#a5a5a5',
    fontSize: 14,
    marginTop: 4,
  },
});
