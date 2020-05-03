package org.sergh.app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Random;

public class Phone {


    @SerializedName("tel")
    private String number;
    private String type;

    public Phone() {
    }

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public void setNumber(String number) {
        this.number = setRandomPhone();
    }

    public String setRandomPhone() {

        final int PHONE_NUMBER_LENGTH = 13;
        String s = "123456789";
        StringBuilder phoneNumber = new StringBuilder();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return phoneNumber.toString();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String setType() {
        return String.valueOf(PhoneTypes.randomPhone());
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

