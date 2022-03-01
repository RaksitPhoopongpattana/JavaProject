package tasktracking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tasktracking.controllers.editwork.EditWeekly;
import tasktracking.models.WeeklyWorkTable;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WeeklyWork {

    @FXML
    TableView table;
    @FXML
    TableColumn jobname,date,timestart,timeend,priority,status,category;

    @FXML TableColumn<WeeklyWork, Button> edit;

    @FXML
    public void initialize(){
        jobname.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("jobname"));
        date.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("date"));
        timestart.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("timestart"));
        timeend.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("timeend"));
        priority.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("status"));
        category.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("category"));
        edit.setCellValueFactory(new PropertyValueFactory("edit"));

        ObservableList<WeeklyWorkTable> data = FXCollections.observableArrayList();

        ArrayList<tasktracking.models.WeeklyWork> allwork = new FileManager().readWeeklyWork();
        Collections.sort(allwork);


        for (tasktracking.models.WeeklyWork w : allwork){
            EventHandler<ActionEvent> temp = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/FXML/editwork/editweekly.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.setScene(new Scene(root));
                        EditWeekly editWeeklyController = (EditWeekly) fxmlLoader.getController();
                        editWeeklyController.setAttribute(w);
                        stage.show();
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }
                }
            };
            data.add(new WeeklyWorkTable(w,temp));
        }
        table.setItems(data);
    }

    @FXML
    public void handleAddWeeklyWork(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("AddWeeklyWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า AddWeeklyWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleGotoCategory(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("CategoryWeekly");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า CategoryWeekly ไม่ได้");
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
