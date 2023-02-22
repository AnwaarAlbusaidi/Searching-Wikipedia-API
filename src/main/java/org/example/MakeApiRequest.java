package org.example;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MakeApiRequest {

    public String makeWikipediaApiRequest(String topic) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://en.wikipedia.org/w/api.php").newBuilder();
        urlBuilder.addQueryParameter("action", "query");
        urlBuilder.addQueryParameter("format", "json");
        urlBuilder.addQueryParameter("list", "search");
        urlBuilder.addQueryParameter("srsearch", topic);
        urlBuilder.addQueryParameter("utf8", "1");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();

            return responseBody;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
