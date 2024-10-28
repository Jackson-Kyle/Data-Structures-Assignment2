import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TaskOne {

    public static void main(String[] args) {
        String inputOne = "C:\\Users\\kdj51\\IdeaProjects\\Assignment2\\src\\task1-input.txt";
        String inputTwo = "C:\\Users\\kdj51\\IdeaProjects\\Assignment2\\src\\task2-input.txt";
        String inputThree = "C:\\Users\\kdj51\\IdeaProjects\\Assignment2\\src\\task3-input.txt";
        MinHeap minHeap = new MinHeap(100);
        int currentTime = 0;
        int totalCompletionTime = 0;
        int jobCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputOne))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                int jobId = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);


                Job job = new Job(jobId, processingTime);
                minHeap.insert(job);
                currentTime += job.getTime();
                totalCompletionTime += currentTime;
                jobCount++;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task 1:");
        System.out.print("Execution order: [");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.delMin() + ", ");

        }
        System.out.println("]");
        System.out.println("Average completion time: " +  totalCompletionTime / jobCount);

        totalCompletionTime = 0;
        jobCount = 0;
        currentTime = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputTwo))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                int jobId = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);


                Job job = new Job(jobId, processingTime, priority);
                minHeap.insert(job);
                currentTime += job.getTime();
                totalCompletionTime += currentTime;
                jobCount++;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task 2:");
        System.out.print("Execution order: [");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.delMin() + ", ");

        }
        System.out.println("]");
        System.out.println("Average completion time: " +  totalCompletionTime / jobCount);
        totalCompletionTime = 0;
        jobCount = 0;
        currentTime = 0;

        MinHeap timeMinHeap = new MinHeap(100);
        System.out.println("Task 3:");
        System.out.print("Execution order: [");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputThree))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                int jobId = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);
                int arrivalTime = Integer.parseInt(parts[2]);
                boolean x = true;


                Job job = new Job(jobId, processingTime, arrivalTime, x);

                    timeMinHeap.timeInsert(job);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (!timeMinHeap.isEmpty() || !minHeap.isEmpty()) {

            while (!timeMinHeap.isEmpty() && timeMinHeap.returnFirst().getArrivalTime() <= currentTime) {
                minHeap.insert(timeMinHeap.returnFirst());
                timeMinHeap.delMin();
            }

            if (!minHeap.isEmpty()) {
                Job job = minHeap.returnFirst();
                minHeap.delMin();
                currentTime += job.getTime();
                totalCompletionTime += currentTime;
                jobCount++;
                System.out.print(job.getId() + ", ");
            } else {
                if (!timeMinHeap.isEmpty()) {
                    currentTime = timeMinHeap.returnFirst().getArrivalTime();
                }
            }
        }

        System.out.println("]");
        System.out.print("Average completion time: " + (double) totalCompletionTime / jobCount);
    }
}