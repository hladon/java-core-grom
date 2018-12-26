package lesson33;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void writeToFileFromConsole(String path) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String bufferedText;
        StringBuffer consoleText = new StringBuffer();
        System.out.println("Enter file content to write in the file");
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File with path " + path + " not found");
            return;
        }
        while (true) {
            try {
                bufferedText = bufferedReader.readLine();
                if (bufferedText.trim().equals("wr")) {
                    writeToFile(path, consoleText);
                    return;
                }
                consoleText.append(bufferedText + "\r\n");
            } catch (IOException e) {
                System.out.println("Can`t write to file " + path);
                return;
            }
        }
    }

    private static void writeToFile(String path, StringBuffer text) throws IOException {

        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.append(text);
        IOUtils.closeQuietly(bufferedWriter);
        IOUtils.closeQuietly(writer);

    }
}
