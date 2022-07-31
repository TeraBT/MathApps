package MathObjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class MatrixTest {

    Matrix A = new Matrix(3, 3, Arrays.asList(1.,2.,3.,4.,5.,6.,7.,8.,9.));
    Matrix B = new Matrix(3, 3, Collections.emptyList(), 1.);
    Matrix C = new Matrix(3, 3, Collections.emptyList());
    Matrix D = new Matrix(3, 3, Arrays.asList(9.,8.,7.,6.,5.,4.,3.,2.,1.));
    /* TODO: fix tests again:
    *   do multiplication with A and D and update assert values...*/
    @Test
    @DisplayName("Constructors work")
    void constructorsTest() {
        assertEquals(5., A.getElement(2, 2));
        assertEquals(1., B.getElement(1, 2));
        assertEquals(0., C.getElement(2, 1));
    }

    @Test
    @DisplayName("setElement, getElement, and setAllElements work")
    void setMethodsTest() {
        Matrix E = new Matrix(3, 3, Collections.emptyList());
        E.setElement(2, 2, 9.);
        assertEquals(9, E.getElement(2, 2));
        E.set // TODO: test setAllElements()
    }

    @Test
    @DisplayName("Adding matrices and scalars to matrix works")
    void addTest() {
        Matrix result1 = A;
        try {
            result1 = A.add(A);
        } catch (Exception ignored) {}

        assertEquals(2, result1.getElement(1,1));
        assertEquals(10, result1.getElement(2,2));

        Matrix result2 = A;
        try {
            result2 = A.add(3);
        } catch (Exception ignored) {}

        assertEquals(4, result2.getElement(1,1));
        assertEquals(8, result2.getElement(2,2));
    }

    @Test
    @DisplayName("Subtracting matrices and scalars from matrices works")
    void subtractTest() {
        Matrix result1 = A;
        try {
            result1 = A.subtract(); //TODO: fix test again
        } catch (Exception ignored) {}

        assertEquals(0, result1.getElement(1,1));
        assertEquals(4, result1.getElement(2,2));

        Matrix result2 = A;
        try {
            result2 = A.subtract(3);
        } catch (Exception ignored) {}

        assertEquals(-2, result2.getElement(1,1));
        assertEquals(2, result2.getElement(2,2));
    }

    @Test
    @DisplayName("Multiplying with matrices and scalars to matrices works")
    void multiplyTest() {
        Matrix result1 = A;
        try {
            result1 = A.multiply(A);
        } catch (Exception ignored) {}

        assertEquals(30, result1.getElement(1,1));
        assertEquals(81, result1.getElement(2,2));
        assertEquals(150, result1.getElement(3,3));

        Matrix result2 = A;
        try {
            result2 = A.multiply(3);
        } catch (Exception ignored) {}

        assertEquals(3, result2.getElement(1,1));
        assertEquals(15, result2.getElement(2,2));
    }

    // TODO: test invert()

}
