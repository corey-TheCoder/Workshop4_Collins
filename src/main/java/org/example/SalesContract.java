package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {
    private BigDecimal salesTax = new BigDecimal("0.05");
    private BigDecimal recordingFee = new BigDecimal("100.00");
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        BigDecimal vehiclePrice = BigDecimal.valueOf(getVehicleSold().getPrice());
        BigDecimal processFee;
        if (getVehicleSold().getPrice() < 10000) {
            processFee = new BigDecimal("295.00");
        }else {
            processFee = new BigDecimal("495.00");
        }
        BigDecimal taxAmount = vehiclePrice.multiply(salesTax);
        BigDecimal total = vehiclePrice.add(recordingFee).add(processFee);
        //formatting
        return total.setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}






