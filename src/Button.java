public class Button {

    /*
    * Creates a boolean type variable called hasAPlayInIt with the value of false
    * Creates a char type variable called charInIt
    * Creates a String type variable called name
    * */
    private boolean hasAPlayInIt = false;
    private char charInIt = '\0';
    private String name;

    /*
    * Constructor that receives a string
    * */
    Button(String name) {

        /*
        * Set the value of the string received on the object name variable
        * */
        this.name = name;

    }

    /*
    * Adds a play to the object and receives a Shift type variable
    * */
    public boolean AddPlay(Shift shift) {

        /*
        * Checks if this object has already a play, and if so:
        * - Returns false
        * Checks if the shift received as parameter has a par counter, and if so:
        * - Set the value of the charInIt variable as 'O'
        * If the shift received as parameter has an odd counter:
        * - Set the value of the charInIt variable as 'X'
        * Set the value of the hasAPlayInIt variable as true
        * Return true
        * */
        if (hasAPlayInIt) {

            return false;

        }

        if (shift.getShiftCounter() % 2 == 0) {

            charInIt = 'O';

        } else {

            charInIt = 'X';

        }

        hasAPlayInIt = true;
        return true;

    }

    /*
    * Get character in the object
    * */
    public char getCharInIt() {

        /*
        * Return the value of the charInIt variable
        * */
        return charInIt;

    }

    /*
    * Get name of the object
    * */
    public String getName() {

        /*
         * Return the value of the name variable
         * */
        return name;

    }

    /*
    * Get if the object has already a play in it
    * */
    public boolean getHasAPlayInIt() {

        /*
         * Return the value of the hasAPlayInIt variable
         * */
        return hasAPlayInIt;

    }

}
