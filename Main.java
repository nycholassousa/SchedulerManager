package schedulermanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nycholas de Sousa
 * @matricula 11228201
 *
 */
public class Main {

    public static Scanner input = new Scanner(System.in);
    public static List<Process> processList = new ArrayList<Process>();

    public static void main(String[] args) {
        int id = 0;
        while (true) {
            String in[] = input.nextLine().split(" ");
            if (in[0].isEmpty() || in[1].isEmpty()) {
                input.close();
                break;
            }
            processList.add(new Process(++id, Integer.parseInt(in[0]), Integer.parseInt(in[1])));
        }

        FCFS fcfs = new FCFS(processList);
        SJF sjf = new SJF(processList);
        RR rr = new RR(processList);
        fcfs.print();
        sjf.print();
        rr.print();

    }

}
