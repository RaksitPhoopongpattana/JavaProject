package tasktracking.controllers.addwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tasktracking.services.FileManager;
import tasktracking.models.GeneralWork;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class AddGeneralWork {

    @FXML
    TextField jobname,timestarthour,timestartminute,timeendhour,timeendminute,priority,category;
    @FXML
    DatePicker date;

    public void handleUseBackToGeneral(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("GeneralWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า GeneralWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void submit(ActionEvent actionEvent){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        String timestart = timestarthour.getText()+"."+timestartminute.getText();
        String timeend = timeendhour.getText()+"."+timeendminute.getText();
        GeneralWork g = new GeneralWork(jobname.getText(), date.getValue().format(format), timestart, timeend, priority.getText(), category.getText(), "not finish");

        if (new FileManager().checkFileNameGeneral(jobname.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR,"ชื่อซ้ำ");
            alert.showAndWait();
            return;
        }
        new FileManager().addNewGeneralWork(g);
        try {
            FXRouter.goTo("GeneralWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า GeneralWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }


}
