public class CommissionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales; //must be greater than or equal to 0.0
    private double commissionRate; //must be between 0.0 and 1.0

    //Constructor
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        setgrossSales(grossSales);
        setcommissionRate(commissionRate);
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setgrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross Sales must be greater or equal to 0");
        }
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setcommissionRate(double commissionRate) {
        if (commissionRate < 0.0 || commissionRate > 1.0) {
            throw new IllegalArgumentException("Commission Rate must between 0.0 and 1.o");
        }
        this.commissionRate = commissionRate;
    }

    public double earnings() {
        return grossSales * commissionRate;
    }

    public String toString() {
        return String.format("CommissionEmployee: %s %s\nSSN: %s\nGross Sales: %.2f\nCommission Rate: %.2f",
                firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
    }

    public static void main(String[] args) {
        try {
            //create object
            CommissionEmployee employee = new CommissionEmployee("Elvis", "Boateng", "124-354-67", 5000, 0.2);

            //display details
            System.out.println(employee);

            // Update fields
            employee.setgrossSales(7000);
            employee.setcommissionRate(0.15);

            // Display updated details
            System.out.println("\nUpdated Employee Details:");
            System.out.println(employee);

            // Display earnings
            System.out.printf("\nEarnings: %.2f\n", employee.earnings());

            // Test validations
            System.out.println("\nTesting validations...");
            employee.setgrossSales(-1); // Should throw an exception

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
