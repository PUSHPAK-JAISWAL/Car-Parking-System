// src/components/AboutUs.js

import React from 'react';
import { Grid, Card, CardContent, Typography, Avatar, Box } from '@mui/material';

const teamMembers = [
  {
    name: 'Pushpak Jaiswal',
    role: 'Team Member',
    // Optional: Add image URLs
    // image: 'https://example.com/pushpak.jpg',
  },
  {
    name: 'Sarthak Dayama',
    role: 'Team Member',
  },
  {
    name: 'Ajay Gaware',
    role: 'Team Member',
  },
  {
    name: 'Prashik Dehere',
    role: 'Team Member',
  },
  {
    name: 'Ritesh Kakde',
    role: 'Team Member',
  },
];

const AboutUs = () => {
  return (
    <Box sx={{ padding: 4 }}>
      <Typography variant="h4" gutterBottom>
        About Us
      </Typography>
      <Grid container spacing={4}>
        {teamMembers.map((member, index) => (
          <Grid item xs={12} sm={6} md={3} key={index}>
            <Card
              sx={{
                backgroundColor: '#1d1d1d',
                color: '#ffffff',
                textAlign: 'center',
                padding: 2,
              }}
            >
              <Avatar
                sx={{
                  width: 80,
                  height: 80,
                  margin: '0 auto',
                  marginBottom: 2,
                  bgcolor: (theme) => theme.palette.primary.main,
                }}
              >
                {/* Display initials if no image */}
                {member.name
                  .split(' ')
                  .map((n) => n[0])
                  .join('')}
              </Avatar>
              <CardContent>
                <Typography variant="h6">{member.name}</Typography>
                <Typography variant="body2" color="text.secondary">
                  {member.role}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
        ))}
      </Grid>
    </Box>
  );
};

export default AboutUs;
