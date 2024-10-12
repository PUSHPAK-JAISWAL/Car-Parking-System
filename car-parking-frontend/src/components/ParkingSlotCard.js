// src/components/ParkingSlotCard.js

import React from 'react';
import { Card, CardContent, Typography, Box } from '@mui/material';
import PropTypes from 'prop-types';

const ParkingSlotCard = ({ slotName, isEmpty }) => {
  return (
    <Card
      sx={{
        minWidth: 200,
        margin: 2,
        backgroundColor: isEmpty ? '#2e7d32' : '#c62828', // Green for empty, Red for filled
        transition: 'background-color 0.3s ease',
      }}
    >
      <CardContent>
        <Typography variant="h5" component="div">
          {slotName}
        </Typography>
        <Box
          sx={{
            display: 'flex',
            alignItems: 'center',
            marginTop: 1,
          }}
        >
          <Box
            sx={{
              width: 16,
              height: 16,
              borderRadius: '50%',
              backgroundColor: isEmpty ? '#4caf50' : '#f44336', // Green/Red dot
              marginRight: 1,
            }}
          />
          <Typography variant="body1">
            {isEmpty ? 'Empty' : 'Filled'}
          </Typography>
        </Box>
      </CardContent>
    </Card>
  );
};

// PropTypes for type checking
ParkingSlotCard.propTypes = {
  slotName: PropTypes.string.isRequired,
  isEmpty: PropTypes.bool.isRequired,
};

export default ParkingSlotCard;
