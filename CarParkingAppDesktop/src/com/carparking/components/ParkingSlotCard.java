// src/com/carparking/components/ParkingSlotCard.java

package com.carparking.components;

import javax.swing.*;
import java.awt.*;

public class ParkingSlotCard extends JPanel {
    private String slotName;
    private boolean isEmpty;

    public ParkingSlotCard(String slotName, boolean isEmpty) {
        this.slotName = slotName;
        this.isEmpty = isEmpty;
        initialize();
    }

    private void initialize() {
        setPreferredSize(new Dimension(150, 100));
        setBackground(isEmpty ? new Color(46, 125, 50) : new Color(198, 40, 40)); // Green or Red
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));

        JLabel nameLabel = new JLabel(slotName, SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel statusLabel = new JLabel(isEmpty ? "Empty" : "Filled", SwingConstants.CENTER);
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        add(nameLabel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        // Rounded corners
        setOpaque(false);
        setUI(new RoundedPanelUI());
    }

    // Custom UI for rounded corners
    private class RoundedPanelUI extends javax.swing.plaf.basic.BasicPanelUI {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(c.getBackground());
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);

            super.paint(g2, c);
            g2.dispose();
        }
    }
}
