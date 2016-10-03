package schedulermanager;

/**
 *
 * @author Nycholas de Sousa
 * @matricula 11228201
 *
 */
public class Process implements Comparable<Process> {

    private int id;
    private int arrivalTime;
    private int duration;
    private int remainingDuration;

    public Process(int id, int arrivalTime, int duration) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.remainingDuration = duration;
    }

    /*
    * Ordena a Lista de acordo com o tempo de chegada e duração
    * 
    */
    public int compareTo(Process aux) {
        if ((this.arrivalTime < aux.getArrivalTime() || this.arrivalTime == aux.getArrivalTime())
                && (this.getDuration() < aux.getDuration())) {
            return -1;
        } else if ((this.arrivalTime > aux.getArrivalTime() || (this.arrivalTime == aux.getArrivalTime())
                && this.getDuration() > aux.getDuration())) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(int remainingDuration) {
        this.remainingDuration = remainingDuration;
    }

}
