package tasktracking.controllers.addwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tasktracking.models.GeneralWork;
import tasktracking.models.WeeklyWork;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class AddWeeklyWork {

    @FXML
    TextField jobname,timestarthour,timestartminute,timeendhour,timeendminute,priority,category;
    @FXML
    DatePicker date;

    @FXML
    public void submit(ActionEvent actionEvent){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        String timestart = timestarthour.getText()+"."+timestartminute.getText();
        String timeend = timeendhour.getText()+"."+timeendminute.getText();
        WeeklyWork w = new WeeklyWork(jobname.getText(), date.getValue().format(format), timestart, timeend, priority.getText(), category.getText(), "not finish");
        if (new FileManager().checkFileNameWeekly(jobname.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR,"ชื่อซ้ำ");
            alert.showAndWait();
            return;
        }
        new FileManager().addNewWeeklyWork(w);
        try {
            FXRouter.goTo("WeeklyWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า WeeklyWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleUseBackToWeekly(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("WeeklyWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า WeeklyWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}
