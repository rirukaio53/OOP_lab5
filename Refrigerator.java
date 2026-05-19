package main;

public class Refrigerator extends Appliance {

    private final int volumeLiters;

    public Refrigerator(String name, double powerWatts, int volumeLiters) {
        super(name, powerWatts);
        if (volumeLiters <= 0) {
            throw new IllegalArgumentException("Об'єм холодильника має бути > 0.");
        }
        this.volumeLiters = volumeLiters;
    }

    public int getVolumeLiters() {
        return volumeLiters;
    }

    @Override
    public double[] getEmfRangeMHz() {
        return new double[]{50.0, 300.0};
    }

    @Override
    public String getCategory() {
        return "Кухонний";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Об'єм: %d л", volumeLiters);
    }
}