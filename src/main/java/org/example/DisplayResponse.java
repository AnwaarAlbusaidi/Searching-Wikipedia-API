package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

public class DisplayResponse {
    /**
     Display search results for a given Wikipedia topic
     @param responseBody the JSON response from the Wikipedia API
     */
    public void display(String responseBody) {
        // Parse the JSON response to extract search results
        JSONObject json = new JSONObject(responseBody);
        JSONArray results = json.getJSONObject("query").getJSONArray("search");

        // Print the top 3 search results with snippets
        for (int i = 0; i < Math.min(3, results.length()); i++) {
            JSONObject result = results.getJSONObject(i);
            String title = result.getString("title");
            String snippet = result.getString("snippet");

            // Format the snippet for easy reading
            snippet = Jsoup.parse(snippet).text();

            // Print the result with formatted snippet
            System.out.println("Title: " + title);
            System.out.println("snippet: " + snippet);
            System.out.println();
        }
    }
}
