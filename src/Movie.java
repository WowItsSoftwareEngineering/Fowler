public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        this.setPriceCode(newPriceCode);
    }
    public int getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
    public String getTitle (){
        return title;
    };
}