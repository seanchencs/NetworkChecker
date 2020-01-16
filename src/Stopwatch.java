public class Stopwatch {
    private long start;

    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    public double getTimeElapsed(){
        return (System.currentTimeMillis() - start) / 1000.0;
    }
}
