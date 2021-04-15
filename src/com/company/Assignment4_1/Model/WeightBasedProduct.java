package com.company.Assignment4_1.Model;

public class WeightBasedProduct extends Product{

    float pricePerKg;
    float minQuantity;

    //we have to make this constructor so as to call the constructor of parent class to save the
    // information of parent class as well.But if we have empty constructor in parent class then we don't
    // have to initialise the parameterized constructor.
    public WeightBasedProduct(String name, String imageUrl, float pricePerKg, float minQuantity) {
        super(name, imageUrl);
        this.pricePerKg = pricePerKg;
        this.minQuantity = minQuantity;
    }

    @Override
    public String toString() {
        return "WeightBasedProduct{" +
                "\nname='" + name + '\'' +
                ", \nimageUrl='" + imageUrl + '\'' +
                ", \npricePerKg=" + pricePerKg +
                ", \nminQuantity=" + minQuantity +
                '}';
    }
}
