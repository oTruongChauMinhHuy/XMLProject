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
        <table>
            <xsl:for-each select="trips/trip[@id='LK070220150700']/seats/seat">
                <xsl:if test="@id=1">
                    <tr>
                        <td colspan="2" class="disabled">0</td>
                        <td class="disabled"></td>
                        <td id="{@id}" colspan="2" onclick="chooseSeat({@id})" class="{@available}">
                            <xsl:value-of select="@id"/>
                        </td>
                    </tr>
                </xsl:if>
                <xsl:choose>
                    <xsl:otherwise>
                        <tr>
                            <xsl:choose>
                                <xsl:when test="@id mod 4=0">
                                    <td class="disabled"></td>
                                    <td id="{@id}" onclick="chooseSeat({@id})" class="">
                                        <xsl:value-of select="@id"/>
                                    </td>    
                                </xsl:when>
                                <xsl:otherwise>
                                    <td id="{@id}" onclick="chooseSeat({@id})" class="">
                                        <xsl:value-of select="@id"/>
                                    </td>    
                                </xsl:otherwise>
                            </xsl:choose>
                        </tr>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>
