package model;
public class Main {
    public static void main(String[] args) {
        BookDB b = new BookDB();
        b.getBook("B0001");
        System.out.println("-------");
        b.getAllBooks();
        System.out.println("-------");
        b.searchByCategory("LT");
    }
}
