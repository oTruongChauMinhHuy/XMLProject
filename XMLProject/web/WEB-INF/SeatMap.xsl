<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : SeatMap.xsl
    Created on : February 16, 2016, 5:53 PM
    Author     : HuyTCM1
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <xsl:for-each select="trips/trip[@id=1]/seats/seat">
            <xsl:value-of select="@id"/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
