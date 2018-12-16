package lesson34.task2;



import java.io.*;

public class Solution {

    public static void transferSentences(String fileFromPath,String fileToPath,String word) throws Exception{
        validate(fileFromPath,fileToPath);
<<<<<<< HEAD
        writeToFile(fileToPath,splitText(readFromFile(fileFromPath),word,fileFromPath));
=======
        StringBuffer transfer=splitText(readFromFile(fileFromPath),word,fileFromPath);
        writeToFile(fileToPath,transfer);
>>>>>>> 0827c94e008c948c9ff5f19061a736ddde1b9350
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
    private static StringBuffer splitText(StringBuffer text,String checkedWord,String pathToOriginFile){
<<<<<<< HEAD
=======

>>>>>>> 0827c94e008c948c9ff5f19061a736ddde1b9350
        StringBuffer textToTransfer = new StringBuffer();
        StringBuffer textToLeave = new StringBuffer();
        String line=text.toString();
        String[] sentencess=line.split("[.]");

        for (String sentences: sentencess){
            if (checkSentences(sentences,checkedWord)){
<<<<<<< HEAD
                textToTransfer.append(sentences);
                textToTransfer.append(".");
=======
                textToTransfer.append(sentences+".");
            }
            else{
                textToLeave.append(sentences+".");
>>>>>>> 0827c94e008c948c9ff5f19061a736ddde1b9350
            }
            textToLeave.append(sentences);
            textToLeave.append(".");
        }
<<<<<<< HEAD
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathToOriginFile,true))){
=======
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathToOriginFile,false))){
>>>>>>> 0827c94e008c948c9ff5f19061a736ddde1b9350
            bufferedWriter.write(String.valueOf(textToLeave));
        }catch (IOException e){
            System.err.println("Can`t write to file");
        }
        return textToTransfer;
    }
    private static boolean checkSentences(String sentences,String checkedWord){

        if (sentences.length()<10){
            return false;
        }
        String[] words=sentences.split(" ");
        for (String word: words){
            if (word.equalsIgnoreCase(checkedWord))
                return true;
        }
        return false;

    }

    private static void writeToFile(String path, StringBuffer contentToWrite){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(path,true))){
            bufferedWriter.append(contentToWrite);
        }catch (IOException e){
            System.err.println("Can`t write to file");
        }
    }
    private static void validate (String fileFromPath,String fileToPath) throws Exception{
        File fileFrom=new File(fileFromPath);
        File fileTo=new File(fileToPath);
        if (!fileFrom.exists()){
            throw new FileNotFoundException("File"+ fileFrom+" does not exist");
        }
        if (!fileTo.exists()){
            throw new FileNotFoundException("File"+fileTo+" does not exist");
        }
        if (!fileFrom.canRead()){
            throw new FileNotFoundException("File"+ fileFrom+" does not have permissions to be read");
        }
        if (!fileTo.canRead()){
            throw new FileNotFoundException("File"+ fileTo+" does not have permissions to be read");
        }
    }
<<<<<<< HEAD
=======

>>>>>>> 0827c94e008c948c9ff5f19061a736ddde1b9350
}
