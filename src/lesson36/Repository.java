package lesson36;


import lesson36.Exceptions.RepositoryDamaged;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Repository {

    public static String[] getListFromRepository(String path, Pattern rightDataStructure) throws Exception {
        StringBuffer text = new StringBuffer();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (line != null && !rightDataStructure.matcher(line).matches())
                    throw new RepositoryDamaged("Repository " + path + " are damaged");
                text.append(line);
                text.append("\n");
            }
        } catch (IOException io) {
            throw new IOException("File " + path + " are missing");
        }
        return String.valueOf(text).split("\n");
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

    public static Set find(String stringToFind, int slot, String[] textList) {
        String[] values;
        Set<String> list = new HashSet<>();
        for (String line : textList) {
            values = line.split("[,]");
            if (values[slot].equalsIgnoreCase(stringToFind))
                list.add(line);
        }
        return list;
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
