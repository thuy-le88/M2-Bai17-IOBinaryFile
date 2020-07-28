package thuchanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    static void copyFileUsingJava7Files(File source, File destination) throws IOException {
        Files.copy(source.toPath(),destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    static void copyFileUsingStream(File source, File destination) throws IOException {
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream=new FileInputStream(source);
            outputStream=new FileOutputStream(destination);
            byte[] buffer=new byte[1024];
            int length;
            int count=0;
            while ((length=inputStream.read(buffer))>0) {
                outputStream.write(buffer,0,length);
                count++;
            }
            System.out.println(count);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter source file: ");
        String sourcePath=sc.nextLine();
        System.out.println("Enter destination file: ");
        String destinationPath=sc.nextLine();

        File sourceFile=new File(sourcePath);
        File destinationFile=new File(destinationPath);

        try {
            copyFileUsingJava7Files(sourceFile,destinationFile);
            System.out.println("Copy completed!");
        }  catch (IOException e) {
            System.out.println("Cannot copy.");
            System.out.println(e.getMessage());
        }

        //copyFileUsingStream(sourceFile,destinationFile);
    }
}
