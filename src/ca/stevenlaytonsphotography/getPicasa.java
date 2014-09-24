package ca.stevenlaytonsphotography;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getPicasa extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6471705999672948262L;
	
	
	Feedalizer feedalizer = new Feedalizer();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String stevensalbums = "http://picasaweb.google.com/data/feed/api/user/stevenlaytonphotography?kind=album&access=public&fields=entry%28media:group/media:title,gphoto:numphotos,link[@rel=%27http%3A%2F%2Fschemas.google.com%2Fg%2F2005%23feed%27]%28@href%29%29";
		String albumsstyle = "styles/albums.xsl";

		String uf = feedalizer.getuserfeed(stevensalbums);		
		String cf = feedalizer.getcleanfeed(uf,albumsstyle);

		List<Album> la = feedalizer.buildAlbums(cf);

		String photofeedstr = null;
		List<Photo> lp = null;

		String photofieldselector = "?fields=entry/summary,entry/content";

		StringBuffer aasb = new StringBuffer();
		
		aasb.append("<Albums>");
		
		for ( Album ab : la) {
			photofeedstr = feedalizer.getphotofeed(ab.getPhotofeedurl() + photofieldselector );
			lp = feedalizer.buildPhotos(photofeedstr);
			ab.setPhotos(lp);
			aasb.append(ab.toXml());
		}
		
		aasb.append("</Albums>");
		
		Feedalizer ff = new Feedalizer();
		out.print(ff.getcleanfeed(aasb.toString(),"styles/albumshtml.xsl"));
	}
}
/*



*/