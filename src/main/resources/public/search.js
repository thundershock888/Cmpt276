//https://www.youtube.com/watch?v=_bj6DKiaH6A&t=438s adapted from here...
const riotKey = 'api_key = RGAPI-543bfabd-096d-4e47-bdc8-4867f718c9c3'
const sp = '%20';
const fetch = require ("node-fetch");

getMatchList(fetchSumByNAme('DELICIOUSMILKGG', 'accountId'));

async function getMatchList(accID,champID,queue,endTime,beginTime,endIndex,beginIndex){

    let link = 'https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/' + await accID + '?';
    if (champID != null)
        link += 'champion='+champID+'&';
    if (queue != null)
        link += 'queue='+queue+'&';
    if (endTime != null)
        link += 'endTime='+endTime+'&';
    if (beginTime != null)
        link += 'beginTime='+beginTime+'&';
    if (endIndex != null)
        link += 'endIndex='+endIndex+'&';
    if (beginIndex != null)
        link += 'beginIndex='+beginIndex+'&';
    link += riotKey;
    //grab info from link
    let response =  await fetch(link);
    response = await response.json()
    console.log(response.matches[0].champion)
}


async function fetchSumByNAme(name,ch){
    //turns name into link format
    while(name.includes(" ")) {
        let spaceSpot = name.indexOf(" ");
        name = name.substring(0,spaceSpot) + sp + name.substring(spaceSpot + 1);
    }
    //request to riots api
    const link = `https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/${name}?${riotKey}`
    const response = await fetch (link);
    //turns the return value to json
    let data = await response.json();

    if (ch == 'id'){
        console.log('wrong one reached')
        return data.id;
    } else if(ch == 'accountID') {
        return data.accountID;

    }else if (ch == 'name'){
        return data.name;

    }else if (ch == 'revisionDate') {
        return data.revisionDate;
    }else if (ch == 'summonerLevel'){
        return data.summonerLevel;
    }else {
        console.log('ch is not valid');
        return null;
    }
}

var a = 0;
function greet (){
    console.log("hello"+a);
    a++;
}