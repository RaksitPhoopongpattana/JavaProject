package tasktracking.controllers.editwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tasktracking.models.WeeklyWork;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditWeekly {
    @FXML
    private TextField jobname, timestarthour, timestartminute, timeendhour, timeendminute, priority, category;

    @FXML
    private DatePicker date;

    private String first;

    public void setAttribute(WeeklyWork weeklyWork){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        LocalDate temp = LocalDate.parse(weeklyWork.getDate(),format);
        first = weeklyWork.getJobname();
        jobname.setText(weeklyWork.getJobname());
        date.setValue(temp);
        String sep[] = weeklyWork.getTimestart().split("\\.");
        System.out.println(sep.length);
        timestarthour.setText(sep[0]);
        timestartminute.setText(sep[1]);
        sep = weeklyWork.getTimeend().split("\\.");
        timeendhour.setText(sep[0]);
        timeendminute.setText(sep[1]);
        priority.setText(weeklyWork.getPriority());
        category.setText(weeklyWork.getCategory());
    }

    @FXML
    public void delete(ActionEvent event){
        FileManager fileManager = new FileManager();

        ArrayList<WeeklyWork> weeklyWorks = fileManager.readWeeklyWork();
        for (int i=0; i<weeklyWorks.size(); i++){
            if (weeklyWorks.get(i).getJobname().equals(first)){
                weeklyWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllWeeklyWorkAfterDelete(weeklyWorks);
        try {
            FXRouter.goTo("WeeklyWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();

    }

    @FXML
    public void save(ActionEvent event){
        FileManager fileManager = new FileManager();
        String s = null;
        ArrayList<WeeklyWork> weeklyWorks = fileManager.readWeeklyWork();
        for (int i=0; i<weeklyWorks.size(); i++){
            if (weeklyWorks.get(i).getJobname().equals(first)){
                s = weeklyWorks.get(i).getStatus();
                weeklyWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllWeeklyWorkAfterDelete(weeklyWorks);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        String timestart = timestarthour.getText()+"."+timestartminute.getText();
        String timeend = timeendhour.getText()+"."+timeendminute.getText();
        WeeklyWork w = new WeeklyWork(jobname.getText(), date.getValue().format(format), timestart, timeend, priority.getText(), category.getText(),s);
        new FileManager().addNewWeeklyWork(w);
        try {
            FXRouter.goTo("WeeklyWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }
}
