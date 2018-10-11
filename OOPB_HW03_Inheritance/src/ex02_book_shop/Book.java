package ex02_book_shop;



public class Book {
    private String title;
    private String author;
    private double price;

    public Book() { }

    public Book(String title, String author, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    protected void setTitle(String title) {
        if(title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected void setAuthor(String author) {
        String[] names;
        names = author.split("\\s+");
        if(names.length > 1) {
            if(names[1].matches("\\d\\w+"))
           throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected void setPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    protected String getTitle() {
        return this.title;
    }

    protected String getAuthor() {
        return this.author;
    }

    protected double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(String.format("%.1f", getPrice()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
