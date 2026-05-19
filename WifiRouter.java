package main;

public class WifiRouter extends Appliance {

    private final String wifiStandard;

    public WifiRouter(String name, double powerWatts, String wifiStandard) {
        super(name, powerWatts);
        if (wifiStandard == null || wifiStandard.isBlank()) {
            throw new IllegalArgumentException("Стандарт Wi-Fi не може бути порожнім.");
        }
        this.wifiStandard = wifiStandard;
    }

    public String getWifiStandard() {
        return wifiStandard;
    }

    @Override
    public double[] getEmfRangeMHz() {
        return new double[]{2400.0, 5850.0};
    }

    @Override
    public String getCategory() {
        return "Мережевий";
    }

    @Override
    public String toString() {
        return super.toString() + " | Стандарт: " + wifiStandard;
    }
}