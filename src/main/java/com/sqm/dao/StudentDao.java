package com.sqm.dao;

import com.sqm.pojo.Student;

import java.util.List;

/**
 * <p>
 *     Student类持久层操作接口
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public interface StudentDao {
    //根据给出的student对象的限制条件得到选择结果
    List<Student> selectStudentsIf(Student student);

    //根据给出的限制条件的student对象返回数据,使用where标签
    List<Student> selectStudentsWhere(Student student);

    //根据给出的限制条件返回数据结果,使用choose标签
    List<Student> selectStudentsChoose(String name,int age);

    //根据给出的数组条件返回数据结果,使用foreach遍历条件
    List<Student> selectStudentsForeachArray(Object[] studentId);

    //根据给出的基本类型List集合条件返回数据结果,使用foreach遍历条件
    List<Student> selectStudentsForeachList(List<Integer> studentIds);

    //根据给出的自定义类型List集合条件返回数据结果,使用foreach遍历条件
    List<Student> selectStudentsForeachList2(List<Student> students);

    //测试sql标签,仍然使用前一个方法
    List<Student> selectStudentsBySqlFragment(List<Student> students);
}
