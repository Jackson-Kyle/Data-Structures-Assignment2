public class Job {
    int Id;
    int time;
    int priority;
    int arrivalTime;
    public Job(int id, int time) {
        this.Id = id;
        this.time = time;
    }
    public Job(int id, int time, int priority) {
        this.Id = id;
        this.time = time;
        this.priority = priority;
    }
    public Job(int id, int time, int arrivalTime, boolean x){
        this.Id = id;
        this.time = time;
        this.arrivalTime = arrivalTime;
    }

    public int getTime() {
        return time;
    }
    public int getId() {
        return Id;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }

    public int compareTo(Job other) {
        if(this.arrivalTime != other.arrivalTime){
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return Integer.compare(this.time, other.time);
    }
    public int timeCompareTo(Job other) {
        if(this.arrivalTime != other.arrivalTime){
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
        return Integer.compare(this.time, other.time);
    }
}
