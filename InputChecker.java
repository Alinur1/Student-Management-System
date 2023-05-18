public final class InputChecker {

    public InputChecker() {

    }

 
    public static boolean CheckInteger(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
        }
        return false;
    }


    public static boolean CheckDouble(final String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

 
    public static boolean CheckFloat(final String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}