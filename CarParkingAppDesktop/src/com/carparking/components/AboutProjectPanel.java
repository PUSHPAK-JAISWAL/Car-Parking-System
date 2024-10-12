// src/com/carparking/components/AboutProjectPanel.java

package com.carparking.components;

import javax.swing.*;
import java.awt.*;

public class AboutProjectPanel extends JPanel {
    public AboutProjectPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(18, 18, 18));

        JLabel header = new JLabel("About the Project", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        JTextArea aboutText = new JTextArea();
        aboutText.setText(getAboutText());
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setForeground(Color.WHITE);
        aboutText.setBackground(new Color(18, 18, 18));
        aboutText.setFont(new Font("Arial", Font.PLAIN, 14));
        aboutText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(aboutText);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    private String getAboutText() {
        return "Project Overview:\n\n" +
                "The Car Parking System is an innovative solution designed to streamline parking management in busy areas. Leveraging modern hardware and software technologies, the system provides real-time updates on parking slot availability, enhancing user experience and optimizing space utilization.\n\n" +
                "Features:\n" +
                "- Real-time parking slot status updates.\n" +
                "- User-friendly desktop interface.\n" +
                "- Efficient hardware integration with Arduino and NodeMCU.\n" +
                "- Secure and scalable backend using Spring Boot.\n\n" +
                "Technology Stack:\n" +
                "- **Frontend:** Java Swing\n" +
                "- **Backend:** Spring Boot, RESTful APIs\n" +
                "- **Hardware:** Arduino, NodeMCU\n" +
                "- **Networking:** java.net.HttpURLConnection for HTTP requests";
    }
}
