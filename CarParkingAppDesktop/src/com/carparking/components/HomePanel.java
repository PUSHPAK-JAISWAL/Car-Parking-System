// src/com/carparking/components/HomePanel.java

package com.carparking.components;

import com.carparking.components.ParkingSlotCard;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private JPanel slotsPanel;
    private Timer refreshTimer;

    // Replace with your backend API URL
    private static final String API_URL = "http://localhost:8080/api/parking/slots";

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(18, 18, 18));

        JLabel header = new JLabel("Car Parking System", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        slotsPanel = new JPanel();
        slotsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        slotsPanel.setBackground(new Color(18, 18, 18));
        JScrollPane scrollPane = new JScrollPane(slotsPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        // Initial data fetch
        fetchParkingSlots();

        // Set up periodic data refresh every 10 seconds
        int delay = 10000; // milliseconds
        refreshTimer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchParkingSlots();
            }
        });
        refreshTimer.start();
    }

    private void fetchParkingSlots() {
        // Display loading message
        SwingUtilities.invokeLater(() -> {
            slotsPanel.removeAll();
            JLabel loadingLabel = new JLabel("Loading parking slots...", SwingConstants.CENTER);
            loadingLabel.setForeground(Color.WHITE);
            loadingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            slotsPanel.add(loadingLabel);
            slotsPanel.revalidate();
            slotsPanel.repaint();
        });

        // Perform HTTP GET request in a separate thread to avoid blocking the UI
        new Thread(() -> {
            try {
                URL url = new URL(API_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(10000); // 10 seconds timeout
                conn.setReadTimeout(10000);

                int status = conn.getResponseCode();
                BufferedReader in;
                if (status > 299) {
                    in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                } else {
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                }

                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                System.out.println("HTTP Status: " + status);
                System.out.println("Server Response: " + content.toString());

                if (status > 299) {
                    showError("Failed to fetch parking slot data. HTTP Status: " + status);
                } else {
                    // Parse JSON manually
                    ArrayList<ParkingSlot> parkingSlots = parseJson(content.toString());
                    updateUIWithSlots(parkingSlots);
                }
            } catch (Exception e) {
                e.printStackTrace();
                showError("An error occurred while fetching data: " + e.getMessage());
            }
        }).start();
    }

    private ArrayList<ParkingSlot> parseJson(String json) {
        ArrayList<ParkingSlot> slots = new ArrayList<>();
        // Simple manual parsing assuming the JSON structure is known and consistent
        // Example JSON:
        // [
        //     {"slotName": "Slot1", "empty": true},
        //     {"slotName": "Slot2", "empty": false}
        // ]
        json = json.trim();
        if (json.startsWith("[") && json.endsWith("]")) {
            json = json.substring(1, json.length() - 1); // Remove [ and ]
            String[] objects = json.split("\\},\\{");
            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "").trim();
                String[] pairs = obj.split(",");
                String slotName = "";
                boolean empty = false;
                for (String pair : pairs) {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length == 2) {
                        String key = keyValue[0].trim().replaceAll("\"", "");
                        String value = keyValue[1].trim().replaceAll("\"", "");
                        if (key.equals("slotName")) {
                            slotName = value;
                        } else if (key.equals("empty")) {
                            empty = value.equalsIgnoreCase("true");
                        }
                    }
                }
                if (!slotName.isEmpty()) {
                    slots.add(new ParkingSlot(slotName, empty));
                }
            }
        }
        return slots;
    }

    private void updateUIWithSlots(ArrayList<ParkingSlot> parkingSlots) {
        SwingUtilities.invokeLater(() -> {
            slotsPanel.removeAll();
            if (parkingSlots.isEmpty()) {
                JLabel noDataLabel = new JLabel("No parking slots available.", SwingConstants.CENTER);
                noDataLabel.setForeground(Color.WHITE);
                noDataLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                slotsPanel.add(noDataLabel);
            } else {
                for (ParkingSlot slot : parkingSlots) {
                    ParkingSlotCard card = new ParkingSlotCard(slot.slotName, slot.empty);
                    slotsPanel.add(card);
                }
            }
            slotsPanel.revalidate();
            slotsPanel.repaint();
        });
    }

    private void showError(String message) {
        SwingUtilities.invokeLater(() -> {
            slotsPanel.removeAll();
            JLabel errorLabel = new JLabel(message, SwingConstants.CENTER);
            errorLabel.setForeground(Color.RED);
            errorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            slotsPanel.add(errorLabel);
            slotsPanel.revalidate();
            slotsPanel.repaint();
        });
    }

    // Inner class to represent a parking slot
    private class ParkingSlot {
        String slotName;
        boolean empty;

        public ParkingSlot(String slotName, boolean empty) {
            this.slotName = slotName;
            this.empty = empty;
        }
    }
}
