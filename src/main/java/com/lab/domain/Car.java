package com.lab.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
 
@JsonIgnoreProperties({ "ignoreme1", "ignoreme2" })
public class Car {
 
    @JsonProperty
    private String name;
 
    @JsonProperty("carModel")
    private int model;
 
    @JsonProperty
    private String price;
 
    private String ignoreme1;
 
    private String ignoreme2;
 
    @JsonProperty
    private List<String> colors = new ArrayList<String>();
 
    @JsonProperty
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date promoDate;
 
    private Map<String, Object> otherProperties = new HashMap<String, Object>();
 
    @JsonAnyGetter
    public Map<String, Object> any() {
        return otherProperties;
    }
 
    @JsonAnySetter
    public void set(String name, Object value) {
        otherProperties.put(name, value);
    }
 
    @Override
    public String toString() {
        return "Car [name=" + name + ", model=" + model + ", price=" + price
                + ", ignoreme1=" + ignoreme1 + ", ignoreme2=" + ignoreme2
                + ", colors=" + colors + ", promoDate=" + promoDate
                + ", otherProperties=" + otherProperties + "]";
    }
 
}
