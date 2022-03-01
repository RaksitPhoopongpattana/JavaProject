package tasktracking.models;


public class ForwardWork implements Comparable{
    private String jobname;
    private String responsiblePerson;
    private String date;
    private String timestart;
    private String timeend;
    private String priority;
    private String category;
    private String status;

    public ForwardWork(String jobname, String responsiblePerson, String date, String timestart, String timeend, String priority, String category, String status) {
        this.jobname = jobname;
        this.responsiblePerson = responsiblePerson;
        this.date = date;
        this.timestart = timestart;
        this.timeend = timeend;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    public ForwardWork(String jobname, String responsiblePerson, String date, String timestart, String timeend, String priority, String category) {
        this.jobname = jobname;
        this.responsiblePerson = responsiblePerson;
        this.date = date;
        this.timestart = timestart;
        this.timeend = timeend;
        this.priority = priority;
        this.category = category;
    }

    public String getJobname() {
        return jobname;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public String getDate() {
        return date;
    }

    public String getTimestart() {
        return timestart;
    }

    public String getTimeend() {
        return timeend;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

   public String getStatus() {
       return status;
   }

    @Override
    public int compareTo(Object o) {
        int comparePriority = Integer.parseInt(((ForwardWork) o).getPriority());

        return comparePriority - Integer.parseInt(this.getPriority());
    }

}
