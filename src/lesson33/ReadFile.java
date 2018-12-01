package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        readFile("C:/Users/Vitaliy/Desktop/test.txt");
        writeFile("C:/Users/Vitaliy/Desktop/test1.txt");
    }

    private static void readFile(String path){
        FileReader reader;
        try {
            reader=new FileReader(path);
        }catch (FileNotFoundException e){
            System.err.println("File does not exist");
            return;
        }
        BufferedReader br=new BufferedReader(reader);
        try{
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.println("Reading from file "+ path+ "failed");
        }finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
    private static void writeFile(String path){
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        try {
            //TODO use other constructor
            writer=new FileWriter(path,true);
            bufferedWriter=new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append("TTTTT");
        }catch (IOException e){
            System.err.println("Can`t write to file");
        }finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }

    }
}
