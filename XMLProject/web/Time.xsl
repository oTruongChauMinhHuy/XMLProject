<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Time.xsl
    Created on : February 18, 2016, 5:48 PM
    Author     : HuyTCM1
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="param_bus"/>
    <xsl:param name="param_date"/>
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <div>
            <form name="radioForm" action="">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Thời gian</th>
                            <th>Còn trống</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="trips/trip[(bus = $param_bus) and date = $param_date]">
                            <tr class="unselected" onclick="chooseTime('{@id}')" id="{@id}">
                                <td>
                                    <xsl:value-of select="time"/>
                                </td>
                                <td>06</td>
                                <td hidden="">
                                    <input type="radio" name="timeRadio" value="{@id}"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </form>
        </div>
    </xsl:template>
</xsl:stylesheet>
