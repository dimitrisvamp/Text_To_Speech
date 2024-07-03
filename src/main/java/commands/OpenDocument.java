package commands;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class OpenDocument implements ActionListener {

    private String title;
    private JFileChooser fileChooser;
    private int choice, openButtonClick;

    public OpenDocument(int openButtonClick){
        this.openButtonClick = openButtonClick;

    }

    public int openWin(){
        fileChooser = new JFileChooser("D:");

        return fileChooser.showOpenDialog(null);
    }

    private static void openFile(File file){
        // Check if Desktop is supported from the system
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try{
                desktop.open(file);
            }
            catch (IOException ex){
                System.out.println("Error in opening file...");
            }
        }
        else{
            System.out.println("Error...Desktop is not supported on this system.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open the window of newButton
        if(openButtonClick == 1){
           choice = openWin();
           openButtonClick--;
        }
        // When user presses the "Open" button
        if(choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            openFile(selectedFile);
            System.out.println("Open Document");
        }
    }
}
