import org.testng.annotations.Test;
import triangle.Triangle;

import static org.testng.Assert.assertEquals;

public class TestTriangle3 {
    //3. Проверить правильность вычисления площади треугольника:
    //a.Когда стороны - целые числа
    @Test
    public void checkSquareInt() {
        Triangle triangle3 = new Triangle(3, 4, 5);
        assertEquals(triangle3.getSquare(), 6);
    }

    //b.Когда стороны - дробные числа
    @Test
    public void checkSquareDouble() {
        Triangle triangle3 = new Triangle(3.5, 4.5, 5.5);
        assertEquals(triangle3.getSquare(), 7.854885024620029);
    }

    //c.При больших значениях сторон (прим. в 50 степени)
    @Test
    public void checkSquareMax() {
        Triangle triangle3 = new Triangle(Math.pow(3.5, 50), Math.pow(3.5, 50), Math.pow(3.5, 50));
        assertEquals(triangle3.getSquare(), 1.1048544546796814E54);
    }

    //d.При маленьких значениях сторон (прим. в -50 степени)
    @Test
    public void checkSquareMin() {
        Triangle triangle3 = new Triangle(Math.pow(3.5, -50), Math.pow(3.5, -50), Math.pow(3.5, -50));
        assertEquals(triangle3.getSquare(), 1.6970561073074532E-55);
    }

    //e.Проверить на переполнении суммы при вычислении периметра
    @Test
    public void checkPerimeter() {
        Triangle triangle3 = new Triangle(Double.MAX_VALUE, 1, Double.MAX_VALUE - 1);
        assertEquals(triangle3.getSquare(), Double.POSITIVE_INFINITY);
    }
}
