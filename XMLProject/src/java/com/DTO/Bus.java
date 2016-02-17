
package com.DTO;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Bus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Bus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LK"/>
 *     &lt;enumeration value="SG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Bus")
@XmlEnum
public enum Bus {

    LK,
    SG;

    public String value() {
        return name();
    }

    public static Bus fromValue(String v) {
        return valueOf(v);
    }

}
