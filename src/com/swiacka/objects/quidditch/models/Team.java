package com.company.objects.quidditch.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";
    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {
        if(house == null || house.isEmpty() || house.isBlank()){
            throw new IllegalArgumentException();
        }
        this.house = house;
        if(keeper == null || keeper.isEmpty() || keeper.isBlank()){
            throw new IllegalArgumentException();
        }
        this.keeper = keeper;
        if(seeker == null || seeker.isEmpty() || seeker.isBlank()){
            throw new IllegalArgumentException();
        }
        this.seeker = seeker;
        if(chasers.length!=3 || Arrays.asList(chasers).contains(null) || Arrays.stream(chasers).anyMatch(String::isBlank)){
            throw new IllegalArgumentException();
        }
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team team) {
        this.house = team.house;
        this.keeper = team.keeper;
        this.seeker = team.seeker;
        this.chasers = team.chasers;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return chasers;
    }

    public void setChasers(String[] chasers) {
        this.chasers = chasers;
    }



    public void checkParam(String param){
        if (param == null || param.isBlank()){
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return house.equals(team.house) && keeper.equals(team.keeper) && seeker.equals(team.seeker) && Arrays.equals(chasers, team.chasers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(house, keeper, seeker, Arrays.toString(this.chasers));
        return result;
    }

    @Override
    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }
}
