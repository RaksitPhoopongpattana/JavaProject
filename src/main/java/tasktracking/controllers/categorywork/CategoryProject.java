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
import tasktracking.controllers.ProjectWork;
import tasktracking.models.ProjectWorkCategoryTable;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryProject {

    private ArrayList<tasktracking.models.ProjectWork> allWork;

    @FXML
    TableView table;
    @FXML
    TableColumn projectname,projectsupervisor,datestart,dateend,priority,status;
    @FXML
    ComboBox pickcategory;

    @FXML
    public void initialize(){
        projectname.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("projectname"));
        projectsupervisor.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("projectsupervisor"));
        datestart.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("datestart"));
        dateend.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("dateend"));
        priority.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("priority"));
        status.setCellValueFactory(new PropertyValueFactory<ProjectWork, String>("status"));

        allWork = new FileManager().readProjectWork();
        ArrayList<String> categoryset = getCategory(allWork);
        ObservableList<String> category = FXCollections.observableArrayList();
        for (String s : categoryset){
            category.add(s);
        }
        pickcategory.setItems(category);
    }

    private ArrayList<String> getCategory(ArrayList<tasktracking.models.ProjectWork> allWork){
        ArrayList<String> allc = new ArrayList<>();
        for (tasktracking.models.ProjectWork p : allWork){
            if (!allc.contains(p.getCategory())){
                allc.add(p.getCategory());
            }
        }
        return allc;
    }

    @FXML
    public void submit(ActionEvent actionEvent){
        String category = pickcategory.getSelectionModel().getSelectedItem().toString();
        ArrayList<tasktracking.models.ProjectWork> filtered = filter(allWork, category);

        ObservableList<ProjectWorkCategoryTable> data = FXCollections.observableArrayList();
        for (tasktracking.models.ProjectWork p : filtered){
            data.add(new ProjectWorkCategoryTable(p));
        }

        table.setItems(data);
    }

    private ArrayList<tasktracking.models.ProjectWork> filter(ArrayList<tasktracking.models.ProjectWork> allWork, String keyword){
        ArrayList<tasktracking.models.ProjectWork> filtered = new ArrayList<>();
        for (tasktracking.models.ProjectWork p : allWork){
            if (p.getCategory().equals(keyword)){
                filtered.add(p);
            }
        }
        return filtered;
    }

    @FXML
    public void handleUseBackToProject(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("ProjectWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
