package commands;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.sun.speech.freetts.Voice;

public class AudioTuner implements ActionListener {

    private JSlider volumeSlider, pitchSlider, rateSlider;
    private JFrame slidersFrame;
    private JPanel volumePanel, pitchPanel, ratePanel, container, buttonPanel;
    private JLabel volumeLabel, pitchLabel, rateLabel;
    private JButton startButton;
    private int speechButton;
    private Voice voice;
    private String stringToSpeech;


    public AudioTuner(int speechButton, Voice voice, String stringToSpeak){
        this.slidersFrame = new JFrame("Audio settings");
        this.volumeSlider = new JSlider();
        this.pitchSlider = new JSlider();
        this.rateSlider = new JSlider();
        this.volumePanel = new JPanel();
        this.pitchPanel = new JPanel();
        this.ratePanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.volumeLabel = new JLabel("Volume");
        this.pitchLabel = new JLabel("Pitch");
        this.rateLabel = new JLabel("Rate");
        this.container = new JPanel();
        this.startButton = new JButton("Start speaking");
        this.speechButton = speechButton;
        this.voice = voice;
        this.stringToSpeech = stringToSpeak;

    }

    public void slidersWin(){

        // Initialize sliders frame
        slidersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        slidersFrame.getContentPane().setBackground(Color.darkGray);
        slidersFrame.setSize(250, 350);
        slidersFrame.setLayout(new BorderLayout());

        // Initialize start speaking button
        startButton.setBackground(Color.CYAN);
        startButton.setFocusable(false);

        // Set label foreground
        volumeLabel.setForeground(Color.LIGHT_GRAY);
        pitchLabel.setForeground(Color.LIGHT_GRAY);
        rateLabel.setForeground(Color.LIGHT_GRAY);

        // Set panels
        volumePanel.setBackground(Color.DARK_GRAY);
        volumePanel.add(volumeLabel);
        volumePanel.add(volumeSlider);

        pitchPanel.setBackground(Color.DARK_GRAY);
        pitchPanel.add(pitchLabel);
        pitchPanel.add(pitchSlider);

        ratePanel.setBackground(Color.DARK_GRAY);
        ratePanel.add(rateLabel);
        ratePanel.add(rateSlider);

        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(startButton);
        // Containerize each panel exactly down from the previous one
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(volumePanel);
        container.add(pitchPanel);
        container.add(ratePanel);
        container.add(buttonPanel);

        // Add panels to frame
        slidersFrame.add(container, BorderLayout.CENTER);
        slidersFrame.setVisible(true);

        startButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Initialize values from sliders
        voice.setVolume(volumeSlider.getValue());
        voice.setPitch(pitchSlider.getValue());
        voice.setRate(rateSlider.getValue());

        if(e.getSource() == startButton) {

            // Bind a new thread to prevent voice allocation blocking the gui operation
            new Thread(() -> {
                try {
                    voice.speak(stringToSpeech);
                } catch (Exception ee) {
                    ee.printStackTrace();
                } finally {
                    // Deallocate the voice after speaking
                    voice.deallocate();
                   }
            }).start();

            }

    }

    public JSlider getVolumeSlider(){
        return volumeSlider;
    }

    public JSlider getPitchSlider(){
        return pitchSlider;
    }

    public JSlider getRateSlider(){
        return rateSlider;
    }
}

