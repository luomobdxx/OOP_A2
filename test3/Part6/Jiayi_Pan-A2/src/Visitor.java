/**
 * 访客
 */
public class Visitor extends Person {
    private String membershipType; // 会员类型

    public Visitor() {
        super();
        this.membershipType = "";
    }

    public Visitor(String name, int age, String gender, String membershipType) {
        super(name, age, gender);
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String toCSV() {
        return String.join(",", getName(), String.valueOf(getAge()), getGender(), membershipType);
    }

    @Override
    public void printInfo() {
        System.out.println("访客姓名: " + getName() + ", 会员类型: " + membershipType + ", 年龄: " + getAge());
    }
}
