package commands;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CommandsFactory {

    private String header, content;
    private JFrame frame;
    private JButton saveButton;

    public CommandsFactory(){

    }

    public ActionListener createCommand(String command){
        switch(command){
            case "New Document":
                int newButtonClick = 1;
                return new NewDocument(newButtonClick);
            case "Speech Document":
                int speechButtonClick =1;
                return new VoiceDocument(speechButtonClick);
            case "Open Document":
                int openButtonClick = 1;
                return new OpenDocument(openButtonClick);
            case "Save Document":
                frame.dispose();
                return new SaveDocument(saveButton, content);
            default:
                return null;
        }
    }

    // Helpful setter functions
    public void setContent(String newContent){

        this.content = newContent;
    }

    public void setFrame(JFrame newFrame){

        this.frame = newFrame;
    }

    public void setSaveButton(JButton newSaveButton){

        this.saveButton = newSaveButton;
    }

}
