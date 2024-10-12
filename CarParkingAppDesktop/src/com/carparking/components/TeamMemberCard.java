// src/com/carparking/components/TeamMemberCard.java

package com.carparking.components;

import javax.swing.*;
import java.awt.*;

public class TeamMemberCard extends JPanel {
    private String name;
    private String role;

    public TeamMemberCard(String name, String role) {
        this.name = name;
        this.role = role;
        initialize();
    }

    private void initialize() {
        setPreferredSize(new Dimension(200, 250));
        setBackground(new Color(29, 29, 29));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));

        // Avatar (Initials)
        JLabel avatar = new JLabel(getInitials(name), SwingConstants.CENTER);
        avatar.setOpaque(true);
        avatar.setBackground(new Color(76, 175, 80)); // Green background
        avatar.setForeground(Color.WHITE);
        avatar.setFont(new Font("Arial", Font.BOLD, 24));
        avatar.setPreferredSize(new Dimension(100, 100));
        avatar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Name Label
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Role Label
        JLabel roleLabel = new JLabel(role, SwingConstants.CENTER);
        roleLabel.setForeground(new Color(176, 190, 197)); // Light gray
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        roleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));

        // Add components to card
        add(avatar, BorderLayout.NORTH);
        add(nameLabel, BorderLayout.CENTER);
        add(roleLabel, BorderLayout.SOUTH);

        // Rounded corners
        setOpaque(false);
        setUI(new RoundedPanelUI());
    }

    private String getInitials(String name) {
        String[] parts = name.split(" ");
        String initials = "";
        for(String part : parts){
            if(!part.isEmpty()){
                initials += part.charAt(0);
            }
        }
        return initials;
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
