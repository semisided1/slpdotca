#slpdotca - stevenlaytonsphotography.ca#

Thu Oct  2 01:25:59 MDT 2014

This is a photo album website for Steven Laytons Photography. 
The site uses Stevens G+ Albums to store and serve the photos.
The site uses Google Appengine to serve the pages and store
which albums and the order of the albums appear on the site.


##Parts##

1. 	Stevens *G+ Albums* 
	- managed with G+ or Picasa by Steven - the customer
2. */getpicasa* 
	- chooses order and which public albums from Stevens G+ go on the web site
	- slide show album must be included but will not be seen in menu
3. */index.html*
	- links to all the parts of the site
4. Appengine *data-store* 
	- the list of albums to show on the web site
	filled with the results of /getpicasa
5. */home* 
	- Uses data-store to build menu and albums and display the home page

##Technology##

- Google Appengine for Java
- Saxonica s9api
- html5
- java
- javascript
- xml
- ajax
- json
- xsl
- css
- jquery

##Aftermath##

In retrospect I overcomplicated a few parts of this but for future projects the 
methods will be handy. I never needed to make pojos ever: but I did just for 
convienence. 

Some new tricks that I used that I am unsure of are: using the xmp tag to hide 
data ;) 

Its a bit ugly how I had to handle <pre>&nbsp;</pre> tag