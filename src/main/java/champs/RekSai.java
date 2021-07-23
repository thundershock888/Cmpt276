package champs;

import java.util.List;

public class RekSai{
	private Image image;
	private Stats stats;
	private String partype;
	private String name;
	private String id;
	private String title;
	private String blurb;
	private String version;
	private String key;
	private Info info;
	private List<String> tags;

	public Image getImage(){
		return image;
	}

	public Stats getStats(){
		return stats;
	}

	public String getPartype(){
		return partype;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBlurb(){
		return blurb;
	}

	public String getVersion(){
		return version;
	}

	public String getKey(){
		return key;
	}

	public Info getInfo(){
		return info;
	}

	public List<String> getTags(){
		return tags;
	}
}