// src/components/AboutProject.js

import React from 'react';
import { Box, Typography, List, ListItem, ListItemIcon, ListItemText, Paper } from '@mui/material';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';

const AboutProject = () => {
  return (
    <Box sx={{ padding: 4 }}>
      <Typography variant="h4" gutterBottom>
        About the Project
      </Typography>
      <Paper
        sx={{
          padding: 3,
          backgroundColor: '#1d1d1d',
          color: '#ffffff',
        }}
        elevation={3}
      >
        <Typography variant="h6" gutterBottom>
          Project Overview
        </Typography>
        <Typography variant="body1" paragraph>
          The Car Parking System is an innovative solution designed to streamline parking management in busy areas. Leveraging modern hardware and software technologies, the system provides real-time updates on parking slot availability, enhancing user experience and optimizing space utilization.
        </Typography>
        <Typography variant="h6" gutterBottom>
          Features
        </Typography>
        <List>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="Real-time parking slot status updates." />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="User-friendly web and mobile interfaces." />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="Efficient hardware integration with Arduino and NodeMCU." />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="Secure and scalable backend using Spring Boot." />
          </ListItem>
        </List>
        <Typography variant="h6" gutterBottom>
          Technology Stack
        </Typography>
        <List>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="**Frontend:** React, Material-UI" />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="**Backend:** Spring Boot, RestTemplate" />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="**Hardware:** Arduino, NodeMCU" />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <CheckCircleIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary="**Mobile App:** React Native" />
          </ListItem>
        </List>
      </Paper>
    </Box>
  );
};

export default AboutProject;
