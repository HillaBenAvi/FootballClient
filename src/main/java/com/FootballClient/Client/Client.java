package com.FootballClient.Client;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Repository
public class Client {

    private static String localhost = "http://132.72.65.124:8083/";
    private String id = "";
    private static Client instance = new Client();

    public static Client getInstance(){
        return instance;
    }
    private Client(){

    }

    /*************************Authentication**************************/

    public String register(String name, String email, String passwordEncryped) {

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

        return response.getBody();
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
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("team1");
//        list.add("team2");
//        list.add("team3");
//        list.add("team4");
//        list.add("team5");
//        return list;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getAllTeams")
                .queryParam("id", this.id);

        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }

    public List<String> getFans() {
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("fan1");
//        list.add("fan2");
//        list.add("fan3");
//        list.add("fan4");
//        list.add("fan5");
//        return list;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getAllFans")
                .queryParam("id", this.id);

        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }

    //get all the names of the teams of specific owner
    public List<String> getTeamsByOwner() {
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("team1");
//        list.add("team2");
//        list.add("team3");
//        list.add("team4");
//        list.add("team5");
//        return list;

                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamsOfOwner")
                .queryParam("id", this.id);

        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }


    /***************************team getters***************************/

    public List<String> getTeamManagers(String team) {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamManagers")
                .queryParam("id", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

//       ArrayList<String> list =new ArrayList<String>();
//       list.add("manager1");
//       list.add("manager2");
//
//        return list;
    }

    public List<String> getTeamOwners(String team) {

                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamOwners")
                .queryParam("id", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }

    public List<String> getTeamCoaches(String team) {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamCoaches")
                .queryParam("id", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }

    public List<String> getTeamPlayers(String team) {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamPlayers")
                .queryParam("id", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

//        ArrayList<String> list = new ArrayList<String>();
//        list.add("teamplayer1");
//        list.add("teamplayer2");
//        list.add("teamplayer3");
//        return list;
    }

    public List<String> getTeamFields(String team) {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getTeamFields")
                .queryParam("id", id)
                .queryParam("teamName", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

    }


    /********************************get team potentials***************************/

    public List<String> getPotentialCoaches(String team) {

                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialCoaches")
                .queryParam("id", id)
                .queryParam("teamName",team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }

    public List<String> getPotentialManagers(String team) {

                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialManagers")
                .queryParam("id", id)
                .queryParam("teamName", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

//        ArrayList<String> list =new ArrayList<String>();
//        list.add("manager1");
//        list.add("manager2");

//        return list;


    }

    public List<String> getPotentialPlayers(String team) {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialPlayers")
                .queryParam("id", id)
                .queryParam("teamName", team);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("player1");
//        list.add("player2");
//        list.add("player3");
//        list.add("player4");
//        list.add("player5");
//        return list;
    }


    /*************************add to team*************************/

    public String addTeamCoach(String team, String coachId) {

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

        return response.getBody();
    }


    public String addTeamField(String team, String fieldName) {
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

        return response.getBody();
    }



    public String addTeamManager(String team, String managerId) {
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

        return response.getBody();
    }

    public String addTeamPlayer(String team, String managerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addPlayerToTeam")
                .queryParam("id", this.id)
                .queryParam("teamName", team)
                .queryParam("mailId", managerId)
                .queryParam("year", "2020")
                .queryParam("month", "5")
                .queryParam("day", "31")
                .queryParam("roleInPlayers", "player")
                ;
        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }


    /*************************remove from team***********************/

    public String removeTeamManager(String team, String managerId) {
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

        return response.getBody();
    }

    public String removeTeamCoach(String team, String coachId) {
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

        return response.getBody();
    }

    public String removeTeamPlayer(String team, String playerId) {
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

        return response.getBody();
    }

    public String removeTeamField(String team, String fieldName) {
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

        return response.getBody();
    }


    /****************************System Manager************************************/
    public String closeTeam(String team) {
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

            return response.getBody();
    }


    public ArrayList<String> getLeaguesInSeasons() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getLeagueInSeasonsIds");

        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }

    public ArrayList<String> getPotentialOwners() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getPotentialOwners");

        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;
    }


    public String schedulingGames(String leagueInSeason) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/schedulingGames")
                .queryParam("id", this.id)
                .queryParam("leagueId:seasonId", leagueInSeason);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }

    /***************************referee**********************************/

    public String updateGameEvents(String gameId,String description, String gameMinute,
                                 String eventType, String playerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/updateGameEvents")
                .queryParam("gameId", gameId)
                .queryParam("refereeId", this.id)
                .queryParam("year", "2020")
                .queryParam("month", "5")
                .queryParam("day", "27")
                .queryParam("description", description)
                .queryParam("gameMinute", gameMinute)
                .queryParam("eventEnum", eventType)
                .queryParam("playersId", playerId);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }


    public ArrayList<String> getRefereeGames() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getRefereeGames")
                .queryParam("id", id);

        HashSet<String> ans = restTemplate.getForObject(builder.toUriString(), HashSet.class);

        ArrayList<String> gamesList = new ArrayList<String>();
        gamesList.addAll(ans);
//
//        ArrayList<String> gamesList = new ArrayList<String>();
        return gamesList;
    }


    public ArrayList<String> getGamePlayers(String gameId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        String id = "";
        for(int i = 0 ; i<gameId.length() ; i++){
            if(gameId.charAt(i)!=' '){
                id+=gameId.charAt(i);
            }
            else{
                id+='-';
            }
        }
        //gameId.replace(' ','-');
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getGamePlayers")
                .queryParam("id", id);

        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

    }


    public String addNotifyGameFinalReport(String gameId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addNotifyGameFinalReport")
                .queryParam("userMail", this.id)
                .queryParam("gameId", gameId);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }
    /************************Association Delegate**************************/

    public ArrayList<String> getAllLeagues() {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getAllLeagues")
                .queryParam("id", id);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

    }

    public ArrayList<String> getAllSchedulingPolicies() {
                RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/getAllSchedulingPolicies")
                .queryParam("id", id);


        ArrayList<String> ans = restTemplate.getForObject(builder.toUriString(), ArrayList.class);

        return ans;

    }

    public String setLeagueByYear(String seasonId,String leagueId, String sWinning,
                                 String sDraw, String sLosing, String schedulingPolicyName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/setLeagueByYear")
                .queryParam("id", this.id)
                .queryParam("seasonId", seasonId)
                .queryParam("leagueId", leagueId)
                .queryParam("sWinning", sWinning)
                .queryParam("sDraw", sDraw)
                .queryParam("sLosing", sLosing)
                .queryParam("schedulingPolicyName", schedulingPolicyName);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }

     /*******************************Fan**********************************/

     public String addNotifyFollowEventGame() {
         RestTemplate restTemplate = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

         UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addNotifyFollowEventGame")
                 .queryParam("userMail", this.id);

         HttpEntity<?> entity = new HttpEntity<String>(headers);

         HttpEntity<String> response = restTemplate.exchange(
                 builder.toUriString(),
                 HttpMethod.POST,
                 entity,
                 String.class);

         return response.getBody();
     }

    public String addNotifyAddAssetToTeam() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addNotifyAddAssetToTeam")
                .queryParam("userMail", this.id);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
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


    public String createTeam(String teamName, String ownerId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        if(ownerId.charAt(ownerId.length()-1)==' ')
            ownerId = ownerId.substring(0,ownerId.length()-1);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"service/addNewTeam")
                .queryParam("id", this.id)
                .queryParam("teamName", teamName)
                .queryParam("ownerId", ownerId);

        HttpEntity<?> entity = new HttpEntity<String>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }



}
