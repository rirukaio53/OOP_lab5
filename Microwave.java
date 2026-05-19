package main;

public class Microwave extends Appliance {

    private final int capacityLiters;

    public Microwave(String name, double powerWatts, int capacityLiters) {
        super(name, powerWatts);
        if (capacityLiters <= 0) {
            throw new IllegalArgumentException("Об'єм мікрохвильовки має бути > 0.");
        }
        this.capacityLiters = capacityLiters;
    }

    public int getCapacityLiters() {
        return capacityLiters;
    }

    @Override
    public double[] getEmfRangeMHz() {
        return new double[]{2400.0, 2500.0};
    }

    @Override
    public String getCategory() {
        return "Кухонний";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Об'єм: %d л", capacityLiters);
    }
}