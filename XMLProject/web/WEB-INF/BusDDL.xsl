<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output method="html"/>
    <xsl:key name="buses" match="bus" use="."/>
    <xsl:template match="/trips">
        <xsl:apply-templates select="trip/bus[generate-id() = generate-id(key('buses', .)[1])]"/>
    </xsl:template>

    <xsl:template match="bus">
        <xsl:variable name="currentBus" select="."/>
        <option value="{$currentBus}">
            <xsl:value-of select="$currentBus"/>
        </option>
    </xsl:template>
</xsl:stylesheet> 
