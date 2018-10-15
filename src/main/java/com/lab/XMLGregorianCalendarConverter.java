package com.lab;

import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.DateTimeZoneBuilder;

public class XMLGregorianCalendarConverter {
	public static XMLGregorianCalendar dateTimeToXMLGregorianCalendar(DateTime dateTime) {
	    XMLGregorianCalendar xmlGregorianCalendar = null;
	    try {
	      DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
	      xmlGregorianCalendar = dataTypeFactory.newXMLGregorianCalendar(dateTime.toGregorianCalendar());
	    }
	    catch (DatatypeConfigurationException e) {
	      System.out.println("Exception in conversion of DateTime to XMLGregorianCalendar" + e);
	    }
	    return xmlGregorianCalendar;
	  }
	  
	  public static DateTime xmlGregorianCalendarToDateTime(XMLGregorianCalendar xmlGregorianCalendar, DateTimeZone zone) throws Exception {
		  if (xmlGregorianCalendar.getTimezone() == DatatypeConstants.FIELD_UNDEFINED || xmlGregorianCalendar.getTimezone() == 0) {
			  	System.out.println("xs:dateTime wihtout timezone .. setting universal UTC timezone");
			  	return new DateTime(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis(), DateTimeZone.UTC);
			}
	    return new DateTime(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis(), zone);
	  }
	  
	  public static void main(String[] args) throws Exception {
		  String isoDateString = "2018-10-08T10:15:56.000Z";
		  DateTime dateTime = DateTime.parse(isoDateString);
		  XMLGregorianCalendar calendar;
		  calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(2018, 10, 8, 10, 15, 56, 000, 0);
		  
		  XMLGregorianCalendar calendarResult = XMLGregorianCalendarConverter.dateTimeToXMLGregorianCalendar(dateTime);
		  System.out.println("DateTimeToXMLGregorianCalendar: " + calendarResult); // DateTimeToXMLGregorianCalendar: 2016-12-29T08:32:15.000Z
		  
		  DateTime dateResult = XMLGregorianCalendarConverter.xmlGregorianCalendarToDateTime(calendar, DateTimeZone.getDefault());
		  System.out.println("XMLGregorianCalendarToDateTime: " + dateResult); // XMLGregorianCalendarToDateTime: 2016-12-29T08:32:15.000Z
	}
}
