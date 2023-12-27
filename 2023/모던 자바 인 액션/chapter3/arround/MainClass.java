package chapter3.arround;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainClass {

    public static void main(String[] args) throws IOException{

        int portNumber = 1337;

        String onLine = processFile((BufferedReader br)-> br.readLine());

        String onLine2 = processFile(new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader b) throws IOException {
                System.out.println(portNumber);
                return b.readLine();
            }
        });

    }

    static public String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReaderProcessor.process(br);
        }
    }



}
