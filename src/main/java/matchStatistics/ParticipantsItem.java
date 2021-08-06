package matchStatistics;

public class ParticipantsItem{
	private int participantId;
	private int championId;
	private Stats stats;
	private int teamId;
	private Timeline timeline;
	private int spell1Id;
	private int spell2Id;

	public int getParticipantId(){
		return participantId;
	}

	public int getChampionId(){
		return championId;
	}

	public Stats getStats(){
		return stats;
	}

	public int getTeamId(){
		return teamId;
	}

	public Timeline getTimeline(){
		return timeline;
	}

	public int getSpell1Id(){
		return spell1Id;
	}

	public int getSpell2Id(){
		return spell2Id;
	}
}
