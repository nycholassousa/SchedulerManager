package schedulermanager;

import static java.lang.String.format;
import java.util.List;

/**
 *
 * @author Nycholas de Sousa
 * @matricula 11228201
 *
 */
public class Scheduler {

    private double avgReturn;
    private double avgResponse;
    private double avgWait;

    public double getAvgReturn() {
        return avgReturn;
    }

    public void setAvgReturn(double avgReturn) {
        this.avgReturn = avgReturn;
    }

    public double getAvgResponse() {
        return avgResponse;
    }

    public void setAvgResponse(double avgResponse) {
        this.avgResponse = avgResponse;
    }

    public double getAvgWait() {
        return avgWait;
    }

    public void setAvgWait(double avgWait) {
        this.avgWait = avgWait;
    }

    public int arrivalMin(List<Process> process) {
        int min = process.get(0).getArrivalTime();
        for (Process p : process) {
            if (p.getArrivalTime() < min) {
                min = p.getArrivalTime();
            }
        }

        return min;
    }

    public int getAmountOfProcess(List<Process> process) {
        return process.size();
    }

    public void print(String schedulerType) {
        System.out.println(format("%s %.1f %.1f %.1f", schedulerType, getAvgReturn(),
                getAvgResponse(), getAvgWait()));
    }
}
