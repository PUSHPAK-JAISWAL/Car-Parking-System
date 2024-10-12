// src/com/carparking/ui/SideBar.java

package com.carparking.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.carparking.MainFrame;

public class SideBar extends JPanel {
    private MainFrame mainFrame;

    public SideBar(MainFrame frame) {
        this.mainFrame = frame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(45, 45, 45)); // Dark background
        setPreferredSize(new Dimension(200, getHeight()));

        // Add spacer
        add(Box.createRigidArea(new Dimension(0, 50)));

        // Home Button
        JButton homeButton = createButton("Home");
        homeButton.addActionListener(e -> mainFrame.showPanel("Home"));
        add(homeButton);

        // About Us Button
        JButton aboutUsButton = createButton("About Us");
        aboutUsButton.addActionListener(e -> mainFrame.showPanel("About Us"));
        add(aboutUsButton);

        // About Project Button
        JButton aboutProjectButton = createButton("About Project");
        aboutProjectButton.addActionListener(e -> mainFrame.showPanel("About Project"));
        add(aboutProjectButton);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(180, 40));
        button.setMinimumSize(new Dimension(180, 40));
        button.setPreferredSize(new Dimension(180, 40));
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(90, 90, 90));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 70, 70));
            }
        });

        return button;
    }
}
