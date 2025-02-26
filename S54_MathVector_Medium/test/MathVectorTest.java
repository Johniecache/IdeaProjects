import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class MathVectorTest {

    @Test
    @DisplayName("Getting Data")
    void getData() {
        double[] d = {1,2,3};
        MathVector v = new MathVector(d,"Upwards");

        assertEquals(d, v.getData());
    }

    @Test
    @DisplayName("Getting Size")
    void getSize() {
        double[] d = {1,2,3};
        MathVector v = new MathVector(d,"Upwards");

        assertEquals(3, v.getSize());
    }

    @Test
    @DisplayName("Get Direction")
    void getDirection() {
        double[] d = {1,2,3};
        MathVector v = new MathVector(d,"Upwards");

        assertEquals("Upwards", v.getDirection());
    }

    @Test
    void magnitude() {
        double[] d = {1,2,2};
        MathVector v = new MathVector(d,"Upwards");

        assertEquals(3,v.magnitude());
    }

    @Test
    void testEquals() {
        double[] d = {1,2,3};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(d,"Upwards");
        MathVector n = new MathVector(2);

        assertEquals(true, v.equals(u));
        assertEquals(false, v.equals(n));
    }

    @Test
    void add() {
        double[] d = {1,2,3};
        double[] a = {2,4,6};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(d,"Upwards");
        MathVector n = new MathVector(a);

        assertArrayEquals(n.getData(),v.add(u).getData());
        assertArrayEquals(n.getData(),MathVector.add(v,u).getData());
    }

    @Test
    void addInPlace() {
        double[] d = {1,2,3};
        double[] a = {2,4,6};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(d,"Upwards");
        v.addInPlace(u);

        assertArrayEquals(a,v.getData());
    }

    @Test
    void subtract() {
        double[] d = {1,2,3};
        double[] a = {0,0,0};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(d,"Upwards");

        assertArrayEquals(a,v.subtract(u).getData());
        assertArrayEquals(a,MathVector.subtract(v,u).getData());
    }

    @Test
    void subtractInPlace() {
        double[] d = {1,2,3};
        double[] a = {0,0,0};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(d,"Upwards");
        v.subtractInPlace(u);

        assertArrayEquals(a,v.getData());
    }

    @Test
    void dotProduct() {
        double[] d = {1,2,3};
        double b = 10;
        double[] a = {3,2,1};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(a,"Upwards");

        assertEquals(10, v.dotProduct(u));
        assertEquals(b, MathVector.dotProduct(v,u));
    }

    @Test
    void dotProductInPlace() {
        double[] d = {1,2,3};
        double[] a = {3,2,1};
        MathVector v = new MathVector(d,"Upwards");
        MathVector u = new MathVector(a,"Upwards");
        v.dotProductInPlace(u);

        assertEquals(10, v.getData()[0]);
    }

    @Test
    void scalarMultiplication() {
        double[] d = {1,2,3};
        double[] a = {2,4,6};
        MathVector v = new MathVector(d,"Upwards");
        int scalar = 2;

        assertArrayEquals(a,v.scalarMultiplication(scalar).getData());
        assertArrayEquals(a,MathVector.scalarMultiplication(v,scalar).getData());
    }


    @Test
    void scalarMultiplicationInPlace() {
        double[] d = {1,2,3};
        double[] a = {2,4,6};
        MathVector v = new MathVector(d,"Upwards");
        MathVector z = new MathVector(a);
        int scalar = 2;
        v.scalarMultiplicationInPlace(scalar);

        assertArrayEquals(z.getData(),v.getData());
    }

    @Test
    void testToString() {
        double[] d = {1,2,3};
        double[] a = new double[0];
        double[] b = new double[2];
        MathVector v1 = new MathVector();
        MathVector v2 = new MathVector(2);
        MathVector v3 = new MathVector(d);

        assertArrayEquals(a,v1.getData());
        assertArrayEquals(b,v2.getData());
        assertArrayEquals(d,v3.getData());
    }
}