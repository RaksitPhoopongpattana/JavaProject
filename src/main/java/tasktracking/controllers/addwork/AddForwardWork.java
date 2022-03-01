package tasktracking.controllers.addwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tasktracking.services.FileManager;
import tasktracking.models.ForwardWork;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class AddForwardWork {

    @FXML
    TextField jobname,responsiblePerson,timestarthour,timestartminute,timeendhour,timeendminute,priority,category;
    @FXML
    DatePicker date;

    @FXML
    public void handleUseBackToForward(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("ForwardWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void submit(ActionEvent actionEvent){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        String timestart = timestarthour.getText()+"."+timestartminute.getText();
        String timeend = timeendhour.getText()+"."+timeendminute.getText();
        ForwardWork f = new ForwardWork(jobname.getText(), responsiblePerson.getText(), date.getValue().format(format), timestart, timeend, priority.getText(), category.getText(), "not finish");
        if (new FileManager().checkFileNameForward(jobname.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR,"ชื่อซ้ำ");
            alert.showAndWait();
            return;
        }
        new FileManager().addNewForwardWork(f);
        try {
            FXRouter.goTo("ForwardWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
