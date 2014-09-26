package ca.stevenlaytonsphotography;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

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
		if (uf==null) {
			resp.setContentType("text");
			out.print("try again"); 
			return;
		}

		if (uf.length()<10) {
			resp.setContentType("text");
			out.print("try again"); 
			return;
		}

		String cf;
		try {
			cf = feedalizer.getcleanfeed(uf,albumsstyle);
			if (cf==null) {
				resp.setContentType("text");
				out.print("try again"); 
				return;
			}
		} catch (SaxonApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text");
			out.print(e.toString()); 
			return;
		}


		List<Album> la = feedalizer.buildAlbums(cf);
		if (la == null) {
			resp.setContentType("text");
			out.print("try again"); 
			return;
		}
		String photofeedstr = null;
		List<Photo> lp = null;

		String photofieldselector = "?fields=entry/summary,entry/content";


		resp.setContentType("text/html");
		// build all available albums
		StringBuffer session = new StringBuffer();

		session.append("<session>");

		session.append("<photofeed>");
		for ( Album ab : la) {
			photofeedstr = feedalizer.getphotofeed(ab.getPhotofeedurl() + photofieldselector );
			lp = feedalizer.buildPhotos(photofeedstr);
			if (lp!=null) { 
				ab.setPhotos(lp);
				session.append(ab.toXml());
			}
		}
		session.append("</photofeed>");

		session.append("<datastore>");
		// gae datastore call to get current doc 
		session.append("<albums>");




		// get current data from gae datastore
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key catkey = null;
		Entity currentcatalogue = null;
		Text text = null;
		String currentdata = null;
		boolean useemptystring = false;

		catkey = KeyFactory.createKey("albums", "xml");
		try {
			currentcatalogue = datastore.get(catkey);
		} catch (EntityNotFoundException e) {
			// createit
			currentcatalogue = new Entity(catkey);
			useemptystring = true;
		}

		if (true==useemptystring ) {
			currentdata = "";
		} else {
			Object o = currentcatalogue.getProperty("xml"); 
			if (o instanceof String) {
				currentdata = (String) o;
			} else {
				Text t = (Text)o;
				currentdata = t.getValue();
			}
		}
		session.append(currentdata);
		System.out.println("currentdata: " + currentdata);
		session.append("</albums>");
		session.append("</datastore>");

		session.append("<login>");
		// gae get login string or user credentials if logged in
		///session.append("session/login/value");

		session.append("</login>");

		session.append("</session>");


		

		Feedalizer ff = new Feedalizer();
		String sstr = null; 
		sstr = session.toString();
		

		String page = null;
		try {
			page = ff.getcleanfeed(sstr,"styles/albumshtml.xsl");
		} catch (SaxonApiException e) {
			out.println(sstr);
		}
		out.println(page);
		out.flush();
		out.close();
	}

}

/*



 */