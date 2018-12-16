package lesson36;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Repository {
    public static List<Hotel> getHotels(){
        return null;
    }

    public static String[] getList(String path){

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


}
