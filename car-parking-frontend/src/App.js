// src/App.js

import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Dashboard from './components/Dashboard';
import AboutUs from './components/AboutUs';
import AboutProject from './components/AboutProject';
import Navbar from './components/Navbar';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';

// Define the dark theme
const darkTheme = createTheme({
  palette: {
    mode: 'dark',
    primary: {
      main: '#90caf9', // Light blue
    },
    secondary: {
      main: '#f48fb1', // Pink
    },
    background: {
      default: '#121212',
      paper: '#1d1d1d',
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <Navbar />
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/about-us" element={<AboutUs />} />
        <Route path="/about-project" element={<AboutProject />} />
      </Routes>
    </ThemeProvider>
  );
}

export default App;
