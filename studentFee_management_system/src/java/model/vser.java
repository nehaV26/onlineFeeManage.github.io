/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hp
 */
public class vser {
    private int roll;

    
    private String name;
    private String email;
    private String gender;
    private String course;
    private int fee;
    private int paid;
    private int due;
    private String address;
    private int contect;
     public vser() {
    }

    public vser(int roll) {
        this.roll = roll;
    }
    
    public vser(int roll, String name, String email, String gender, String course, int fee, int paid, int due, String address, int contect) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.course = course;
        this.fee = fee;
        this.paid = paid;
        this.due = due;
        this.address = address;
        this.contect = contect;
    }

   

    public vser(String name, String email, String gender, String course, int fee, int paid, int due, String address, int contect) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.course = course;
        this.fee = fee;
        this.paid = paid;
        this.due = due;
        this.address = address;
        this.contect = contect;
    }
    
    
    
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContect() {
        return contect;
    }

    public void setContect(int contect) {
        this.contect = contect;
    }
    
}
