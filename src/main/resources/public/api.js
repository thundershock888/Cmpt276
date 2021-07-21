/*import { createRequire } from 'module';
const require = createRequire(import.meta.url);
const fetch = require("node-fetch");
const bluebird = require("bluebird");
fetch.promise = bluebird;

async function requestSummonerData(summonerName, key){//helps get summoner info 
    const link = 'https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/' + summonerName+"?api_key="+ key;
    const response = await fetch(link);
    let data = await response.json();
    console.log(data);
    return data;
}

async function requestMatchData(matchID, key){//helps get specific match data
    const link = "https://na1.api.riotgames.com/lol/match/v4/matches/"+ matchID+"?api_key="+key;
    const response = await fetch(link);
    let data = await response.json();
    return data;
}

async function requestMatchListData(accountID, key){//gets list of matches
    const link = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/"+ summonerID+"?api_key="+key;
    const response = await fetch(link);
    let data = await response.json();
    return data;
}

async function requestRankedLeagueData(summonerID, key){//gets data of player rank in competitive
    const link = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/"+ summonerID+"?api_key="+key;
    const response = await fetch(link);
    let data = await response.json();
    return data;
}


function getInfo(){//function is called when summoner name is entered and thus 
    const key = "RGAPI-8f8f2cad-0a08-472e-8a89-d5b7d2a1e63f";//api key
    const sp = "%20";
    const name= document.getElementById('summonerSearch').value;



    while(name.includes(" ")){
        let spaceSpot = name.indexOf(" ");
        name - name.substring(0,spaceSpot) + sp + name.substring(spaceSpot+1);
    }

    let summonerData = requestSummonerData(name, key);
    //different ids corressponding to function values
    let accountID = summonerData.accountId;
    let summonerLevel = summonerData.summonerLevel;
    let summonerID = summonerData.id;

    let matchData = requestRankedLeagueData(summonerID, key);
    let rankTier = matchData.tier;
    let rankDivision = matchData.rank;
    let rankPoint = matchData.leaguePoints;
    let rankWins = matchData.wins;
    let rankLosses = matchData.losses;

    console.log("{ accountId: "+ accountID + " },");
    console.log("{ summonerLevel: "+ summonerLevel + " },");
    console.log("{ summonerID: "+ summonerID + " },");
    console.log("{ rankTier: "+ rankTier + " },");
    console.log("{ rankDivision: "+ rankDivision + " },");
    console.log("{ rankPoint: "+ rankPoint + " },");
    console.log("{ rankWins: "+ rankWins + " },");
    console.log("{ rankLosses: "+ rankLosses + " },");

}*/


function getInfo(){
    //let url = 'https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/ImTeggy?api_key=RGAPI-8f8f2cad-0a08-472e-8a89-d5b7d2a1e63f';
    fetch('https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/ImTeggy?api_key=RGAPI-8f8f2cad-0a08-472e-8a89-d5b7d2a1e63f',{mode: 'no-cors'})
      .then(res => res.json())
      .then(data => console.log(data))
      .catch(error => console.log("error"))
  }