/**
 * visitor
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

    public String toCSV() {
        return String.join(",", getName(), String.valueOf(getAge()), getGender(), membershipType);
    }

    @Override
    public void printInfo() {
        System.out.println("Visitor Name:" + getName() + ", Membership Type: " + membershipType + ", Membership Type: " + getAge());
    }
}
