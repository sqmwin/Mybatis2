import com.sqm.dao.StudentDao;
import com.sqm.pojo.Student;
import com.sqm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 测试类
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class Test {
    private SqlSession session;
    private StudentDao dao;

    @Before
    public void setUp() {
        session = MyBatisUtil.getSqlSession();
        dao = session.getMapper(StudentDao.class);
    }

    @After
    public void tearDown() {
        session.close();
    }

    //根据if标签中的sql语句判断获取数据
    @org.junit.Test
    public void test01() {
        Student condition = new Student();
        //condition.setName("si");
        //condition.setAge(-5);
        List<Student> students = dao.selectStudentsIf(condition);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //根据if标签中的条件返回数据,若if全部为false,则where标签中包含的语句相当于true
    @org.junit.Test
    public void test02() {
        Student condition = new Student();
        //condition.setName("i");
        condition.setAge(-5);
        List<Student> students = dao.selectStudentsWhere(condition);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //若姓名不空，则按照姓名查询；若姓名为空，年龄大于0,则按照年龄查询；
    //若没有查询条件，则没有查询结果
    @org.junit.Test
    public void test03() {
        String name = "li";
        int age = 19;
        List<Student> students = dao.selectStudentsChoose(name, age);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //根据给出的数组条件,获取数据,查询出id为 1 与 3 的学生信息
    @org.junit.Test
    public void test04() {
        Object[] array = {1, 3};
        List<Student> students = dao.selectStudentsForeachArray(array);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //根据给出的基本类型List集合条件返回数据结果,使用foreach遍历条件
    @org.junit.Test
    public void test05() {
        List<Integer> studentsId = new ArrayList<Integer>();
        studentsId.add(1);
        studentsId.add(3);
        List<Student> students = dao.selectStudentsForeachList(studentsId);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //根据给出的自定义类型List集合条件返回数据结果,使用foreach遍历条件
    @org.junit.Test
    public void test06() {
        Student s1 = new Student();
        s1.setId(1);
        Student s2 = new Student();
        s2.setId(3);
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        List<Student> results = dao.selectStudentsForeachList2(students);
        for (Student result : results) {
            System.out.println(result.toString());
        }
    }

    //方法同上,用于测试sql标签的语句片段
    @org.junit.Test
    public void test07() {
        Student s1 = new Student();
        s1.setId(1);
        Student s2 = new Student();
        s2.setId(3);
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        List<Student> results = dao.selectStudentsBySqlFragment(students);
        for (Student result : results) {
            System.out.println(result.toString());
        }
    }
}
