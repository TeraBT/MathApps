package MathObjects;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private final int dimension1;
    private final int dimension2;
    private List<List<Double>> elements = new ArrayList<>();

    public Matrix(int dimension1, int dimension2, List<Double> elements, Double defaultValue) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;

        int counter = 0;
        for (int i = 1; i <= dimension1; ++i) {
            List<Double> row = new ArrayList<>();
            for (int j = 1; j <= dimension2; ++j) {
                if (elements.isEmpty()) {
                    row.add(defaultValue);
                } else {
                    row.add(elements.get(counter++));
                }
            }
            this.elements.add(row);
        }
    }

    public Matrix(int dimension1, int dimension2, List<Double> elements) {
        this(dimension1, dimension2, elements, 0.0);
    }

    private Matrix(List<List<Double>> embeddedElements, int dimension2) {
        this.dimension1 = embeddedElements.size();
        this.dimension2 = dimension2;
        this.elements = embeddedElements;
    }

    public int getDimension1() {
        return dimension1;
    }

    public int getDimension2() {
        return dimension2;
    }

    public void setElement(int index1, int index2, Double element) {
        elements.get(index1-1).set(index2-1, element);
    }

    public void setAllElements(Double element) {
        for (int i = 1; i <= dimension1; ++i) {
            for (int j = 1; j <= dimension2; ++j) {
                setElement(i, j, element);
            }
        }

    }

    public Double getElement(int dimension1, int dimension2) {
        return elements.get(dimension1-1).get(dimension2-1);
    }

    public Matrix add(Matrix B) throws DimensionMismatchException {
        if (dimension1 != B.getDimension1() || dimension2 != getDimension2()) {
            throw new DimensionMismatchException();
        } else {
            List<List<Double>> rows = new ArrayList<>();
            for (int i = 1; i <= dimension1; ++i) {
                List<Double> rowElements = new ArrayList<>();
                for (int j = 1; j <= dimension2; ++j) {
                    rowElements.add(this.getElement(i, j) + B.getElement(i, j));
                }
                rows.add(rowElements);
            }
            return new Matrix(rows, dimension2);
        }
    }

    public Matrix add(double scalar) {
        List<List<Double>> rows = new ArrayList<>();
        for (int i = 1; i <= dimension1; ++i) {
            List<Double> rowElements = new ArrayList<>();
            for (int j = 1; j <= dimension2; ++j) {
                rowElements.add(this.getElement(i, j) + scalar);
            }
            rows.add(rowElements);
        }
        return new Matrix(rows, dimension2);
    }

    public  Matrix subtract(Matrix B) throws DimensionMismatchException {
        return add(B.multiply(-1.0));
    }

    public  Matrix subtract(double scalar) throws DimensionMismatchException {
        return add(scalar * -1.0);
    }

    public Matrix multiply( Matrix B) throws DimensionMismatchException {
        if (dimension2 != B.getDimension1()) {
            throw new DimensionMismatchException();
        } else {
            List<List<Double>> rows = new ArrayList<>();
            for (int i = 1; i <= dimension1; ++i) {
                List<Double> rowElements = new ArrayList<>();
                for (int j = 1; j <= dimension2; ++j) {
                    double sum = 0;
                    for (int r = 1; r <= dimension1; ++r) {
                        sum += getElement(i, r) * B.getElement(r, j);
                    }
                    rowElements.add(sum);
                }
                rows.add(rowElements);
            }
            return new Matrix(rows, B.getDimension2());
        }
    }

    public Matrix multiply(double scalar) {
        List<List<Double>> rows = new ArrayList<>();
        for (int i = 1; i <= dimension1; ++i) {
            List<Double> rowElements = new ArrayList<>();
            for (int j = 1; j <= dimension2; ++j) {
                rowElements.add(this.getElement(i, j) * scalar);
            }
            rows.add(rowElements);
        }
        return new Matrix(rows, dimension2);
    }

    public Matrix invert(Matrix A) {
        // TODO: implement
        return null;
    }

}
