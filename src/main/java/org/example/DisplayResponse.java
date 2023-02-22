package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class DisplayResponse {

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
            snippet = snippet.replaceAll("<[^>]*>", ""); // Remove HTML tags
            snippet = snippet.replaceAll("\\s+", " "); // Replace multiple spaces with a single space
            snippet = snippet.replaceAll("&quot;", "\""); // Replace HTML entity for double quote
            snippet = snippet.replaceAll("&amp;", "&"); // Replace HTML entity for ampersand
            snippet = snippet.replaceAll("&lt;", "<"); // Replace HTML entity for less-than
            snippet = snippet.replaceAll("&gt;", ">"); // Replace HTML entity for greater-than

            // Print the result with formatted snippet
            System.out.println("Title: " + title);
            System.out.println("snippet: " + snippet);
            System.out.println();
        }
    }
}
