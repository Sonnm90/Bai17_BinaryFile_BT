package BT1.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static final String PATH_CATEGORY ="src/BT1/database/product.csv";
    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public List<T> readFromFile(String pathFile){
        List<T> tList =new ArrayList<>();
        try{
            FileInputStream fileInputStream=new FileInputStream(pathFile);
            if (fileInputStream.available()!=0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tList = (List<T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        } catch (FileNotFoundException f){
            System.err.println("File Not Found!");
        } catch (IOException i){
            System.err.println("IOE Exception!");
        } catch (ClassNotFoundException c){
            System.err.println("Class Not Found!");
        }
        return tList;
    }

    public void writeToFile(String pathFile,List<T>tList){
        File file = new File(pathFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException f){
            System.err.println("File Not Found!");
        } catch (IOException i){
            System.err.println("IOE Exception!");
        }
    }
}