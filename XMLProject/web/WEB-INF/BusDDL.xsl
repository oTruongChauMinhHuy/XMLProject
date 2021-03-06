<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:key name="buscode" match="trip" use="bus"/>
    <xsl:template match="/">
        <xsl:for-each select="//trip[generate-id(.)=generate-id(key('buscode', bus)[1])]">
            <xsl:sort select="bus"/>
            <option>
                <xsl:attribute name="value">
                    <xsl:value-of select="bus"/>
                </xsl:attribute>
                <xsl:value-of select="bus"/>
            </option>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet> 
