package tasktracking.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ProjectWorkTable {
    private SimpleStringProperty projectname;
    private SimpleStringProperty datestart;
    private SimpleStringProperty projectsupervisor;
    private SimpleStringProperty dateend;
    private SimpleStringProperty priority;
    private SimpleStringProperty category;
    private SimpleStringProperty status;
    private Button edit;

    public ProjectWorkTable(ProjectWork projectWork, EventHandler<ActionEvent> event){
        projectname = new SimpleStringProperty(projectWork.getProjectname());
        datestart = new SimpleStringProperty(projectWork.getDatestart());
        projectsupervisor = new SimpleStringProperty(projectWork.getProjectsupervisor());
        dateend = new SimpleStringProperty(projectWork.getDateend());
        priority = new SimpleStringProperty(projectWork.getPriority());
        category = new SimpleStringProperty(projectWork.getCategory());
        status = new SimpleStringProperty(projectWork.getStatus());
        edit = new Button("แก้ไข");

        edit.setOnAction(event);
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

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public Button getEdit() {
        return edit;
    }

}
