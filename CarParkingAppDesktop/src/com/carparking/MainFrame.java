// src/com/carparking/MainFrame.java

package com.carparking;

import com.carparking.ui.SideBar;
import com.carparking.components.HomePanel;
import com.carparking.components.AboutUsPanel;
import com.carparking.components.AboutProjectPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Car Parking System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Set layout
        setLayout(new BorderLayout());

        // Initialize side bar
        SideBar sideBar = new SideBar(this);
        add(sideBar, BorderLayout.WEST);

        // Initialize main panel with CardLayout
        mainPanel = new JPanel(new CardLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Add panels to main panel
        mainPanel.add(new HomePanel(), "Home");
        mainPanel.add(new AboutUsPanel(), "About Us");
        mainPanel.add(new AboutProjectPanel(), "About Project");

        // Show Home panel by default
        showPanel("Home");
    }

    public void showPanel(String name) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, name);
    }
}
