package matchStatistics;

public class Timeline{
	private int participantId;
	private CsDiffPerMinDeltas csDiffPerMinDeltas;
	private DamageTakenPerMinDeltas damageTakenPerMinDeltas;
	private String role;
	private DamageTakenDiffPerMinDeltas damageTakenDiffPerMinDeltas;
	private XpPerMinDeltas xpPerMinDeltas;
	private XpDiffPerMinDeltas xpDiffPerMinDeltas;
	private String lane;
	private CreepsPerMinDeltas creepsPerMinDeltas;
	private GoldPerMinDeltas goldPerMinDeltas;

	public int getParticipantId(){
		return participantId;
	}

	public CsDiffPerMinDeltas getCsDiffPerMinDeltas(){
		return csDiffPerMinDeltas;
	}

	public DamageTakenPerMinDeltas getDamageTakenPerMinDeltas(){
		return damageTakenPerMinDeltas;
	}

	public String getRole(){
		return role;
	}

	public DamageTakenDiffPerMinDeltas getDamageTakenDiffPerMinDeltas(){
		return damageTakenDiffPerMinDeltas;
	}

	public XpPerMinDeltas getXpPerMinDeltas(){
		return xpPerMinDeltas;
	}

	public XpDiffPerMinDeltas getXpDiffPerMinDeltas(){
		return xpDiffPerMinDeltas;
	}

	public String getLane(){
		return lane;
	}

	public CreepsPerMinDeltas getCreepsPerMinDeltas(){
		return creepsPerMinDeltas;
	}

	public GoldPerMinDeltas getGoldPerMinDeltas(){
		return goldPerMinDeltas;
	}
}
