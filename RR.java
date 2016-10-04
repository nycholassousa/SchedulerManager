package schedulermanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nycholas de Sousa
 * @matricula 11228201
 *
 */
public class RR extends Scheduler {

    private static final int QUANTUM = 2;
    private static List<Process> listReady = new ArrayList<Process>();
    private static List<Integer> arrivalTime = new ArrayList<Integer>();
    private static Map<Integer, Integer> responseTime = new HashMap<Integer, Integer>();

    private void prepareList(List<Process> process, int returnAux) {
        int min = 0;

        for (Process p1 : process) {
            if (!arrivalTime.contains(p1.getArrivalTime()) && p1.getArrivalTime() <= returnAux) {
                if (!listReady.contains(p1)) {
                    min = p1.getArrivalTime();
                    arrivalTime.add(min);
                    for (Process p2 : process) {
                        if (p2.getArrivalTime() == min) {
                            listReady.add(p2);
                        }
                    }
                }
            }
        }
    }

    private int responseTimeTotal() {
        int sumResposta = 0;
        for (int key : responseTime.keySet()) {
            sumResposta += responseTime.get(key);
        }
        return sumResposta;
    }

    public RR(List<Process> process) {
        int returnTime = 0;
        int waitTime = 0;
        int totalProcess = super.getAmountOfProcess(process);
        int arrivalProcess = arrivalMin(process);

        prepareList(process, arrivalProcess);

        // enquanto houver processos na lista de prontos
        while (!listReady.isEmpty()) {
            Process p = listReady.remove(0);

            //key: processo
            //value: tempo em que foi atendido
            if (!responseTime.containsKey(p.getId())) {
                responseTime.put(p.getId(), arrivalProcess - p.getArrivalTime());
            }

            if (p.getRemainingDuration() > QUANTUM) {
                p.setRemainingDuration(p.getRemainingDuration() - QUANTUM);
                arrivalProcess += QUANTUM;
                prepareList(process, arrivalProcess);

                listReady.add(p);
            } else {
                arrivalProcess += p.getRemainingDuration();
            }

            if (!listReady.contains(p)) {
                returnTime += (arrivalProcess - p.getArrivalTime());
                waitTime += (arrivalProcess - p.getArrivalTime() - p.getDuration());
            }
        }

        super.setAvgReturn((float) returnTime / totalProcess);
        super.setAvgResponse((float) responseTimeTotal() / totalProcess);
        super.setAvgWait((float) waitTime / totalProcess);
    }

    public void print() {
        super.print("RR");
    }
}
