package lesson34.task1;



import java.io.*;

public class Solution {

    public static void transferFileContent(String fileFromPath,String fileToPath) throws Exception{
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
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        }catch (IOException e){
            System.err.println("Reading from file"+path+"failed");
        }
        return res;
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
