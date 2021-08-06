package com.example;

import com.example.Helper;
import com.google.gson.Gson;
import match.MatchList;
import match.Matches;
import match.UserMatchData;
import matchStatistics.ParticipantsItem;
import matchStatistics.Response;
import matchStatistics.Stats;
import matchStatistics.ParticipantIdentitiesItem;
import matchStatistics.Player;
import model.MatchResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class matchController {
    final static Gson gson = new Gson();

    @GetMapping("/pie")
    public String showAllMatches(Model model, @RequestParam String name){
        Summoner summoner = new Summoner();
        Helper.getSummoner(summoner, name);

        Ranked ranked = new Ranked();
        Helper.getRanked(ranked, summoner.getId());
        MatchList matchList = new MatchList();
        Helper.getSummonerMatch(matchList, summoner.getAccountId());
        ArrayList<Matches> newmatchlist = matchList.getMatches();
        //List<UserMatchData> listOfMatches = Helper.getMatchResponseDataFromUserName(name);
        model.addAttribute("listOfMatchData",newmatchlist);
        float win = ranked.getWins();
        float loss = ranked.getLosses();
        float winR = win/(win+loss)*100;
        System.out.println("RATIO "+ winR);
        String png = ".png";
        model.addAttribute("names", summoner.getName());
        model.addAttribute("levels", summoner.getSummonerLevel());
        model.addAttribute("tiers", ranked.getTier());
        model.addAttribute("ranks",ranked.getRank());
        model.addAttribute("lps", ranked.getLeaguePoints());
        model.addAttribute("wins", ranked.getWins());
        model.addAttribute("losses", ranked.getLosses());
        model.addAttribute("winstreak",ranked.isHotStreak());
        model.addAttribute("news", ranked.isFreshBlood());
        model.addAttribute("veterans", ranked.isVeteran());
        model.addAttribute("inactives", ranked.isInactive());
        model.addAttribute("pfps", summoner.getProfileIconId());
        model.addAttribute("winratio", winR);
        model.addAttribute("png", png);
        return "result";
    }
    @GetMapping("/pineapples")
    public String showMatch(Model model, @RequestParam String matchId){
        String matchString = Api.getMatchDataByMatchId(matchId);
        Response response = gson.fromJson(matchString, Response.class);
        List<ParticipantsItem> participantsItems = response.getParticipants();
        List<ParticipantIdentitiesItem> participantIdentities = response.getParticipantIdentities();
        List<Player> players = new ArrayList<>();

        List<Stats> stats = new ArrayList<>();
        for (ParticipantIdentitiesItem p: participantIdentities){
            players.add((p.getPlayer()));
        }
        for (ParticipantsItem p: participantsItems
             ) {
            stats.add(p.getStats());
        }
        for (int i = 0; i < stats.size(); i++) {
            Stats stat = stats.get(i);
            stats.get(i).setUserName(players.get(i).getSummonerName());
            stats.get(i).setKDA(Integer.toString(stat.getKills())+ "-" + Integer.toString(stat.getDeaths())+ "-" + Integer.toString(stat.getAssists()));
            stat.setObjectivePlayerScore(stat.getTurretKills()+stat.getInhibitorKills()+stat.getObjectivePlayerScore());
            System.out.println("printing numbers" + stat.getItem5());
        }




        model.addAttribute("stats", stats);

        return "match";
    }

}
