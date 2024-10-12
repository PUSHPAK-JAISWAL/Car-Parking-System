// src/com/carparking/components/AboutUsPanel.java

package com.carparking.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class AboutUsPanel extends JPanel {
    private List<TeamMember> teamMembers;

    public AboutUsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(18, 18, 18));

        JLabel header = new JLabel("About Us", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        // Define team members
        teamMembers = Arrays.asList(
                new TeamMember("Pushpak Jaiswal", "Team Member"),
                new TeamMember("Sarthak Dayama", "Team Member"),
                new TeamMember("Ajay Gware", "Team Member"),
                new TeamMember("Prashik Dehere", "Team Member"),
                new TeamMember("Ritesh Kakde", "Team Member")
        );

        JPanel membersPanel = new JPanel();
        membersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        membersPanel.setBackground(new Color(18, 18, 18));

        for (TeamMember member : teamMembers) {
            TeamMemberCard card = new TeamMemberCard(member.getName(), member.getRole());
            membersPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(membersPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Inner class to represent team members
    private class TeamMember {
        private String name;
        private String role;

        public TeamMember(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() { return name; }

        public String getRole() { return role; }
    }
}
