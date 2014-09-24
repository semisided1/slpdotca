<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:atom="http://www.w3.org/2005/Atom"
	xmlns:gphoto='http://schemas.google.com/photos/2007' 
	xmlns:media='http://search.yahoo.com/mrss/'
	exclude-result-prefixes="xsl atom gphoto media"
><xsl:output method="xml" omit-xml-declaration="no" indent="yes"/>
<xsl:template match="/">
<albums>
<xsl:apply-templates></xsl:apply-templates>
</albums>
</xsl:template>


<xsl:template match="atom:feed/atom:entry">
<album>
<albumname>
<xsl:value-of select="media:group/media:title" />
</albumname>
<xsl:text>   </xsl:text>
<numphotos>
<xsl:value-of select="gphoto:numphotos" />
</numphotos>
<xsl:text>   </xsl:text>
<photofeed>
<xsl:value-of select="atom:link/@href" />
</photofeed>
</album>
<xsl:text>  

</xsl:text>
</xsl:template>



</xsl:stylesheet>