import java.util.Arrays;

/**
 * Create Matrix objects and do mathematical operations on them such as
 * Adding, Subtracting, Scalar Multiplication, Identity identification, etc.
 * @see java.util.Arrays
 * @author Caleb Thomas
 */
public class Matrix {
    private int rows; // # of rows in matrix
    private int cols; // # of columns in matrix
    private double[][] data;

    /**
     * Default constructor for the matrix class that sets the data values to 0 with no rows or columns
     */
    public Matrix(){
        rows = 2; // sets default rows as 2
        cols = 2; // sets default columns as 2
        data = new double[2][2]; // sets the default values to 0
    }

    /**
     * Matrix constructor for matrix object that takes a 2D array and sets rows and columns of matrix and sets values
     * @param data 2D array of data values
     */
    public Matrix(double[][] data){
        this.data = data; // default values are passed in as d
        this.rows = data.length; // # of rows found by length of d
        this.cols = data[0].length; // columns found by length of d at pos 0
    }

    /**
     * Matrix constructor for matrix object, takes # of rows and columns, sets all values to 0
     * @param row number of rows
     * @param col number of columns
     */
    public Matrix(int row, int col){
        this.rows = row; // input r for # of rows is set to instance rows
        this.cols = col; // input c for # of columns is set to instance columns
        this.data = new double[row][col]; // 2D array is created and set to those previous row & column values with 0 as values
    }

    /**
     * Sets the number of rows for instance object to given input
     * @param row number of rows to set
     */
    public void setRows(int row){
        this.rows = row; // sets rows to input # r
    }

    /**
     * sets number of columns for instance object with given input col
     * @param col number of columns as input
     */
    public void setCols(int col){
        this.cols = col; // sets columns to input # c
    }

    /**
     * an override of setData to take an input 2D array
     * @param data as values from 2D array
     */
    public void setData(double[][] data){
        for(int i = 0; i< rows; i++){ // loop through rows
            for(int j = 0; j< cols; j++){ // loop through columns
                this.data[i][j] = data[i][j]; // set _data at i,j to input d at i,j
            }
        }
    }

    /**
     * an override to setData to take row number, column number, and data value and sets it
     * @param row number of rows as input
     * @param col number of columns as input
     * @param data data value to place in given position
     */
    public void setData(int row, int col, int data){
        this.data[row][col] = data; // data value given set to instance value at given position
    }

    /**
     * gets the number of rows in instance matrix
     * @return number of rows
     */
    public int getRows(){
        return this.rows; // returns number of rows
    }

    /**
     * gets the number of columns in an instance matrix
     * @return number of columns
     */
    public int getCols(){
        return this.cols; // return number of columns
    }

    /**
     * gets all the data of an instance matrix
     * @return values from a 2D array
     */
    public double[][] getData(){
        return this.data; // returns all data in instance matrix
    }

    /**
     * override of getData with given inputs of row value and column value
     * @param row number of rows
     * @param col number of columns
     * @return data value at that row and column number
     */
    public double getData(int row, int col){
        return data[row][col]; // returns instance value at given position
    }

    /**
     * Checks two instance matrices to see if they are equal or not through dimensions and values
     * @param m Matrix to see if equal against
     * @return boolean that shows if matrices are equal or not in a true/false statement
     */
    public boolean equals(Matrix m){
        boolean is_equal = true; // default value of is_equal set to true, then ran through tests for validity
        if(this.rows != m.rows || this.cols != m.cols){ // if rows or columns of two matrices are not the same...
            is_equal = false; // the two matrices cannot be equal
            return is_equal; // return boolean
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // Loop through 2D matrices to check if values at [i][j] position are the same
                if(this.data[i][j] != m.data[i][j]){ // if a value of original matrix doesnt equal that of input...
                    is_equal = false; // cannot be equal
                    return is_equal; //  return boolean
                }
            }
        }

        return is_equal; // if all tests pass then return is equal as true
    }

    /**
     * With given input size creates a new matrix with 1's on the diagonal which would be
     * an identity matrix. Made this static as it doesn't take any already created matrix to
     * actually do and as long as given size will always produce a newly made matrix anyway.
     * @param size the size of the identity matrix wanted
     * @return the identity matrix
     */
    public static Matrix identity(int size){
        Matrix m = new Matrix(size,size); // create a new matrix for output and to put value of 1 into
        for(int i=0;i<size;i++){ // for loop to go through each value
            m.setData(i,i,1); // at [i][i], which is diagonal, put value of 1
        }
        return m; // return identity matrix
    }

    /**
     * takes a given bounds (rows and columns) and strips the other outside the bounds off the matrix
     * @param row number of rows wanted
     * @param col number of columns wanted
     * @return new matrix with smaller bounds from original
     */
    public Matrix subMatrix(int row, int col){
        Matrix id = new Matrix(row,col); // create a new matrix for output and to set values in
        double[][] d = new double[row][col]; // create new 2D array to put into matrix after getting values needed
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){ // Loop through original 2D array
                d[i][j] = this.data[i][j]; // set data from original into new smaller array
            }
        }
        id.setData(d); // put data from 2D array into the matrix
        return id; // return matrix
    }


    // End of must implement


    // Adding

    /**
     * adds two matrices together after checking to make sure both are same dimensions otherwise
     * tell user they are not the same dimensions and return problem matrix
     * @param m the matrix to add from
     * @return new matrix with added values from both original and input
     */
    public Matrix add(Matrix m){
        Matrix added = new Matrix(rows, cols); // New matrix "added" which will contain result values
        double[][] d = new double[rows][cols]; // 2D array that will be put into the added matrix
        if(rows != m.rows && cols != m.cols){ // if matrices dont have same dimensions fail the method
            System.out.println("Matrices must have same dimensions"); // give user info on what happened
            return m; // return problem matrix
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // nested loop to go through 2D array
                d[i][j] = this.data[i][j] + m.data[i][j]; // set added value to each position in d 2D array
            }
        }
        added.setData(d); // put 2D array into new matrix
        return added; // return added matrix
    }

    /**
     * static method add that can be called by using the class name followed by the two matrices wanting
     * to be added together.
     * @param m matrix one of the two needed to add together
     * @param n matrix two of the two needed to add together
     * @return new matrix with added values of input matrices
     */
    public static Matrix add(Matrix m, Matrix n){
        Matrix added = new Matrix(m.rows, m.cols); // New matrix "added" which will contain result values
        double[][] d = new double[m.rows][m.cols]; // 2D array that will be put into the added matrix
        if(m.rows != n.rows && m.cols != n.cols){ // if matrices dont have same dimensions fail the method
            System.out.println("Matrices must have same dimensions"); // give user info on what happened
            return m; // return problem matrix
        }
        for(int i=0;i<m.rows;i++){
            for(int j=0;j<m.cols;j++){ // nested loop to go through 2D array
                d[i][j] = m.data[i][j] + n.data[i][j]; // set added value to each position in d 2D array
            }
        }
        added.setData(d); // put 2D array into new matrix
        return added; // return added matrix
    }

    /**
     * applies addition to two matrices and then applies it to the original matrix
     * @param m matrix to add from
     */
    public void addInPlace(Matrix m){
        if(rows != m.rows && cols != m.cols){ // if matrices dont have same dimensions fail the method
            System.out.println("Matrices must have same dimensions"); // give user info on what happened
            return; // break out of the method if they do not equal
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // nested loop to go through 2D array
                this.data[i][j] += m.data[i][j]; // set instance 2d array as added together
            }
        }
    }


    // Subtracting

    /**
     * subtracts two matrices together and returns it as a new matrix otherwise if matrices are
     * not same dimensions will return problem matrix to user
     * @param m matrix to subtract from
     * @return new matrix with subtracted values
     */
    public Matrix subtract(Matrix m){
        Matrix sub = new Matrix(rows,cols); // New matrix "sub" which will contain result values
        double[][] d = new double[rows][cols]; // 2D array that will be put into the added matrix
        if(this.rows != m.rows && this.cols != m.cols){ // if matrices dont have same dimensions fail the method
            System.out.println("Matrices must have same dimensions"); // give user info on what happened
            return m; // return problem matrix
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // nested loop to go through 2D array
                d[i][j] = this.data[i][j] - m.data[i][j]; // set sub value to each position in d 2D array
            }
        }
        sub.setData(d); // put 2D array into new matrix
        return sub; // return sub matrix
    }

    /**
     * static method subtract can be called using the class name followed by the two matrices wanting
     * to be subtracted from one another.
     * @param m matrix one of two needed to subtract from each other
     * @param n matrix two of two needed to subtract from each other
     * @return new matrix with subtracted values from input matrices
     */
    public static Matrix subtract(Matrix m, Matrix n){
        Matrix added = new Matrix(m.rows, m.cols); // New matrix "subtracted" which will contain result values
        double[][] d = new double[m.rows][m.cols]; // 2D array that will be put into the subtracted matrix
        if(m.rows != n.rows && m.cols != n.cols){ // if matrices dont have same dimensions fail the method
            System.out.println("Matrices must have same dimensions"); // give user info on what happened
            return m; // return problem matrix
        }
        for(int i=0; i<m.rows;i++){
            for(int j=0;j<m.cols;j++){ // nested loop to go through 2D array
                d[i][j] = m.data[i][j] - n.data[i][j]; // set subtracted value to each position in d 2D array
            }
        }
        added.setData(d); // put 2D array into new matrix
        return added; // return added matrix
    }

    /**
     * applies subtraction to two matrices and then applies it to the original matrix
     * @param m matrix to subtract from
     */
    public void subtractInPlace(Matrix m){
        if(rows != m.rows && cols != m.cols){ // if matrices dont have same dimensions fail the method
            System.out.println("Matrices must have same dimensions"); // give user info on what happened
            return; // break out of the method if they do not equal
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // nested loop to go through 2D array
                this.data[i][j] -= m.data[i][j]; // set instance 2d array as added together
            }
        }
    }


    // Scalar Multiplication

    /**
     * multiplies any matrix by given scalar integer
     * @param x scalar number to multiply by
     * @return new matrix with multiplied values from original matrix and input scalar
     */
    public Matrix scalarMultiply(int x){
        Matrix m = new Matrix(rows,cols); // set new matrix for result values
        double[][] d = new double[rows][cols]; // new 2D array that will contain values that have been multiplied
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // Loop through 2D array for each value
                d[i][j] = this.data[i][j] * x; // value at i,j is multiplied by scalar input and put into d @ i,j
            }
        }
        m.setData(d); // put 2D array into new matrix
        return m; // return new matrix
    }

    /**
     * Static method for the scalar multiplication with inputs of Matrix and constant value
     * @param x the scalar multiple
     * @param m the matrix to do scalar multiplication on
     * @return new matrix with multiplied values
     */
    public static Matrix scalarMultiply(int x, Matrix m){
        Matrix multiplied = new Matrix(m.rows,m.cols); // New matrix "multiplied" which will contain multiplied values
        double[][] d = new double[m.rows][m.cols]; // 2D array to put new values in
        for(int i=0;i<m.rows;i++){
            for(int j=0;j<m.cols;j++){ // looping through 2D array of input matrix
                d[i][j] = m.data[i][j] * x; // data of input matrix @ i,j multiplied by scalar x is put into new 2D array
            }
        }
        multiplied.setData(d); // put new values into new matrix
        return multiplied; // return new matrix
    }

    /**
     * multiplies original matrix by input value and sets the original data to newly multiplied data
     * @param x as the scalar to multiply by
     */
    public void scalarMultiplyInPlace(int x){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ // Loop through 2D array for each value
                this.data[i][j] *= x; // value at i,j is multiplied by scalar input and set to originals data
            }
        }
    }

    // Matrix Multiplication

    /**
     * Takes two matrices checks if their rows and columns are the same, if so continues to do
     * matrix multiplication on them.
     * @param m matrix to multiply by
     * @return new matrix with matrix-multiplied values
     */
    public Matrix multiply(Matrix m){
        Matrix multiplied = new Matrix(this.rows,m.cols); // create new matrix with originals rows and inputs columns
        double[][] d = new double[this.rows][m.cols]; // create new 2D array that will hold new data
        if(this.cols != m.rows){ // check if columns equal rows
            System.out.println("Columns of first matrix must equal that of the rows in the second matrix.");
            return m;
        }
        for(int i=0;i<rows;i++){ // loop through originals rows [Notebook for more info]
            for(int j=0;j<m.cols;j++){ // loop through others columns
                for(int k=0;k<cols;k++){ // loop through originals cols
                    d[i][j] += this.data[i][k] * m.data[k][j]; // set new data as: original @ i,k * other @ k,j
                }
            }
        }
        multiplied.setData(d); // set new data into
        return multiplied; // return new matrix
    }

    /**
     * Static method of multiply that takes two matrices as input and does matrix multiplication to them
     * @param m matrix one of two needed for matrix-multiplication
     * @param n matrix two of two needed for matrix-multiplication
     * @return new matrix with values from input matrices from matrix-multiplication
     */
    public static Matrix multiply(Matrix m, Matrix n){
        Matrix multiplied = new Matrix(m.rows,n.cols); // create new matrix with originals rows and inputs columns
        double[][] d = new double[m.rows][n.cols]; // create new 2D array that will hold new data
        if(m.cols != n.rows){ // check if columns equal rows
            System.out.println("Columns of first matrix must equal that of the rows in the second matrix.");
            return m; // prompt user and return problem matrix
        }
        for(int i=0;i<m.rows;i++){ // loop through originals rows [Notebook for more info]
            for(int j=0;j<n.cols;j++){ // loop through others columns
                for(int k=0;k<m.cols;k++){ // loop through originals cols
                    d[i][j] += m.data[i][k] * n.data[k][j]; // set new data as: original @ i,k * other @ k,j
                }
            }
        }
        multiplied.setData(d); // set new data into
        return multiplied; // return new matrix
    }

    /**
     * Multiplies two matrices together and sets the originals values as the multiplied value
     * @param m matrix as matrix to multiply by
     */
    public void multiplyInPlace(Matrix m){
        double[][] d = new double[this.rows][m.cols]; // create new 2D array that will hold new data
        if(this.cols != m.rows){ // check if columns equal rows
            System.out.println("Columns of first matrix must equal that of the rows in the second matrix.");
            return; // break out of method if it fails
        }
        for(int i=0;i<rows;i++){ // loop through originals rows [Notebook for more info]
            for(int j=0;j<m.cols;j++){ // loop through others columns
                for(int k=0;k<cols;k++){ // loop through originals cols
                    d[i][j] += this.data[i][k] * m.data[k][j]; // set new data as: original @ i,k * other @ k,j
                }
            }
        }
        this.setData(d); // set new data into original matrix
    }


    // To String Method Override

    /**
     * toString
     * Takes the instance Matrix and outputs it to the screen in a readable fashion
     * string object of the 2d array matrix
     */
    public String toString() {
        double[][] d = data; // Created to return the string of the 2d array
        for (int i=0;i<rows; i++){ // to loop through "rows" of the matrix
            System.out.print("["); // Brace for better readability
            for(int j=0;j<cols; j++){ // to loop through "columns" of the matrix
                System.out.print(data[i][j]); // print the value in the matrix at i,j
                if(j< cols -1){ // at the end of the "column" add a "," for better readability
                    System.out.print(", ");
                }
            }
            System.out.println("]"); // after j is looped through add brace for better readability
        }
        return Arrays.deepToString(d); // suggested through intelliJ to do, returns string type of 2d array
    }
}
