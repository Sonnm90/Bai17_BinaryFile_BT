package BT2;



import BT1.config.Config;
import BT1.model.Product;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class Main {
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = Files.newInputStream(source.toPath());
            os = Files.newOutputStream(dest.toPath());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Enter source file:");
        String sourcePath = Config.scanner().nextLine();
        System.out.printf("Enter destination file:");
        String destPath = Config.scanner().nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.printf("Copy completed");
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
        System.out.println(new Config<Product>().readFromFile("src/BT1/database/product.csv"));
    }

}
