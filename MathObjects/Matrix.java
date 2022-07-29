package MathObjects;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends Number> {

    private final int dimension1;
    private final int dimension2;
    private final List<List<T>> elements = new ArrayList<>();

    public Matrix(int dimension1, int dimension2, T defaultValue, List<T> elements) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;

        for (int i = 1; i <= dimension2; ++i) {
            List<T> row = new ArrayList<>();
            for (int j = 1; j <= dimension2; ++j) {
                if (elements.isEmpty()) {
                    row.add(defaultValue);
                } else {
                    row.add(elements.get(0));
                    elements.remove(0);
                }
            }
            this.elements.add(row);
        }
    }

    public int getDimension1() {
        return dimension1;
    }

    public int getDimension2() {
        return dimension2;
    }

    public void setElement(int dimension1, int dimension2, T element) {
        elements.get(dimension1-1).set(dimension2-1, element);
    }

    public T getElement(int dimension1, int dimension2) {
        return elements.get(dimension1-1).get(dimension2-1);
    }

    public Matrix<T> add(Matrix<T> B) {

    }

    public  Matrix<T> subtract( Matrix<T> B) {

    }

    public  Matrix<T> multiply( Matrix<T> B) {

    }

    public  Matrix<T> invert( Matrix<T> A) {

    }

}
