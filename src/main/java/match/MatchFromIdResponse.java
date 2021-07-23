package match;

import java.util.List;

public class MatchFromIdResponse{
	private int startIndex;
	private int totalGames;
	private int endIndex;
	private List<MatchesItem> matches;

	public int getStartIndex(){
		return startIndex;
	}

	public int getTotalGames(){
		return totalGames;
	}

	public int getEndIndex(){
		return endIndex;
	}

	public List<MatchesItem> getMatches(){
		return matches;
	}
}