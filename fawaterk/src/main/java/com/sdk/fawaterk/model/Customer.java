package com.sdk.fawaterk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private Integer phone;

    @SerializedName("address")
    @Expose
    private String address;
    /**
     * No args constructor for use in serialization
     *
     */
    public Customer() {
    }

    /**
     *
     * @param phone
     * @param email
     * @param last_name
     * @param address
     * @param first_name
     */
    public Customer(String first_name, String last_name, String email,String address, Integer phone) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String productName) {
        this.last_name = last_name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public Integer getphone() {
        return phone;
    }

    public void setphone(Integer price) {
        this.phone = phone;
    }

}

