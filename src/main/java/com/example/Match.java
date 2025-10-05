package com.example;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final long timestamp;

    public Match(String homeTeam, String awayTeam, long timestamp) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.timestamp = timestamp;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        this.homeScore = homeTeamScore;
        this.awayScore = awayTeamScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }
    public int getAwayScore() {
        return awayScore;
    }

    public long getTimestamp() {
        return timestamp;
    }
}