package com.example.firebasecrud;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class BakiUser {
    private String name;
    private String address;
    private String total_price;
    private String initial_pay;
    private String current_due;
    private String jamanot_name;
    private String jamanot_mobile;
    private String grohon_date;
    private String commitment_to_pay_date;


    public BakiUser() {
    }

    public BakiUser(String name, String address, String total_price, String initial_pay, String current_due, String jamanot_name, String jamanot_mobile, String grohon_date, String commitment_to_pay_date) {
        this.name = name;
        this.address = address;
        this.total_price = total_price;
        this.initial_pay = initial_pay;
        this.current_due = current_due;
        this.jamanot_name = jamanot_name;
        this.jamanot_mobile = jamanot_mobile;
        this.grohon_date = grohon_date;
        this.commitment_to_pay_date = commitment_to_pay_date;
    }

    public String getGrohon_date() {
        return grohon_date;
    }

    public void setGrohon_date(String grohon_date) {
        this.grohon_date = grohon_date;
    }

    public String getCommitment_to_pay_date() {
        return commitment_to_pay_date;
    }

    public void setCommitment_to_pay_date(String commitment_to_pay_date) {
        this.commitment_to_pay_date = commitment_to_pay_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getInitial_pay() {
        return initial_pay;
    }

    public void setInitial_pay(String initial_pay) {
        this.initial_pay = initial_pay;
    }

    public String getCurrent_due() {
        return current_due;
    }

    public void setCurrent_due(String current_due) {
        this.current_due = current_due;
    }

    public String getJamanot_name() {
        return jamanot_name;
    }

    public void setJamanot_name(String jamanot_name) {
        this.jamanot_name = jamanot_name;
    }

    public String getJamanot_mobile() {
        return jamanot_mobile;
    }

    public void setJamanot_mobile(String jamanot_mobile) {
        this.jamanot_mobile = jamanot_mobile;
    }
}
