// src/components/Navbar.js

import React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import { Button } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import MenuIcon from '@mui/icons-material/Menu';
import IconButton from '@mui/material/IconButton';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import useMediaQuery from '@mui/material/useMediaQuery';
import { useTheme } from '@mui/material/styles';

const Navbar = () => {
  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('sm'));

  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleMenu = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const navLinks = [
    { title: 'Home', path: '/' },
    { title: 'About Us', path: '/about-us' },
    { title: 'About Project', path: '/about-project' },
  ];

  return (
    <Box sx={{ flexGrow: 1, marginBottom: 4 }}>
      <AppBar position="static">
        <Toolbar>
          <Typography
            variant="h6"
            component={RouterLink}
            to="/"
            sx={{
              flexGrow: 1,
              textDecoration: 'none',
              color: 'inherit',
            }}
          >
            Car Parking System
          </Typography>
          {isMobile ? (
            <>
              <IconButton
                size="large"
                edge="end"
                color="inherit"
                aria-label="menu"
                onClick={handleMenu}
              >
                <MenuIcon />
              </IconButton>
              <Menu
                anchorEl={anchorEl}
                open={Boolean(anchorEl)}
                onClose={handleClose}
              >
                {navLinks.map((link) => (
                  <MenuItem
                    key={link.title}
                    component={RouterLink}
                    to={link.path}
                    onClick={handleClose}
                  >
                    {link.title}
                  </MenuItem>
                ))}
              </Menu>
            </>
          ) : (
            navLinks.map((link) => (
              <Button
                key={link.title}
                color="inherit"
                component={RouterLink}
                to={link.path}
                sx={{ marginLeft: 2 }}
              >
                {link.title}
              </Button>
            ))
          )}
        </Toolbar>
      </AppBar>
    </Box>
  );
};

export default Navbar;
