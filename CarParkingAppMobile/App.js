// App.js

import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { StatusBar } from 'expo-status-bar';
import HomeScreen from './screens/HomeScreen';
import AboutUsScreen from './screens/AboutUsScreen';
import AboutProjectScreen from './screens/AboutProjectScreen';
import { Ionicons } from '@expo/vector-icons'; // For tab icons

const Tab = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer
      theme={{
        dark: true,
        colors: {
          primary: '#1f1f1f',
          background: '#121212',
          card: '#1f1f1f',
          text: '#ffffff',
          border: '#272727',
          notification: '#ff453a',
        },
      }}
    >
      <StatusBar style="light" />
      <Tab.Navigator
        screenOptions={({ route }) => ({
          headerShown: false,
          tabBarActiveTintColor: '#ffffff',
          tabBarInactiveTintColor: '#888888',
          tabBarStyle: {
            backgroundColor: '#1f1f1f',
            borderTopColor: '#272727',
          },
          tabBarIcon: ({ focused, color, size }) => {
            let iconName;

            if (route.name === 'Home') {
              iconName = focused ? 'home' : 'home-outline';
            } else if (route.name === 'About Us') {
              iconName = focused ? 'people' : 'people-outline';
            } else if (route.name === 'About Project') {
              iconName = focused ? 'information-circle' : 'information-circle-outline';
            }

            // Return the appropriate icon
            return <Ionicons name={iconName} size={size} color={color} />;
          },
        })}
      >
        <Tab.Screen name="Home" component={HomeScreen} />
        <Tab.Screen name="About Us" component={AboutUsScreen} />
        <Tab.Screen name="About Project" component={AboutProjectScreen} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
