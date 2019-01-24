package lesson36;


import lesson36.Exceptions.RepositoryDamaged;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Repository {

    public static List<String> getListFromRepository(String path) throws Exception {
        List list=new LinkedList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                   list.add(line);
            }
        } catch (IOException io) {
            throw new IOException("File " + path + " are missing");
        }
        return list;
    }

    public static void changeData(long id, String repositoryPath, String[] dataStored, String newDataLine) {

        StringBuffer newData = new StringBuffer();
        String idString;
        boolean isExist = true;
        for (String object : dataStored) {
            if (object.isEmpty())
                continue;
            idString = object.substring(0, object.indexOf(","));
            if (Long.valueOf(idString) == id) {
                isExist = false;
                if (newDataLine == null)
                    continue;
                newData.append(newDataLine);
                newData.append("\n");
            } else {
                newData.append(object);
                newData.append("\n");
            }
        }
        if (isExist && newDataLine != null) {
            newData.append(newDataLine);
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(repositoryPath, false))) {
            br.write(String.valueOf(newData));
        } catch (IOException io) {
            System.err.println("File " + repositoryPath + " not exist!");
        }
    }


    public static String findById(Long id, String[] textList) {
        String[] values;
        for (String line : textList) {
            values = line.split("[,]");
            if (Long.valueOf(values[0]) == id)
                return line;
        }
        return null;
    }


}
