package lesson36;

import lesson36.Exceptions.RepositoryDamaged;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Repository {

    public static String[] getListFromRepository(String path, Pattern rightDataStructure)throws RepositoryDamaged{
        StringBuffer text=new StringBuffer();
        String line;
        try (BufferedReader br=new BufferedReader(new FileReader(path))) {
            while ((line=br.readLine())!=null){
                if (rightDataStructure!=null&&!rightDataStructure.matcher(line).matches())
                    throw new RepositoryDamaged("Repository " + path+" are damaged");
                text.append(line);
                text.append("\n");
            }
        }catch (IOException io){
            System.err.println("File "+path+" are missing");
        }
        return String.valueOf(text).split("\n");
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
    //Method do not check information in repository
    public static void delete(long id,String repositoryPath){
        String[] repositoryData=null;
        Pattern patternToCheck=Pattern.compile(Long.toString(id)+",");
        StringBuffer newData=new StringBuffer();
        try{
        repositoryData=getListFromRepository(repositoryPath,null);
        }catch (Exception e){ return;}
        for (String object: repositoryData){
            if (patternToCheck.matcher(object).matches())
                continue;
            newData.append(object);
            newData.append("\n");
        }
        try(BufferedWriter br=new BufferedWriter(new FileWriter(repositoryPath,false))){
            br.write(String.valueOf(newData));
        }catch (IOException io){
            System.err.println("File "+repositoryPath+" not exist!");
        }
    }


}
