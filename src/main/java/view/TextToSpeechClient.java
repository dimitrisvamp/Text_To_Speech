package view;

import commands.CommandsFactory;

import javax.swing.*;
import java.awt.*;

public class TextToSpeechClient {

    public static void main(String[] args){

        CommandsFactory factory = new CommandsFactory();


        // Set the application's buttons
        JButton editButton = new JButton();
        JButton newButton = new JButton();
        JButton openButton = new JButton();

        newButton.setBounds(50, 200, 120, 30);
        newButton.setText("New Document");
        newButton.setBackground(Color.CYAN);
        newButton.setFocusable(false);


        editButton.setBounds(240, 200, 150, 30);
        editButton.setText("Speech Document");
        editButton.setBackground(Color.CYAN);
        editButton.setFocusable(false);


        openButton.setBounds(450, 200, 150, 30);
        openButton.setText("Open Document");
        openButton.setBackground(Color.CYAN);
        openButton.setFocusable(false);

        // Set the application's label
        JLabel label = new JLabel("This is a text to speech application");
        ImageIcon labelIcon = new ImageIcon("logo.png");
        label.setIcon(labelIcon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setForeground(Color.CYAN);


        // Set the frame of the application
        JFrame frame = new JFrame();
        frame.setTitle("Text To Speech Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setVisible(true);

        // Set application's appearance
        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.darkGray);
        frame.add(newButton);
        frame.add(editButton);
        frame.add(openButton);
        frame.add(label);

        // Add actionListeners to each button when you click it
        newButton.addActionListener(factory.createCommand("New Document"));
        editButton.addActionListener(factory.createCommand("Speech Document"));
        openButton.addActionListener(factory.createCommand("Open Document"));

    }
}
