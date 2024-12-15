import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 游乐设施类
 */
public class Ride implements RideInterface {
    private String name; // 游乐设施名称
    private int capacity; // 游乐设施容量
    private Employee employeeInCharge; // 负责该设施的员工
    private Queue<Visitor> queue; // 使用队列存储等待中的游客
    private LinkedList<Visitor> rideHistory; // 使用LinkedList存储游乐设施历史记录

    // 默认构造函数
    public Ride() {
        this.name = "";
        this.capacity = 0;
        this.employeeInCharge = null;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // 带参数的构造函数
    public Ride(String name, int capacity, Employee employeeInCharge) {
        this.name = name;
        this.capacity = capacity;
        this.employeeInCharge = employeeInCharge;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getter 和 Setter 方法
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

    // 添加游客到队列
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor); // 添加到队列尾部
        System.out.println(visitor.getName() + " 添加到队列中");
    }

    // 从队列中移除游客
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) { // 如果移除成功
            System.out.println(visitor.getName() + " 从队列中删除");
        } else {
            System.out.println(visitor.getName() + " 在队列中找不到");
        }
    }

    // 打印当前队列中的所有游客
    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("当前队列为空。");
        } else {
            System.out.println("排队的游客:");
            for (Visitor visitor : queue) {
                visitor.printInfo();
            }
        }
    }

    // 运行一个游乐循环
    @Override
    public void runOneCycle() {
        System.out.println("运行一个循环：" + name + " 游乐设施");
        int visitorsToRide = Math.min(queue.size(), capacity); // 最多载入设施容量的游客数量
        for (int i = 0; i < visitorsToRide; i++) {
            Visitor visitor = queue.poll(); // 从队列中移除第一个游客
            if (visitor != null) {
                addVisitorToHistory(visitor); // 添加到历史记录
                System.out.println(visitor.getName() + " 已经上了游乐设施");
            }
        }
    }

    // 添加游客到游乐历史记录
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor); // 添加到历史LinkedList
        System.out.println(visitor.getName() + " 添加到游乐设施历史中");
    }

    // 检查游客是否在历史记录中
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor); // 检查是否存在
        System.out.println(visitor.getName() + (found ? " 已在历史记录中" : " 不在历史记录中"));
        return found;
    }

    // 返回游乐设施的历史游客总数
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("历史记录中的游客总数: " + count);
        return count;
    }

    // 使用Iterator打印游乐设施的历史记录
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("没有历史记录。");
        } else {
            System.out.println("游乐设施历史记录:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                iterator.next().printInfo();
            }
        }
    }

    // 按照游客的姓名和年龄排序历史记录
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator()); // 使用Comparator对历史记录进行排序
        System.out.println("历史记录已排序：");
        printRideHistory(); // 打印排序后的历史记录
    }

    // 导出历史记录到CSV文件
//    public void exportRideHistory(String filePath) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (Visitor visitor : rideHistory) {
//                writer.write(visitor.toCSV());
//                writer.newLine();
//            }
//            System.out.println("历史记录已导出到 " + filePath);
//        } catch (IOException e) {
//            System.out.println("导出历史记录时发生错误：" + e.getMessage());
//        }
//    }

    /**
     * 导出游乐设施历史记录到文件
     * @param filePath 文件路径
     */
    public void exportRideHistory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if (rideHistory.isEmpty()) {
                System.out.println("历史记录为空，未导出任何数据。");
                return;
            }
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toCSV()); // 使用 Visitor 类的 toCSV 方法
                writer.newLine();
            }
            System.out.println("历史记录已成功导出到文件: " + filePath);
        } catch (IOException e) {
            System.out.println("导出历史记录时发生错误: " + e.getMessage());
        }
    }

    // 从CSV文件导入历史记录
    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Visitor visitor = new Visitor(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                rideHistory.add(visitor);
            }
            System.out.println("历史记录已从 " + filePath + " 导入");
        } catch (IOException e) {
            System.out.println("导入历史记录时发生错误：" + e.getMessage());
        }
    }
}

