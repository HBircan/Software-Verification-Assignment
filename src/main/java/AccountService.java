public class AccountService {
    /**
     * Validates account registration data.
     * Note: Current Year is assumed to be 2026 per project requirements.
     */
    public String validateSubmission(String firstName, String lastName, String email,
                                     String dob, String password, String confirmPassword) {

        // 1. Validate Name
        if (firstName == null || firstName.trim().isEmpty()) {
            return "First Name is required";
        }
        if (firstName.length() > 50) {
            return "Invalid Name Length";
        }

        // 2. Validate Email
        if (email == null || !email.contains("@")) {
            return "Invalid Email Format";
        }

        // 3. Validate Password Match
        if (password == null || !password.equals(confirmPassword)) {
            return "Passwords do not match";
        }

        // 4. Validate Password Strength (Min 8 characters)
        if (password.length() < 8) {
            return "Password too short";
        }

        // 5. Validate Age (BVA requirements: 18 - 120 years old)
        // Expected dob format: "dd/mm/yyyy" (e.g., "01/01/2000")
        try {
            if (dob == null || dob.length() < 10) {
                return "Invalid Date Format";
            }

            // Extract the year from the end of the string
            int birthYear = Integer.parseInt(dob.substring(6));
            int currentYear = 2026;
            int age = currentYear - birthYear;

            if (age < 18) {
                return "User must be at least 18 years old";
            }
            if (age > 120) {
                return "Invalid Age";
            }
        } catch (Exception e) {
            return "Invalid Date Format";
        }

        // If all checks pass
        return "SUCCESS";
    }
}
