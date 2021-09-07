package com.zetcode.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//The Cities bean is a helper bean which is used to get nicer XML output
@JacksonXmlRootElement
public class Cities implements Serializable {

    private static final long serialVersionUID = 22L;

    /*
     * With @JacksonXmlProperty and @JacksonXmlElementWrapper annotations we ensure that we have
     *  City elements nested in the Cities element for a an ArrayList of city objects
     */
    @JacksonXmlProperty(localName = "City")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<City> cities = new ArrayList<>();

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}