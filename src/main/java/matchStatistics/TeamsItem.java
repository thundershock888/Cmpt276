package matchStatistics;

import java.util.List;

public class TeamsItem{
	private int towerKills;
	private int riftHeraldKills;
	private boolean firstBlood;
	private int inhibitorKills;
	private List<Object> bans;
	private boolean firstBaron;
	private boolean firstDragon;
	private int dominionVictoryScore;
	private int dragonKills;
	private int baronKills;
	private boolean firstInhibitor;
	private boolean firstTower;
	private int vilemawKills;
	private boolean firstRiftHerald;
	private int teamId;
	private String win;

	public int getTowerKills(){
		return towerKills;
	}

	public int getRiftHeraldKills(){
		return riftHeraldKills;
	}

	public boolean isFirstBlood(){
		return firstBlood;
	}

	public int getInhibitorKills(){
		return inhibitorKills;
	}

	public List<Object> getBans(){
		return bans;
	}

	public boolean isFirstBaron(){
		return firstBaron;
	}

	public boolean isFirstDragon(){
		return firstDragon;
	}

	public int getDominionVictoryScore(){
		return dominionVictoryScore;
	}

	public int getDragonKills(){
		return dragonKills;
	}

	public int getBaronKills(){
		return baronKills;
	}

	public boolean isFirstInhibitor(){
		return firstInhibitor;
	}

	public boolean isFirstTower(){
		return firstTower;
	}

	public int getVilemawKills(){
		return vilemawKills;
	}

	public boolean isFirstRiftHerald(){
		return firstRiftHerald;
	}

	public int getTeamId(){
		return teamId;
	}

	public String getWin(){
		return win;
	}
}