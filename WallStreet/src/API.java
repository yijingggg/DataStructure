import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
StockList() - Display a list of 'symbol' & 'name'
getPrices() - For user to search for prices (can search multiple stock at one time)
getRealTimePrice() - For TradingEngine, it returns a double price ONLY
extractStocks() - return ArrayList of symbols and name
 */

public class API {
    public static String fileName = "MyStocks";
    public static final String API_KEY = "UM-1cd15cbc8ba9f613f94373ca35c267a52acf88978d73439e9f3c941b1c49318d";
    public static final String API_ENDPOINT = "https://wall-street-warriors-api-um.vercel.app/price";

    public static void main(String[] args) {
        API api = new API();
        api.updateStockList();
    }

    void updateStockList() {
        try {
            List<Stock> stocks = extractStocks();
            List<Stock> stocksWithPrice = new ArrayList<>();

            for (Stock stock : stocks) {
                double price = getRealTimePrice(stock.getSymbol());
                if (price != 0) {
                    stocksWithPrice.add(stock);
                }
            }

            // Save the stocks with price to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("UpdatedMyStock.txt"))) {
                for (Stock stock : stocksWithPrice) {
                    writer.write(stock.getSymbol() + "," + stock.getName());
                    writer.newLine();
                }
            }

            System.out.println("Stock list updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Call this method to read JSON data from a file copied from API end point provided
    String readJsonFromFile(String fileName) throws IOException {
        StringBuilder jsonText = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
        }

        return jsonText.toString();
    }


    // Extract the stocks' symbols and names from the JSON response and store them in a List
    List<Stock> extractStocks() throws IOException {
        String jsonResponse = readJsonFromFile(fileName);
        List<Stock> stockList = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsonResponse);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject stockJson = jsonArray.getJSONObject(i);
                String symbol = stockJson.getString("symbol");
                String name = stockJson.getString("name");

                Stock stock = new Stock(symbol, name);
                stockList.add(stock);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stockList;
    }


    // Only return single value price for Trading Machine
    double getRealTimePrice(String symbol) throws IOException {
        String url = API_ENDPOINT + "?apikey=" + API_KEY + "&function=TIME_SERIES_INTRADAY_EXTENDED&symbol=" + symbol;
        URL apiURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        String jsonResponse = "";
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            jsonResponse = response.toString();
        }

        double latestClosePrice = 0;
        try {
            JSONObject json = new JSONObject(jsonResponse);

            if (!json.isNull(symbol)) {

                JSONObject symbolData = json.getJSONObject(symbol);
                JSONObject closeData = symbolData.getJSONObject("Close");

                long latestTimestamp = 0;

                Iterator<String> timestampIterator = closeData.keys();
                while (timestampIterator.hasNext()) {
                    String timestamp = timestampIterator.next();
                    long currentTimestamp = Long.parseLong(timestamp);
                    double close = closeData.getDouble(timestamp);

                    if (currentTimestamp > latestTimestamp) {
                        latestTimestamp = currentTimestamp;
                        latestClosePrice = close;
                    }

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return latestClosePrice;
    }

}