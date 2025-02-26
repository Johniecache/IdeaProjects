
public class MatrixDriver {
    public static void main(String[] args) {
        // Custom Matrix with values and sizes
        System.out.println("\n\t\t New Matrix Testing");
        double[][] z = {{3,2,1},{1,2,3}};
        Matrix m = new Matrix(z);
        m.toString();

        // Default Matrix with bounds given
        Matrix n = new Matrix(2,3);
        n.toString();
        double[][] x = {{.1,.2,.3},{.3,.2,.1}};
        n.setData(x);

        // More matrices
        Matrix t = new Matrix(5,5);
        Matrix y = new Matrix(5,5);
        double[][] c = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};

        // Mathematical operations on matrices
        System.out.println("\n\t\t Add and Subtract instance testing...");
        m.add(n).toString();
        m.subtract(n).toString();

        // Using subMatrix
        System.out.println("\n\t\t subMatrix testing...");
        m.subMatrix(2,2).toString();

        // Checking equals
        System.out.println("\n\t\t Check equals testing...");
        System.out.println(m.equals(n)); // Should be false off of size
        System.out.println(t.equals(y)); // Should be true
        y.setData(c);
        System.out.println(t.equals(y)); // Should be false off of values

        // Identity testing
        System.out.println("\n\t\t Identity testing...");
        Matrix.identity(7).toString();

        // Scalar Multiply
        System.out.println("\n\t\t Scalar Multiply testing...");
        m.scalarMultiply(7).toString();
        m.scalarMultiply(-1).toString();
        n.scalarMultiply(0).toString();

        // Multiplication
        System.out.println("\n\t\t Matrix Multiply testing...");
        m.multiply(n).toString(); // should fail and give n matrix
        t.multiply(y).toString(); // should all be 0
        double[][] h = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};
        t.setData(h);
        t.multiply(y).toString(); // should all have values

        // Static Adding
        System.out.println("\n\t\t Static Adding testing...");
        Matrix.add(t,y).toString(); // both matrices are same so just be doubled value
        Matrix.add(m,t).toString(); // should fail

        // Add in place
        System.out.println("\n\t\t Add in Place testing...");
        m.addInPlace(n);
        m.toString(); // m matrix should be m + n

        // Static Subtracting
        System.out.println("\n\t\t Static Subtracting testing...");
        Matrix.subtract(t,y).toString(); // should all be 0
        Matrix.subtract(m,t).toString(); // should fail

        // Subtracting in Place
        System.out.println("\n\t\t Subtracting in place testing...");
        m.subtractInPlace(n);
        m.toString(); // m matrix should be m - n

        // Static Scalar Multiply
        System.out.println("\n\t\t Static scalar multiplication testing...");
        Matrix.scalarMultiply(7,m).toString(); // m matrix multiplied by 7

        // Scalar Multiply in Place
        System.out.println("\n\t\t Scalar multiplication testing...");
        m.scalarMultiplyInPlace(-1);
        m.toString(); // should all be negative
        m.scalarMultiplyInPlace(0);
        m.toString(); // should all be 0
        m.setData(z); // resetting m's data for future use

        // Static Multiply
        System.out.println("\n\t\t Static Multiply testing...");
        Matrix.multiply(m,n).toString(); // should fail
        Matrix.multiply(t,y).toString(); // should all have values


        // Multiply in Place
        System.out.println("\n\t\t Multiply in Place testing...");
        m.multiplyInPlace(n); // should fail due to dimensions
        m.toString();
        t.multiplyInPlace(y);
        t.toString();

    }
}