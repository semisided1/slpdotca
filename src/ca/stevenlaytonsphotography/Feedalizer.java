package ca.stevenlaytonsphotography;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.Axis;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.WhitespaceStrippingPolicy;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmNodeKind;
import net.sf.saxon.s9api.XdmSequenceIterator;
import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;

import javax.xml.transform.stream.StreamSource;


public class Feedalizer {

	public String getuserfeed( String urlString) {
		URL feedUrl = null;
		try {
			feedUrl = new URL(urlString);
		} catch (MalformedURLException e) {
			//e.printStackTrace();
			return null;
		}
		HttpURLConnection yc = null;
		try {
			yc = (HttpURLConnection) feedUrl.openConnection();

			yc.setConnectTimeout(15 * 1000);
			yc.setRequestMethod("GET");
			yc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			yc.connect();


		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(
					new InputStreamReader(
							yc.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String inputLine;
		String ai;
		StringBuffer result = new StringBuffer();
		try {
			while (true) {
				if (in == null) break;  // throw new IOException("try again");
				inputLine = in.readLine();
				if (inputLine==null) break;
				ai = inputLine;
				result.append(ai);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (in != null) {
				in.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		String a = result.toString();
		String b = a.replaceAll("&nbsp;"," ");
		String c = a;
		
		
		return b;
	}


	// change the g+ xml to something simpler using xsl style

	// this step is completely unnecessary
	// buildAlbums using the Feed instead (its not that messy )


	// will support 1 param for now but may need a param list class
	public String getcleanfeed(String feed, String style) throws SaxonApiException {

		Processor proc = new Processor(false);
		XsltCompiler comp = proc.newXsltCompiler();

		// get xslt executor from local file using compiler
		XsltExecutable exp = null;

		try {
			exp = comp.compile(new StreamSource(new File(style)));
		} catch (SaxonApiException e) {
			//e.printStackTrace();
			//throw e;
			return null;
		}

		// get xdmnode document with using processor and feed(string)
		// XdmNode source = null;
		XdmNode source = null;
		DocumentBuilder docbuilder = null;
		
		

		byte[] ba = feed.getBytes(StandardCharsets.UTF_8);

		if ( ba.length < 5 ) {
			//not valid xml surely just put the 5 in there if was a few newlines or something crazy
			return null;
		}

		ByteArrayInputStream bais = new ByteArrayInputStream(ba);
		javax.xml.transform.stream.StreamSource ss = new StreamSource(bais);


ss.setSystemId("xml");
		docbuilder = proc.newDocumentBuilder();
	
		docbuilder.setDTDValidation(false);
		docbuilder.setWhitespaceStrippingPolicy(WhitespaceStrippingPolicy.ALL);
//docbuilder.setentityresolver("xml");
		source = docbuilder.build(ss);




		// set up output stream
		ByteArrayOutputStream stringwriter = new ByteArrayOutputStream();
		Serializer out = new Serializer();
		out.setOutputStream(stringwriter);

		// transform using executor and source xdmnode
		XsltTransformer trans = exp.load();
		trans.setInitialContextNode(source);
		trans.setDestination(out);
		try {
			/*
			QName name = new QName("session");
			XdmValue value = new XdmValue(new XdmAtomicValue(sessionXml));	
			trans.setParameter(name, value);
			 */
			trans.transform();
		} catch (SaxonApiException e) {
			e.printStackTrace();
		}
		return stringwriter.toString();
	}




	public String getphotofeed(String photofeedurl) {

		return getuserfeed(photofeedurl);
	}

	private XdmNode buildResultXdmNode(String feedstr) {
		XdmNode res = null;
		Processor proc = new Processor(false);
		try {

			byte[] ba = feedstr.getBytes(StandardCharsets.UTF_8);
			if ( ba.length < 5 ) {
				//not valid xml surely just put the 5 in there if was a few newlines or something crazy
				return null;
			}
			ByteArrayInputStream bais = new ByteArrayInputStream(ba);
			javax.xml.transform.stream.StreamSource ss = new StreamSource(bais);

			res = proc.newDocumentBuilder().build(ss);

		} catch (SaxonApiException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<Album> buildAlbums(String feedstr) {
		//	XdmSequenceIterator 	axisIterator(Axis axis)

		List<Album> la =  new ArrayList<Album>();
		XdmNode result = null;
		Album aaa = null;

		result = buildResultXdmNode(feedstr);
		if ( result == null ) {
			return null;
		}
		XdmSequenceIterator iter = result.axisIterator(Axis.DESCENDANT);

		String nodename = null;

		while (iter.hasNext()) {
			XdmNode child = (XdmNode) iter.next();

			if (child==null) {
				return la;
			}

			QName gnqn = child.getNodeName();
			if (gnqn == null) {
				// probably whitespace check this out???
				continue;
			}
			nodename = gnqn.toString();


			if (child.getNodeKind() == XdmNodeKind.TEXT ) {
				continue;
			}

			if (nodename.equals("album")) {
				aaa = new Album();
				la.add(aaa);
			}

			if (nodename.equals("albumname")) {
				child = (XdmNode) iter.next();
				aaa.setAlbumname(child.toString());
			}

			if (nodename.equals("numphotos")) {
				child = (XdmNode) iter.next();
				aaa.setNumphotos( Integer.parseInt(child.toString()) );
			}

			if (nodename.equals("photofeed")) {
				child = (XdmNode) iter.next();
				aaa.setPhotofeedurl(child.toString());
			}
		}

		return la;		
	}

	public List<Photo> buildPhotos(String photofeed) {

		List<Photo> lp =  new ArrayList<Photo>();
		XdmNode result = null;
		Photo ppp = null;

		result = buildResultXdmNode(photofeed);
		if (result==null) return null;
		XdmSequenceIterator iter = result.axisIterator(Axis.DESCENDANT);

		String nodename = null;

		while (iter.hasNext()) {
			XdmNode child = (XdmNode) iter.next();

			if (child==null) {
				return lp;
			}

			String srcstr = child.getAttributeValue(new QName("src"));
			if (srcstr!=null ) {
				ppp.setPurl(srcstr);
			}

			QName gnqn = child.getNodeName();
			if (gnqn == null) {
				// probably whitespace check this out???
				continue;
			}
			nodename = gnqn.toString();
			if (child.getNodeKind() == XdmNodeKind.TEXT ) {
				continue;
			}

			if (nodename.equals("entry")) {
				ppp = new Photo();
				lp.add(ppp);
			}

			if (nodename.equals("summary")) {            	 
				ppp.setCaption("" + child.getStringValue() );
			}

		}

		return lp;		
	}
}
