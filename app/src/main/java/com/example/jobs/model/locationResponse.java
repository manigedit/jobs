package com.example.jobs.model;

public class locationResponse {

    String _id;
    String city;
    String state;
    String country;
    int pincode;
    int __v;

    public locationResponse(String _id, String city, String state, String country, int pincode, int __v) {
        this._id = _id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.__v = __v;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
