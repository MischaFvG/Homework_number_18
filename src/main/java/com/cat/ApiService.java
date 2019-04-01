package com.cat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jetbrains.annotations.NotNull;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiService {
    private static ApiService apiService;

    private ApiService() {
    }

    public static ApiService getApiService() {
        if (apiService == null) {
            apiService = new ApiService();
        }
        return apiService;
    }

    public List<Object> getAll(@NotNull String address) throws IOException {
        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Object>>() {
        }.getType();
        List<Object> objectsList = gson.fromJson(response.toString(), listType);
        return objectsList;
    }

    public List<Object> getAll(@NotNull String address, @NotNull Integer number) throws IOException {
        URL url = new URL(address + number);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Object>>() {
        }.getType();
        List<Object> objectsList = gson.fromJson(response.toString(), listType);
        return objectsList;
    }

    public Object getClassById(@NotNull String address, @NotNull Integer id) throws IOException {
        URL url = new URL(address + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();
        Gson gson = new Gson();
        Object object = gson.fromJson(response.toString(), Object.class);
        return object;
    }

    public void postPosts(@NotNull String address) throws IOException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(address);
        List<Object> objectList = getAll(address);
        StringEntity stringEntity = new StringEntity(gson.toJson(objectList));
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Object-type", "object/json");
        HttpResponse httpResponse = httpClient.execute(httpPost);
    }

    public void putPosts(@NotNull String address, @NotNull Integer number) throws IOException {
        URL url = new URL(address + number);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        Object object = getClassById(address, number);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
        outputStreamWriter.write(String.valueOf(object));
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    public void deletePostById(@NotNull String address, @NotNull Integer number) throws IOException {
        URL url = new URL(address + number);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty(
                "Content-Type", "application/json");
        httpURLConnection.setRequestMethod("DELETE");
        httpURLConnection.connect();
    }
}
