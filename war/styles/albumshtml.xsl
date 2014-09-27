<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet exclude-result-prefixes="xsl" version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output indent="yes" method="html" omit-xml-declaration="no"/>
	<xsl:template match="session">
		<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;</xsl:text>
		<html lang="en">
			<head>
				<meta charset="utf-8"/>
				<title>List of Available Albums</title>
				<link href="styles/albumshtml.css" rel="stylesheet"/>
				<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"/>
				<script src="styles/albumshtml.js"/>
			</head>
			<body>
				<h2>login</h2>
				<xsl:apply-templates select="login"/>
				<h2>Albums in current document</h2>
				<xsl:apply-templates select="datastore"/>
				<h2>List of Available Albums</h2>
				<xsl:apply-templates select="photofeed"/>
			</body>
		</html>
	</xsl:template>
	<!-- consider changing login to meta, its all the information other than doc not sure we even need any of it -->
	<!--  	<xsl:template match="login"><xmp><xsl:copy ><xsl:apply-templates></xsl:apply-templates></xsl:copy></xmp></xsl:template>-->
	<xsl:template match="login">
		<p>username: </p>
	</xsl:template>
	<!--  
	<xsl:template match="document/Albums"><xsl:apply-templates></xsl:apply-templates></xsl:template>-->
	<xsl:template match="datastore">
		<xsl:apply-templates select="albums/Album"/>
	</xsl:template>
	<xsl:template match="albums/Album">
		<p>
			<xsl:value-of select="Albumname"/>
		</p>
	</xsl:template>
	<xsl:template match="photofeed">
		<xsl:apply-templates select="Album"/>
	</xsl:template>
	<xsl:template match="photofeed/Album">
		<div class="album">
			<h3>
				<xsl:value-of select="Albumname"/>
			</h3>
			<ul>
				<li>
					<xsl:value-of select="Numphotos"/>
				</li>
				<li>
					<xsl:value-of select="Photofeedurl"/>
				</li>
				<li>
					<div class="flexcontainer">
						<xsl:apply-templates/>
					</div>
				</li>
			</ul>
			<div class="addthisalbum">Add 
				<xsl:value-of select="Albumname"/>
				<xmp style="display:none"><xsl:copy-of select="."/></xmp>  
			</div>
		</div>
	</xsl:template>
	<xsl:template match="photofeed/Album/Photo">.
		
		<div class="photo flexitem">
			<img>
				<xsl:attribute name="src">
					<xsl:value-of select="Folder"/>
					<xsl:text>/s100</xsl:text>
					<xsl:value-of select="File"/></xsl:attribute>
			</img>
		</div>
	</xsl:template>
	<xsl:template match="text()|@*"/>
</xsl:stylesheet>