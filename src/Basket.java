import java.io.*;
import java.util.ArrayList;

class Basket implements Serializable {
    private int amount;
    private ArrayList<Integer> prices;
    private ArrayList<Integer> counts;
    private ArrayList<String> products;
    private static final long serialVersionUID = 1L;

    Basket(ArrayList<String> products, ArrayList<Integer> prices, ArrayList<Integer> counts) {
        this.amount = products.size();
        this.products = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.counts = new ArrayList<>();
        for (int i = 0; i < amount; ++i) {
            this.products.add(products.get(i));
            this.prices.add(prices.get(i));
            this.counts.add(counts.get(i));
        }
    }

    Basket() {
        amount = 0;
        products = new ArrayList<>();
        prices = new ArrayList<>();
        counts = new ArrayList<>();
    }

    public void addProduct(String product, int price, int count) {
        products.add(product);
        prices.add(price);
        counts.add(count);
        amount++;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public String getProduct(int i) {
        return products.get(i);
    }

    public int getCount(int i) {
        return counts.get(i);
    }

    public int getPrice(int i) {
        return prices.get(i);
    }

    public void printCart() {
        for (int i = 0; i < products.size(); ++i) {
            System.out.println("Name = " + products.get(i) + ", price = " + String.valueOf(prices.get(i)) + ", count = " + String.valueOf(counts.get(i)));
        }
    }


    public static Basket loadFromTxtFile(File textFile) {
        Basket basket = null;
        try (FileInputStream fin = new FileInputStream(textFile)) {
            ObjectInputStream myReader = new ObjectInputStream(fin);
            basket = (Basket) myReader.readObject();
            myReader.close();
            System.out.println("Saved!");
        } catch (StreamCorruptedException e) {
            System.out.println("Exception occurred!");
        } catch (UncheckedIOException e) {
            System.out.println("Exception occurred!");
        } catch (FileNotFoundException e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basket;
    }

    public void saveTxt(File textFile) {
        try (FileOutputStream fos = new FileOutputStream(textFile)) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(this);
            out.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        }
    }

    public void saveBin(File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(this);
            out.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        }
    }

    public static Basket loadFromBinFile(File file) {
        Basket basket = null;
        try (FileInputStream fin = new FileInputStream(file)) {
            ObjectInputStream myReader = new ObjectInputStream(fin);
            basket = (Basket) myReader.readObject();
            myReader.close();
            System.out.println("Saved!");
        } catch (UncheckedIOException e) {
            System.out.println("Exception occurred!");
        } catch (FileNotFoundException e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basket;
    }
}