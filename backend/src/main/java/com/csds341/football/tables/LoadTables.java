package com.csds341.football.tables;

import com.csds341.football.entities.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadTables {
    private static final Logger logger = LoggerFactory.getLogger(LoadTables.class);

    public LoadTables() {}

    @Bean
    CommandLineRunner initTeamTable(TeamRepository teams, DefenseSTRepository defenseSTRepository, KickerRepository kickerRepository, QuarterbackRepository quarterbackRepository, RunningbackRepository runningbackRepository, WideReceiverRepository wideReceiverRepository, StadiumRepository stadiumRepository) throws IOException, JSONException {
        InputStream inputStream = new ClassPathResource("data.json").getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        String inputString;
        while ((inputString= reader.readLine()) != null)
            builder.append(inputString);
        JSONArray json = new JSONArray(builder.toString());
        logger.info(json.toString());

        return args -> {
            for (int i = 0; i < json.length(); i++) {
                JSONObject team = json.getJSONObject(i);
                List<Quarterback> quarterbacks = new ArrayList<>();
                List<Runningback> runningbacks = new ArrayList<>();
                List<Kicker> kickers = new ArrayList<>();

                List<WideReceiver> wideReceivers = new ArrayList<>();
                Team t = new Team(team.getString("teamName"), team.getString("location"), team.getInt("superbowls"), team.getString("Division"), team.getString("headCoach"), team.getString("manager"), team.getString("owner"), team.getString("record"));

                Stadium stadium = new Stadium(team.getString("stadium"), team.getString("location"), team.getInt("stadiumCapacity"), team.getString("teamName"));
                stadium.setTeam(t);
                stadiumRepository.save(stadium);

                JSONObject defenceObj = team.getJSONObject("defence");
                DefenseST defenseST = new DefenseST(defenceObj.getInt("Interceptions"), defenceObj.getInt("Sacks"), defenceObj.getInt("rshYdsAllowed"), defenceObj.getInt("passYdsAllowed"));
                defenseST.setTeam(t);
                defenseSTRepository.save(defenseST);

                JSONArray quarterbackArray = team.getJSONArray("QuarterBack");
                for (int j = 0; j < quarterbackArray.length(); j++) {
                    JSONObject currQB = quarterbackArray.getJSONObject(j);
                    Quarterback q = new Quarterback(currQB.getString("name"), currQB.getInt("passingYards"), currQB.getInt("rushingYards"), currQB.getInt("completions"), currQB.getInt("tds"));
                    q.setTeam(t);
                    quarterbackRepository.save(q);
                    quarterbacks.add(q);
                }

                JSONArray rbArray = team.getJSONArray("RunningBack");
                for (int j = 0; j < rbArray.length(); j++) {
                    JSONObject currRB = rbArray.getJSONObject(j);
                    Runningback r = new Runningback(currRB.getString("name"), currRB.getInt("recYds"), currRB.getInt("rshYds"), currRB.getInt("catches"), currRB.getInt("tds"), currRB.getInt("fumbles"), currRB.getInt("drops"));
                    r.setTeam(t);
                    runningbackRepository.save(r);
                    runningbacks.add(r);
                }

                JSONArray wrArray = team.getJSONArray("wideReceiver");
                for (int j = 0; j < wrArray.length(); j++) {
                    JSONObject currWR = wrArray.getJSONObject(j);
                    WideReceiver w = new WideReceiver(currWR.getString("name"), currWR.getInt("recYds"), currWR.getInt("catches"), currWR.getInt("tds"), currWR.getInt("fumbles"), currWR.getInt("drops"));
                    w.setTeam(t);
                    wideReceiverRepository.save(w);
                    wideReceivers.add(w);
                }

                JSONArray kArray = team.getJSONArray("Kicker");
                for (int j = 0; j < kArray.length(); j++) {
                    JSONObject currKicker = kArray.getJSONObject(j);
                    Kicker k = new Kicker(currKicker.getString("name"), currKicker.getInt("fgMade"), currKicker.getInt("fgMissed"));
                    k.setTeam(t);
                    kickerRepository.save(k);
                    kickers.add(k);
                }

                t.setDefenseST(defenseST);
                t.setKickers(kickers);
                t.setQuarterbacks(quarterbacks);
                t.setRunningbacks(runningbacks);
                t.setStadium(stadium);
                t.setWideReceivers(wideReceivers);
                teams.save(t);
            }
        };
    }
}
