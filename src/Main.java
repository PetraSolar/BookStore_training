import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Author doe = new Author("John", "Doe");
        Book theShining = new Book("The Shining", Genre.HORROR, 400, doe);

        Author rowling = new Author("J.K.", "Rowling");
        Book harryPotter = new Book("Harry Potter", Genre.FANTASY, 500, rowling);

        Author tolkien = new Author("J.R.R.", "Tolkien");
        Book lordOfTheRings = new Book("Lord of the Rings", Genre.FANTASY, 999, tolkien);


        Book twelfthNight = new Book("Twelfth Night", Genre.HORROR, 200, doe);
        Book hobit = new Book("The Hobbit", Genre.FANTASY, 300, doe);

        // Přidání knihy do knihkupectví
        Bookstore bookstore = new Bookstore(10);
        bookstore.addBook(lordOfTheRings);
        bookstore.addBook(twelfthNight);
        bookstore.addBook(harryPotter);
        bookstore.addBook(theShining);

        // Výpis všech knih z knihkupectví
        System.out.println("Výpis všech knih z knihkupectví:");
        bookstore.printAllBooks();
        System.out.println();

        // Získání knihy dle názvu
        System.out.println("Získání knihy dle názvu:");
        System.out.println(bookstore.getBookByName("Krteček"));
        System.out.println();

        // výpočet průměrné ceny knih
        System.out.println("Výpočet průměrné ceny knih:");
        System.out.println(bookstore.getAverageBookPrice() + " Kč");
        System.out.println();

        // Výpis knih podle žánru
        System.out.println("Výpis knih podle žanru:");
        Book[] booksByGenre = bookstore.getBooksByGenre(Genre.HORROR);
        for (Book book : booksByGenre) {
            System.out.println(book);
        }
        System.out.println();

        // Získání knih pod určitou cenou
        System.out.println("Získání knih pod určitou cenou:");
        Book[] booksByPrice = bookstore.getBooksUnderPrice(501);
        for (Book book : booksByPrice) {
            System.out.println(book);
        }
        System.out.println();

        // Získání knih podle příjmení autora
        System.out.println("Získání knih podle příjmení autora:");
        Book[] booksByAuthor = bookstore.getBooksByAuthorSurname("Doe");
        for (Book book : booksByAuthor) {
            System.out.println(book);
        }
    }
}
