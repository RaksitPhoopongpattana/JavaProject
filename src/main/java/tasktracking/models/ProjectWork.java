package tasktracking.models;

public class ProjectWork implements Comparable{
    private String projectname;
    private String projectsupervisor;
    private String datestart;
    private String dateend;
    private String priority;
    private String category;
    private String status;

    public ProjectWork(String projectname, String projectsupervisor, String datestart, String dateend, String priority, String category, String status) {
        this.projectname = projectname;
        this.projectsupervisor = projectsupervisor;
        this.datestart = datestart;
        this.dateend = dateend;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    public ProjectWork(String projectname, String projectsupervisor, String datestart, String dateend, String priority, String category) {
        this.projectname = projectname;
        this.projectsupervisor = projectsupervisor;
        this.datestart = datestart;
        this.dateend = dateend;
        this.priority = priority;
        this.category = category;
    }


    public String getProjectname() {
        return projectname;
    }

    public String getDatestart() {
        return datestart;
    }

    public String getProjectsupervisor() {
        return projectsupervisor;
    }

    public String getDateend() {
        return dateend;
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
        int comparePriority = Integer.parseInt(((ProjectWork) o).getPriority());

        //ascending order
        return comparePriority - Integer.parseInt(this.getPriority());
    }

//    public void updateStatus(){
//
//    }
}
