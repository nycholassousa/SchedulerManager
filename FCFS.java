package schedulermanager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nycholas de Sousa
 * @matricula 11228201
 *
 */
public class FCFS extends Scheduler {

    private static List<Process> listReady;

    public FCFS(List<Process> process) {
        listReady = new ArrayList<Process>(process);
        int returnTime = 0;
        int responseTime = 0;
        int waitTime = 0;

        int amountProcess = process.size();
        int returnAux = arrivalMin(process);

        // enquanto existir processos
        while (!listReady.isEmpty()) {
            Process p = listReady.remove(0); //pega o primeiro da fila e o remove
            returnAux += p.getDuration();
            returnTime += (returnAux - p.getArrivalTime());
            waitTime += (returnAux - p.getArrivalTime() - p.getDuration());
        }
        responseTime = waitTime; //FCFS: tempo de resposta e de espera são iguais

        super.setAvgReturn((double) returnTime / amountProcess);
        super.setAvgResponse((double) responseTime / amountProcess);
        super.setAvgWait((double) waitTime / amountProcess);

    }

    public void print() {
        super.print("FCFS");
    }
}
