
public class SolidPrinciple
{
    /* 
        1. Single Responsibility principle

        A class should have only 1 responsibility, and it should change for only that one responsibilty.

        Benefits : 
        1. Improved Code Readability and Maintainability:
        2. Easier debugging and testing.
        3. Easier to make changes without breaking other functionalities.

    */

    // Here the class has 2 responsibilities and can have a reason to change for either of those.
    public class User_Bad
    {
        void loginUser()
        {
            System.out.println("Logging in user bad");
        }

        void sendEmail()
        {
            System.out.println(("Sending email bad"));
        }
    }

    // Improved version
    public class LoginUser_Good
    {
        void loginUser()
        {
            System.out.println(("login user good"));
        }
    }

    public class Sendmail_good
    {
        void sendEmail()
        {
            System.out.println(("Send the email good"));
        }
    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /*
     * 2. Open Closed Principle ( OCP)
     * Beacon for flexibility and extensibility
     * Should be open for extension but closed for modification
     * 
     * Advantages : 
     * 1. Reduced Risk of Introducing New Bugs - we don't tamper with existing code
     * 2. Easier Maintenance -  ability to extend functionality without modification streamline the maintenance process.
     * 3. Promotes Code Reuse - Each new extension or feature can be built upon existing, well-tested components, accelerating development.
     * 
     */

    
    // Now, let’s say we want to calculate the area of another shape.
    // Now, we need to directly modify this class to add this feature and we would violate the OCP.

    // Updated class violating OCP by modifying existing code
    public class AreaCalculator {
        public double calculateRectangleArea(double width, double height) {
        return width * height;
        }
    
        public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
        }
    
        // New method added for calculating the area of a triangle
        public double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
        }
    }

    //////////////////////////////////////////////////////////////////
    
    // Good code

    // Interface representing a shape
    public interface Shape {
        // implement it for each shape
        double calculateArea();
    }
    
    // Rectangle implementation
    public class Rectangle implements Shape {
        private double width;
        private double height;
    
        public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        }
    
        @Override
        public double calculateArea() {
        return width * height;
        }
    }
    
    // Circle implementation
    public class Circle implements Shape {
        private double radius;
    
        public Circle(double radius) {
        this.radius = radius;
        }
    
        @Override
        public double calculateArea() {
        return Math.PI * radius * radius;
        }
    }
    
    // Triangle implementation
    public class Triangle implements Shape {
        private double base;
        private double height;
    
        public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        }
    
        @Override
        public double calculateArea() {
        return 0.5 * base * height;
        }
    }


    public class AreaCalculator_OCP {
        public double calculateTotalArea(Shape[] shapes) 
        {
            double totalArea = 0;
            for (Shape shape : shapes) 
            {
                totalArea += shape.calculateArea();
            }
            return totalArea;
        }
    }

    // Now, if we have to add a new shape, existing classes will not be modified.
    // Hence, by following the OCP, we have made our code more flexible and adaptable to changes in requirements.
    // New features can be added without modifying existing code, reducing the risk of introducing bugs.





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    /*
     * 3. Liskov Substitution Principle (LSP):
     * 
     * It declares that objects of a superclass should be replaceable with objects of its subclasses 
     * without breaking the program.
     * 
     * Subclasses can be used interchangeably with their parent classes.
     * 
     * Advantages : 
     * 
     * 1. Increased Flexibility in Code Design
     * 2. Easier Code Maintenance
     * 3. Enhanced Code Clarity
    */

     // Bad code example

    public class Bird {
        public void fly() {
            // Flying logic
        }
    }
    
    public class Ostrich extends Bird {
        // Ostriches cannot fly, but they inherit the fly method
    }


    // Good code example

    public abstract class Bird_Liskov {
        public abstract void move();
    }
    
    public class Sparrow extends Bird_Liskov {
        @Override
        public void move() {
            // Flying logic
        }
    }
    
    public class Ostrich_Liskov extends Bird_Liskov {
        @Override
        public void move() {
            // Running logic
        }
    }







    /*
     * 4. Interface Segregation Principle (ISP)
     * 
     * Instead of creating large, all-encompassing interfaces, ISP recommends crafting smaller, client-specific ones
     * 
     * Advantages:
     * 
     * 1. No Implementation of Unnecessary Methods: 
     * 2. Concise and Relevant Interfaces
     */


    // Bad example

    public interface ResturantWorker {
        public void cook();
        public void clean();
    }

    public class Waiter implements ResturantWorker
    {
        @Override
        public void cook()
        {
            // Error waiter shouldn't cook
        }

        @Override
        public void clean()
        {
            // clean the resturant
        }
    }

    public class Cook implements ResturantWorker
    {
        @Override
        public void cook()
        {
            // Cook dishes
        }

        @Override
        public void clean()
        {
            // Error cook should't be cleaning dishes
        }
    }

    // Good example

    public interface ResturantWorker_ISP
    {
        public void markAttendance();
    }

    public class Waiter_ISP implements ResturantWorker_ISP
    {
        @Override
        public void markAttendance()
        {
            // mark the attendance
        }

        public void takeOrder()
        {
            // take the order from tables
        }
    }

    public class Chef_ISP implements ResturantWorker_ISP
    {
        @Override
        public void markAttendance()
        {
            // marking attendance
        }

        public void cookFood()
        {
            // cook food
        }
    }

    


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * 
     * 4. Dependency inversion principle
     * 
     * The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules. 
     * Instead, both should depend on abstractions.
     * This principle promotes the use of interfaces or abstract classes to decouple modules and improve code maintainability.
     * 
     * 
     * 
     * 
     * The DIP promotes the decoupling of software modules by relying on abstractions instead of concrete implementations.
     * By depending on abstractions, high-level modules can be easily replaced or extended without modifying the existing code.
     * 
     * 
     * 
     *  Advantages : 
     * 
     * 1. Reduced couplling
     * 2. Enhanced testing
     * 3. Improved Code Maintainability:
     * 
     * 
     */




    // Bad code

    // High-level module representing a business logic class
    public class BusinessLogic {
        private DatabaseConnection databaseConnection;
    
        public BusinessLogic() {
            this.databaseConnection = new DatabaseConnection();
        }
    
        public void performBusinessLogic() {
        // Using the DatabaseConnection directly
        databaseConnection.connect();
        // Business logic code
        System.out.println("Performing business logic");
        // Using the DatabaseConnection directly
        databaseConnection.disconnect();
        }
    }
    
    // Low-level module representing a database connection class
    public class DatabaseConnection {
        public void connect() {
            System.out.println("Connecting to the database");
        }
    
        public void disconnect() {
            System.out.println("Disconnecting from the database");
        }
    }
    
    // Client code
    public class Client {
        public static void main(String[] args) {
            BusinessLogic businessLogic = new SolidPrinciple().new BusinessLogic();
            businessLogic.performBusinessLogic();
        }
    }


    // In this example, the BusinessLogic class directly creates instances of the DatabaseConnection class 
    // using the new keyword. This violates the DIP because the high-level module (BusinessLogic) 
    // is directly dependent on low-level module (DatabaseConnection).





    // Good code

    // Abstraction representing a connection interface
    public interface Connection {
        void connect();
        void disconnect();
    }

    // High-level module representing a business logic class
    public class BusinessLogic_DIP {
        private Connection connection;

        public BusinessLogic_DIP(Connection connection) {
            this.connection = connection;
        }

        public void performBusinessLogic() {
            // Using the Connection abstraction
            connection.connect();
            // Business logic code
            System.out.println("Performing business logic");
            // Using the Connection abstraction
            connection.disconnect();
        }
    }

    // Low-level module representing a database connection class
    public class DatabaseConnection_DIP implements Connection {
        @Override
        public void connect() {
            System.out.println("Connecting to the database");
        }

        @Override
        public void disconnect() {
            System.out.println("Disconnecting from the database");
        }
    }


    // By introducing the Connection interface, we have decoupled the BusinessLogic class from the 
    // concrete implementation of the database.

    // By following the DIP, we have improved the flexibility and testability of our codebase.
    // High-level modules depend on abstractions, promoting code reuse and making the code easier to maintain.





     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
 * Advantages of SOLID principles
 * 
 * 1. Increased maintainability
 * 2. Increased scalability
 * 3. Improved readability
 * 4. Improved code reusability
 * 5. Ease of testing.
 * 
 * 
 * Disadvantages of SOLID principles
 * 
 * 1. Increased Complexity
 */






    public static void main(String[] args) {
        // User_Bad user = new SingleResponsibility().new User_Bad();;
        // user.loginUser();
        // user.sendEmail();

        LoginUser_Good login= new SolidPrinciple().new LoginUser_Good();
        login.loginUser();

        Sendmail_good sendEmail = new SolidPrinciple().new Sendmail_good();
        sendEmail.sendEmail();

    }
}

 

