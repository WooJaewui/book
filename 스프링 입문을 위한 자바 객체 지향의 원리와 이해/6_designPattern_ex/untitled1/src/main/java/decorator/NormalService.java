package decorator;

public class NormalService implements DService{
    @Override
    public String runSomething() {
        return "일반 서비스 실행!!";
    }
}
