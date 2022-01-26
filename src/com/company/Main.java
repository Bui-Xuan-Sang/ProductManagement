package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "IPhone X", "apple", 10000000, "IPX"));
        products.add(new Product("2", "IPhone 11", "apple", 20000000, "IP11"));
        products.add(new Product("3", "IPhone12", "apple", 30000000, "IP12"));
        products.add(new Product("4", "IPhone13", "apple", 40000000, "IP13"));
        writeFile(products);
        List<Product> products1 = readFile();
        for (Product product : products1) {
            System.out.println(product);
        }

    }

    private static List<Product> readFile() {
        List<Product> products1 = new ArrayList<>();
        try {
            InputStream is = new FileInputStream("product.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            products1 = (List<Product>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products1;
    }

    private static void writeFile(List<Product> products) {
        try {
            OutputStream os = new FileOutputStream("product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(products);
            os.close();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
