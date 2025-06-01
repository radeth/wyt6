public class Trojkat {

    public boolean sprawdz(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public boolean isRectangular(double a, double b, double c) {
        if (!sprawdz(a, b, c)) {
            return false;
        }
        // Sortujemy boki, aby najdłuższy bok był c
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        double x = sides[0];
        double y = sides[1];
        double z = sides[2]; // najdłuższy bok

        // Sprawdzamy twierdzenie Pitagorasa z tolerancją na błędy numeryczne
        double epsilon = 1e-10;
        return Math.abs(z * z - (x * x + y * y)) < epsilon;
    }

    public boolean isIsosceles(double a, double b, double c) {
        if (!sprawdz(a, b, c)) {
            return false;
        }
        // Sprawdzamy, czy co najmniej dwa boki są równe
        return (Math.abs(a - b) < 1e-10) || (Math.abs(a - c) < 1e-10) || (Math.abs(b - c) < 1e-10);
    }

    public double areaOfRectangular(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Długości boków muszą być dodatnie.");
        }
        return (a * b) / 2.0;
    }
}
