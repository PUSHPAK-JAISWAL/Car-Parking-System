// screens/AboutUsScreen.js

import React from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';
import TeamMemberCard from '../components/TeamMemberCard';

export default function AboutUsScreen() {
  const teamMembers = [
    { name: 'Pushpak Jaiswal', role: 'Team Member' },
    { name: 'Sarthak Dayama', role: 'Team Member' },
    { name: 'Ajay Gware', role: 'Team Member' },
    { name: 'Prashik Dehere', role: 'Team Member' },
    { name: 'Ritesh Kakde', role: 'Team Member' },
  ];

  return (
    <View style={styles.container}>
      <Text style={styles.header}>About Us</Text>
      <ScrollView contentContainerStyle={styles.scrollContainer}>
        {teamMembers.map((member) => (
          <TeamMemberCard key={member.name} name={member.name} role={member.role} />
        ))}
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
    alignItems: 'center',
    paddingBottom: 20,
  },
});
