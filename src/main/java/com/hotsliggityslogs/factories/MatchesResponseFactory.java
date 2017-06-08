package com.hotsliggityslogs.factories;

import com.hotsliggityslogs.models.Match;
import com.hotsliggityslogs.models.responses.MatchesResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchesResponseFactory {
    public MatchesResponse createMatchesResponse(List<Match> matches) {
        MatchesResponse matchesResponse = new MatchesResponse();

        double wins = 0;
        double losses = 0;
        double matchesCount = 0;

        for (Match match : matches) {
            matchesCount++;

            if (match.getMatchOutcome().equals("Win")) {
                wins++;
            } else {
                losses++;
            }
        }

        matchesResponse.setMatches(matches);
        matchesResponse.setWins(wins);
        matchesResponse.setLosses(losses);
        matchesResponse.setMatchesCount(matchesCount);
        matchesResponse.setWinLossRatio(roundToTwoDecimalPlaces(wins/matchesCount));

        return matchesResponse;
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round((value)* 10000.0)/100.0;
    }
}
