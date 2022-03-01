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
import tasktracking.controllers.editwork.EditGeneral;
import tasktracking.services.FileManager;
import tasktracking.models.GeneralWorkTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GeneralWork {

    @FXML
    TableView table;
    @FXML
    TableColumn jobname,date,timestart,timeend,priority,status,category;

    @FXML TableColumn<GeneralWork, Button> edit;

    @FXML
    public void initialize(){
        jobname.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("jobname"));
        date.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("date"));
        timestart.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("timestart"));
        timeend.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("timeend"));
        priority.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("status"));
        category.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("category"));
        edit.setCellValueFactory(new PropertyValueFactory("edit"));

        ObservableList<GeneralWorkTable> data = FXCollections.observableArrayList();

        ArrayList<tasktracking.models.GeneralWork> allWork = new FileManager().readGeneralWork();
        Collections.sort(allWork);


        for (tasktracking.models.GeneralWork g : allWork){
            EventHandler<ActionEvent> temp = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                          FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/FXML/editwork/editgeneral.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.setScene(new Scene(root));
                        EditGeneral editGeneralController = (EditGeneral) fxmlLoader.getController();
                        editGeneralController.setAttribute(g);
                        stage.show();
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }
                }
            };
            data.add(new GeneralWorkTable(g,temp));
        }

        table.setItems(data);
    }

    @FXML
    public void handleAddGeneralWork(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("AddGeneralWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า AddGeneralWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleGotoCategory(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("CategoryGeneral");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า CategoryGeneral ไม่ได้");
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
