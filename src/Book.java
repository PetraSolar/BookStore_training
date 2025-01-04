public class Book {
    private String name;
    private Genre genre;
    private double price;
    private Author author;

    public Book(String name, Genre genre, double price, Author author) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return name + ", žánr: " + genre + ", cena " + price + ", autor: " + author.getName() + " " + author.getSurname();
    }
}
