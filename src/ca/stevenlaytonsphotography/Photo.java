package ca.stevenlaytonsphotography;


public class Photo {
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public String getFolderPart() {
		int i;
		String f;
		String photourl = this.getPurl();
		i = photourl.lastIndexOf('/');
		f = photourl.substring(0,i);
		return f;
	}
	
	public String getFilePart() {
		int i;
		String g;
		String photourl = this.getPurl();
		i = photourl.lastIndexOf('/');
		g = photourl.substring(i);
		return g;
	}
	
	public String toXml() {
		return "<Photo>" + 
				"<Folder>" + getFolderPart() + "</Folder>" +
				"<File>" + getFilePart() + "</File>" +
				"<Caption>" + caption +
				"</Caption></Photo>";
	}
	
	private String caption;
	private String purl;
	private String filename;
}


