package champs;

import java.awt.*;
import java.util.List;

public class SpellsItem{
	private String cooldownBurn;
	private Image image;
	private List<Integer> cost;
	private Datavalues datavalues;
	private String maxammo;
	private Leveltip leveltip;
	private String resource;
	private String rangeBurn;
	private String tooltip;
	private String description;
	private List<Integer> range;
	private int maxrank;
	private List<Object> effect;
	private String costType;
	private String name;
	private List<Integer> cooldown;
	private String id;
	private String costBurn;
	private List<Object> vars;
	private List<Object> effectBurn;

	public String getCooldownBurn(){
		return cooldownBurn;
	}

	public Image getImage(){
		return image;
	}

	public List<Integer> getCost(){
		return cost;
	}

	public Datavalues getDatavalues(){
		return datavalues;
	}

	public String getMaxammo(){
		return maxammo;
	}

	public Leveltip getLeveltip(){
		return leveltip;
	}

	public String getResource(){
		return resource;
	}

	public String getRangeBurn(){
		return rangeBurn;
	}

	public String getTooltip(){
		return tooltip;
	}

	public String getDescription(){
		return description;
	}

	public List<Integer> getRange(){
		return range;
	}

	public int getMaxrank(){
		return maxrank;
	}

	public List<Object> getEffect(){
		return effect;
	}

	public String getCostType(){
		return costType;
	}

	public String getName(){
		return name;
	}

	public List<Integer> getCooldown(){
		return cooldown;
	}

	public String getId(){
		return id;
	}

	public String getCostBurn(){
		return costBurn;
	}

	public List<Object> getVars(){
		return vars;
	}

	public List<Object> getEffectBurn(){
		return effectBurn;
	}
}