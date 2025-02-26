/*
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MatrixDriverJUnitTest {

    // Invalid Constructor tests throwing illegal arguments
    @ParameterizedTest(name="run #{index} with [{arguments}]")
    @CsvSource({"{}"})
    void invalidConstructor(double[][] data){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Matrix(2,2));
    }

    @ParameterizedTest(name="run #{index} with [{arguments}]")
    @CsvSource({"0,0"})
    void invalidConstructor2Arguments(int rows, int cols){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Matrix(2,2));
    }

    @Test
    void validConstructors(){
        double[][] d = {{1,2,3},{3,2,1}};
        Matrix m0 = new Matrix();
        Matrix m1 = new Matrix(2,2);
        Matrix m2 = new Matrix(d);

        assertEquals(m0.toString(), "[0.0, 0.0]\n[0.0, 0.0]");
        assertEquals(m1.toString(), "[0.0, 0.0]\n[0.0, 0.0]");
        assertEquals(m2.toString(), "[1.0, 2.0, 3.0]\n[3.0, 2.0, 1.0]");
    }

    @Test
    void copyConstructor(){
        double[][] d = {{1,2,3},{3,2,1}};
        double[][] b = {{0,0,0},{0,0,0}};

        Matrix original = new Matrix(d);
        Matrix copy = new Matrix(original.getData());

        // Deep copy -> address of original Matrix
        original.setData(b);

        assertEquals(copy.toString(), "[0.0, 0.0, 0.0]\n[0.0, 0.0, 0.0]");
    }

    // Variable parameter setup
    @ParameterizedTest(name="run #{index} with [{arguments}]")
    @CsvSource({"{}"})
    void invalidSetData(double[][] data){
        Assertions.assertThrows(IllegalArgumentException.class, () -> m.setData(data));
    }

    @ParameterizedTest(name="run #{index} with [{arguments}]")
    @CsvSource({"-1,-1,-1"})
    void invalidSetData(int rows, int cols, int data){
        Assertions.assertThrows(IllegalArgumentException.class, () -> m.setData(int rows, int cols, int data));
    }



    // Method Testing

    @Test
    public void validSetters(){
        Matrix m = new Matrix();
        assertEquals(m.toString(), "[0.0, 0.0]\n[0.0, 0.0]");

        m.setData(0,0,1);
        m.setData(1,1,1);

        assertEquals(m.toString(), "[1.0, 0.0]\n[1.0, 0.0]");
    }

    @Test
    public void testToString(){
        Matrix m = new Matrix();
        System.out.println(m.toString());
    }

    @Test
    public void identityTest(){
        Matrix.identity(7).toString();
    }

    @Test
    public void equalsTest(){
        double[][] d = {{1,2,3},{3,2,1}};
        Matrix m = new Matrix(d);
        Matrix n = new Matrix(d);

        m.equals(n);
    }

    @Test
    public void subMatrixTest(){
        Matrix m = new Matrix(5,5);
        m.subMatrix(2,2).toString();
    }

    @Test
    public void addTest(){
        double[][] d = {{1,2,3},{3,2,1}}
        double[][] b = {{0.1,0.2,0.3},{0.3,0.2,0.1}};

        Matrix m = new Matrix(d);
        Matrix n = new Matrix(b);

        m.add(n).toString();
    }

    @Test
    public void subtractTest(){
        double[][] d = {{1,2,3},{3,2,1}}
        double[][] b = {{0.1,0.2,0.3},{0.3,0.2,0.1}};

        Matrix m = new Matrix(d);
        Matrix n = new Matrix(b);

        m.subtract(n).toString();
    }

    @Test
    public void scalarMultiplyTest(){
        double[][] d = {{1,2,3},{3,2,1}}

        Matrix m = new Matrix(d);

        m.scalarMultiply(7).toString();
    }

    @Test
    public void multiplyTest(){
        double[][] d = {{1,2,3},{3,2,1}}
        double[][] b = {{0.1,0.2,0.3},{0.3,0.2,0.1}};

        Matrix m = new Matrix(d);
        Matrix n = new Matrix(b);

        m.multiply(n).toString();
    }
}

 */