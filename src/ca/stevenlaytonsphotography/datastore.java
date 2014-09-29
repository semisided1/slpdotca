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

public class datastore extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6471705999672948262L;


	Feedalizer feedalizer = new Feedalizer();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/plain");
		// build all available albums
		StringBuffer session = new StringBuffer();
		session.append("<session>");
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
		session.append("</albums>");
		session.append("</datastore>");
		
		session.append("</session>");
		
		PrintWriter out = resp.getWriter();

		out.println(session.toString());
		out.flush();
		out.close();
	}

}

/*



 */