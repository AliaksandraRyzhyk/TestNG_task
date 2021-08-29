import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import triangle.Triangle;

import static org.testng.Assert.assertEquals;

public class TestTriangle2 {
    //2. Проверить правильность определения типа треугольника:
    @DataProvider
    public static Object[][] dataForValidationType() {
        return new Object[][]{
                {1.0, 1.0, 1.0},
                {3.0, 4.0, 5.0},
                {1.0, 1.0, 1.5},
                {3.0, 4.0, 6.0}
        };
    }

    //a.Когда тип треугольника - равносторонний (если треугольник равносторонний - он не считается равнобедренным!!!)
    @Test(dataProvider = "dataForValidationType")
    public void checkEquilateral(double a, double b, double c) {
        assertEquals(new Triangle(a,b,c).detectTriangle(), 1);
    }

    //b.Когда тип треугольника - равнобедренный (проверить со всеми комбинациями боковых сторон: ab, ac, bc)
    @Test(dataProvider = "dataForValidationType")
    public void checkIsosceles(double a, double b, double c) {
//        Triangle triangle1 = new Triangle(1, 1, 1.5);
//        Triangle triangle2 = new Triangle(1.5, 1, 1);
//        Triangle triangle3 = new Triangle(1, 1.5, 1);

      assertEquals(new Triangle(a,b,c).detectTriangle(), 2);

    }

    //c.Когда тип треугольника - прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
    @Test(dataProvider = "dataForValidationType")
    public void checkRectangular(double a, double b, double c) {
//        Triangle triangle1 = new Triangle(5, 4, 3);
//        Triangle triangle2 = new Triangle(4, 3, 5);
//        Triangle triangle3 = new Triangle(3, 4, 5);

      assertEquals(new Triangle(a,b,c).detectTriangle(), 8);
    }

    //d.Когда тип треугольника - равнобедренный прямоугольный (проверить со всеми комбинациями катетов: ab, ac, bc)
    @Test(dataProvider = "dataForValidationType")
    public void checkRectangularAndIsosceles(double a, double b, double c) {
//        Triangle triangle1 = new Triangle(3, 4, 5);
//        Triangle triangle2 = new Triangle(1.4142, 1, 1);
//        Triangle triangle3 = new Triangle(1, 1.4142, 1);

        assertEquals(new Triangle(a,b,c).detectTriangle(), 10);

    }

    //e.Когда тип треугольника  - обычный
    @Test(dataProvider = "dataForValidationType")
    public void checkOrdinary(double a, double b, double c) {
//        Triangle triangle1 = new Triangle(3, 4, 6);
//        Triangle triangle2 = new Triangle(10, 5, 6);
//        Triangle triangle3 = new Triangle(11, 14, 10);

       assertEquals(new Triangle(a,b,c).detectTriangle(), 4);

    }
}
