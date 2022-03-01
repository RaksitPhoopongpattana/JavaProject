package tasktracking.controllers.editwork;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tasktracking.models.ForwardWork;
import tasktracking.models.GeneralWork;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditForward {
    @FXML
    private TextField jobname,responsiblePerson, timestarthour, timestartminute, timeendhour, timeendminute, priority, category;

    @FXML
    private DatePicker date;

    private String first;

    public void setAttribute(ForwardWork forwardWork){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        LocalDate temp = LocalDate.parse(forwardWork.getDate(),format);
        first = forwardWork.getJobname();
        jobname.setText(forwardWork.getJobname());
        responsiblePerson.setText(forwardWork.getResponsiblePerson());
        date.setValue(temp);
        String sep[] = forwardWork.getTimestart().split("\\.");
        System.out.println(sep.length);
        timestarthour.setText(sep[0]);
        timestartminute.setText(sep[1]);
        sep = forwardWork.getTimeend().split("\\.");
        timeendhour.setText(sep[0]);
        timeendminute.setText(sep[1]);
        priority.setText(forwardWork.getPriority());
        category.setText(forwardWork.getCategory());
    }

    @FXML
    public void delete(ActionEvent event){
        FileManager fileManager = new FileManager();

        ArrayList<ForwardWork> forwardWorks = fileManager.readForwardWork();
        for (int i=0; i<forwardWorks.size(); i++){
            if (forwardWorks.get(i).getJobname().equals(first)){
                forwardWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllForwardWorkAfterDelete(forwardWorks);
        try {
            FXRouter.goTo("ForwardWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();

    }

    @FXML
    public void save(ActionEvent event){
        FileManager fileManager = new FileManager();
        String s = null;
        ArrayList<ForwardWork> forwardWorks = fileManager.readForwardWork();
        for (int i=0; i<forwardWorks.size(); i++){
            if (forwardWorks.get(i).getJobname().equals(first)){
                s = forwardWorks.get(i).getStatus();
                forwardWorks.remove(i);
                break;
            }
        }
        fileManager.writeAllForwardWorkAfterDelete(forwardWorks);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy");
        String timestart = timestarthour.getText()+"."+timestartminute.getText();
        String timeend = timeendhour.getText()+"."+timeendminute.getText();
        ForwardWork f = new ForwardWork(jobname.getText(),responsiblePerson.getText(), date.getValue().format(format), timestart, timeend, priority.getText(), category.getText(),s);
        new FileManager().addNewForwardWork(f);
        try {
            FXRouter.goTo("ForwardWork");
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }
}
