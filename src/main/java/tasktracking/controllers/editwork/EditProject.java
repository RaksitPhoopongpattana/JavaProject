package tasktracking.controllers.editwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tasktracking.models.ProjectWork;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditProject {

    @FXML
    private TextField projectname, projectsupervisor, priority, category;

    @FXML
    private DatePicker datestart, dateend;

    private String first;

    public void setAttribute(ProjectWork projectWork){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        LocalDate temp = LocalDate.parse(projectWork.getDatestart(),format);
        LocalDate temp2 = LocalDate.parse(projectWork.getDateend(),format);
        first = projectWork.getProjectname();
        projectname.setText(projectWork.getProjectname());
        projectsupervisor.setText(projectWork.getProjectsupervisor());
        datestart.setValue(temp);
        dateend.setValue(temp2);
        priority.setText(projectWork.getPriority());
        category.setText(projectWork.getCategory());
    }

    @FXML
    public void delete(ActionEvent event){
        FileManager fileManager = new FileManager();

        ArrayList<ProjectWork> projectWorks = fileManager.readProjectWork();
        for (int i=0; i<projectWorks.size(); i++){
            if (projectWorks.get(i).getProjectname().equals(first)){
                projectWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllProjectWorkAfterDelete(projectWorks);
        try {
            FXRouter.goTo("ProjectWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();

    }

    @FXML
    public void save(ActionEvent event){
        FileManager fileManager = new FileManager();
        String s = null;
        ArrayList<ProjectWork> projectWorks = fileManager.readProjectWork();
        for (int i=0; i<projectWorks.size(); i++){
            if (projectWorks.get(i).getProjectname().equals(first)){
                s = projectWorks.get(i).getStatus();
                projectWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllProjectWorkAfterDelete(projectWorks);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        ProjectWork p = new ProjectWork(projectname.getText(),projectsupervisor.getText(), datestart.getValue().format(format), dateend.getValue().format(format), priority.getText(), category.getText(),s);
        new FileManager().addNewProjectWork(p);
        try {
            FXRouter.goTo("ProjectWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }
}
