package chapter1.item7;

import java.lang.ref.WeakReference;

public class MainClass {

    public static void main(String[] args) {

        // 강한 참조
        Student student1 = new Student("범수");

        /*
            어쩌구 저쩌구
         */

        Student student2 = student1;
        /*
            어쩌구 저쩌구
         */
        student1 = null;
        System.out.println(student1);
        System.out.println(student2);



        // 약한 참조
        WeakReference<Student> weakStudent = new WeakReference<>(new Student("인수"));

        Student student5 = weakStudent.get();
        /*
            어쩌구 저쩌구
         */
        Student student6 = student5;
        /*
            어쩌구 저쩌구
         */

        weakStudent.clear();
        System.out.println(student5);
        System.out.println(student6);


    }

}
