package com.company.objects.quidditch.tests;

import com.company.objects.quidditch.models.Game;
import com.company.objects.quidditch.models.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    static Game game;

    @Before
    public void setup() {
        Team team = new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[]{"Angelina", "Ginny", "Katie"});
        Team team2 = new Team("SLYTHERIN", "Vincent", "Draco",
                new String[]{"Bridget", "Harper", "Malcolm"});

        game = new Game(team, team2);
    }

    @Test
    public void getPlaceholder(){
        Assertions.assertEquals("chaser", game.getPlaceholder("<chaser> gets the next pass"));
    }

    @Test
    public void replacePlaceholder(){
        Assertions.assertEquals("Katie gets the next pass", game.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie"));
    }

    @Test
    public void quaffleScore(){
        Team team = game.getTeam("GRYFFINDOR");
        game.quaffleScore(team);
        game.quaffleScore(team);
        Assertions.assertEquals(20, game.getScore(team));
    }

    @Test
    public void catchSnitch(){
        Team team = game.getTeam("SLYTHERIN");
        game.catchSnitch(team);
        Assertions.assertEquals(150, game.getScore(team));
    }
}
