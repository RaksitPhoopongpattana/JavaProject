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
import tasktracking.controllers.editwork.EditForward;
import tasktracking.services.FileManager;
import tasktracking.models.ForwardWorkTable;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;

public class ForwardWork {

    @FXML
    TableView table;
    @FXML
    TableColumn jobname,responsiblePerson,date,timestart,timeend,priority,status,category;

    @FXML TableColumn<ForwardWork, Button> edit;

    @FXML
    public void initialize(){
        jobname.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("jobname"));
        responsiblePerson.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("responsiblePerson"));
        date.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("date"));
        timestart.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("timestart"));
        timeend.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("timeend"));
        priority.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("status"));
        category.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("category"));
        edit.setCellValueFactory(new PropertyValueFactory("edit"));

        ObservableList<ForwardWorkTable> data = FXCollections.observableArrayList();

        ArrayList<tasktracking.models.ForwardWork> allWork = new FileManager().readForwardWork();

        for (tasktracking.models.ForwardWork f : allWork){
            EventHandler<ActionEvent> temp = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/FXML/editwork/editforward.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.setScene(new Scene(root));
                        EditForward editForwardController = (EditForward) fxmlLoader.getController();
                        editForwardController.setAttribute(f);
                        stage.show();
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }
                }
            };
            data.add(new ForwardWorkTable(f,temp));

        }

        table.setItems(data);
    }

    @FXML
    public void handleAddForwardWork(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("AddForwardWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า AddForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleGotoCategory(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("CategoryForward");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า CategoryForward ไม่ได้");
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
