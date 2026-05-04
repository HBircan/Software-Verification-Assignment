public class AccountService {

    // This method returns a String message: "Success" or an error message
    public String validateSubmission(String firstName, String lastName, String email,
                                     String dob, String password, String confirmPassword) {

        // 1. Validate Name
        if (firstName == null || firstName.trim().isEmpty()) {
            return "First Name is required";
        }

        // 2. Validate Email (Simple check for '@' for EP testing)
        if (email == null || !email.contains("@")) {
            return "Invalid Email Format";
        }

        // 3. Validate Password Match
        if (password == null || !password.equals(confirmPassword)) {
            return "Passwords do not match";
        }

        // 4. Validate Password Strength 
        if (password.length() < 8) {
            return "Password too short";
        }

        return "SUCCESS";
    }
}
