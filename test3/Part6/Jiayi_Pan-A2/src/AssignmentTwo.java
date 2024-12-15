public class AssignmentTwo {
    public static void main(String[] args) {
//        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
//        Visitor visitor1 = new Visitor("李四", 30, "女性", "年票");
//        Visitor visitor2 = new Visitor("王五", 20, "男性", "VIP");
//        Ride rollerCoaster = new Ride("赵六", 5, emp);
//
//        rollerCoaster.addVisitorToQueue(visitor1);
//        rollerCoaster.addVisitorToQueue(visitor2);
//        rollerCoaster.printQueue();
//
//        rollerCoaster.runOneCycle();
//
//        rollerCoaster.printRideHistory();
//
//        System.out.println("李四有没有游玩历史" + rollerCoaster.checkVisitorFromHistory(visitor1));

//        AssignmentTwo assignmentTwo = new AssignmentTwo();
//        assignmentTwo.partThree();

//        AssignmentTwo assignmentTwo = new AssignmentTwo();
//        assignmentTwo.partFourA();

//        AssignmentTwo assignmentTwo = new AssignmentTwo();
//        assignmentTwo.partFourB();

//        AssignmentTwo assignmentTwo = new AssignmentTwo();
//        assignmentTwo.partFive();

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partSix();
    }

    public void partThree() {
        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
        // 创建游乐设施对象
        Ride ride = new Ride("过山车", 5, emp);

        // 添加5名游客到队列
        Visitor visitor1 = new Visitor("张三", 25, "男", "普通会员");
        Visitor visitor2 = new Visitor("李四", 30, "男", "高级会员");
        Visitor visitor3 = new Visitor("王五", 22, "女", "普通会员");
        Visitor visitor4 = new Visitor("赵六", 28, "男", "VIP会员");
        Visitor visitor5 = new Visitor("孙七", 20, "女", "普通会员");
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        // 从队列中移除一名游客
        ride.removeVisitorFromQueue(visitor2);

        // 打印当前队列
        ride.printQueue();
    }

    public void partFourA() {
        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
        // 创建游乐设施对象
        Ride ride = new Ride("过山车", 5, emp);

        // 添加游客到历史记录
        Visitor visitor1 = new Visitor("张三", 25, "男", "普通会员");
        Visitor visitor2 = new Visitor("李四", 30, "男", "高级会员");
        Visitor visitor3 = new Visitor("王五", 22, "女", "普通会员");
        Visitor visitor4 = new Visitor("赵六", 28, "男", "VIP会员");
        Visitor visitor5 = new Visitor("孙七", 20, "女", "普通会员");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        // 检查某个游客是否在历史记录中
        ride.checkVisitorFromHistory(visitor3); // 王五
        ride.checkVisitorFromHistory(new Visitor("周八", 30, "男", "普通会员")); // 不在历史中的游客

        // 打印历史记录中的游客总数
        ride.numberOfVisitors();

        // 打印历史记录
        ride.printRideHistory();
    }

    public void partFourB() {
        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
        // 创建游乐设施对象
        Ride ride = new Ride("过山车", 5, emp);

        // 添加游客到历史记录
        Visitor visitor1 = new Visitor("张三", 25, "男", "普通会员");
        Visitor visitor2 = new Visitor("李四", 30, "男", "高级会员");
        Visitor visitor3 = new Visitor("王五", 22, "女", "普通会员");
        Visitor visitor4 = new Visitor("赵六", 28, "男", "VIP会员");
        Visitor visitor5 = new Visitor("孙七", 20, "女", "普通会员");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        // 打印历史记录中的游客
        System.out.println("排序前的历史记录：");
        ride.printRideHistory();

        // 对历史记录进行排序
        ride.sortRideHistory();
    }

    public void partFive() {
        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
        Ride ride = new Ride("过山车", 10, emp);

        // 添加游客到队列
        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("游客" + i, 20 + i, "男", "普通会员"));
        }

        // 打印队列中的游客
        System.out.println("初始队列:");
        ride.printQueue();

        // 运行一个循环
        ride.runOneCycle();

        // 打印队列中的游客和历史记录
        System.out.println("运行一个循环后的队列:");
        ride.printQueue();
        System.out.println("游乐设施历史记录:");
        ride.printRideHistory();

        // 导出和导入历史记录
        String filePath = "ride_history.csv";
        ride.exportRideHistory(filePath);
        Ride newRide = new Ride();
        newRide.importRideHistory(filePath);
        newRide.printRideHistory();
    }

    public void partSix() {
        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
        // 创建一个新的 Ride 对象
        Ride ride = new Ride("海盗船", 5, emp);

        // 添加至少5个游客到游乐设施历史记录
        ride.addVisitorToHistory(new Visitor("游客1", 25, "男", "普通会员"));
        ride.addVisitorToHistory(new Visitor("游客2", 30, "女", "高级会员"));
        ride.addVisitorToHistory(new Visitor("游客3", 22, "男", "普通会员"));
        ride.addVisitorToHistory(new Visitor("游客4", 28, "女", "普通会员"));
        ride.addVisitorToHistory(new Visitor("游客5", 35, "男", "高级会员"));

        // 导出游客历史记录到文件
        String filePath = "ride_history.csv";
        ride.exportRideHistory(filePath);

        System.out.println("演示完成。请检查文件 " + filePath + " 中的导出结果。");
    }

    public void partSeven() {
    }
}

