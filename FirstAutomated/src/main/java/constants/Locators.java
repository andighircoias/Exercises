package constants;

public enum Locators {
	
		
	ID("id"), CSS("css"), CLASS_NAME("className"), XPATH("xpath"), LINK_TEXT("linkText"), NAME("name") ,TAG_NAME("tagName"), UNDIFINED("undifined");
	
	private String type;
	Locators(String type){
		this.type = type;
	}
	public String getType() {
		return type;
	}


	
	

}
