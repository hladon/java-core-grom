package lesson34task2;

import java.io.*;

public class Solution {

    public static void transferSentences(String fileFromPath,String fileToPath,String word) throws Exception{
        validate (fileFromPath,fileToPath);
        StringBuffer transfer=splitText(readFromFile(fileFromPath),word,fileFromPath);
        writeToFile(fileToPath,transfer,true);
    }
    private static StringBuffer readFromFile(String path){
        StringBuffer res =new StringBuffer();
        try (BufferedReader br=new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append(" ");
            }
        }catch (FileNotFoundException e){
            System.err.println("File does not exist");
        }
        catch (IOException e){
            System.err.println("Reading from file"+path+"failed");
        }
        return res;
    }
    private static StringBuffer splitText(StringBuffer text, String checkedWord, String pathToOriginFile) {
        StringBuffer textToTransfer = new StringBuffer();
        StringBuffer textToLeave = new StringBuffer();
        String line = text.toString();
        String[] sentencess = line.split("[.]");

        for (String sentences : sentencess) {
            if (sentences.length() > 10&&sentences.contains(checkedWord)) {
                textToTransfer.append(sentences);
                textToTransfer.append(".");
            }else {
                textToLeave.append(sentences);
                textToLeave.append(".");
            }
        }
        writeToFile(pathToOriginFile,textToLeave,false);
        return textToTransfer;
    }

    private static void writeToFile (String path, StringBuffer contentToWrite, boolean saveTheText){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, saveTheText))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }
    private static void validate (String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File" + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File" + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new FileNotFoundException("File" + fileFrom + " does not have permissions to be read");
        }
        if (!fileTo.canRead()) {
            throw new FileNotFoundException("File" + fileTo + " does not have permissions to be read");
        }
    }

}