package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputData {
    private int[] array;
    public int rhs;
    
    public int[] readFile(String filename) {        
        try (BufferedReader reader = new BufferedReader(
                                        new FileReader(
                                            new File(filename)))) {
            array = new int [Integer.valueOf(reader.readLine())];
            rhs = Integer.valueOf(reader.readLine());
            int i = 0;
            while(reader.ready()){
                String value = reader.readLine();
                array[i] = Integer.valueOf(value);
                i++;
            }
        }catch(FileNotFoundException e){
            System.out.println("Error, file could not be found");
        }catch(IOException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return array;
    }
}
