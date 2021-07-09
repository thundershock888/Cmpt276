function requestSummonerData(summonerName, key){//helps get summoner info 
    let link = 'https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/' + summonerName+"?api_key="+ key;
    let response = await fetch(link);
    response = await response.json();
    return response;
}

function requestMatchData(matchID, key){//helps get specific match data
    let link = "https://na1.api.riotgames.com/lol/match/v4/matches/"+ matchID+"?api_key="+key;
    let response = await fetch(link);
    response = await response.json();
    return response;
}

function requestMatchListData(accountID, key){//gets list of matches
    let link = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/"+ summonerID+"?api_key="+key;
    let response = await fetch(link);
    response = await response.json();
    return response;
}

function requestRankedLeagueData(summonerID, key){//gets data of player rank in competitive
    let link = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/"+ summonerID+"?api_key="+key;
    let response = await fetch(link);
    response = await response.json();
    return response;
}


function summonerInfo(){//function is called when summoner name is entered and thus 
    const key = "RGAPI-3934ee96-4600-4722-9053-b5626cb4a6fd";//api key
    const sp = "%20";
    const fetch = require("node-fetch");
    const name= document.getElementById('summonerSearch').value;

    while(name.includes(" ")){
        let spaceSpot = name.indexOf(" ");
        name - name.substring(0,spaceSpot) + sp + name.substring(spaceSpot+1);
    }

    const responseJSON = requestSummonerData(name, key);
    //different ids corressponding to function values
    const accountID = responseJSON["accountId"];
    const summonerLevel = responseJSON["summonerLevel"];
    const summonerID = responseJSON["id"];

    const responseJSON2 = requestRankedLeagueData(summonerID, key);
    const rankTier = responseJSON2["tier"];
    const rankDivision = responseJSON2["rank"];
    const rankPoint = responseJSON2["leaguePoints"];
    const rankWins = responseJSON["wins"];
    const rankLosses = responseJSON2["losses"];

    console.log("{ accountId: "+ accountID + " },");
    console.log("{ summonerLevel: "+ summonerLevel + " },");
    console.log("{ summonerID: "+ summonerID + " },");
    console.log("{ rankTier: "+ rankTier + " },");
    console.log("{ rankDivision: "+ rankDivision + " },");
    console.log("{ rankPoint: "+ rankPoint + " },");
    console.log("{ rankWins: "+ rankWins + " },");
    console.log("{ rankLosses: "+ rankLosses + " },");

}