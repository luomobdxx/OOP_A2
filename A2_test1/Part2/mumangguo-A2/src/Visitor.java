/**
 * 访客
 */
public class Visitor extends Person {

    private String membershipType;

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

    @Override
    public void printInfo() {
        System.out.println("访客姓名:" + getName() + ",会员类型:" + membershipType);
    }
}
