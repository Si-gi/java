package com.example.smsbomber;

public class ContactModel {
    private String name, number;
    private int nb_sms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNbSms(){
        return this.nb_sms;
    }
    public void setNbSms(int nb){
        this.nb_sms = nb;
    }
}
