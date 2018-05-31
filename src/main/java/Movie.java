public class Movie {
    public enum Type {
        CHILDREN,
        REGULAR,
        NEW_RELEASE
    }

    private String title;
    private Type priceCode;

    public Movie(String title, Type priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public Type getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(Type priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }
}