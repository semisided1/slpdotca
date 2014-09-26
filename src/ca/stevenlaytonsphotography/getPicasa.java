package ca.stevenlaytonsphotography;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.saxon.s9api.SaxonApiException;

public class getPicasa extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6471705999672948262L;
	
	
	Feedalizer feedalizer = new Feedalizer();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		PrintWriter out = resp.getWriter();
		
		String stevensalbums = "http://picasaweb.google.com/data/feed/api/user/stevenlaytonphotography?kind=album&access=public&fields=entry%28media:group/media:title,gphoto:numphotos,link[@rel=%27http%3A%2F%2Fschemas.google.com%2Fg%2F2005%23feed%27]%28@href%29%29";
		String albumsstyle = "styles/albums.xsl";

		String uf = feedalizer.getuserfeed(stevensalbums);		
		String cf;
		try {
			cf = feedalizer.getcleanfeed(uf,albumsstyle);
		} catch (SaxonApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text");
			out.print(e.toString()); 
			return;
		}
		resp.setContentType("text/html");
		
		List<Album> la = feedalizer.buildAlbums(cf);

		String photofeedstr = null;
		List<Photo> lp = null;

		String photofieldselector = "?fields=entry/summary,entry/content";

		
		
		// build all available albums
		StringBuffer session = new StringBuffer();
		
		session.append("<session>");
		
		session.append("<photofeed>");
		for ( Album ab : la) {
			photofeedstr = feedalizer.getphotofeed(ab.getPhotofeedurl() + photofieldselector );
			lp = feedalizer.buildPhotos(photofeedstr);
			ab.setPhotos(lp);
			session.append(ab.toXml());
		}
		session.append("</photofeed>");
		
		session.append("<datastore>");
		// gae datastore call to get current doc 
		session.append("<albums></albums>");
		session.append("</datastore>");
		
		session.append("<login>");
		// gae get login string or user credentials if logged in
		session.append("session/login/value");
		
		session.append("</login>");
		
		session.append("</session>");
		
		
		// get all allbums in the db
		
		
		
		Feedalizer ff = new Feedalizer();
		try {
			out.println(ff.getcleanfeed(session.toString(),"styles/albumshtml.xsl"));
			out.flush();
			out.close();
		} catch (SaxonApiException e) {
			e.printStackTrace();
			resp.setContentType("text");
			out.print(e.toString()); 
			return;
		}
	}
}
/*



*/