package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam, System.nanoTime()));
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.setScore(homeScore, awayScore);
                break;
            }
        }
    }

    public List<Match> getSummary() {
        List<Match> sorted = new ArrayList<>(matches);
        sorted.sort(Comparator.comparingInt(Match::getTotalScore).reversed()
                .thenComparing(Match::getTimestamp, Comparator.reverseOrder()));
        return sorted;
    }
}