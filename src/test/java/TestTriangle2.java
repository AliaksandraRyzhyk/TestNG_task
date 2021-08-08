import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import triangle.Triangle;

import static org.testng.Assert.assertEquals;

public class TestTriangle2 {
    //2. Проверить правильность определения типа треугольника:
    //a.Когда тип треугольника - равносторонний (если треугольник равносторонний - он не считается равнобедренным!!!)
    @Test
    public void checkEquilateral() {
        Triangle triangle = new Triangle(1, 1, 1);
        assertEquals(triangle.detectTriangle(), 1);
    }

    //b.Когда тип треугольника - равнобедренный (проверить со всеми комбинациями боковых сторон: ab, ac, bc)
    @Test
    public void checkIsosceles() {
        SoftAssert softAssert = new SoftAssert();
        Triangle triangle1 = new Triangle(1, 1, 1.5);
        Triangle triangle2 = new Triangle(1.5, 1, 1);
        Triangle triangle3 = new Triangle(1, 1.5, 1);

        softAssert.assertEquals(triangle1.detectTriangle(), 2);
        softAssert.assertEquals(triangle2.detectTriangle(), 2);
        softAssert.assertEquals(triangle3.detectTriangle(), 2);
        softAssert.assertAll();
    }

    //c.Когда тип треугольника - прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
    @Test
    public void checkRectangular() {
        SoftAssert softAssert = new SoftAssert();
        Triangle triangle1 = new Triangle(5, 4, 3);
        Triangle triangle2 = new Triangle(4, 3, 5);
        Triangle triangle3 = new Triangle(3, 4, 5);

        softAssert.assertEquals(triangle1.detectTriangle(), 8);
        softAssert.assertEquals(triangle2.detectTriangle(), 8);
        softAssert.assertEquals(triangle3.detectTriangle(), 8);
        softAssert.assertAll();
    }

    //d.Когда тип треугольника - равнобедренный прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
    @Test
    public void checkRectangularAndIsosceles() {
        SoftAssert softAssert = new SoftAssert();
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(1.4142, 1, 1);
        Triangle triangle3 = new Triangle(1, 1.4142, 1);

        softAssert.assertEquals(triangle1.detectTriangle(), 10);
        softAssert.assertEquals(triangle2.detectTriangle(), 10);
        softAssert.assertEquals(triangle3.detectTriangle(), 10);
        softAssert.assertAll();
    }

    //e.Когда тип треугольника  - обычный
    @Test
    public void checkOrdinary() {
        SoftAssert softAssert = new SoftAssert();
        Triangle triangle1 = new Triangle(3, 4, 6);
        Triangle triangle2 = new Triangle(10, 5, 6);
        Triangle triangle3 = new Triangle(11, 14, 10);

        softAssert.assertEquals(triangle1.detectTriangle(), 4);
        softAssert.assertEquals(triangle2.detectTriangle(), 4);
        softAssert.assertEquals(triangle3.detectTriangle(), 4);
        softAssert.assertAll();
    }
}
