public class Stock {
    private String symbol;
    private String name;
    private double price;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;

    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock[symbol=" + symbol + ", name=" + name + "]";
    }
}
