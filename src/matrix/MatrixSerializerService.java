package matrix;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixSerializerService {
    public static Matrix readMatrix(Scanner scanner) {
        List<List<Double>> data = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] lineItems = line.split(" ");
            List<Double> row = new ArrayList<>();
            for (String item : lineItems) {
                row.add(Double.parseDouble(item));
            }
            data.add(row);
        }

        return new Matrix(data);
    }

    public static void printMatrix(PrintStream printer, Matrix matrix) {
        for (int i = 0; i < matrix.n(); i++) {
            for (int j = 0; j < matrix.m(); j++) {
                printer.print(matrix.get(i, j));
                if (j != matrix.m() - 1) {
                    printer.print(" ");
                }
            }
            printer.println();
        }
    }
}
