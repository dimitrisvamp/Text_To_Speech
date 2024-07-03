package commands;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.Voice;
import org.example.ReadFile;
import javax.swing.*;

public class VoiceDocument implements ActionListener {

    private String fileName, stringToSpeech;
    private JFileChooser fileChooser;
    private int speechButtonClick, choice;
    private ReadFile fileReader;
    private File selectedFile;
    private VoiceManager voiceManager;
    private Voice voice;
    private AudioTuner audioTuner;



    public VoiceDocument(int speechButtonClick){

        this.speechButtonClick = speechButtonClick;
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        voice.allocate();

    }

    public int selectDocumentToSpeechWin(){

        fileChooser = new JFileChooser("D:");

        return fileChooser.showOpenDialog(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(speechButtonClick == 1){
            choice = selectDocumentToSpeechWin();

        }
        if(choice == JFileChooser.APPROVE_OPTION){


            selectedFile = fileChooser.getSelectedFile();
            fileReader = new ReadFile(selectedFile);
            fileName = selectedFile.toString();

            // Get string to speech
            stringToSpeech = getStringToSpeech(fileReader, fileName);

            // Show tuner options window
            audioTuner = new AudioTuner(speechButtonClick, voice, stringToSpeech);
            audioTuner.slidersWin();



        }

    }

    public String getStringToSpeech(ReadFile fileReader, String fileName){
        // Return string to speech
        if ( fileName.endsWith("txt") ) {
            return fileReader.getContentFromTXT();
        }
        else{
            return fileReader.getContentFromDOCX();
        }
    }

}
