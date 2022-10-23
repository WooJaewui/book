import java.lang.reflect.Array;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {

        Lecture lecture = new GradeLecture(70,"객체지향 프로그래밍",
                Arrays.asList(81,95,75,50,45),
                Arrays.asList(new Grade("A",100,95)
                        ,new Grade("B", 95,80)
                        ,new Grade("C", 79,70)
                        ,new Grade("D", 79,50)
                        ,new Grade("F", 49,0)));

        String evaluration = lecture.evaluate();

        System.out.println(evaluration);

        Professor professor = new Professor("다익스트라", new GradeLecture(70, "알고리즘",
                            Arrays.asList(81,95,75,50,45),
                            Arrays.asList(new Grade("A",100,95)
                                    ,new Grade("B", 95,80)
                                    ,new Grade("C", 79,70)
                                    ,new Grade("D", 79,50)
                                    ,new Grade("F", 49,0))));

        String statistics = professor.compileStatistics();

        System.out.println(statistics);


    }

}
