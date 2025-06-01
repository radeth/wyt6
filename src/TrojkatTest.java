import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrojkatTest {

    private Trojkat trojkat;

    @BeforeEach
    public void setUp() {
        trojkat = new Trojkat();
    }

    @Test
    public void testPoprawnyTrojkat() {
        // Trójkąt o bokach 3, 4, 5 (prostokątny)
        assertTrue(trojkat.sprawdz(3, 4, 5));
    }

    @Test
    public void testZeroJedenBok() {
        // Jeden bok równy zero - nie można zbudować trójkąta
        assertFalse(trojkat.sprawdz(0, 4, 5));
    }

    @Test
    public void testUjemnyBok() {
        // Jeden bok ujemny - nie można zbudować trójkąta
        assertFalse(trojkat.sprawdz(3, -4, 5));
    }

    @Test
    public void testNiespelnionyWarunekTrojkata() {
        // Suma dwóch boków równa trzeciemu - nie tworzy trójkąta
        assertFalse(trojkat.sprawdz(1, 2, 3));
    }

    @Test
    public void testBokiBliskieWarunkowi() {
        // Suma dwóch boków mniejsza niż trzeci - nie tworzy trójkąta
        assertFalse(trojkat.sprawdz(2, 2, 5));
    }

    @Test
    public void testBokiZmiennoprzecinkowe() {
        // Test z liczbami zmiennoprzecinkowymi, które tworzą trójkąt
        assertTrue(trojkat.sprawdz(2.5, 3.1, 4.2));
    }

    // Testy dla metody isRectangular

    @Test
    public void testIsRectangularTrue() {
        assertTrue(trojkat.isRectangular(3, 4, 5));
        assertTrue(trojkat.isRectangular(5, 3, 4));
        assertTrue(trojkat.isRectangular(4, 5, 3));
    }

    @Test
    public void testIsRectangularFalse() {
        assertFalse(trojkat.isRectangular(3, 3, 3));
        assertFalse(trojkat.isRectangular(2, 2, 3));
        assertFalse(trojkat.isRectangular(1, 2, 3)); // nie trójkąt
    }

    // Testy dla metody isIsosceles

    @Test
    public void testIsIsoscelesTrue() {
        assertTrue(trojkat.isIsosceles(5, 5, 8));
        assertTrue(trojkat.isIsosceles(7, 10, 7));
        assertTrue(trojkat.isIsosceles(6, 9, 9));
    }

    @Test
    public void testIsIsoscelesFalse() {
        assertFalse(trojkat.isIsosceles(3, 4, 5));
        assertFalse(trojkat.isIsosceles(2, 3, 4));
        assertFalse(trojkat.isIsosceles(1, 1, 3)); // nie trójkąt
    }

    // Testy dla metody areaOfRectangular

    @Test
    public void testAreaOfRectangular() {
        assertEquals(6.0, trojkat.areaOfRectangular(3, 4), 1e-10);
        assertEquals(12.5, trojkat.areaOfRectangular(5, 5), 1e-10);
        assertEquals(0.5, trojkat.areaOfRectangular(1, 1), 1e-10);
    }

    @Test
    public void testAreaOfRectangularInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> trojkat.areaOfRectangular(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> trojkat.areaOfRectangular(2, 0));
    }
}
