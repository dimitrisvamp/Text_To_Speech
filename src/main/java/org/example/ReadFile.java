package org.example;

import java.io.*;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadFile {

    private File selectedFile;
    private BufferedReader br;
    private FileReader fr;
    private String line;
    private  StringBuilder content;

    public ReadFile(File file){

        this.selectedFile = file;
        content = new StringBuilder();

    }

    public String getContentFromTXT(){

        try {
            br = new BufferedReader(new FileReader(selectedFile.toString()));
            while ((line = br.readLine()) != null){
                content.append(line).append(System.lineSeparator());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();

    }

    public String getContentFromDOCX(){
        try{
            FileInputStream fis = new FileInputStream(selectedFile.toString());
            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph para: paragraphs){
                content.append(para.getText()).append(System.lineSeparator());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return content.toString();
    }


}