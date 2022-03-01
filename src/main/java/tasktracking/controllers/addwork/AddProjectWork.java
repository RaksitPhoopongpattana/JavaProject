package tasktracking.controllers.addwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tasktracking.services.FileManager;
import tasktracking.models.ProjectWork;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class AddProjectWork {

    @FXML
    TextField projectname,projectsupervisor,priority,category;
    @FXML
    DatePicker datestart,dateend;

    @FXML
    public void submit(ActionEvent actionEvent) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        ProjectWork p = new ProjectWork(projectname.getText(), projectsupervisor.getText(), datestart.getValue().format(format), dateend.getValue().format(format),priority.getText(), category.getText(), "not finish");
        if (new FileManager().checkFileNameProject(projectname.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR,"ชื่อซ้ำ");
            alert.showAndWait();
            return;
        }
        new FileManager().addNewProjectWork(p);
        try {
            FXRouter.goTo("ProjectWork");
        }catch (IOException e) {
            System.err.println("ไปที่หน้า ProjectWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleUseBackToProject(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("ProjectWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ProjectWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
