public class Button {

    private boolean hasAPlayInIt = false;
    private char charInIt = '\0';
    private String name;

    Button(String name) {

        this.name = name;

    }

    public boolean AddPlay(Shift shift) {

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

    public char getCharInIt() {

        return charInIt;

    }

    public String getName() {

        return name;

    }

    public boolean getHasAPlayInIt() {

        return hasAPlayInIt;

    }
}
