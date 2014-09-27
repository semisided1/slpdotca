package ca.stevenlaytonsphotography;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

public class clear extends HttpServlet {
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key catkey = null;
		Entity currentcatalogue = null;
		catkey = KeyFactory.createKey("albums", "xml");
		currentcatalogue = new Entity(catkey);		
		Text newval = new Text("");
		currentcatalogue.setProperty("xml", newval);
		datastore.put(currentcatalogue);
		return;
	}
}
