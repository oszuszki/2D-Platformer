package com.game.main;

import java.awt.*;

import javax.swing.*;


public class Game {

    public static void main(String [] args) {
        String name= JOptionPane.showInputDialog(null,"Enter your name");
        JFrame frame = new JFrame("Platformer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new GamePanel(name), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
