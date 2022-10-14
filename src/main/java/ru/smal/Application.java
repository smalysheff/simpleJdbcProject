package ru.smal;

import ru.smal.model.Group;
import ru.smal.service.GroupService;
import ru.smal.service.StudentService;
import ru.smal.service.impl.GroupServiceImpl;
import ru.smal.service.impl.StudentServiceImpl;

public class Application {

    public static void main(String[] args) {

        GroupService groupService = new GroupServiceImpl();
        StudentService studentService = new StudentServiceImpl();

        Group group = new Group("12t", "Компьютерные системы и комплексы");

        // Create
//        boolean save = groupDao.save(group);
//        System.out.println(save ? "success" : "fail");

        // Find
//        Group entity = groupDao.findById(2);
//        System.out.println(entity);

//        List<Group> groups = groupDao.findAll();
//        groups.forEach(System.out::println);

        // STUDENTS
//        Student student = new Student("John", "Smith", 22, 2);
//        boolean save = studentDao.save(student);
//        System.out.println(save ? "success" : "fail");

//        List<Student> students = studentDao.findAll();
//        students.forEach(System.out::println);

//        Student student = new Student("Stepan", "Smith", 2, 2);
//        System.out.println(studentDao.update(student, 2) ? "success" : "fail");

        studentService.findAll().forEach(System.out::println);


    }
}
