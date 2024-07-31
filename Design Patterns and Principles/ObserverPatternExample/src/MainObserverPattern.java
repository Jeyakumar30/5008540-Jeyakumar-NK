public class MainObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp_1");
        Observer webApp = new WebApp("WebApp_1");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(98.20);
        stockMarket.setStockPrice(120.80);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(105.0);
    }
}
