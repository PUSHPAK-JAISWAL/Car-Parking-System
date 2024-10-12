// src/components/Dashboard.js

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ParkingSlotCard from './ParkingSlotCard';
import { Grid, Typography, CircularProgress, Alert, Box } from '@mui/material';

const Dashboard = () => {
  const [parkingSlots, setParkingSlots] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  // Backend API URL
  const API_URL = 'http://localhost:8080/api/parking/slots';

  // Function to fetch parking slots data
  const fetchParkingSlots = async () => {
    try {
      const response = await axios.get(API_URL);
      setParkingSlots(response.data);
      setError(false);
    } catch (err) {
      console.error('Error fetching parking slots:', err);
      setError(true);
    } finally {
      setLoading(false);
    }
  };

  // Fetch data on component mount
  useEffect(() => {
    fetchParkingSlots();

    // Set up polling every 5 seconds
    const interval = setInterval(() => {
      fetchParkingSlots();
    }, 5000); // 5000ms = 5 seconds

    // Cleanup interval on component unmount
    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return (
      <Box
        sx={{
          display: 'flex',
          justifyContent: 'center',
          marginTop: 4,
        }}
      >
        <CircularProgress />
      </Box>
    );
  }

  if (error) {
    return (
      <Alert severity="error" sx={{ marginTop: 4 }}>
        Failed to fetch parking slot data. Please try again later.
      </Alert>
    );
  }

  return (
    <Box sx={{ padding: 4 }}>
      <Typography variant="h4" gutterBottom>
        Car Parking System
      </Typography>
      <Grid container spacing={2}>
        {parkingSlots.map((slot) => (
          <Grid item xs={12} sm={6} md={4} key={slot.slotName}>
            <ParkingSlotCard slotName={slot.slotName} isEmpty={slot.empty} />
          </Grid>
        ))}
      </Grid>
    </Box>
  );
};

export default Dashboard;
