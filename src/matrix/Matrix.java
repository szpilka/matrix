package matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private final int n;
    private final int m;

    private final List<List<Double>> data;

    public Matrix(List<List<Double>> data) {
        this.data = data;

        n = data.size();
        if (n == 0) {
            throw new IllegalArgumentException("Empty matrix");
        }

        m = data.get(0).size();
        if (m == 0) {
            throw new IllegalArgumentException("Empty matrix");
        }

        for (List<Double> row : data) {
            if (row.size() != m) {
                throw new IllegalArgumentException("Rows lengths not equal");
            }
        }
    }

    public int n() {
        return n;
    }

    public int m() {
        return m;
    }

    public double get(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(i).get(j);
    }

    public Matrix add(Matrix other) {
        if (n != other.n || m != other.m) {
            throw new IllegalArgumentException("Invalid matrix size");
        }

        List<List<Double>> newData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Double> newRow = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                newRow.add(data.get(i).get(j) + other.data.get(i).get(j));
            }
            newData.add(newRow);
        }

        return new Matrix(newData);
    }

    public Matrix multiply(int a) {
        List<List<Double>> newData = new ArrayList<>();
        for (List<Double> row : data) {
            List<Double> newRow = new ArrayList<>();
            for (double rowItem : row) {
                newRow.add(rowItem * a);
            }
            newData.add(newRow);
        }

        return new Matrix(newData);
    }

    public Matrix multiply(Matrix other) {
        if (m != other.n) {
            throw new IllegalArgumentException("Invalid matrix size");
        }

        List<List<Double>> newData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Double> newRow = new ArrayList<>();
            for (int j = 0; j < other.m; j++) {
                double newValue = 0;
                for (int k = 0; k < m; k++) {
                    newValue += data.get(i).get(k) * other.data.get(k).get(j);
                }
                newRow.add(newValue);
            }
            newData.add(newRow);
        }

        return new Matrix(newData);
    }

    public Matrix inverse() {
        if (n != m) {
            throw new UnsupportedOperationException("Cannot inverse matrix when n is not equal to m");
        }

        return this;
    }
}
