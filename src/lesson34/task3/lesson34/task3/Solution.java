package lesson34.task3;




import org.apache.commons.io.FileUtils;
import java.io.*;


public class Solution {
    public static void copyFileContent(String fileFromPath,String fileToPath) throws Exception{
        validate(fileFromPath);
        writeToFile(fileToPath,readFromFile(fileFromPath));

    }
    public static void copyFileContentApacheIO(String fileFromPath,String fileToPath) throws Exception{
        File fileFrom=new File(fileFromPath);
        String fileToCreate=fileToPath+"/fileTo.txt";
        File fileTo =new File(fileToCreate);
        FileUtils.copyFile(fileFrom,fileTo);


    }

    private static StringBuffer readFromFile(String path){
        StringBuffer res =new StringBuffer();
        try (BufferedReader br=new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length()-1,res.length(),"");
        }catch (FileNotFoundException e){
            System.err.println("File does not exist");
        }
        catch (IOException e){
            System.err.println("Reading from file"+path+"failed");
        }
        return res;
    }
    private static void writeToFile(String path, StringBuffer contentToWrite){
        String fileToCreate=path+"/fileTo.txt";
        File fileTo =new File(fileToCreate);
        try {
            fileTo.createNewFile();
        }catch (IOException e){
            System.err.println("New file can`t be created!");
        }
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileToCreate,true))){
            bufferedWriter.append(contentToWrite);
        }catch (IOException e){
            System.err.println("Can`t write to file");
        }
    }
    private static void validate (String fileFromPath) throws Exception{
        File fileFrom=new File(fileFromPath);
        if (!fileFrom.exists()){
            throw new FileNotFoundException("File"+ fileFrom+" does not exist");
        }
        if (!fileFrom.canRead()){
            throw new FileNotFoundException("File"+ fileFrom+" does not have permissions to be read");
        }
    }
}