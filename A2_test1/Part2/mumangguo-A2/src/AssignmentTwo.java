public class AssignmentTwo {
    public static void main(String[] args) {
        Employee emp = new Employee("张三", 25, "男性", "游乐设施操作员", 3000);
        Visitor visitor1 = new Visitor("李四", 30, "女性", "年票");
        Visitor visitor2 = new Visitor("王五", 20, "男性", "VIP");
        Ride rollerCoaster = new Ride("赵六", 5, emp);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.printQueue();

        rollerCoaster.runOneCycle();

        rollerCoaster.printRideHistory();

        System.out.println("李四有没有游玩历史" + rollerCoaster.checkVisitorFromHistory(visitor1));
    }

    public void partThree() {
    }

    public void partFourA() {
    }

    public void partFourB() {
    }

    public void partFive() {
    }

    public void partSix() {
    }

    public void partSeven() {
    }
}

