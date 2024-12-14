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

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partFourB();
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
    }

    public void partSix() {
    }

    public void partSeven() {
    }
}

