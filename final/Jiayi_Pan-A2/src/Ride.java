import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Amusement facilities
 */
public class Ride implements RideInterface {
    private String name;
    private int capacity;
    private Employee employeeInCharge;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory;


    public Ride() {
        this.name = "";
        this.capacity = 0;
        this.employeeInCharge = null;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }


    public Ride(String name, int capacity, Employee employeeInCharge) {
        this.name = name;
        this.capacity = capacity;
        this.employeeInCharge = employeeInCharge;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    public void setEmployeeInCharge(Employee employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }


    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getName() + " Add to the queue");
    }


    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " Delete from the queue");
        } else {
            System.out.println(visitor.getName() + " Couldn't find it in the queue");
        }
    }


    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The current queue is empty.");
        } else {
            System.out.println("Visitors in line:");
            for (Visitor visitor : queue) {
                visitor.printInfo();
            }
        }
    }


    @Override
    public void runOneCycle() {
        System.out.println("Run a loop:" + name + "Amusement facilities");
        int visitorsToRide = Math.min(queue.size(), capacity);
        for (int i = 0; i < visitorsToRide; i++) {
            Visitor visitor = queue.poll();
            if (visitor != null) {
                addVisitorToHistory(visitor);
                System.out.println(visitor.getName() + " Already on the ride");
            }
        }
    }


    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " Added to ride history");
    }


    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println(visitor.getName() + (found ? " Already in history ":" Not in history"));
        return found;
    }


    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Total number of visitors in historical records: " + count);
        return count;
    }


    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("There's no history.");
        } else {
            System.out.println("History of amusement facilities:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                iterator.next().printInfo();
            }
        }
    }


    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("History sorted:");
        printRideHistory();
    }


    /**
     * Export ride history to a file
     * @param filePath File path
     */
    public void exportRideHistory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if (rideHistory.isEmpty()) {
                System.out.println("The history is empty and no data is exported.");
                return;
            }
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toCSV());
                writer.newLine();
            }
            System.out.println("History successfully exported to file: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while exporting history: " + e.getMessage());
        }
    }

    /**
     * Import ride history from a file
     * @param filePath File path
     */
    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int importedCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String gender = data[2];
                    String membershipType = data[3];
                    Visitor visitor = new Visitor(name, age, gender, membershipType);
                    addVisitorToHistory(visitor);
                    importedCount++;
                } else {
                    System.out.println("The data format is incorrect and cannot be imported: " + line);
                }
            }
            System.out.println("The file has been successfully imported " + importedCount + " A historical record.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("File contains invalid age data: " + e.getMessage());
        }
    }
}

