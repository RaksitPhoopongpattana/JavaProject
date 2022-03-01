package tasktracking.controllers.categorywork;

import com.github.saacsos.FXRouter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasktracking.controllers.WeeklyWork;
import tasktracking.models.WeeklyWorkCategoryTable;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryWeekly {

    private ArrayList<tasktracking.models.WeeklyWork> allWork;

    @FXML
    TableView table;
    @FXML
    TableColumn jobname,date,timestart,timeend,priority,status;
    @FXML
    ComboBox pickcategory;

    @FXML
    public void initialize(){
        jobname.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("jobname"));
        date.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("date"));
        timestart.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("timestart"));
        timeend.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("timeend"));
        priority.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<WeeklyWork, String>("status"));

        allWork = new FileManager().readWeeklyWork();
        ArrayList<String> categoryset = getCategory(allWork);
        ObservableList<String> category = FXCollections.observableArrayList();
        for (String s : categoryset){
            category.add(s);
        }
        pickcategory.setItems(category);
    }

    private ArrayList<String> getCategory(ArrayList<tasktracking.models.WeeklyWork> allWork){
        ArrayList<String> allc = new ArrayList<>();
        for (tasktracking.models.WeeklyWork w : allWork){
            if (!allc.contains(w.getCategory())){
                allc.add(w.getCategory());
            }
        }
        return allc;
    }

    @FXML
    public void handleUseBackToWeekly(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("WeeklyWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void submit(ActionEvent actionEvent){
        String category = pickcategory.getSelectionModel().getSelectedItem().toString();
        ArrayList<tasktracking.models.WeeklyWork> filtered = filter(allWork, category);

        ObservableList<WeeklyWorkCategoryTable> data = FXCollections.observableArrayList();
        for (tasktracking.models.WeeklyWork w : filtered){
            data.add(new WeeklyWorkCategoryTable(w));
        }

        table.setItems(data);
    }

    private ArrayList<tasktracking.models.WeeklyWork> filter(ArrayList<tasktracking.models.WeeklyWork> allWork, String keyword){
        ArrayList<tasktracking.models.WeeklyWork> filtered = new ArrayList<>();
        for (tasktracking.models.WeeklyWork w : allWork){
            if (w.getCategory().equals(keyword)){
                filtered.add(w);
            }
        }
        return filtered;
    }
}
