package models;

public class Articles {
	private String Title;
	private String Tag;
// private Date = new Date (TODO : chercher comment l'insérer);
	private int ID;
	
	public Articles (String Title, String Tag, int ID) {
		this.Title = Title;
		this.Tag = Tag;
		this.ID = ID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	
}
