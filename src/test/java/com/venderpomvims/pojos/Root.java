package com.venderpomvims.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {


    @JsonProperty("username")
    String uname;
    String password;
    String annualyearing;
    String availableInventory;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnnualyearing() {
        return annualyearing;
    }

    public void setAnnualyearing(String annualyearing) {
        this.annualyearing = annualyearing;
    }

    public String getAvailableInventory() {
        return availableInventory;
    }

    public void setAvailableInventory(String availableInventory) {
        this.availableInventory = availableInventory;
    }

    public String getMonthlyearing() {
        return monthlyearing;
    }

    public void setMonthlyearing(String monthlyearing) {
        this.monthlyearing = monthlyearing;
    }

    public String getProfitmargin() {
        return profitmargin;
    }

    public void setProfitmargin(String profitmargin) {
        this.profitmargin = profitmargin;
    }

    String monthlyearing;
    String profitmargin;




}
