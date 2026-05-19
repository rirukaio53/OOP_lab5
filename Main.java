package main;

public class Main {

    public static void main(String[] args) {
        try {
            Appliance[] appliances = {
                new Refrigerator("Samsung RB38T776CB1", 150.0, 385),
                new Television("LG OLED55C3", 130.0, 55),
                new Microwave("Panasonic NN-ST342W", 800.0, 23),
                new WifiRouter("ASUS RT-AX88U", 25.0, "Wi-Fi 6"),
                new Refrigerator("Bosch KGN39VL25E", 140.0, 315),
                new Television("Sony KD-43X80J", 85.0, 43),
            };

            Apartment apartment = new Apartment(appliances);

            System.out.println(">>> ПОЧАТКОВИЙ СТАН:");
            apartment.printAll();

            System.out.println("\n>>> Вмикаємо перші 4 прилади у розетку...");
            apartment.plugInFirst(4);

            double totalPower = apartment.totalPluggedInPower();
            System.out.printf(">>> Загальна споживана потужність увімкнених приладів: %.1f Вт%n",
                    totalPower);

            System.out.println("\n>>> ПІСЛЯ СОРТУВАННЯ ЗА ПОТУЖНІСТЮ:");
            apartment.sortByPower();
            apartment.printAll();

            double searchMin = 50.0;
            double searchMax = 300.0;
            System.out.printf(
                    "%n>>> Пошук приладу з ЕМВ у діапазоні %.0f–%.0f МГц:%n",
                    searchMin, searchMax);

            Appliance found = apartment.findByEmfRange(searchMin, searchMax);
            if (found != null) {
                System.out.println("    Знайдено: " + found);
            } else {
                System.out.println("    Прилад із таким ЕМВ-діапазоном не знайдений.");
            }

            System.out.println("\n>>> ДЕМОНСТРАЦІЯ ОБРОБКИ ВИНЯТКІВ:");

            try {
                apartment.plugInFirst(100);
            } catch (IllegalArgumentException e) {
                System.out.println("  [Очікуваний виняток] plugInFirst(100): " + e.getMessage());
            }

            try {
                apartment.findByEmfRange(5000.0, 100.0);
            } catch (IllegalArgumentException e) {
                System.out.println("  [Очікуваний виняток] findByEmfRange(5000, 100): "
                        + e.getMessage());
            }

            try {
                new Television("BadTV", -50.0, 32);
            } catch (IllegalArgumentException e) {
                System.out.println("  [Очікуваний виняток] new Television(..., -50, 32): "
                        + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Критична помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}