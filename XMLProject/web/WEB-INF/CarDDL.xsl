<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : CarDDL.xsl
    Created on : February 14, 2016, 11:12 AM
    Author     : Admin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <select name="ddlCar" id="ddlCar">
            <xsl:for-each select="cars/car">
                <option value="{@numberPlate}">
                    <xsl:value-of select="@numberPlate"/>
                </option>
            </xsl:for-each>
        </select>
    </xsl:template>
</xsl:stylesheet>
