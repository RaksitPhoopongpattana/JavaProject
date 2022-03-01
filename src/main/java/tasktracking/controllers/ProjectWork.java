package tasktracking.controllers;

import com.github.saacsos.FXRouter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tasktracking.controllers.editwork.EditProject;
import tasktracking.services.FileManager;
import tasktracking.models.ProjectWorkTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ProjectWork {

    @FXML
    TableView table;
    @FXML
    TableColumn projectname,projectsupervisor,datestart,dateend,priority,status,category;

    @FXML TableColumn<GeneralWork, Button> edit;

    @FXML
    public void initialize(){
        projectname.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("projectname"));
        datestart.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("datestart"));
        projectsupervisor.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("projectsupervisor"));
        dateend.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("dateend"));
        priority.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("status"));
        category.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("category"));
        edit.setCellValueFactory(new PropertyValueFactory("edit"));

        ObservableList<ProjectWorkTable> data = FXCollections.observableArrayList();

        ArrayList<tasktracking.models.ProjectWork> allWork = new FileManager().readProjectWork();
        Collections.sort(allWork);

        for (tasktracking.models.ProjectWork p : allWork){
            EventHandler<ActionEvent> temp = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/FXML/editwork/editproject.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.setScene(new Scene(root));
                        EditProject editProjectController = (EditProject) fxmlLoader.getController();
                        editProjectController.setAttribute(p);
                        stage.show();
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }
                }
            };
            data.add(new ProjectWorkTable(p,temp));
        }

        table.setItems(data);
    }

    @FXML
    public void handleAddProjectWork(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("AddProjectWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า AddProjectWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleGotoCategory(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("CategoryProject");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า CategoryProject ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleUseBackToInterface(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("AppInterface");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า AppInterface ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
