public class test {

    // check validity of password.
    public static boolean checkPasswordValidity(String password) {
        return (isCorrectLength(password) && containsNumbers(password) && containsNoSpaces(password));
    }

    //password must have at least 10 characters
    private static boolean isCorrectLength(String password) {
        return password.length() > 10;
    }

    //password must have at least 1 number
    private static boolean containsNumbers(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    //password must not have any spaces
    private static boolean containsNoSpaces(String password) {
        return !password.contains(" ");
    }

}
