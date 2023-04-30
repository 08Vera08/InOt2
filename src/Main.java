import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(2);
        counts.add(5);
        counts.add(10);
        counts.add(10);
        counts.add(5);
        ArrayList<String> products = new ArrayList<>();
        products.add("Banana");
        products.add("Meat");
        products.add("Grape");
        products.add("Milk");
        products.add("Sugar");
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(100);
        prices.add(300);
        prices.add(200);
        prices.add(60);
        prices.add(70);
        products.add("Peach");
        prices.add(180);
        counts.add(4);
        products.add("Apple");
        prices.add(105);
        counts.add(10);
        products.add("Apricot");
        prices.add(165);
        counts.add(7);
        Basket basket = new Basket(products, prices, counts);
        //File textFile = new File("Basket.txt");
        File textFile = new File("basket.txt");


        if (textFile.exists()) {
            System.out.println("Exist!");
            Basket buffer = basket.loadFromTxtFile(textFile);
            ArrayList<String> things = buffer.getProducts();
            for (String product : things) {
                if (!basket.getProducts().contains(product)) {
                    int index = things.indexOf(product);
                    basket.addProduct(buffer.getProduct(index), buffer.getPrice(index), buffer.getCount(index));
                }
            }
            basket.saveTxt(textFile);
        } else {
            System.out.println("Not exist!");
            basket.saveTxt(textFile);
        }
        basket.printCart();
    }
}