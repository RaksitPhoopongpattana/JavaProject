package tasktracking.controllers.editwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import tasktracking.models.GeneralWork;
import tasktracking.services.FileManager;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditGeneral {
    @FXML
    private TextField jobname, timestarthour, timestartminute, timeendhour, timeendminute, priority, category;

    @FXML
    private DatePicker date;

    private String first;

    public void setAttribute(GeneralWork generalWork){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        LocalDate temp = LocalDate.parse(generalWork.getDate(),format);
        first = generalWork.getJobname();
        jobname.setText(generalWork.getJobname());
        date.setValue(temp);
        String sep[] = generalWork.getTimestart().split("\\.");
        System.out.println(sep.length);
        timestarthour.setText(sep[0]);
        timestartminute.setText(sep[1]);
        sep = generalWork.getTimeend().split("\\.");
        timeendhour.setText(sep[0]);
        timeendminute.setText(sep[1]);
        priority.setText(generalWork.getPriority());
        category.setText(generalWork.getCategory());
    }

    @FXML
    public void delete(ActionEvent event){
        FileManager fileManager = new FileManager();

        ArrayList<GeneralWork> generalWorks = fileManager.readGeneralWork();
        for (int i=0; i<generalWorks.size(); i++){
            if (generalWorks.get(i).getJobname().equals(first)){
                generalWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllGeneralWorkAfterDelete(generalWorks);
        try {
            FXRouter.goTo("GeneralWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();

    }

    @FXML
    public void save(ActionEvent event){
        FileManager fileManager = new FileManager();
        String s = null;
        ArrayList<GeneralWork> generalWorks = fileManager.readGeneralWork();
        for (int i=0; i<generalWorks.size(); i++){
            if (generalWorks.get(i).getJobname().equals(first)){
                s = generalWorks.get(i).getStatus();
                generalWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllGeneralWorkAfterDelete(generalWorks);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        String timestart = timestarthour.getText()+"."+timestartminute.getText();
        String timeend = timeendhour.getText()+"."+timeendminute.getText();
        GeneralWork g = new GeneralWork(jobname.getText(), date.getValue().format(format), timestart, timeend, priority.getText(), category.getText(),s);
        new FileManager().addNewGeneralWork(g);
        try {
            FXRouter.goTo("GeneralWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }



}
