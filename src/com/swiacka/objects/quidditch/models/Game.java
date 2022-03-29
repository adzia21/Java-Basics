package com.company.objects.quidditch.models;

import java.util.HashMap;

public class Game {
    static int gameCount;

    final static int QUAFFLE_POINTS = 10;
    final static int SNITCH_POINTS = 150;
    HashMap<Team, Integer> scoreboard;

    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();
        scoreboard.put(new Team(home), 0);
        scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public Integer getScore(Team team) {
        return scoreboard.get(new Team(team));
    }

    public void setScore(Team team, Integer score) {
        if(team == null){
            throw new IllegalArgumentException("Cannot add null to the scoreboard.");
        }
        scoreboard.put(new Team(team), score);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream().filter((key) -> key.getHouse().equals(name)).findFirst().orElse(null);
    }

    public String getPlaceholder(String play) {
        play = play.substring(play.indexOf("<") + 1);
        play = play.substring(0, play.indexOf(">"));
        return play;
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        placeholder = "<" + placeholder + ">";
        return play.replaceAll(placeholder, value);
    }

    public void quaffleScore(Team team) {
        int score = getScore(team) + QUAFFLE_POINTS;
        setScore(team, score);
    }

    public void catchSnitch(Team team) {
        int score = getScore(team) + SNITCH_POINTS;
        setScore(team, score);
    }

    public String simulate(String play) {
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        String value = "";
        if(placeholder.equals(Team.getPositionChaser())){
            quaffleScore(team);
            value = team.getChasers()[random(team.getChasers().length)];
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team);
            value = team.getSeeker();
        }else if (placeholder.equals(Team.getPositionKeeper())){
            value = team.getKeeper();
        }else{
            value = "";
        }
        return replacePlaceholder(play, placeholder, value);
    }

    public Team getRandomTeam() {
        Object[] teams = scoreboard.keySet().toArray();
        return (Team) teams[random(teams.length)];
    }

    public int random(int range) {
        return (int) (Math.random() * range);
    }

}
