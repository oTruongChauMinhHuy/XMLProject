/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
@Path("xml")
public class XMLServices {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of XMLServices
     */
    public XMLServices() {
    }

    @Path("/createTrip")
    @GET
    @Produces("text/plain")
    public String createTrip(@QueryParam("bus") String bus,
            @QueryParam("date") String date,
            @QueryParam("time") String time,
            @QueryParam("numberPlate") String numberPlate,
            @QueryParam("driver") String driver) {
//        Trip trip = new Trip();
//        switch (bus) {
//            case "LK":
//                trip.setBus(Bus.LK);
//                break;
//            case "SG":
//                trip.setBus(Bus.SG);
//                break;
//        }
//        String dateTime = date + "T" + time;
//        trip.setTime(XMLUtilities.toXMLGregorianCalendar(dateTime));
//        Car car = new Car();
//        car.setNumberPlate(numberPlate);
//        car.setDriver(driver);
//        trip.setCar(car);
//        
//        XMLUtilities.JAXBMarshalling(trip, null);
        return "false";
    }
//    @Path("/getCars")
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public Collection<Car> getAllCars () {
//        List<Car> cars = DBUtilities.getAllCars();
//        return cars;
//    }
    /**
     * Retrieves representation of an instance of com.services.XMLServices
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of XMLServices
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
