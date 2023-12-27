package chapter9.chain;

import chapter9.chain.classic.HeaderTextProcessing;
import chapter9.chain.classic.ProcessingObject;
import chapter9.chain.classic.SpellCheckerProcessing;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MainClass {

    public static void main(String[] args) {

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");

        System.out.println(result);




        UnaryOperator<String> headerProcessing = s -> "From raoul, Mario and Alan : " + s;
        UnaryOperator<String> spellChecker = s -> s.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellChecker);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println("result2 = " + result2);



    }

}
