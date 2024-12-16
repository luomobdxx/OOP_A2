public class AssignmentTwo {
    public static void main(String[] args) {

        AssignmentTwo assignmentTwo = new AssignmentTwo();
//        assignmentTwo.partThree();
//        assignmentTwo.partFourA();
//       assignmentTwo.partFourB();
//        assignmentTwo.partFive();
//        assignmentTwo.partSix();
        assignmentTwo.partSeven();
    }

    public void partThree() {
        Employee emp = new Employee("Jack", 25, "male", "Ride operator", 3000);

        Ride ride = new Ride("Roller coaster", 5, emp);

        // Add 5 visitors to queue
        Visitor visitor1 = new Visitor("Andy", 25, "male", "Ordinary member");
        Visitor visitor2 = new Visitor("Bob", 30, "male", "Premium member");
        Visitor visitor3 = new Visitor("Roy", 22, "female", "Ordinary member");
        Visitor visitor4 = new Visitor("Hank", 28, "male", "VIP member");
        Visitor visitor5 = new Visitor("John", 20, "female", "Ordinary member");
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);


        ride.removeVisitorFromQueue(visitor2);

        ride.printQueue();
    }

    public void partFourA() {
        Employee emp = new Employee("Jack", 25, "male", "Ride operator", 3000);

        Ride ride = new Ride("Roller coaster", 5, emp);

        // Add visitors to history
        Visitor visitor1 = new Visitor("Jack", 25, "male", "Ordinary member");
        Visitor visitor2 = new Visitor("Andy", 30, "male", "Premium member");
        Visitor visitor3 = new Visitor("Bob", 22, "female", "Ordinary member");
        Visitor visitor4 = new Visitor("Hank", 28, "male", "VIP member");
        Visitor visitor5 = new Visitor("John", 20, "female", "Ordinary member");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        // Check if a visitor is in the history
        ride.checkVisitorFromHistory(visitor3); // 王五
        ride.checkVisitorFromHistory(new Visitor("Tom", 30, "male", "Ordinary member"));


        ride.numberOfVisitors();

        ride.printRideHistory();
    }

    public void partFourB() {
        Employee emp = new Employee("Jack", 25, "male", "Ride operator", 3000);

        Ride ride = new Ride("Roller coaster", 5, emp);

        // Add visitors to history
        Visitor visitor1 = new Visitor("Jack", 25, "male", "Ordinary member");
        Visitor visitor2 = new Visitor("Andy", 30, "male", "Premium member");
        Visitor visitor3 = new Visitor("Bob", 22, "female", "Ordinary member");
        Visitor visitor4 = new Visitor("Hank", 28, "male", "VIP member");
        Visitor visitor5 = new Visitor("John", 20, "female", "Ordinary member");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        System.out.println("History before sorting:");
        ride.printRideHistory();

        // Sort the history
        ride.sortRideHistory();
    }

    public void partFive() {
        Employee emp = new Employee("Jack", 25, "Jack", "Ride operator", 3000);
        Ride ride = new Ride("Roller coaster", 10, emp);

        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("tourist" + i, 20 + i, "male", "Ordinary member"));
        }


        System.out.println("Initial queue:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("The queue after running a loop:");
        ride.printQueue();
        System.out.println("History of amusement facilities:");
        ride.printRideHistory();


        String filePath = "ride_history.csv";
        ride.exportRideHistory(filePath);
        Ride newRide = new Ride();
        newRide.importRideHistory(filePath);
        newRide.printRideHistory();
    }

    public void partSix() {
        Employee emp = new Employee("Jack", 25, "male", "Ride operator", 3000);

        Ride ride = new Ride("Pirate ship", 5, emp);

        // Add at least 5 visitors to the ride history
        ride.addVisitorToHistory(new Visitor("Tourist 1", 25, "male", "Ordinary member"));
        ride.addVisitorToHistory(new Visitor("Tourist 2", 30, "female", "Premium member"));
        ride.addVisitorToHistory(new Visitor("Tourist 3", 22, "male", "Ordinary member"));
        ride.addVisitorToHistory(new Visitor("Tourist 4", 28, "female", "Ordinary member"));
        ride.addVisitorToHistory(new Visitor("Tourist 5", 35, "male", "Premium member"));


        String filePath = "ride_history.csv";
        ride.exportRideHistory(filePath);

        System.out.println("Presentation complete. Please check the file " + filePath + " The exported result is in.");
    }

    public void partSeven() {
        Employee emp = new Employee("Jack", 25, "male", "Ride operator", 3000);

        Ride ride = new Ride("Roller coaster", 5, emp);


        String filePath = "ride_history.csv";
        ride.importRideHistory(filePath);


        System.out.println("Total visitors imported:" + ride.numberOfVisitors());


        System.out.println("Imported visitor details:");
        ride.printRideHistory();
    }
}

