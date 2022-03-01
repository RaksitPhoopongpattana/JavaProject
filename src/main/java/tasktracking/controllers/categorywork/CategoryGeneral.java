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
import tasktracking.controllers.GeneralWork;
import tasktracking.models.GeneralWorkCategoryTable;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryGeneral {

    private ArrayList<tasktracking.models.GeneralWork> allWork;

    @FXML
    TableView table;
    @FXML
    TableColumn jobname,date,timestart,timeend,priority,status;
    @FXML
    ComboBox pickcategory;

    @FXML
    public void initialize(){
        jobname.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("jobname"));
        date.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("date"));
        timestart.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("timestart"));
        timeend.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("timeend"));
        priority.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<GeneralWork, String>("status"));

        allWork = new FileManager().readGeneralWork();
        ArrayList<String> categoryset = getCategory(allWork);
        ObservableList<String> category = FXCollections.observableArrayList();
        for (String s : categoryset){
            category.add(s);
        }
        pickcategory.setItems(category);
    }

    private ArrayList<String> getCategory(ArrayList<tasktracking.models.GeneralWork> allWork){
        ArrayList<String> allc = new ArrayList<>();
        for (tasktracking.models.GeneralWork g : allWork){
            if (!allc.contains(g.getCategory())){
                allc.add(g.getCategory());
            }
        }
        return allc;
    }

    @FXML
    public void handleUseBackToGeneral(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("GeneralWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void submit(ActionEvent actionEvent){
        String category = pickcategory.getSelectionModel().getSelectedItem().toString();
        ArrayList<tasktracking.models.GeneralWork> filtered = filter(allWork, category);

        ObservableList<GeneralWorkCategoryTable> data = FXCollections.observableArrayList();
        for (tasktracking.models.GeneralWork g : filtered){
            data.add(new GeneralWorkCategoryTable(g));
        }

        table.setItems(data);
    }

    private ArrayList<tasktracking.models.GeneralWork> filter(ArrayList<tasktracking.models.GeneralWork> allWork, String keyword){
        ArrayList<tasktracking.models.GeneralWork> filtered = new ArrayList<>();
        for (tasktracking.models.GeneralWork g : allWork){
            if (g.getCategory().equals(keyword)){
                filtered.add(g);
            }
        }
        return filtered;
    }
}
