<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet exclude-result-prefixes="xsl" version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output indent="yes" method="html" omit-xml-declaration="no" />


	<xsl:template match="session">
		<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;</xsl:text>
		<html lang="en">
			<head>
				<meta charset="utf-8" />
				<title>Steven Layton Photography</title>
				<link href="styles/home.css" rel="stylesheet" />
				<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" />
				<script src="styles/home.js" />
			</head>
			<body>
				<div class="main flexcontainer">
					
					<xsl:apply-templates select="datastore/albums/Album" />
				</div>
				<div class="view">
				</div>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="Album">
	<div class="albumname flexcontainer">
	<xsl:value-of select="Albumname"></xsl:value-of>
	<div class="photos hidden">
	<xsl:apply-templates select="Photos/Photo">
	</xsl:apply-templates>
	</div>
	</div>
	</xsl:template>
		
	<xsl:template match="Photo">
	<div class="photo flexitem">
	<img>
	<xsl:attribute	name="src"> <xsl:value-of select="Folder"/> 
	<xsl:text>/s100</xsl:text> 
	<xsl:value-of select="File"/>
	</xsl:attribute> 
	</img> 
	</div>			
	</xsl:template>
	
	
	<!-- <xsl:template match="Photo" > <div class="photo flexitem"> <img> <xsl:attribute 
		name="src"> <xsl:value-of select="Folder"/> <xsl:text>/s100</xsl:text> <xsl:value-of 
		select="File"/></xsl:attribute> </img> </div> </xsl:template> -->
	<xsl:template match="text()|@*" />
</xsl:stylesheet>