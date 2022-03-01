package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;

public class ProjectWorkCategoryTable {
    private SimpleStringProperty projectname;
    private SimpleStringProperty datestart;
    private SimpleStringProperty projectsupervisor;
    private SimpleStringProperty dateend;
    private SimpleStringProperty priority;
    private SimpleStringProperty status;

    public ProjectWorkCategoryTable(ProjectWork projectWork){
        projectname = new SimpleStringProperty(projectWork.getProjectname());
        datestart = new SimpleStringProperty(projectWork.getDatestart());
        projectsupervisor = new SimpleStringProperty(projectWork.getProjectsupervisor());
        dateend = new SimpleStringProperty(projectWork.getDateend());
        priority = new SimpleStringProperty(projectWork.getPriority());
        status = new SimpleStringProperty(projectWork.getStatus());
    }

    public String getProjectname() {
        return projectname.get();
    }

    public SimpleStringProperty projectnameProperty() {
        return projectname;
    }

    public String getDatestart() {
        return datestart.get();
    }

    public SimpleStringProperty datestartProperty() {
        return datestart;
    }

    public String getProjectsupervisor() {
        return projectsupervisor.get();
    }

    public SimpleStringProperty projectsupervisorProperty() {
        return projectsupervisor;
    }

    public String getDateend() {
        return dateend.get();
    }

    public SimpleStringProperty dateendProperty() {
        return dateend;
    }

    public String getPriority() {
        return priority.get();
    }

    public SimpleStringProperty priorityProperty() {
        return priority;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }
}
