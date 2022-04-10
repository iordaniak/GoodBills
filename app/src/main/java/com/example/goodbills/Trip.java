package com.example.goodbills;
import java.util.ArrayList;
import java.io.Serializable;

public class Trip implements Serializable{

    //  Variables ----------------------------------------------------------------------------------------------------------
    private String name;
    private int numOfTravellers;
    private Traveller[] travellers;
    private double[][] table;
    private ArrayList<Payment> payments = new ArrayList<>();
    private double total;

    //  Constructor --------------------------------------------------------------------------------------------------------
    public Trip(String name, int numOfTravellers) {
        this.name = name;
        this.numOfTravellers = numOfTravellers;
        this.total = 0;
        this.travellers = new Traveller[numOfTravellers];
        this.table = new double[numOfTravellers][numOfTravellers];
        ArrayList<Payment> payments = new ArrayList<>();
    }

    //  Methods ------------------------------------------------------------------------------------------------------------
    public void addPayment(Payment payment, String name){
        this.payments.add(payment);
        for(Traveller t: this.getTravellers()){
            if(name.equals(t.getName())){
                t.setExpenses(t.getExpenses()+payment.getAmount());
            }
        }
    }

    //  Getters & Setters --------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public int getNumOfTravellers() {
        return numOfTravellers;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Payment> getPayments() { return payments; }

    public Traveller[] getTravellers() {
        return travellers;
    }

    public void setTravellers(Traveller[] travellers) {
        this.travellers = travellers;
    }
    public void setTraveller(Traveller traveller, int i) {
        this.travellers[i] = traveller;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfTravellers(int numOfTravellers) {
        this.numOfTravellers = numOfTravellers;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPayments(ArrayList<Payment> payments) { this.payments = payments; }
}
