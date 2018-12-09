package lesson33;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void writeToFileFromConsole(String path) {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String bufferedText ;
        List<String> consoleText=new LinkedList<String>();

        System.out.println("Enter file content to write in the file");
        File file = new File(path);
        while (true) {
            if (!file.exists()) {
                System.out.println("File with path " + path + " not found");
                return;
            }
            try {
                bufferedText=bufferedReader.readLine();
                if (bufferedText.trim().equals("wr")) {
                    writeToFile(path, consoleText);
                    return;
                }
                consoleText.add(bufferedText);

            } catch (IOException e) {
                System.out.println("Can`t write to file " + path);
                return;
            } catch (Exception e) {
                System.out.println("Something wrong");
                return;
            }

        }
    }

    private static void writeToFile(String path, List<String> text) throws Exception {

        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (String str:text) {

            bufferedWriter.append(str);
            bufferedWriter.append(" ");
        }
        IOUtils.closeQuietly(bufferedWriter);
        IOUtils.closeQuietly(writer);

    }
}
