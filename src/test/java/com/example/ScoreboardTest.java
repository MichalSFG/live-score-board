package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    @Test
    void testScoreboard() {
        System.out.println("testScoreboard");
    }

    @Test
    void testStartAndSummary() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");
        sb.startMatch("Spain", "Brazil");
        List<Match> summary = sb.getSummary();

        assertEquals(2, summary.size());
        assertEquals("Spain", summary.get(0).getHomeTeam());
        assertEquals("Brazil", summary.get(0).getAwayTeam());
    }

    @Test
    void testFinishMatch() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");
        sb.startMatch("Spain", "Brazil");
        sb.finishMatch("Mexico", "Canada");
        sb.finishMatch("Spain", "Brazil");

        assertTrue(sb.getSummary().isEmpty());
    }

    @Test
    void testUpdateScore() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");
        sb.updateScore("Mexico", "Canada", 0, 5);
        Match match = sb.getSummary().get(0);
        assertEquals(0, match.getHomeScore());
        assertEquals(5, match.getAwayScore());
    }

    @Test
    void testSummaryOrder() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");
        sb.updateScore("Mexico", "Canada", 0, 5);
        sb.startMatch("Spain", "Brazil");
        sb.updateScore("Spain", "Brazil", 10, 2);
        sb.startMatch("Germany", "France");
        sb.updateScore("Germany", "France", 2, 2);
        sb.startMatch("Uruguay", "Italy");
        sb.updateScore("Uruguay", "Italy", 6, 6);
        sb.startMatch("Argentina", "Australia");
        sb.updateScore("Argentina", "Australia", 3, 1);
        List<Match> summary = sb.getSummary();
        assertEquals("Uruguay", sb.getSummary().get(0).getHomeTeam());
        assertEquals("Italy", sb.getSummary().get(0).getAwayTeam());
        assertEquals(6, sb.getSummary().get(0).getHomeScore());
    }

}