package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

abstract class UnfollowGithubUsersApi {


    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final String accessToken = "";
    protected final String username = "";
    protected final String GITHUB_API_BASE_URL = "https://api.github.com";

    public UnfollowGithubUsersApi() {
        httpClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    protected List<Github> sendGetRequest(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "token " + accessToken)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                List<Github> github = objectMapper.readValue(response.body(), new TypeReference<List<Github>>() {
                });
                return github;
            } else {
                throw new RuntimeException("Failed to send GET request: " + response.statusCode());
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            List<Github> s = null;
            return s;
        }
    }

    protected void sendDeleteRequest(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "token " + accessToken)
                    .DELETE()
                    .build();

            HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
            if (response.statusCode() != 204) {
                throw new RuntimeException("Failed to send DELETE request: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    // implementation in inherited class’
    public abstract List<Github> getFollowing();

    public abstract List<Github> getFollowers();

    public abstract void unfollowUsersNotFollowingBack();


}
