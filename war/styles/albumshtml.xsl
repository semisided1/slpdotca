<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	exclude-result-prefixes="xsl">
	<xsl:output method="html" omit-xml-declaration="no" indent="yes" />

<xsl:template match="session">
		<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html>
</xsl:text>
		<html lang="en">
			<head>
				<meta charset="utf-8" />
				<title>List of Available Albums</title>
				<link rel="stylesheet" href="styles/albumshtml.css" />
				<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
				<script src="styles/albumshtml.js"></script>
			</head>
			<body>
			
				<h2>login</h2>
				 <xsl:apply-templates select="login"></xsl:apply-templates>
 
				<h2>Albums in current document</h2>
				<xsl:apply-templates select="document"></xsl:apply-templates>
				
				<h2>List of Available Albums</h2>
				<xsl:apply-templates select="photofeed"></xsl:apply-templates>

			</body>
			
		</html>
	</xsl:template>
	
	<!-- consider changing login to meta, its all the information other than doc not sure we even need any of it -->
	<!--  	<xsl:template match="login">
	<xmp>
	<xsl:copy >
	<xsl:apply-templates></xsl:apply-templates>
	</xsl:copy>
	</xmp>
	</xsl:template>
	-->
	
	
	<xsl:template match="login">
	</xsl:template>
	
	
	
	<!--  -->
	<xsl:template match="document">
	<xsl:apply-templates></xsl:apply-templates>
	</xsl:template>
	
<!-- <xsl:template match="document">
	<xmp>
	<xsl:copy >
	<xsl:apply-templates></xsl:apply-templates>
	</xsl:copy>
	</xmp>
	</xsl:template> -->

	<xsl:template match="photofeed">
	<!--  <xmp>
	<xsl:copy >
	<xsl:apply-templates></xsl:apply-templates>
	</xsl:copy>
	</xmp> -->
	<h2>Albums</h2>
	<xsl:apply-templates select="Album" ></xsl:apply-templates>
	
	</xsl:template>
	
	<xsl:template match="Album">
		<div class="album">
			
			<h3>
				<xsl:value-of select="Albumname"></xsl:value-of>
			</h3>
			<ul>
				<li>
					<xsl:value-of select="Numphotos"></xsl:value-of>
				</li>
				<li>
					<xsl:value-of select="Photofeedurl"></xsl:value-of>
				</li>
				<li>
					<div class="flexcontainer">
						<xsl:apply-templates></xsl:apply-templates>
					</div>
				</li>
			</ul>
			<br />
			
			<div class="addthisalbum">
				Add <xsl:value-of select="Albumname"></xsl:value-of>
				<xmp>
			<xsl:copy-of select="." />
			</xmp>
	<!-- 		
		
<form action="addalbum" id="g_form" method="POST">
<input type="text" name=" ">
	
			
	
</input>

<input type="submit" value="submit!" id="f_submit" name="submit"/>
</form>
 -->
</div>



 
			
			
		</div>
	</xsl:template>

	<xsl:template match="Photo">.<!-- 
		<div class="photo flexitem">
			<img>
				<xsl:attribute name="src">
<xsl:value-of select="Folder"></xsl:value-of><xsl:text>/s100</xsl:text><xsl:value-of
					select="File"></xsl:value-of>
</xsl:attribute>
			</img>
		</div>
		
		 -->
	</xsl:template>


	<xsl:template match="text()|@*">
	</xsl:template>

</xsl:stylesheet>