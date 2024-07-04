# TextToSpeech-Application

## University Project
A version of school project from Computer Science and Engineering department of the University of Ioannina (UOI).

## Description 
An application that utilizes freetts library to speak the content of a text file or a docx file.

## Requirements
For this project you need to install: <br>
- java ( https://www.java.com/download/ie_manual.jsp )
- freetts ( https://freetts.sourceforge.io/ )
- apache POI ( https://poi.apache.org/download.html )
<br> 
Don't forget to add the jar files of freetts and apache POI to your project structure.

## Usage 
When the user runs the application, the main application window will appear on his screen. User will notice that there
are three main functions represented by the three respective buttons. The first button is "New Document" button, the
second button is "Speech Document" button and the third is "Open Document" button. So the first button corresponds on
the creation of a new document, the second button corresponds on the document that user wants to speak and the third 
button corresponds on the opening of an existed document. <br>

When the user presses the "New Document" button a new window will appear. This window indicates the user how the structure 
of the file he is going to create should be. Specifically, the application prompts the user to fill three fields. The
first field is the title of the document, the second field is the author's name and the third field in which user can type the 
content of his document. Below those fields there is a "Save" button which user should press so he can save his document. Once
user presses that button, the window for new document creation will be disposed and a new window will appear. This new window
is a hard drive browser where user can browse his pc files in it, so he saves his document wherever he wants. Once user browses
the path and selects the folder where he wants to save his document, he should type on the "File Name:" field the name of his 
document (e.g textFile.txt for text document of wordFile.docx for word document) and then to select the type of his file as a 
"Text Document" or "Word Document". The the user presses the button "save" bellow to complete the precedure of creating a new 
document. <br> 

The second option for the user is to press the "Speech Document" button. Once user presses this button a new window will appear, 
similar with the window that user saves his new document. Consequently, the user should browse his hard drive folders to find
and select the document he wants to speak. The user can select the speech document by double ckicking on it or by selecting it 
and then pressing the open button below. After selecting the speech document, the window of hard drive browsing will be disposed
and the "Audio Settings" window will appear. Because of some restrictions of freetts library, it is not possible for the user 
to synthesize the audio settings while the voice is speaking the document's content. But he can do it before the voice starts 
speaking. So the user can adjust the audio settings (volume, pitch, rate) by moving the respective sliders according to his needs.
After that the user presses the "Start speaking" button to start speaking the document's content.

The third and the last option that the application provides to user is the opening and editting function by clicking the "Open Document"
button. Once user presses this button it will appear the same window with that of browsing and selecting the file to speak. So the user 
follows the same procedure to open the document he wants to. The document will be opened as a text document or word document in 
desktop, according to his type of document. Then the user can read or edit the content and save as he could do it at his desktop.

The application is closing by clicking the close option up and right side of the main window as most of the applications.

## Uploaded Files
Inside the src/main/java folder there are three folders that contain the java files for the application's implementation. <br>
- commands:
  - AudioTuner.java: Class for the audio settings window and function.
  - CommandsFactory: The factory class responsible for creating the main ActionListener objects based on user commands.
  - NewDocument.java: Class for creating a new document.
  - OpenDocument.java: Class for opening a document in desktop.
  - SaveDocument.java: Class for saving a document.
  - VoiceDocument.java: Class searching the document to speak and setting up the content to speak.
- org/example:
  - FileCreator.java: Class for creating a text or word document.
  - FileTypeFilter.java: Class for adding new document types.
  - ReadFile.java: Class for reading the content of a text or word document.
- view:
  - TextToSpeechClient.java: The main class that creates the main client's window.

## How To Run
I made this project with maven so I run it as a maven project.
- If you run from Intellij IDEA or eclipse:
  - Go to "build" option.
  - Select "build project" option.
  - Run the TextToSpeechClient.java file by clicking the play button up and right.
- If you run from cmd type:
  - mvn -version ( to secure that maven is installed )
  - cd path\to\your\project
  - mvn clean install
  - mvn compile
  - java -cp target/classes view.TextToSpeechClient
