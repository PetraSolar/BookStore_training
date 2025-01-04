public class Bookstore {
    private int count;
    private Book[] books;

    public Bookstore(int capacity) {
        this.count = 0;
        this.books = new Book[capacity]; // do atributu books si vytvořím nové pole Book, které bude velké jako je hodnota ve vstupním parametru capacity
    }

    // přidání knihy do knihkupectví
    public void addBook(Book book) {
//        if (count == books.length) { // ptám se, jestli je count v počtu knih v knihkupectví stejné jako je velikost pole
//            System.out.println("Knihkupectví je plné a nelze přidat další knížku"); // vypsat do konzole, že knihkupectví je plné
//            return; // ukončím volání metody, dále už metoda nepokračuje - takže se pak neukazuje ta chybová hláška
//        }
//        // využití atributu count, aby se nemuselo opakovaně procházet pole, pokud je tam už velké množství knih
//        books[count] = book; // do pole knih na index count chci vložit danou knihu, kterou jsem tam poslala ve vstupním parametru
//        count++; // následně count zvednu o jedničku

        if (count < books.length) { // alternativní zápis, ale pro mě asi jednodušší, i když přednášejícímu dává větší smysl ten zápis výše
            books[count] = book;
            count++;
        } else {
            System.out.println("Knihkupectví je plné a nelze přidat další knížku");
        }

//        for (int i = 0; i < books.length; i++) { // procházím cyklicky celý seznam
//            if (books[i] == null) { // ptám se, jestli je prvek na tom daném indexu prázdný
//                books[i] = book; // přidám knihu do pole
//                break; // vyskočím z cyklu, protože chci přidat pouze jednu knihu, pokud by to tam nebylo, tak by se jedna knížka vložila na všechna prázdná místa v tom poli
//                // return; // lze použít místo break
//            }
//        }
    }

    // výpis všech knih z knihkupectví
    public void printAllBooks() {
//        for (int i = 0; i < books.length; i++) {// prochází pole knih
//            if (books[i] == null) { // jestli je prvek na tom daném indexu prázdný
//                break;} // vyskočím z cyklu, ať mi to tam nehází tu hodnotu null, pokud na indexu není žádná kniha
//            System.out.println(books[i]); // každou knihu vypíše do konzole
//    }

        for (int i = 0; i < count; i++) { // lepší zápis - pole procházím jen do počtu knih, které jsou v knihkupectví, nikoliv celou velikost pole
            System.out.println(books[i]);
        }
    }

    // získání knihy dle názvu
    public Book getBookByName(String name) {
        for (int i = 0; i < count; i++) {
            if (books[i].getName().equals(name)) {
                return books[i];
            }
        }
        return null;
    }

    // výpočet průměrné ceny knih z knihkupectví
    public double getAverageBookPrice() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += books[i].getPrice();
        }
        return sum / count;
    }

    // pole jen tak velké, kolik je v něm prvků
    private Book[] trimBooks(Book[] books, int count) { // metoda vytvoření pomocného pole pro tu následující metodu
        Book[] trimmedBooks = new Book[count]; // vytvoření pomocného pole, které bude velké jako je počet knih v knihkupectví

        for (int i = 0; i < count; i++) {
            trimmedBooks[i] = books[i]; // do pomocného pole knížek na index i vkládám knížku z pole knih na indexu i
        }

        return trimmedBooks;
    }

    // výpis knih podle žánru
    public Book[] getBooksByGenre(Genre genre) {
        Book[] booksByGenre = new Book[count];// vytvoření pomocného pole, které bude velké jako je počet knih v knihkupectví
        int genreCount = 0; // vytvoření počítadla - pomocná proměnná, která se pohybuje po indexech pomocného pole
        for (int i = 0; i < count; i++) {
            if (books[i].getGenre() == genre) {
                booksByGenre[genreCount] = books[i];// pokud se žánr shoduje, tak do pomocného pole knížek na index genreCount vkládám knížku z pole knih na indexu i
                genreCount++; // počítadlo zvednu o jedničku
            }
        }
        return trimBooks(booksByGenre, genreCount); // volám tu vytvořenou pomocnou metodu
    }

    // Získání knih pod určitou cenou
    public Book[] getBooksUnderPrice(double price) {
        Book[] booksUnderPrice = new Book[count]; // vytvoření pomocného pole, které bude velké jako je počet knih v knihkupectví
        int priceCount = 0; // vytvoření počítadla - pomocná proměnná, která se pohybuje po indexech pomocného pole
        for (int i = 0; i < count; i++) {
            if (books[i].getPrice() < price) {
                booksUnderPrice[priceCount] = books[i]; // do pomocného pole knížek na index priceCount vkládám knížku z pole knih na indexu i
                priceCount++; // počítadlo zvednu o jedničku
            }
        }
        return trimBooks(booksUnderPrice, priceCount); // volám tu vytvořenou pomocnou metodu
    }

    // Získání knih podle příjmení autora
    public Book[] getBooksByAuthorSurname(String surname) {
        Book[] booksByAuthorSurname = new Book[count]; // vytvoření pomocného pole, které bude velké jako je počet knih v knihkupectví
        int authorCount = 0; // vytvoření počítadla - pomocná proměnná, která se pohybuje po indexech pomocného pole
        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().getSurname().equals(surname)) {
                booksByAuthorSurname[authorCount] = books[i]; // do pomocného pole knížek na index authorCount vkládám knížku z pole knih na indexu i
                authorCount++; // počítadlo zvednu o jedničku
            }
        }
        return trimBooks(booksByAuthorSurname, authorCount); // volám tu vytvořenou pomocnou metodu
    }
}
