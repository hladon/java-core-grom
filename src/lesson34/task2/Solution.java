package lesson34.task2;



import java.io.*;

public class Solution {

    public static void TransferSentences(String fileFromPath,String fileToPath,String word) throws Exception{
        validate(fileFromPath,fileToPath);
        writeToFile(fileToPath,readFromFile(fileFromPath));
        cleanFile(fileFromPath);
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
    private static void splitText(StringBuffer text,String checkedWord){
        String line=text.toString();
        String[] sentencess=line.split(".");
        for (String sentences: sentencess){
            if (checkSentences(sentences,checkedWord)){

            }
        }

    }
    private static boolean checkSentences(String sentences,String checkedWord){
        if (sentences.length()<10){
            return false;
        }
        String[] words=sentences.split(" ");
        for (String word: words){
            if (word.equals(checkedWord))
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
    private static void cleanFile(String path){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write("");
        }catch (IOException e){
            System.err.println("Can`t clean file");
        }
    }
}
