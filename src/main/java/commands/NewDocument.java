package commands;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.util.Date;

import javax.swing.*;

public class NewDocument implements ActionListener{

    private String title, author, Text;
    private JFrame frame;
    private JPanel titlePanel, authorPanel, textPanel;
    private JTextArea titleArea, authorArea, text;
    private JButton saveButton;
    private CommandsFactory factory;
    private int newButtonClick;

    public NewDocument(int newButtonClick){
        this.frame = new JFrame("New Document");
        this.newButtonClick = newButtonClick;
        this.factory = new CommandsFactory();
    }

    public void NewDocWin(){

        // Initialize new frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(450, 250);
        frame.setVisible(true);

        // Container Panel for left-aligned components
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        // Initialize title panel
        JLabel title = new JLabel("Title:");
        title.setForeground(Color.LIGHT_GRAY);
        titleArea = new JTextArea(1,10);
        titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBounds(0,0, 50, 50);
        titlePanel.setBackground(Color.darkGray);
        titlePanel.add(title);
        titlePanel.add(titleArea);
        frame.add(titlePanel);

        // Initialize author panel
        JLabel author = new JLabel("Author:");
        author.setForeground(Color.LIGHT_GRAY);
        authorArea = new JTextArea(1,10);
        authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        authorPanel.setBounds(0,0, 50, 50);
        authorPanel.setBackground(Color.darkGray);
        authorPanel.add(author);
        authorPanel.add(authorArea);
        frame.add(authorPanel);

        // Initialize text panel
        text = new JTextArea(10,20);
        textPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        textPanel.setBounds(0,0, 50, 50);
        textPanel.setBackground(Color.darkGray);
        textPanel.add(text);
        frame.add(authorPanel);

        // Initialize save button
        saveButton = new JButton("Save");
        saveButton.setBounds(0, 0, 50, 30);
        saveButton.setBackground(Color.CYAN);
        saveButton.setFocusable(false);

        // Add panels to the left panel
        leftPanel.add(titlePanel);
        leftPanel.add(authorPanel);

        // Add left panel to the frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(textPanel, BorderLayout.EAST);
        frame.add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open the window of newButton
        if(newButtonClick == 1){
            NewDocWin();
            newButtonClick--;
        }
        if(e.getSource() == saveButton){
            // Get the contents of the title, author and text
            title = titleArea.getText();
            author = authorArea.getText();
            Text = text.getText();

            // Save the headline consisted of the title and author's name to a string
            String content = new String("title: "+title+ "\n"+ "author: "+ author+ "\n" +
                    "======================" + "\n" + Text);
            factory.setContent(content);
            factory.setFrame(frame);
            factory.setSaveButton(saveButton);

            // Reset the contents of text areas
            newButtonClick++;
            titleArea.setText("");
            authorArea.setText("");
            text.setText("");

            factory.createCommand("Save Document");
        }
    }
}
