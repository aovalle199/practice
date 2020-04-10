package HW8;

// an incomplete code for homework assignment
// you need to change the name of the program (and the class name) to ProcessScheduling
// complete this code
// you may change any part of this code



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


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
        FileWriter csvWriter = new FileWriter("process_scheduling_results.csv");

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


    // Class that stores the dates that need to be computed and saved for each process
    public static class RunningClass {
        int id;
        int previous_wait_time;
        Double total_wait_time;
        int previous_finished_time;

        public RunningClass(int id, int previous_finished_time, int previous_wait_time, Double total_wait_time) {
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

        public Double getTotal_wait_time() {
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

        public void setTotal_wait_time(Double total_wait_time) {
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

        // variables
        int ct = 0;
        boolean running = false;
        int id = 0;
        int previous_wait_time = 0;
        int total_wait_time = 0;
        int previous_finished_time = 10;
        int current_wait_time = 0;
        int removedTime = 0;
        Process min = new Process();

        int wait_time = 0;
        int at_time = 0;
        Double ttl_wait_time;
        // class that writes the output of each process into a csv file
        FileWriter csvWriter = new FileWriter("process_scheduling_results.csv");
        csvWriter.append("\n");
        csvWriter.append("Andrea Ovalle - process simulation ");
        csvWriter.append("\n");

        // saves the raw information of each process
        for (Process l: processList) {
            csvWriter.append("Id = ").append(String.valueOf(l.getId())
            ).append(", priority = ").append(String.valueOf(l.getPriority())
            ).append(", duration").append(String.valueOf(l.getDuration())
            ).append(", arrival time = ").append(String.valueOf(l.getArrivalTime()));
            csvWriter.append("\n");
        }
        // saves the total wait times of each process - this helps compute the average of the total wait times
        ArrayList<Double> total_wait_times = new ArrayList<>();

        // Initiates the class with all the arguments set to 0
        RunningClass running_state = new RunningClass(id, previous_finished_time, previous_wait_time, (double) total_wait_time);

        // Creates a new process where the process with the earliest arrival time will be store
        Process EarliestProcess = new Process();
        while (!processList.isEmpty()) {
            // grabs the top process, because arrival time process are in ascending order
            EarliestProcess = processList.get(0);
            // compares the earliest process with the current time
            if (EarliestProcess.getArrivalTime() <= ct) {
                q.insert(EarliestProcess.getPriority(), EarliestProcess);
                processList.remove(EarliestProcess);
            }
            // checks if the queue is empty and not running
            if (!q.isEmpty() && !running) {
                min = q.removeMin().getValue();
                running = true;

                // gets the previous finished of the previous process to compute the time the current process will start
                at_time = running_state.getPrevious_finished_time();
                // computes the wait time by substracting the time of arrival in the cpu to
                // the actual arrival time
                wait_time = at_time - min.getArrivalTime();
                // computes the total time by substracting the current wait time and total
                // wait time of the previous process
                ttl_wait_time = (double) (wait_time + running_state.getTotal_wait_time());

                // adds the ttl_wait_time to total_wait_times array to compute the average
                total_wait_times.add(ttl_wait_time);

                previous_finished_time = (min.getDuration() + min.getArrivalTime() + wait_time);
                // sets the values to be used for the next iteration
                running_state.setPrevious_finished_time(previous_finished_time);
                running_state.setPrevious_wait_time(wait_time);
                running_state.setTotal_wait_time(ttl_wait_time);

                System.out.println("Process removed queue is: id = " + min.getId() +
                        ", at time = " + at_time +
                        ", wait time = " + wait_time +
                        ", total wait time = " + ttl_wait_time);
                //writes to csv file
                csvWriter.append("\n");
                csvWriter.append("Process removed from queue is: id = ").append(String.valueOf(min.getId())
                ).append( ", at time = ").append(String.valueOf(at_time)
                ).append(", wait time = ").append(String.valueOf(wait_time)
                ).append(", total wait time = ").append(String.valueOf(ttl_wait_time));
                csvWriter.append("\n");

                System.out.println("Process id = " + min.getId() +
                        "\n Priority = " + min.getPriority() +
                        "\n Arrival = " + min.getArrivalTime() +
                        "\n Duration = " + min.getDuration());

                csvWriter.append(" Process id =  ").append(String.valueOf(min.getId()));
                csvWriter.append("\n");
                csvWriter.append(" Priority =  ").append(String.valueOf(min.getPriority()));
                csvWriter.append("\n");
                csvWriter.append(" Arrival =  ").append(String.valueOf(min.getArrivalTime()));
                csvWriter.append("\n");
                csvWriter.append(" Duration =  ").append(String.valueOf(min.getDuration()));
                csvWriter.append("\n");
                // the time the process is removed is the current time, this will be used to
                // compute if the process has finished and if the next process can be executed
                removedTime = ct;


            }
            ct++;
            // checks if the next process can be executed.
            if ((ct - removedTime) >= min.getDuration() && running == true) {
                previous_finished_time = (min.getDuration() + min.getArrivalTime() + wait_time);
                running_state.setPrevious_finished_time(previous_finished_time);

                running = false;
                System.out.println("Process " + min.getId() + " finished at time " + previous_finished_time);
                System.out.println();
                csvWriter.append("\n");
                csvWriter.append("Process = ").append(String.valueOf(min.getId())
                ).append(", finished at time = ").append(String.valueOf(previous_finished_time));
                csvWriter.append("\n");
            }


        }
        // once it exits out of the loop the current time will equal the time the processList is empty
        System.out.println();
        System.out.println("************** processList empty at: " + ct + " **************");
        csvWriter.append("\n");
        csvWriter.append("************** processList empty at: ").append(String.valueOf(ct)).append(" **************");
        csvWriter.append("\n");
        System.out.println();

        // checks if the q is empty, if is not empty and there are no processes running, remove process from queue
        // the same behavior from above should be executed, remove process from queue, get and set times, check if
        // process has finished, wait or continue executing until queue is empty. At this point the processList MUST be
        // empty.
        while (!q.isEmpty()) {

            if (!running) {
                min = q.removeMin().getValue();
                running = true;
                at_time = running_state.getPrevious_finished_time();
                wait_time = running_state.getPrevious_finished_time() - min.getArrivalTime();
                ttl_wait_time = (double) (wait_time + running_state.getTotal_wait_time());
                total_wait_times.add(ttl_wait_time);
                previous_finished_time = (min.getDuration() + min.getArrivalTime() + wait_time);

                running_state.setPrevious_finished_time(previous_finished_time);
                running_state.setPrevious_wait_time(wait_time);
                running_state.setTotal_wait_time(ttl_wait_time);

                System.out.println("Process removed queue is: id = " + min.getId() +
                        ", at time = " + at_time +
                        ", wait time = " + wait_time +
                        ", total wait time = " + ttl_wait_time);

                csvWriter.append("\n");
                csvWriter.append("Process removed from queue is: id = ").append(String.valueOf(min.getId())
                ).append( ", at time = ").append(String.valueOf(at_time)
                ).append(", wait time = ").append(String.valueOf(wait_time)
                ).append(", total wait time = ").append(String.valueOf(ttl_wait_time));
                csvWriter.append("\n");

                System.out.println("Process id = " + min.getId() +
                        "\n Priority = " + min.getPriority() +
                        "\n Arrival = " + min.getArrivalTime() +
                        "\n Duration = " + min.getDuration());

                csvWriter.append("Process id =").append(String.valueOf(min.getId()));
                csvWriter.append("\n");
                csvWriter.append("Priority = ").append(String.valueOf(min.getPriority()));
                csvWriter.append("\n");
                csvWriter.append("Arrival = ").append(String.valueOf(min.getArrivalTime()));
                csvWriter.append("\n");
                csvWriter.append("Duration = ").append(String.valueOf(min.getDuration()));
                csvWriter.append("\n");
            }
            ct++;
            if ((ct - removedTime) >= min.getDuration()) {
                previous_finished_time = (min.getDuration() + min.getArrivalTime() + wait_time);
                running_state.setPrevious_finished_time(previous_finished_time);

                running = false;
                System.out.println("Process " + min.getId() + " finished at time " + previous_finished_time);
                System.out.println();
                csvWriter.append("\n");
                csvWriter.append("Process =  ").append(String.valueOf(min.getId())
                ).append(", finished at time =  ").append(String.valueOf(previous_finished_time));
                csvWriter.append("\n");
                csvWriter.append("\n");
            }



        }
        System.out.println("Total wait time = " +  running_state.getTotal_wait_time());
        System.out.println("Average wait time = " + running_state.getTotal_wait_time()/total_wait_times.size());
        csvWriter.append("\n");
        csvWriter.append("Total wait time = ").append(String.valueOf(running_state.getTotal_wait_time()));
        csvWriter.append("\n");
        csvWriter.append("Average wait time = ").append(String.valueOf(running_state.getTotal_wait_time()/total_wait_times.size()));

        // closed the csv file
        csvWriter.flush();
        csvWriter.close();
    }
}






