public class MathVectorDriver {
    public static void main(final String[] args) {
        // Initializing vectors
        MathVector v1 = new MathVector();
        MathVector v2 = new MathVector(2,"Down");
        double[] d = {1.1, 2.2, 3.3};
        double[] b = {1,2,3};
        double[] z = {3,2,1};
        MathVector v3 = new MathVector(d);
        MathVector v4 = v2;
        MathVector v5 = new MathVector(b);

        MathVector v9 = new MathVector(z);
        MathVector v8 = new MathVector(b);
        v9.dotProductInPlace(v8);
        v9.toString();

        //toString method testing
        v1.toString();
        v2.toString();
        v3.toString();
        v4.toString();
        v5.toString();
        System.out.println("\n");

        // magnitude and direction testing
        System.out.println(v1.magnitude());
        System.out.println(v2.magnitude());
        System.out.println(v3.magnitude());
        System.out.println(v4.magnitude());
        System.out.println(v5.magnitude());
        System.out.print("\n");

        // equals testing
        System.out.print(v1.equals(v2)); // should be false
        System.out.print("\n" + v2.equals(v4)); // should be true
        System.out.print("\n");

        // add testing
        v3.add(v5).toString();
        MathVector.add(v3,v5).toString();
        v3.addInPlace(v5);
        v3.toString();
        System.out.print("\n");

        // subtract testing
        v3.subtract(v5).toString();
        MathVector.subtract(v3,v5).toString();
        v3.subtractInPlace(v5);
        v3.toString();
        System.out.print("\n");

        // dot product testing
        System.out.println(v3.dotProduct(v5));
        System.out.print(MathVector.dotProduct(v3,v5));
        v3.dotProductInPlace(v5);
        v3.toString();
        System.out.print("\n");

        // scalar multiply testing
        v3.scalarMultiplication(3).toString();
        MathVector.scalarMultiplication(v3,3).toString();
        v3.scalarMultiplicationInPlace(3);
        v3.toString();
        System.out.print("\n");

    }
}
