import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the base change class
 */
public class BaseChangeGUIController {
    @FXML private Label curr_base_label; // label identifying current base type
    @FXML private Label converted_base_label; // label identifying desired base type
    @FXML private Label current_number_label; // label identifying current value
    @FXML private Label converted_number_label; // label identifying desired value

    @FXML private ChoiceBox<String> curr_base_box = new ChoiceBox<>(); // went with choice box to avoid invalid base type (unless one isn't chosen)
    @FXML private ChoiceBox<String> converted_base_box = new ChoiceBox<>(); // same with converted base type
    @FXML private TextField input_value; // text field containing value of input
    @FXML private TextField output_value; // text field containing converted value of input

    private String input_type; // string that contains current base type
    private String output_type; // string that contains desired base type
    private String value; // value of input number or value if hexadecimal

    ObservableList<String> bases = FXCollections.observableArrayList("Hexadecimal","Binary","Decimal","Octal"); // box choice of base types available

    /**
     * initialization of the window for a javafx, setting the text of labels and items of choice box's
     */
    public void initialize(){
        curr_base_label.setText("Current Base");
        converted_base_label.setText("Converted Base");
        current_number_label.setText("Current Number");
        converted_number_label.setText("Converted Number");

        curr_base_box.setItems(bases);
        converted_base_box.setItems(bases);

        curr_base_box.setValue("Choose one");
        converted_base_box.setValue("Choose one");

    }

    /**
     * action to take when convert button is pressed
     */
    public void convertBaseButtonPressed() {
        input_type = curr_base_box.getValue(); // set value to whatever is selected from option box
        output_type = converted_base_box.getValue(); // set value to whatever is selected from option box
        value = input_value.getText(); // set value of whatever is input into text box
        output_value.setText(toHandle(input_type,output_type,value)); // set the output text to whatever input parameters are with converted number
    }

    /**
     * toHandle method that organizes and finds correct method to use based on input base and desired base
     * @param it input type
     * @param dt desired type
     * @param val value of what user wants changed
     * @return string value of converted base of input value
     */
    private String toHandle(String it, String dt, String val){
        String var = it + "-" + dt;
        switch(var){
            // all hexadecimal cases
            case "Hexadecimal-Binary": return hexToBin(val);
            case "Hexadecimal-Decimal": return hexToDec(val);
            case "Hexadecimal-Octal": return hexToOct(val);

            // all binary cases
            case "Binary-Decimal": return binToDec(val);
            case "Binary-Hexadecimal": return binToHex(val);
            case "Binary-Octal": return binToOct(val);

            // all decimal cases
            case "Decimal-Binary": return decToBin(val);
            case "Decimal-Hexadecimal": return decToHex(val);
            case "Decimal-Octal": return decToOct(val);

            // all octal cases
            case "Octal-Binary": return octToBin(val);
            case "Octal-Hexadecimal": return octToHex(val);
            case "Octal-Decimal": return octToDec(val);

            // all same base cases
            case "Hexadecimal-Hexadecimal": return checkValidity(val);
            case "Binary-Binary": return checkValidity(val);
            case "Decimal-Decimal": return checkValidity(val);
            case "Octal-Octal": return checkValidity(val);

            default:
                output_value.setText("invalid base"); // set text of output value text box to error
                return "invalid base."; // handle invalid output base
        }
    }

    //------------------------------
    // All Hexadecimal to X methods
    //------------------------------
    /**
     * gets the hexadecimal value and returns the binary value of input
     * @param s Hexadecimal value
     * @return binary value
     */
    private String hexToBin(String s){
        StringBuilder bin_builder = new StringBuilder(); // start a string builder to hold values of the binary type and be able to add more values to it
        char[] c = s.toCharArray(); // create a character array to check each value of the string
        for (int i=0;i<s.length();i++) { // loop through new character array
            int dec; // variable to store current hexadecimal value as decimal value
            if (c[i] >= '0' && c[i] <= '9') { // check if char @ i is between 0 - 9
                dec = c[i] - '0'; // converts character to numeric value
            } else if (c[i] >= 'A' && c[i] <= 'F') { // check if char @ i is between A - F alphabetically
                dec = c[i] - 'A' + 10; // convert to numeric value between 10-15
            } else if (c[i] >= 'a' && c[i] <= 'f') { // check if char @ i is between a - f alphabetically
                dec = c[i] - 'a' + 10; // convert to numeric value between 10-15
            } else { // if char @ i is not a valid hexadecimal value
                return "invalid hexadecimal value"; // handle
            }

            StringBuilder binary_string = new StringBuilder(); //
            for (int j=3;j>=0;j--){ // from 3 down to 0 | 4 section value of a binary number
                int shift_val = dec >> j; // move dec right by j position
                int bit = shift_val & 1; // isolate the least significant bit & with 1 | extracts last bit of shifted value
                binary_string.append(bit); // append either the 0 or 1 to the string builder
            }

            bin_builder.append(binary_string); // Append the 4-bit binary representation
        }

        return bin_builder.toString(); // send back string value of built string
    }

    /**
     * turns hexadecimal value into a decimal value
     * @param s hexadecimal value
     * @return decimal value
     */
    private String hexToDec(String s){
        int v = 0; // total value of decimal
        int p = 0; // position number to represent power of for hexadecimal value

        for (int i=s.length()-1;i>=0;i--) { // loop through hexadecimal string from right to left
            char hex = s.charAt(i); // hexadecimal character @ pos i
            int dec; // current decimal value

            if (hex >= '0' && hex <= '9') { // checks if char @ i is between 0 - 9
                dec = hex - '0'; // turn char @ i to decimal eq
            } else if (hex >= 'A' && hex <= 'F') { // checks if char @ i is between A - F
                dec = hex - 'A' + 10; // turn char @ i to decimal eq for uppercase
            } else if (hex >= 'a' && hex <= 'f') { // checks if char @ i is between a - f
                dec = hex - 'a' + 10; // turn char @ i to decimal eq for lowercase
            } else {
                return "Invalid hexadecimal string"; // if character isn't a valid hexadecimal value then return not valid
            }

            v += dec * Math.pow(16, p); // value is 16^p where p is the position of the char
            p++; // increase power as position is decreased
        }

        return String.valueOf(v); // return value of total decimal
    }

    /**
     * turns a hexadecimal value into a octal value and returns that to the screen
     * @param s hexadecimal value
     * @return octal value
     */
    private String hexToOct(String s){
        int v = 0; // total decimal value of the hexadecimal input
        int p = 0; // position of hexadecimal char used for power of 16

        for (int i=s.length()-1;i>=0;i--) { // loops through hexadecimal string
            char hex = s.charAt(i); // hexadecimal character @ pos i
            int dec; // decimal value

            if (hex >= '0' && hex <= '9') { // checks if char @ i is between 0 - 9
                dec = hex - '0'; // turn char @ i to decimal eq
            } else if (hex >= 'A' && hex <= 'F') { // checks if char @ i is between A - F
                dec = hex - 'A' + 10; // turn char @ i to decimal eq for uppercase
            } else if (hex >= 'a' && hex <= 'f') { // checks if char @ i is between a - f
                dec = hex - 'a' + 10; // turn char @ i to decimal eq for lowercase
            } else {
                return "Invalid hexadecimal string"; // if character isn't a valid hexadecimal value then return not valid
            }

            v += dec * Math.pow(16, p);
            p++;
        } // end of loop should have decimal value of hexadecimal value

        StringBuilder octal_string = new StringBuilder(); // start a octal string builder to make the octal string
        while(v>0){ // while current decimal value is greater then 0
            octal_string.insert(0, v%8); // inserts the least significant digit from right to left by finding remainder
            v /= 8; // shifts v to right by base 8
        }

        return octal_string.toString(); // returns string value of base 8 value
    }


    //------------------------------
    // All Binary to X methods
    //------------------------------
    /**
     * takes a binary string and converts it to decimal form
     * @param s binary value
     * @return decimal value
     */
    private String binToDec(String s){
        int v = 0; // decimal value eq of binary
        int p = 0; // place value to power of base 2 (2^p)

        for (int i=s.length()-1;i>=0;i--) { // loop from right to left through
            char bin = s.charAt(i); // binary value @ pos i

            if (bin == '1') { // either 1 or 0 since its binary
                v += Math.pow(2, p); // if one then get 2^p and add it to total decimal value
            } else if (bin != '0') { // handles if binary value isnt 1 or 0
                return "Invalid Binary Value";
            }
            p++; // increment p for each position backwards in "char array"
        }

        return String.valueOf(v); // return total decimal value from input binary value
    }

    /**
     * takes a binary value and converts it to hexadecimal form
     * @param s binary value
     * @return hexadecimal value
     */
    private String binToHex(String s){
        int v = 0; // decimal value eq of binary
        int p = 0; // place value to power of base 2

        for (int i=s.length()-1;i>=0;i--) { // loop through from right to left
            char bin = s.charAt(i); // binary value @ pos i

            if (bin == '1') { // either going to be 1 or 0 since binary
                v += Math.pow(2, p); // v increments based on 2^p if bin is a 1
            } else if (bin != '0') { // handles if binary value isnt 1 or 0
                return "Invalid Binary Value";
            }
            p++; // increment p for each position backwards in "char array"
        }

        StringBuilder hex_string = new StringBuilder(); // new string builder to make the hexadecimal value
        char[] hex_characters = "0123456789ABCDEF".toCharArray(); // create an array with all base 16 values

        while(v > 0){ // loop through the decimal value of the binary value that was calculated previously
            int r = v % 16; // get the remainder of each value
            hex_string.insert(0,hex_characters[r]); // insert the character @ the remainder position
            v /= 16; // divide by base 16
        }

        return hex_string.toString(); // return string value of string builder that holds the new hexadecimal value
    }

    /**
     * takes a binary value and converts it to octal
     * @param s binary value
     * @return octal value
     */
    private String binToOct(String s){
        int v = 0; // decimal value eq of binary
        int p = 0; // place value to power of base 2

        for (int i=s.length()-1;i>=0;i--) { // loop through binary from right to left
            char bin = s.charAt(i); // binary value @ pos i

            if (bin == '1') { // either 1 or 0 b/c binary
                v += Math.pow(2, p); // v increments based on 2^p if bin is 1
            } else if (bin != '0') { // handles if binary value isn't 1 or 0
                return "Invalid Binary Value";
            }
            p++; // increment p per position i in binary string
        }

        StringBuilder octal_string = new StringBuilder(); // create an octal string builder to make the octal string
        while(v > 0){ // while the decimal value is above 0
            int r = v % 8; // get the remainder
            octal_string.insert(0,r); // put remainder at the least significant position
            v /= 8; // divide by 8 to get next, the least significant digit
        }

        return octal_string.toString(); // return string value of octal value
    }


    //------------------------------
    // All Decimal to X methods
    //------------------------------
    /**
     * takes a decimal value as string and returns a binary value equivalent
     * @param s decimal value
     * @return binary value
     */
    private String decToBin(String s){
        try {
            int v = Integer.parseInt(s); // try to parse decimal string
            if (v == 0) return "0"; // if decimal value is 0 so is binary value

            StringBuilder bin_string = new StringBuilder(); // make a new string builder to hold binary string

            while (v > 0) { // while the decimal value is above 0
                int r = v % 2; // get remainder of converted base value (2)
                bin_string.insert(0, r); // set the remainder to the far right of the string builder
                v /= 2; // divide by base (2)
            }

            return bin_string.toString(); // return binary string to user

        } catch (NumberFormatException e){ // if cant parse string as integer then not a decimal value
            return "not a decimal value"; // return to user
        }
    }

    /**
     * takes a decimal string value and returns a hexadecimal equivalent
     * @param s decimal value
     * @return hexadecimal
     */
    private String decToHex(String s){
        try{
            int v = Integer.parseInt(s); // try to parse input string as an integer
            if (v == 0) return "0"; // if decimal value is 0 then hex value is 0

            StringBuilder hex_string = new StringBuilder(); // initialize new string builder for hex string value
            char[] hex_char = "0123456789ABCDEF".toCharArray(); // create new array of hexadecimal values

            while (v > 0) { // while decimal value is above 0
                int r = v % 16; // get remainder by dividing by base value (16)
                hex_string.insert(0, hex_char[r]); // set the hex character at that remainder value to the far right in string builder
                v /= 16; // divide by base value (16)
            }

            return hex_string.toString(); // return hexadecimal string value

        } catch (NumberFormatException e){ // if input isn't an integer its not a decimal value
            return "not a decimal value"; // return error to user
        }
    }

    /**
     * takes a decimal value string and returns an on octal value equivalent
     * @param s decimal value
     * @return octal value
     */
    private String decToOct(String s){
        try {
            int v = Integer.parseInt(s); // try to parse string value as integer
            if (v == 0) return "0"; // if decimal value is 0 then so is octal value

            StringBuilder oct_string = new StringBuilder(); // create new string builder to hold octal value

            while (v > 0) { // while the decimal value is greater then 0
                int r = v % 8; // get remainder of base (8)
                oct_string.insert(0, r); // set remainder to far right of string builder position
                v /= 8; // divide by base (8)
            }

            return oct_string.toString(); // return the octal value as a string to user
        } catch (NumberFormatException e){ // if not an integer then not a decimal value
            return "not a decimal value"; // return error to the user
        }
    }


    //------------------------------
    // All Octal to X methods
    //------------------------------
    /**
     * takes a octal value and returns the decimal value equivalent
     * @param s octal value
     * @return decimal value
     */
    private String octToDec(String s){
        int v = 0; // decimal value eq of octal
        int p = 0; // power position (8^p)

        for (int i=s.length()-1;i>=0;i--) { // loop through octal input from right to left
            char oct = s.charAt(i); // set oct to each character @ pos i

            if (oct<'0' || oct>'7') { // check to see if it't a valid octal input
                return "not a valid octal value";
            }

            int val = oct - '0'; // subtract the current octal value @ pos i from char 0 to get octal value
            v += val * Math.pow(8, p); // take octal value multiplied by base (8) to the pos power of (^p) [octal * 8^p]
            p++; // increment power position
        }

        return String.valueOf(v); // return string value of decimal value eq of octal value
    }

    /**
     * takes an octal value and returns the binary equivalent
     * @param s octal value
     * @return binary value
     */
    private String octToBin(String s){
        int v = 0; // decimal value eq of octal
        int p = 0; // power position of base 8

        for (int i=s.length()-1;i>=0;i--) { // loop through octal value from right to left
            char oct = s.charAt(i); // octal character value @ pos i

            if (oct<'0' || oct>'7') { // if not a valid octal value
                return "not a valid octal value";
            }

            int val = oct - '0'; // get the integer value of octal character
            v += val * Math.pow(8, p); // increment v based on octal value times base value to power of p
            p++; // increment p per position
        } // have decimal value here

        StringBuilder bin_string = new StringBuilder(); // create new string builder to hold binary value
        while (v > 0) { // while decimal value is greater then 0
            int r = v % 2; // get remainder of decimal divided binary base (2)
            bin_string.insert(0, r); // set reminder to far right position in string builder
            v /= 2; // divide v by 2 and set it
        }

        return bin_string.length() > 0 ? bin_string.toString() : "0";
    }

    /**
     * takes an octal value and converts it to a hexadecimal value
     * @param s octal value
     * @return hexadecimal value
     */
    private String octToHex(String s){
        int v = 0; // decimal value eq of octal
        int p = 0; // power position holder

        for (int i=s.length()-1;i>=0;i--) { // loop through octal array from right to left
            char oct = s.charAt(i); // octal value @ pos i in octal string

            if (oct<'0' || oct>'7') { // check if its a valid octal value
                return "not a valid octal value"; // if not then return that its not an octal
            }

            int val = oct - '0'; // set integer value of octal character
            v += val * Math.pow(8, p); // increment v from octal integer value times base 8 to power of p position
            p++; // increment p as check goes form right to left
        }

        StringBuilder hex_string = new StringBuilder(); // create a new string builder to get string value of hex eq.
        char[] hex_char = "0123456789ABCDEF".toCharArray(); // set a new char array with all valid hex characters

        while (v > 0) { // as long as decimal value is greater then 0
            int r = v % 16; // get remainder of base wanted (16)
            hex_string.insert(0, hex_char[r]); // put remainder in string builder from right to left
            v /= 16; // divide by base 16 to "shift" value by the base
        }

        return hex_string.toString(); // if its over 0 then return hex_string
    }

    //------------------------------
    // Helper Methods
    //------------------------------
    /**
     * takes any base value as input and checks if it's a valid value for that specific base
     * @param s base value
     * @return validity of base value
     */
    private String checkValidity(String s){
        try{
            if(this.input_type.equals("Binary") || this.input_type.equals("Octal") || this.input_type.equals("Decimal")){
                int v = Integer.parseInt(s); // check to see if input is a valid integer value
                String sval = Integer.toString(v); // put parsed integer back into string form

                if(this.input_type.equals("Binary")){ // for a binary input base
                    for(int i=0;i<sval.length();i++){ // loop through value array
                        char bin = sval.charAt(i); // set bin to the character at that position
                        if(bin>'1' || bin<'0'){ // if its ever bigger than 1 or less than 0 then its not a binary value
                            return "not a binary value";
                        }
                    }
                }
                if(this.input_type.equals("Octal")){ // for an octal input base
                    for(int i=0;i<sval.length();i++){ // loop through value array
                        char oct = sval.charAt(i); // set oct to the character at that position
                        if(oct>'8' || oct<'0'){ // if its ever bigger than 8 or less than 0 then its not an octal value
                            return "not a octal value";
                        }
                    }
                }
                if(this.input_type.equals("Decimal")){ // for a decimal input base
                    for(int i=0;i<sval.length();i++){ // loop through value array
                        char dec = sval.charAt(i); // set dec to the character at that position
                        if(dec>'9' || dec<'0'){ // if it's ever bigger than 9 or less than 0 then its not a decimal value
                            return "not a decimal value";
                        }
                    }
                }
                return Integer.toString(v);
            } else if (this.input_type.equals("Hexadecimal")){
                int v = 0; // decimal value of hexadecimal input
                int p = 0; // to the power of for position value (16^p)
                for (int i=s.length()-1;i>=0;i--) { // loops through hexadecimal string from right to left
                    char hex = s.charAt(i); // hexadecimal character @ pos i
                    int dec; // decimal value

                    if (hex >= '0' && hex <= '9') { // checks if char @ i is between 0 - 9
                        dec = hex - '0'; // turn char @ i to decimal eq
                    } else if (hex >= 'A' && hex <= 'F') { // checks if char @ i is between A - F
                        dec = hex - 'A' + 10; // turn char @ i to decimal eq for uppercase
                    } else if (hex >= 'a' && hex <= 'f') { // checks if char @ i is between a - f
                        dec = hex - 'a' + 10; // turn char @ i to decimal eq for lowercase
                    } else {
                        return "not a valid hexadecimal value"; // if character isn't a valid hexadecimal value then return not valid
                    }

                    v += dec * Math.pow(16, p); // decimal value incremented by the wanted base to the power of p
                    p++; // increase power position per element position
                } // end of loop should have decimal value of hexadecimal value
            } else {
                return "pick a type"; // if no base is given return to user
            }
        } catch (NumberFormatException e){
            return "not a valie " + this.input_type + " value"; // if not an integer for one of integer based bases
        }
        return s; // return the value back
    }
}
