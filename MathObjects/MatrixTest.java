package MathObjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class MatrixTest {

    Matrix A = new Matrix(3, 3, Arrays.asList(1.,2.,3.,4.,5.,6.,7.,8.,9.));
    Matrix B = new Matrix(3, 3, Collections.emptyList(), 1.);
    Matrix E = new Matrix(3, 3, Collections.emptyList());

    @Test
    @DisplayName("setElement, getElement, and setAllElements work")
    void setMethodsTest() {
        Matrix E = new Matrix(3, 3, Collections.emptyList());
        E.setElement(2, 2, 9.);
        assertEquals(2., E.getElement(2, 2));
    }

    @Test
    @DisplayName("adding matrices and scalars to matrix works")
    void addTest() {
        try {
            Matrix result1 = A.add(B);
        } catch (Exception ignored) {}

        // TODO
    }
}
