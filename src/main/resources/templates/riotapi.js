const key = "api_key=";
const sp = "%20";
const fetch = require("node-fetch");
const sumName= document.querySelector('input').value;

getMatchList(fetchSumByName(sumName, 'accountId'));

async function getMatchList(accId, champID, queue, endTime, beginTime, endIndex, beginIndex){
    let link = 'https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/' + await accid + "?";
    if(champID != null)
        link+= 'champion=' +champID+'&';
    if(queue != null)
        link+= 'queue=' +queue+'&';
    if(endTime != null)
        link+= 'endTime=' +endTime+'&';
    if(beginTime != null)
        link+= 'beginTime=' +beginTime+'&';
    if(endIndex != null)
        link+= 'endIndex=' +endIndex+'&';
    if(beginIndex != null)
        link+= 'beginIndex=' +beginIndex+'&';
    link += key;

    let response = await fetch(link);
    response = await response.json();
    console.log(response.atches[0].champion);

}


async function fetchSumByName(name, ch){
    while(name.includes(" ")){
        let spaceSpot = name.indexOf(" ");
        name - name.substring(0,spaceSpot) + sp + name.substring(spaceSpot+1);
    }

    const link = 'https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/${name}?${key}'
    const resposne = await fetch(link);

    let data = await resposne.json();

    if(ch == "id"){
        console.log("wrong one reached")
        return data.id;
    } else if(ch == 'puuuid'){
        return data.puuuid;
    }else if(ch = 'name'){
        return data.name;
    }else if(ch == 'profileIconId'){
        return data.profileIconId;
    }else if(ch == 'revisionDate'){
        return data.revisionDate;
    }else if(ch == 'summonerLevel'){
        return data.summonerLevel;
    }else{
        console.log("ch is not valid");
        return null;
    }
}