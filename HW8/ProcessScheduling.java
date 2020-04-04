package HW8;

// an incomplete code for homework assignment
// you need to change the name of the program (and the class name) to ProcessScheduling
// complete this code
// you may change any part of this code



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ProcessScheduling {

    public ProcessScheduling() {
    }

    // nested class Process
    protected static class Process {
        private int priority;
        private int id;
        private int arrivalTime;
        private int duration;

        public Process() {
            priority = 0;
            id = 0;
            arrivalTime = 0;
            duration = 0;
        }

        public int getPriority() {
            return priority;
        }

        public int getId() {
            return id;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public int getDuration() {
            return duration;
        }

        public void setPriority(int pr) {
            priority = pr;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setArrivalTime(int at) {
            arrivalTime = at;
        }

        public void setDuration(int dr) {
            duration = dr;
        }
    }

    // print an entry in priority queue
    public static void printEntry(Entry<Integer, Process> e) {
        System.out.println("Process id = " + e.getValue().getId());
        System.out.println("\tPriority = " + e.getKey());
        System.out.println("\tArrival = " + e.getValue().getArrivalTime());
        System.out.println("\tDuration  = " + e.getValue().getDuration());
    }

    // read processes from input file and add them to ArrayList
    // receive empty ArrayList
    // return number of processes
    public static ArrayList readProcesses(ArrayList<Process> list) throws IOException {

        String[] tokens;
        Scanner inputFile = new Scanner(new File("process_scheduling.txt"));
        int numProcesses = 0;
        while (inputFile.hasNext()) {
            tokens = inputFile.nextLine().trim().split("\\s+");
            Process p = new Process();
            int id = Integer.parseInt(tokens[0]);
            int pr = Integer.parseInt(tokens[1]);
            int dr = Integer.parseInt(tokens[2]);
            int at = Integer.parseInt(tokens[3]);
            p.setPriority(pr);
            p.setId(id);
            p.setArrivalTime(at);
            p.setDuration(dr);
            list.add(p);
            numProcesses++;
            // for debugging
            System.out.println("Id = " + id + ", priority = " + pr + ", duration = " + dr + ", arrival time = " + at);
        }
        System.out.println();
        inputFile.close();
        return list;
    }


    public static class RunningClass {
        int id;
        int previous_wait_time;
        int total_wait_time;
        int previous_finished_time;

        public RunningClass(int id, int previous_finished_time , int previous_wait_time, int total_wait_time) {
            this.id = id;
            this.previous_finished_time = previous_finished_time;
            this.previous_wait_time = previous_wait_time;
            this.total_wait_time = total_wait_time;

        }

        public int get_ID() {
            return id;
        }

        public int getPrevious_wait_time() {
            return previous_wait_time;
        }

        public int getTotal_wait_time() {
            return total_wait_time;
        }

        public int getPrevious_finished_time() {
            return previous_finished_time;
        }

        public void set_ID(int id) {
            this.id = id;
        }

        public void setPrevious_wait_time(int previous_wait_time) {
            this.previous_wait_time = previous_wait_time;
        }

        public void setTotal_wait_time(int total_wait_time) {
            this.total_wait_time = total_wait_time;
        }

        public void setPrevious_finished_time(int previous_finished_time) {
            this.previous_finished_time = previous_finished_time;
        }

    }

    public static void main(String[] args) throws IOException {


        // create empty priority queue
        HeapPriorityQueue<Integer, Process> q = new HeapPriorityQueue<>();

        // create empty ArrayList
        ArrayList<Process> processList = new ArrayList<Process>();

        // read processes from input file
        ArrayList listProcesses = readProcesses(processList);
        System.out.println(listProcesses);

        int at;
        int ct = 0;
        boolean running = false;
        int id = 0;
        int previous_wait_time = 0;
        int total_wait_time = 0;
        int previous_finished_time = 0;
        int current_wait_time = 0;
        Process min = new Process();

        ArrayList<RunningClass> times = new ArrayList<>();
        RunningClass running_state = new RunningClass(id, previous_finished_time, previous_wait_time, total_wait_time);

        while (!processList.isEmpty()) {
            for (int i = 0; i < processList.size(); i++) {
                if (processList.size() == 10) {
                    q.insert(processList.get(i).getPriority(), processList.get(i));
                    processList.remove(i);
                    current_wait_time = 0;
                    while (!q.isEmpty()) {
                        if (!running) {
                            min = q.removeMin().getValue();

                            id = min.getId();

                            previous_wait_time = current_wait_time;
                            total_wait_time = current_wait_time + previous_wait_time;
                            previous_finished_time = min.getArrivalTime();


                            System.out.println("Process removed queue is: id = " + min.getId() +
                                    ", at time = " + previous_finished_time +
                                    ", wait time = " + current_wait_time +
                                    ", total wait time = " + total_wait_time);
                            System.out.println("Process id = " + min.getId() +
                                    "\n Priority = " + min.getPriority() +
                                    "\n Arrival = " + min.getArrivalTime() +
                                    "\n Duration = " + min.getDuration());

                            previous_finished_time = (min.getDuration() + min.getArrivalTime() + current_wait_time) ;
                            running = true;

                            }
                        }

                    running_state.setPrevious_finished_time(previous_finished_time);
                    running_state.setPrevious_wait_time(previous_wait_time);
                    running_state.setTotal_wait_time(current_wait_time);

                    running = false;
                    // DEBUGGING
                    System.out.println( "Process Times :" +
                            "\nid: " + running_state.get_ID() +
                            "\nprevious finished time: " + running_state.getPrevious_finished_time() +
                            "\nPrevious wait time : " + running_state.getPrevious_wait_time() +
                            "\ntotal wait time: " + running_state.getTotal_wait_time());


                } else {
                    q.insert(processList.get(i).getPriority(), processList.get(i));
                    processList.remove(i);

                    while (!q.isEmpty()) {
                        if (!running) {
                            min = q.removeMin().getValue();

                            id = min.getId();

                            previous_finished_time = running_state.getPrevious_finished_time();
                            previous_wait_time = running_state.getPrevious_wait_time();

                            int wait_time = (previous_finished_time - min.getArrivalTime());
                            total_wait_time = (wait_time + previous_wait_time);

                            System.out.println("Process removed queue is: id = " + min.getId() +
                                    ", at time = " + previous_finished_time +
                                    ", wait time = " + wait_time +
                                    ", total wait time = " + total_wait_time);
                            System.out.println("Process id = " + min.getId() +
                                    "\n Priority = " + min.getPriority() +
                                    "\n Arrival = " + min.getArrivalTime() +
                                    "\n Duration = " + min.getDuration());

                            running = true;
                            previous_finished_time = (min.getDuration() + min.getArrivalTime() + total_wait_time);
                        }

                    }
                    running_state.setPrevious_wait_time(previous_wait_time);
                    running_state.setPrevious_finished_time(previous_finished_time);
                    running_state.setTotal_wait_time(total_wait_time);
                    running = false;


                }
            }
        }
    }
}

