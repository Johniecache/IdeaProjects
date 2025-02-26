public class MathVector {
    private double[] data;
    private int size;
    private String direction;


    /**
     * grabs all the data in the instance vector
     * @return data
     */
    public double[] getData(){
        return this.data;
    }

    /**
     * grabs the size of instance vector
     * @return size
     */
    public int getSize(){
        return this.size;
    }

    /**
     * grabs the directions of instance vector
     * @return the direction
     */
    public String getDirection(){
        return this.direction;
    }

    /**
     * sets the data as an array
     * @param data the data
     */
    public void setData(double[] data){
        this.data = data;
    }

    /**
     * sets the size of the vector
     * @param size the size
     */
    public void setSize(int size){
        this.size = size;
    }

    /**
     * sets the direction of instance vector
     * @param direction the direction
     */
    public void setDirection(String direction){
        this.direction = direction;
    }

    /**
     * default constructor with no input
     */
    public MathVector(){
        data = new double[0];
        direction = "Up";
    }

    /**
     * default constructor with no inputs
     */
    public MathVector(String direction){
        data = new double[0];
        this.direction = direction;
    }

    /**
     * default constructor with integer size input
     * @param size the size
     */
    public MathVector(int size){
        this.size = size;
        data = new double[size];
        direction = "Up";
    }

    /**
     * default constructor with double data array
     * @param data the array
     */
    public MathVector(double[] data){
        this.data = data;
        size = data.length;
        direction = "Up";
    }

    /**
     * default constructor with two inputs a size an direction
     * @param size the size
     * @param direction the direction
     */
    public MathVector(int size, String direction){
        this.size = size;
        data = new double[size];
        this.direction = direction;
    }

    /**
     * default constructor with two inputs as double array and string direction
     * @param data the data
     * @param direction the direction
     */
    public MathVector(double[] data, String direction){
        size = data.length;
        this.data = data;
        this.direction = direction;
    }

    /**
     * like the default constructor but instead takes magnitude instead of size
     * @param magnitude the magnitude of the vector
     * @param direction the direction of the vector
     */
    public void fromMagnitudeAndDirection(int magnitude, String direction){
        this.size = magnitude;
        this.direction = direction;
        data = new double[magnitude];
    }

    /**
     * loops through vector array, squares each value and adds them together then square roots them
     * @return magnitude of vector
     */
    public double magnitude(){
        double mag = 0; // initialize magnitude
        for(int i=0;i<data.length;i++){ // loop through vector array
            mag += data[i]*data[i]; // square all components @ position i and add it to mag
        }
        return Math.sqrt(mag); // have javas already established square root function return to user
    }

    /**
     * checks to see if two vectors are equal
     * @param v as second vector
     * @return boolean of whether two vectors are equal
     */
    public boolean equals(MathVector v){
        if(this.data.length != v.data.length){ // if the lengths of two vectors do not equal
            return false; // return false
        }
        for(int i=0;i<v.data.length;i++){ // loop through either array
            if(this.data[i] != v.data[i]){ // if the data of main vector does not equal that of input vector
                return false; // return false
            }
        }
        return true; // if tests pass then return true
    }

    /**
     * adds two vectors with one input vector
     * @param v vector
     * @return added vectors
     */
    public MathVector add(MathVector v){
        MathVector added = new MathVector(v.data.length); // create new vector to hold added values
        if(this.data.length != v.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not  length."); // in case either vectors are not equal
        }
        for(int i=0;i<v.data.length;i++){ // loop through arrays
            added.data[i] = this.data[i] + v.data[i]; // set data of new vector as the added values of input vectors
        }
        return added; // return added vectors
    }

    /**
     * a static method add that overloads the other add method
     * @param v1 as first vector
     * @param v2 as second vector
     * @return added values of vectors input
     */
    public static MathVector add(MathVector v1, MathVector v2){
        MathVector added = new MathVector(v1.data.length); // create new vector to hold added values
        if(v1.data.length != v2.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // case of non equal length vectors
        }
        for(int i=0;i<v1.data.length;i++){ // loop through array
            added.data[i] = v1.data[i] + v2.data[i]; // set added vector as the two input vectors added together
        }
        return added;
    }

    /**
     * method that adds two vectors and applies that addition to original vector
     * @param v as input vector
     */
    public void addInPlace(MathVector v){
        if(this.data.length != v.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // in case of not equal lengths
        }
        for(int i=0;i<v.data.length;i++){ // loop through array
            this.data[i] += v.data[i]; // assign original vector as new vector added values
        }
    }

    /**
     * subtracts two vectors
     * @param v vector input
     * @return subtracted values in vector form
     */
    public MathVector subtract(MathVector v){
        MathVector subtracted = new MathVector(v.data.length); // create new vector to hold subtracted values
        if(this.data.length != v.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // in case either vectors are not equal
        }
        for(int i=0;i<v.data.length;i++){ // loop through arrays
            subtracted.data[i] = this.data[i] - v.data[i]; // set data of new vector as the subtracted values of input vectors
        }
        return subtracted; // return subtracted vectors
    }

    /**
     * static method overload with two input vectors
     * @param v1 vector one
     * @param v2 vector two
     * @return subtracted vector
     */
    public static MathVector subtract(MathVector v1, MathVector v2){
        MathVector subtracted = new MathVector(v1.data.length); // create new vector to hold added values
        if(v1.data.length != v2.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // case of non-equal length vectors
        }
        for(int i=0;i<v1.data.length;i++){ // loops through array
            subtracted.data[i] = v1.data[i] - v2.data[i]; // sets subtracted vector to that of the subtracted values of the two input vectors
        }
        return subtracted; // return subtracted vector
    }

    /**
     * assign original values with subtracted values
     * @param v the input vector
     */
    public void subtractInPlace(MathVector v){
        if(this.data.length != v.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // in case of non-equal lengths
        }
        for(int i=0;i<v.data.length;i++){ // loop through array
            this.data[i] -= v.data[i]; // assign original vector wit new values
        }
    }

    /**
     * gets the dot product of two vectors
     * @param v vector input
     * @return dot product value
     */
    public double dotProduct(MathVector v){
        double dotted = 0; // create new double to hold dot product values
        if(this.data.length != v.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // checks if equal lengths
        }
        for(int i=0;i<v.data.length;i++){ // loop through array
            dotted += this.data[i] * v.data[i]; // assign dotted value as multiple values of vectors and add them
        }
        return dotted;
    }

    /**
     * takes two vector inputs and gets the dot product of them
     * @param v1 vector one
     * @param v2 vector two
     * @return dotted values
     */
    public static double dotProduct(MathVector v1, MathVector v2){
        double dotted = 0; // create new double to hold dot product values
        if(v1.data.length != v2.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // checks if equal lengths
        }
        for(int i=0;i<v1.data.length;i++){ // loop through array
            dotted += v1.data[i] * v2.data[i]; // assign dotted value as multiple values of vectors and add them
        }
        return dotted;
    }

    /**
     * re-assigns both length and first value in original vector as the dot product value
     * @param v input vector
     */
    public void dotProductInPlace(MathVector v){
        if(this.data.length != v.data.length){
            throw new ArrayIndexOutOfBoundsException("Vectors are not equal length."); // checks if equal lengths
        }
        double temp = 0; // set a temp value with the value at 0
        for(int i=0;i<v.data.length;i++){ // loop through array
            temp += this.data[i] * v.data[i]; // assign dotted value as multiple values of vectors and add them
        }
        this.data = new double[1]; // re-assign original vector to 1 length
        this.data[0] = temp; // set that one length to the dot product value
    }

    /**
     * takes a double as input and uses that as the scalar to multiply by
     * @param x scalar
     * @return multiplied vector
     */
    public MathVector scalarMultiplication(double x){
        MathVector multi = new MathVector(this.data.length); // create new vector to hold multiplied values
        for(int i=0;i<this.data.length;i++){ // loop through arrays
            multi.data[i] = this.data[i] * x; // multiply each value in data by scalar
        }
        return multi; // return multiplied vectors
    }

    /**
     * overloads the original scalar multiplication and takes 2 inputs
     * @param v the vector
     * @param x the scalar
     * @return multiplied vector
     */
    public static MathVector scalarMultiplication(MathVector v, double x){
        MathVector multi = new MathVector(v.data.length); // create new vector to hold multiplied values
        for(int i=0;i<v.data.length;i++){ // loop through arrays
            multi.data[i] = v.data[i] * x; // multiply each value in data by scalar
        }
        return multi; // return multiplied vectors
    }

    /**
     * in place method that replaces original with the new multiplied values
     * @param x the scalar
     */
    public void scalarMultiplicationInPlace(double x){
        for(int i=0;i<this.data.length;i++){ // loop through arrays
            this.data[i] *= x; // multiply each value in data by scalar
        }
    }

    /**
     * a toString override of the default to string that prints the instance vector to the screen
     * @return vector string
     */
    public String toString(){
        System.out.print("\n["); // prints starting bracket for vector
        for(int i=0;i<data.length;i++){ // loops through array of vector
            System.out.print(data[i]); // displays the data at position i
            if(i < data.length - 1){ // if not at the last element in the array
                System.out.print(", "); // print a comma for better readability
            }
        }
        System.out.print("]"); // print final bracket
        return String.valueOf(data); // return string
    }
}
