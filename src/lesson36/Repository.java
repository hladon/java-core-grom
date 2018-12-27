package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Hotel;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
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

    public static void add (String repositoryAddres, String text){
        try (BufferedWriter br=new BufferedWriter(new FileWriter(repositoryAddres,true))){
            br.append(text);
            br.append("\n");
        }catch (Exception e){
            System.err.println("Repository in "+repositoryAddres+" not found!");
        }
    }
    //Method do not check information in repository
    public static void changeData(long id,String repositoryPath, String changedData) throws RepositoryDamaged{
        String[] repositoryData=getListFromRepository(repositoryPath,null);
        Pattern patternToCheck=Pattern.compile(String.valueOf(id)+",");
        StringBuffer newData=new StringBuffer();
        String line =findById(id,repositoryData);
        for (String object: repositoryData){
            if (object.equals(line)){
                newData.append(changedData);
                if (!changedData.isEmpty())
                    newData.append("\n");
                continue;
            }
            newData.append(object);
            newData.append("\n");
        }
        try(BufferedWriter br=new BufferedWriter(new FileWriter(repositoryPath,false))){
            br.write(String.valueOf(newData));
        }catch (IOException io){
            System.err.println("File "+repositoryPath+" not exist!");
        }
    }
    public static Set find(String stringToFind, int slot,String[] textList){
        String[] values;
        Set <String> list=new HashSet<>();
        for (String line: textList){
            values=line.split("[,]");
            if (values[slot].equals(stringToFind))
                 list.add(line);
        }
        return list;
    }

    public static String findById(Long id,String[] textList){
        String[] values;
        for (String line: textList){
            values=line.split("[,]");
            if (Long.valueOf(values[1])==id)
                return line;
        }
        return null;
    }


}
