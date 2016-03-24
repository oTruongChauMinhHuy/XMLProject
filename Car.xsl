<?xml version="1.0"?>
//Change
<!--
    Document   : Car.xsl
    Created on : January 13, 2016, 9:21 AM
    Author     : Admin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="Car">
        <html>
            <head>
                <title>Car.xsl</title>
            </head>
            <body>
                <table>
                    <tr>
                        <th>
                            Number Plate
                        </th>
                        <th>
                            Driver name
                        </th>
                    </tr>
                    <xsl:for-each select="//dr:Driver">
                        <tr>
                            <td>
                                <xsl:value-of select="dr:name"/>
                            </td>
                            <td>
                                <xsl:value-of select="dr:salarye"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
