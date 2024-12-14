import java.util.Comparator;

/**
 * 游客比较器类
 */
public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 先根据姓名排序，如果姓名相同再根据年龄排序
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
