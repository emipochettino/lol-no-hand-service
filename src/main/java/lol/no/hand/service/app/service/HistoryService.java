package lol.no.hand.service.app.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lol.no.hand.service.app.rito.api.response.history.Game;
import lol.no.hand.service.app.rito.api.response.history.RecentHistory;
import lol.no.hand.service.app.rito.api.response.statistics.history.RecentHistoryStatistics;
import lol.no.hand.service.app.rito.api.response.summoner.Summoner;

@Service
public class HistoryService {

    private static final String CLASSIC_MODE = "CLASSIC";

    @Autowired
    private RitoService ritoService;

    @Autowired
    private SummonerService summonerService;

    public RecentHistory findRecentHistoryBySummonerId(int summonerId) throws IOException {
        return ritoService.findRecentHistory(summonerId);
    }

    public RecentHistory findRecentHistoryBySummonerName(String summonerName) throws IOException {
        final Summoner summoner = summonerService.findSummoner(summonerName);
        return findRecentHistoryBySummonerId(summoner.getId());
    }

    public RecentHistoryStatistics findRecentStatisticsBySummonerId(int summonerId) throws IOException {
        final RecentHistory recentHistory = findRecentHistoryBySummonerId(summonerId);
        return calculateStatistics(recentHistory);
    }

    public RecentHistoryStatistics findRecentStatisticsBySummonerName(String summonerName) throws IOException {
        final Summoner summoner = summonerService.findSummoner(summonerName);
        final RecentHistory recentHistory = findRecentHistoryBySummonerId(summoner.getId());
        final RecentHistoryStatistics statistics = calculateStatistics(recentHistory);
        statistics.setSummonerName(summoner.getName());
        return statistics;
    }

    private RecentHistoryStatistics calculateStatistics(RecentHistory recentHistory) {
        final List<Game> games = recentHistory.getGames().stream().filter(x -> x.getGameMode().equals(CLASSIC_MODE))
                .collect(Collectors.toList());

        final RecentHistoryStatistics statistics = new RecentHistoryStatistics();
        statistics.setSummonerId(recentHistory.getSummonerId());
        statistics.setLastGamePlayedNbr((int) games.size());
        calculateWinRate(games, statistics);

        return statistics;
    }

    private void calculateWinRate(final List<Game> games, final RecentHistoryStatistics statistics) {
        final float winRate = ((float) games.stream().filter(x -> x.getStats().isWin()).count()
                / (float) statistics.getLastGamePlayedNbr()) * 100f;
        statistics.setLastWinRate(winRate);
    }
}
