package ex02_book_shop;

public class GoldenEditionBook extends Book {
    private static final double DEFAULT_PRICE_CORRECTION = 1.3;

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
        setPrice(price);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price * DEFAULT_PRICE_CORRECTION);
    }
}
