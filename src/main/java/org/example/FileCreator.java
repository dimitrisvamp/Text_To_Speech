package org.example;

import java.io.*;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class FileCreator {

    private String filePath;
    private String content;

    public FileCreator(String newContent, String path){
        this.content = newContent;
        this.filePath = path;
    }

    public void getContentToFile(){

        if(filePath.endsWith(".txt")) {
            // Create a txt file
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(content);
            } catch (IOException ex) {
                System.out.println("Invalid Path");
            }
        }
        else{
            // Create a new docx document
            XWPFDocument document = new XWPFDocument();

            // Create the new paragraph
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(content);

            // Save the docx document to the specified path
            try{
                FileOutputStream fos = new FileOutputStream(filePath);
                document.write(fos);
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                try{
                    document.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
