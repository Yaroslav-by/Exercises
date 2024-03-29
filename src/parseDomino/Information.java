package parseDomino;

public class Information {

	private String name;
	private String price;
	private String link;
	
	Information(String name, String price, String link) {
		
		this.name = name;
		this.price = price;
		this.link = link;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "\t" + this.getName() + " - " + this.getPrice() + " ���." + " - " + this.getLink() + ";";
	}
	
}
