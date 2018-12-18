package lesson36;

import lesson36.Exceptions.RepositoryDamaged;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Repository {

    public static String[] getListFromRepository(String path){

        StringBuffer text=new StringBuffer();
        String line;
        try (BufferedReader br=new BufferedReader(new FileReader(path))) {
            while ((line=br.readLine())!=null){
                text.append(line);
                text.append("\n");
            }
        }catch (IOException io){
            System.err.println("File "+path+" are missing");
        }
        return String.valueOf(text).split("\n");
    }

    public static void checkDataFromRepository(Pattern pattern, String text, String path) throws RepositoryDamaged {
        Matcher matcher=pattern.matcher(text);
               if (!matcher.matches())
                   throw new RepositoryDamaged("Repository " + path+" are damaged");
    }

    public static String add (String repositoryAddres, String text){
        try (BufferedWriter br=new BufferedWriter(new FileWriter(repositoryAddres,true))){
            br.append(text);
            br.append("\n");
            return text;
        }catch (Exception e){
            System.err.println("Repository in "+repositoryAddres+" not found!");
        }
        return null;
    }


}
