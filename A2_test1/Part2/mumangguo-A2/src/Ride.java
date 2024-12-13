import java.util.ArrayList;
import java.util.List;

/**
 * 游乐设施类
 */
public class Ride implements RideInterface {
    private String name;

    private int capacity;

    private Employee employeeInCharge;

    private List<Visitor> queue;

    private List<Visitor> rideHistory;

    public Ride() {
        this.name = "";
        this.capacity = 0;
        this.employeeInCharge = null;
        this.queue = new ArrayList<>();
        this.rideHistory = new ArrayList<>();
    }

    public Ride(String name, int capacity, Employee employeeInCharge) {
        this.name = name;
        this.capacity = capacity;
        this.employeeInCharge = employeeInCharge;
        this.queue = new ArrayList<>();
        this.rideHistory = new ArrayList<>();
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
        if (queue.size() < capacity) {
            queue.add(visitor);
            System.out.println(visitor.getName() + "添加到队列中");
        } else {
            System.out.println("队列已满!");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + "从队列中删除");
        } else {
            System.out.println(visitor.getName() + "在队列中找不到");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("排队的游客:");
        for (Visitor visitor : queue) {
            visitor.printInfo();
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println("运行一个循环" + name + "游乐设施");
        int visitorsToRide = Math.min(queue.size(), capacity);
        for (int i = 0; i < visitorsToRide; i++) {
            Visitor visitor = queue.get(0);
            addVisitorToHistory(visitor);
            queue.remove(0);
            System.out.println(visitor.getName() + "已经上了游乐设施");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + "添加到游乐设施历史中");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("游乐设施历史:");
        for (Visitor visitor : rideHistory) {
            visitor.printInfo();
        }
    }
}

