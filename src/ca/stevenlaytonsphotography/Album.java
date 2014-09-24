package ca.stevenlaytonsphotography;

import java.util.List;

public class Album {

    private String albumname;  
    private int numphotos;
    private String photofeedurl;
    private List<Photo> photos;
    
    public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public void setPhotofeedurl(String photofeedurl) {
		this.photofeedurl = photofeedurl;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String name) {
		this.albumname = name;
	}
	public int getNumphotos() {
		return numphotos;
	}
	public void setNumphotos(int numphotos) {
		this.numphotos = numphotos;
	}
	public String getPhotofeedurl() {
		return photofeedurl;
	}
	public String toString() {
		return  "pojo: " + albumname + numphotos + photofeedurl;
	}
	
	public String toXml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<Album>");
		
		sb.append("<Albumname>");
		sb.append(this.albumname);
		sb.append("</Albumname>");
		
		sb.append("<Numphotos>");
		sb.append(this.numphotos + "");
		sb.append("</Numphotos>");
		
		sb.append("<Photofeedurl>");
		sb.append(this.photofeedurl);
		sb.append("</Photofeedurl>");
		
		for (Photo p : photos) {
			sb.append(p.toXml());
		}
		
		sb.append("</Album>");
		
		return sb.toString();
		
	}
	
}
