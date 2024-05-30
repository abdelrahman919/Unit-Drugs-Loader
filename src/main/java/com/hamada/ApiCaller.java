package com.hamada;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiCaller {

    private final static URI drugUrl;

    static {
        try {
            drugUrl = new URI("http://localhost:8081/drugs");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpResponse<String> callServer() {
        HttpResponse<String> response;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(drugUrl)
                .GET()
                .build();
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }
        return response;
    }

    private static List<Drug> mapJsonToDrug(String jsonString) {
        List<Drug> drugList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            String type = jsonObject.getString("type");
            drugList.add(new Drug(name, type));
        }
        return drugList;
    }

    public static List<Drug> getDrugListFromServer() {
        HttpResponse<String> response = callServer();
        String body = response.body();
        return mapJsonToDrug(body);
    }





}
