<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	exclude-result-prefixes="xsl"
><xsl:output method="html" omit-xml-declaration="no" indent="yes"/>
<xsl:template match="Albums">
<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html>
</xsl:text>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>List of Available Albums</title>
<link rel="stylesheet" href="styles/albumshtml.css" />

</head>
<body>
<h2>List of Available Albums</h2>

<xsl:apply-templates></xsl:apply-templates>
</body>
</html>
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
<li><div >
<xsl:apply-templates></xsl:apply-templates>
</div></li>
</ul>
</div>
</xsl:template>

<xsl:template match="Photo">
<div class="photo">
<img>
<xsl:attribute name="src">
<xsl:value-of select="Folder"></xsl:value-of><xsl:text>/s100</xsl:text><xsl:value-of select="File"></xsl:value-of>
</xsl:attribute>
</img>
</div>
</xsl:template>


<xsl:template match="text()|@*">
</xsl:template>

</xsl:stylesheet>