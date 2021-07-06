function httpGet() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", 'https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/DELICIOUSMILKGG?api_key=RGAPI-ae821434-576f-4b93-8643-9cb02a5cb145', true);
    xmlHttp.send();
    document.write(xmlHttp.responseText);
}