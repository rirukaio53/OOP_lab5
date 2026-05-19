package main;

public class Television extends Appliance {

    private final int screenInches;

    public Television(String name, double powerWatts, int screenInches) {
        super(name, powerWatts);
        if (screenInches <= 0) {
            throw new IllegalArgumentException("Діагональ екрану має бути > 0.");
        }
        this.screenInches = screenInches;
    }

    public int getScreenInches() {
        return screenInches;
    }

    @Override
    public double[] getEmfRangeMHz() {
        return new double[]{470.0, 890.0};
    }

    @Override
    public String getCategory() {
        return "Мультимедіа";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Екран: %d\"", screenInches);
    }
}