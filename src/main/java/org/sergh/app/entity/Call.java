package org.sergh.app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Call {

    @SerializedName("__name")
    private String __name;
    private Date dateAndTime;
    private String companyName;
    private String firstName;
    private String lastName;
    @SerializedName("phoneNumber")
    private List<Phone> phoneNumber;
    private String testMessage;

    public Call() {

    }

    public Call(String __name, Date dateAndTime, String companyName, String firstName, String lastName, List<Phone> phoneNumber, String testMessage) {
        this.__name = __name;
        this.dateAndTime = dateAndTime;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.testMessage = testMessage;
    }

    public String get__name() {
        return __name;
    }

    public void set__name(String __name) {
        this.__name = __name;
    }

    public Date getDate() {
        return dateAndTime;
    }

    public void setDate() {
        this.dateAndTime = new Date();
    }

    public String getDateString() {
        return dateAndTime.toString();
    }

    public void setDate(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Phone> getPhone() {
        return phoneNumber;
    }

    public void setPhone(String number, String type) {
        List<Phone> phoneNumber = new ArrayList<>();
        phoneNumber.add(new Phone(number, type));
        this.phoneNumber = phoneNumber;
    }

    public String getTestMessage() {
        return testMessage;
    }

    public void setTestMessage(String testMessage) {
        this.testMessage = testMessage;
    }

    @Override
    public String toString() {
        return "Call{" +
                "__name='" + __name + '\'' +
                ", dateAndTime=" + dateAndTime +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", testMessage='" + testMessage + '\'' +
                '}';
    }

    /**
     * Метод для генерации рандомной строки
     * @return
     */
    public String generateSimpleString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}