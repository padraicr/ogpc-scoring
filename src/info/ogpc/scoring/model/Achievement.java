package info.ogpc.scoring.model;

public class Achievement {
	private String name;
	private String description;
	private Integer pointValue;
	
	public Achievement(String _name, int _value, String _description) {
		name = _name;
		pointValue = new Integer(_value);
		description = _description;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPointValue() {
		return pointValue;
	}
	
	public String getDescription() {
		return description;
	}

}
