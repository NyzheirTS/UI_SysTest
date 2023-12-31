package com.example.test_uijfx;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


import java.io.IOException;

public class ApiConnection {
    private final OkHttpClient client;

    public ApiConnection() {
        this.client = new OkHttpClient();
    }

    public void getRequestAsync(String url, ResponseHandler responseHandler){ //TMDB API Handler
        Thread networkThread = new Thread(() -> {
            Response response;
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", "")
                    .build();
            try{
                response = client.newCall(request).execute();
                ResponseBody responseBody = response.body();
                assert responseBody != null;
                responseHandler.handleResponse(responseBody.string());

            } catch (IOException e){
                throw new RuntimeException();
            }
        });
        networkThread.start();
    }
    public interface ResponseHandler{
        void handleResponse(String jsonResponse);
    }

}
