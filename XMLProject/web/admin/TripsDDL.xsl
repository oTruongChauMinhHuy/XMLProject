<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <table class="table">
            <thead>
                <tr>
                    <td>
                        Trip ID
                    </td>
                    <td>
                        Bus
                    </td>
                    <td>
                        Time
                    </td>
                    <td>
                        Car
                    </td>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="trips/trip[@isAvailable = 'true']">
                    <form action="../ControllerServlet" method="GET">
                        <tr>
                            <td>
                                <xsl:value-of select="@id"/>
                                <input type="text" value="{@id}" name="txtTripID" hidden=""/>
                            </td>
                            <td>
                                <xsl:value-of select="bus"/>
                            </td>
                            <td>
                                <xsl:value-of select="date"/> 
                                ---
                                <xsl:value-of select="time"/>
                            </td>
                            <td>
                                <xsl:value-of select="car/@numberPlate"/>
                            </td>
                            <td>
                                <input type="submit" name="btnAction" value="StartTrip"/>
                            </td>
                            <td>
                                <input type="submit" name="btnAction" value="CancelTrip"/>
                            </td>
                        </tr>
                    </form>
                </xsl:for-each>
            </tbody>
        </table>
    </xsl:template>

</xsl:stylesheet>
