package com.FootballClient.Client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Repository
public class Client {

    private static String localhost = "http://localhost:8081/";
    private String id;


    public void register(String name, String email, String passwordEncryped) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/register")
                .queryParam("userName", name)
                .queryParam("userMail", email)
                .queryParam("password", passwordEncryped);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
    }

    public String login(String name, String passwordEncryped) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/login")
                .queryParam("id", name)
                .queryParam("password", passwordEncryped);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }

    public List<String> getAllCoches() {
        return new ArrayList<>();
    }

    public List<String> getAllTeams() {
        return new ArrayList<>();
    }


    public static void addCoach(String coachId, String Team) {
    }


    public List<String> getTeams() {
        return new ArrayList<>();
    }

    public void addField(String teamName, String fieldName) {
    }

    public List<String> getFans() {
        return new ArrayList<>();
    }

    public List<String> getManagers() {
        return new ArrayList<>();
    }

    public void addTeamManager(String text, String actionCommand) {
    }

    public void addNewOwner(String text, String actionCommand) {
    }

    public LinkedList<String> getPlayers() {
        return new LinkedList<>();
    }

    public void addPlayer(String text, String actionCommand, int parseInt, int parseInt1, int parseInt2, String text1) {
    }
}
