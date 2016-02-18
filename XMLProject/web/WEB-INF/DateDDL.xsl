<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:key name="dateC" match="trip" use="date"/>
    <xsl:template match="/">
        <xsl:for-each select="//trip[generate-id(.)=generate-id(key('dateC', date)[1])]">
            <xsl:sort select="date"/>
            <option>
                <xsl:attribute name="value">
                    <xsl:value-of select="date"/>
                </xsl:attribute>
                <xsl:value-of select="date"/>
            </option>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
