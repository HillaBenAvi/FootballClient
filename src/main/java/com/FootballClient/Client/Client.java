package com.FootballClient.Client;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Repository
public class Client {

    private static String localhost = "http://225.225.225.225:8081/";
    private String id = "";


    /*************************Authentication**************************/

    public void register(String name, String email, String passwordEncryped) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/register")
                .queryParam("userName", name)
                .queryParam("userMail", email)
                .queryParam("password", passwordEncryped);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
    }

    public String login(String mail, String passwordEncryped) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/login")
                .queryParam("id", mail)
                .queryParam("password", passwordEncryped);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        this.id = mail;
        return response.getBody();
    }


    public void logout (){
        //todo
    }

    /********************************general getters*****************************/
    //get all the teams in the system
    public List<String> getAllTeams() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("team1");
        list.add("team2");
        list.add("team3");
        list.add("team4");
        list.add("team5");
        return list;

//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getAllTeams")
//                .queryParam("id", this.id);
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
    }

    public List<String> getFans() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("fan1");
        list.add("fan2");
        list.add("fan3");
        list.add("fan4");
        list.add("fan5");
        return list;

//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getAllFans")
//                .queryParam("id", this.id);
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
    }

    //get all the names of the teams of specific owner
    public List<String> getTeamsByOwner() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("team1");
        list.add("team2");
        list.add("team3");
        list.add("team4");
        list.add("team5");
        return list;

        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamsOfOwner")
//                .queryParam("id", this.id);
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
    }


    /***************************team getters***************************/

    public List<String> getTeamManagers(String team) {
        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamManagers")
//                .queryParam("id", "idValue")
//                .queryParam("teamName", "teamValue");
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
        return new ArrayList<String>();
    }

    public List<String> getTeamOwners(String team) {

        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamOwners")
//                .queryParam("id", id)
//                .queryParam("teamName", team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
        return new ArrayList<String>();
    }

    public List<String> getTeamCoaches(String team) {
        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamCoaches")
//                .queryParam("id", id)
//                .queryParam("teamName", team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
        return new ArrayList<String>();
    }

    public List<String> getTeamPlayers(String team) {
        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamPlayers")
//                .queryParam("id", id)
//                .queryParam("teamName", team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;

        ArrayList<String> list = new ArrayList<String>();
        list.add("teamplayer1");
        list.add("teamplayer2");
        list.add("teamplayer3");
        return list;
    }

    public List<String> getTeamFields(String team) {
        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamFields")
//                .queryParam("id", id)
//                .queryParam("teamName", team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
        return new ArrayList<String>();
    }


    /********************************get team potentials***************************/

    public List<String> getPotentialCoaches(String team) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("coach1");
        list.add("coach2");
        list.add("coach3");
        list.add("coach4");
        list.add("coach5");
        return list;
        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialCoaches")
//                .queryParam("id", id)
//                .queryParam("teamName",team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
    }

    public List<String> getPotentialManagers(String team) {

        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialManagers")
//                .queryParam("id", id)
//                .queryParam("teamName", team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;

        ArrayList<String> list = new ArrayList<String>();
        list.add("manager1");
        list.add("manager2");
        list.add("manager3");
        list.add("manager4");
        list.add("manager5");
        return list;
    }

    public List<String> getPotentialPlayers(String team) {
        //        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialPlayers")
//                .queryParam("id", id)
//                .queryParam("teamName", team);
//
//
//        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);
//
//        return ans;
        ArrayList<String> list = new ArrayList<String>();
        list.add("player1");
        list.add("player2");
        list.add("player3");
        list.add("player4");
        list.add("player5");
        return list;
    }


    /*************************add to team*************************/

    public void addTeamCoach(String team, String coachId) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addCoachToTeam")
                .queryParam("id", this.id)
                .queryParam("mailId", coachId)
                .queryParam("teamName", team);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
    }


    public void addTeamField(String team, String fieldName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/register")
                .queryParam("id", this.id)
                .queryParam("fieldName", fieldName)
                .queryParam("teamName", team);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
    }



    public void addTeamManager(String team, String managerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addManagerToTeam")
                .queryParam("id", this.id)
                .queryParam("managerId", managerId)
                .queryParam("teamName", team);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

    }

    public void addTeamPlayer(String team, String managerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addPlayerToTeam")
                .queryParam("id", this.id)
                .queryParam("playerId", managerId)
                .queryParam("teamName", team);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

    }


    /*************************remove from team***********************/

    public void removeTeamManager(String team, String managerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/removeTeamManager")
                .queryParam("id", this.id)
                .queryParam("teamName", team)
                .queryParam("mailId", managerId);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

    }

    public void removeTeamCoach(String team, String coachId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/removeTeamCoach")
                .queryParam("id", this.id)
                .queryParam("teamName", team)
                .queryParam("mailId", coachId);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

    }

    public void removeTeamPlayer(String team, String playerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/removeTeamPlayer")
                .queryParam("id", this.id)
                .queryParam("teamName", team)
                .queryParam("mailId", playerId);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
    }

    public void removeTeamField(String team, String fieldName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/removeTeamField")
                .queryParam("id", this.id)
                .queryParam("teamName", team)
                .queryParam("fieldName", fieldName);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);
    }


    /****************************System Manager************************************/
    public void closeTeam(String team) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/closeTeam")
                    .queryParam("id", this.id)
                    .queryParam("teamName", team);

            HttpEntity<?> entity = new HttpEntity<String>(headers);

            HttpEntity<String> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.POST,
                    entity,
                    String.class);

    }



    /*********************************tests****************************/
    public void paramTest() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/paramsTest")
                .queryParam("id", "idValue")
                .queryParam("teamName", "teamValue");


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        System.out.println();
    }



    public void test() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HashMap<String, String> ans = restTemplate.getForObject(localhost+"service/test", HashMap.class);

        System.out.println();
    }


    public void createTeam(String teamName, String ownerId) {
    }


}
