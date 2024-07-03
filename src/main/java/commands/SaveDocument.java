package commands;

import org.example.FileCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveDocument implements ActionListener {

    private String content;
    private JFrame frame;
    private JButton saveButton;
    private JFileChooser fileChooser;
    private int choice;
    private FileCreator fileCreator;

    public SaveDocument(JButton saveButton, String newContent){
        this.saveButton = saveButton;
        this.content = newContent;
        this.choice = saveWin();
        actionPerformed(null);

    }

    public int saveWin(){

        // Initialize the file chooser frame
        fileChooser = new JFileChooser("D:");
        saveButton.addActionListener(this);

        // Initialize new file types
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Document", ".txt"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Word Document", ".docx"));

        return fileChooser.showSaveDialog(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // When user presses the "Save" button
        if(choice == JFileChooser.APPROVE_OPTION){
            // Get the path from the frame
            File selectedFile = fileChooser.getSelectedFile();
            String filepath = selectedFile.getAbsolutePath();

            // Create file
            fileCreator = new FileCreator(content, filepath);
            fileCreator.getContentToFile();
            System.out.println(filepath);
        }
    }
}
