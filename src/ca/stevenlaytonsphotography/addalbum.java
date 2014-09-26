package ca.stevenlaytonsphotography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONObject;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;




public class addalbum extends HttpServlet {

	private static final long serialVersionUID = -3803653777947724001L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		// extract xml data to append from the ajax post as json
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /*report an error*/ }

		JSONObject jsonObject =   HTTP.toJSONObject(jb.toString());
		System.out.print(jsonObject.toString());

		Iterator<String> itr = jsonObject.keys();
		while(itr.hasNext()) {
			String key = itr.next();
			Object o = jsonObject.get(key);
			System.out.println(key + " : " + o);
		}
		System.out.println();
		String method = jsonObject.getString("Method");
		String jsonvalue = URLDecoder.decode(method,"UTF-8");

		// this is an empty post
		if (jsonvalue.length()<18) return;


		// strip data=<xmp>      
		// strip  .. . .  </xmp>		
		String xmlalbum = jsonvalue.substring(11,jsonvalue.length()-6);

		System.out.println(xmlalbum);
		


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
			
		
		//append the new one
		// write it to the datastore

		// trying to reuse datastore,key and entity but ...
		//DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		//Key catkey = KeyFactory.createKey("catalogue", "html");
		
		Text newval = new Text(xmlalbum + currentdata + "" );
		currentcatalogue.setProperty("xml", newval);
		datastore.put(currentcatalogue);

	}
}
