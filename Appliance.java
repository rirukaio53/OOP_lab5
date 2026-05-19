package main;

public abstract class Appliance {

    private final String name;
    private final double powerWatts;
    private boolean pluggedIn;

    public Appliance(String name, double powerWatts) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва приладу не може бути порожньою.");
        }
        if (powerWatts <= 0) {
            throw new IllegalArgumentException(
                    "Споживана потужність має бути більше нуля: " + powerWatts);
        }
        this.name = name;
        this.powerWatts = powerWatts;
        this.pluggedIn = false;
    }

    public String getName() {
        return name;
    }

    public double getPowerWatts() {
        return powerWatts;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public void plugIn() {
        this.pluggedIn = true;
    }

    public void unplug() {
        this.pluggedIn = false;
    }

    public abstract double[] getEmfRangeMHz();

    public abstract String getCategory();

    @Override
    public String toString() {
        double[] emf = getEmfRangeMHz();
        return String.format(
                "[%s] %s | Категорія: %s | Потужність: %.1f Вт | ЕМВ: %.1f–%.1f МГц | %s",
                getClass().getSimpleName(),
                name,
                getCategory(),
                powerWatts,
                emf[0],
                emf[1],
                pluggedIn ? "УВІМКНЕНО" : "вимкнено");
    }
}