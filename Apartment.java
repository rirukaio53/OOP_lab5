package main;

import java.util.Arrays;
import java.util.Comparator;

public class Apartment {

    private final Appliance[] appliances;

    public Apartment(Appliance[] appliances) {
        if (appliances == null || appliances.length == 0) {
            throw new IllegalArgumentException("Масив приладів не може бути null або порожнім.");
        }
        this.appliances = Arrays.copyOf(appliances, appliances.length);
    }

    public void plugInFirst(int count) {
        if (count < 1 || count > appliances.length) {
            throw new IllegalArgumentException(
                    "Кількість приладів для вмикання: 1.." + appliances.length
                            + ", отримано: " + count);
        }
        for (int i = 0; i < count; i++) {
            appliances[i].plugIn();
        }
    }

    public double totalPluggedInPower() {
        double total = 0.0;
        for (Appliance appliance : appliances) {
            if (appliance.isPluggedIn()) {
                total += appliance.getPowerWatts();
            }
        }
        return total;
    }

    public void sortByPower() {
        Arrays.sort(appliances, Comparator.comparingDouble(Appliance::getPowerWatts));
    }

    public Appliance findByEmfRange(double emfMinMHz, double emfMaxMHz) {
        if (emfMinMHz < 0 || emfMaxMHz < 0) {
            throw new IllegalArgumentException("Частоти не можуть бути від'ємними.");
        }
        if (emfMinMHz >= emfMaxMHz) {
            throw new IllegalArgumentException(
                    "emfMinMHz має бути менше emfMaxMHz: " + emfMinMHz + " >= " + emfMaxMHz);
        }
        for (Appliance appliance : appliances) {
            double[] range = appliance.getEmfRangeMHz();
            if (emfMinMHz <= range[1] && emfMaxMHz >= range[0]) {
                return appliance;
            }
        }
        return null;
    }

    public void printAll() {
        System.out.println("=== Електроприлади квартири ===");
        for (int i = 0; i < appliances.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, appliances[i]);
        }
    }
}