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
import tasktracking.services.FileManager;
import tasktracking.controllers.ForwardWork;
import tasktracking.models.ForwardWorkCategoryTable;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryForward {

    private ArrayList<tasktracking.models.ForwardWork> allWork;

    @FXML
    TableView table;
    @FXML
    TableColumn jobname,responsiblePerson,date,timestart,timeend,priority,status;
    @FXML
    ComboBox pickcategory;

    @FXML
    public void initialize(){
        jobname.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("jobname"));
        responsiblePerson.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("responsiblePerson"));
        date.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("date"));
        timestart.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("timestart"));
        timeend.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("timeend"));
        priority.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<ForwardWork, String>("status"));

        allWork = new FileManager().readForwardWork();
        ArrayList<String> categoryset = getCategory(allWork);
        ObservableList<String> category = FXCollections.observableArrayList();
        for (String s : categoryset){
            category.add(s);
        }
        pickcategory.setItems(category);
    }

    private ArrayList<String> getCategory(ArrayList<tasktracking.models.ForwardWork> allWork){
        ArrayList<String> allc = new ArrayList<>();
        for (tasktracking.models.ForwardWork f : allWork){
            if (!allc.contains(f.getCategory())){
                allc.add(f.getCategory());
            }
        }
        return allc;
    }

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
        String category = pickcategory.getSelectionModel().getSelectedItem().toString();
        ArrayList<tasktracking.models.ForwardWork> filtered = filter(allWork, category);

        ObservableList<ForwardWorkCategoryTable> data = FXCollections.observableArrayList();
        for (tasktracking.models.ForwardWork f : filtered){
            data.add(new ForwardWorkCategoryTable(f));
        }

        table.setItems(data);
    }

    private ArrayList<tasktracking.models.ForwardWork> filter(ArrayList<tasktracking.models.ForwardWork> allWork, String keyword){
        ArrayList<tasktracking.models.ForwardWork> filtered = new ArrayList<>();
        for (tasktracking.models.ForwardWork f : allWork){
            if (f.getCategory().equals(keyword)){
                filtered.add(f);
            }
        }
        return filtered;
    }

}
