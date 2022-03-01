package tasktracking;

import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXRouter.bind(this, primaryStage, "TimeTracking", 800, 600);
        Image icon = new Image(getClass().getResourceAsStream("/image/icontimetracking.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
        configRoute();

        FXRouter.goTo("AppInterface");
    }

    private static void configRoute() {
        FXRouter.when("Profile", "FXML/mainInterface/profile.fxml");
        FXRouter.when("AppInterface", "FXML/mainInterface/interface.fxml");
        FXRouter.when("GeneralWork", "FXML/work/generalwork.fxml");
        FXRouter.when("WeeklyWork", "FXML/work/weeklywork.fxml");
        FXRouter.when("ForwardWork", "FXML/work/forwardwork.fxml");
        FXRouter.when("ProjectWork", "FXML/work/projectwork.fxml");
        FXRouter.when("AddGeneralWork", "FXML/addwork/addgeneralwork.fxml");
        FXRouter.when("AddForwardWork", "FXML/addwork/addforwardwork.fxml");
        FXRouter.when("AddProjectWork", "FXML/addwork/addprojectwork.fxml");
        FXRouter.when("AddWeeklyWork", "FXML/addwork/addweeklywork.fxml");
        FXRouter.when("CategoryGeneral", "FXML/category/generalcategory.fxml");
        FXRouter.when("CategoryForward", "FXML/category/forwardcategory.fxml");
        FXRouter.when("CategoryProject", "FXML/category/projectcategory.fxml");
        FXRouter.when("CategoryWeekly", "FXML/category/weeklycategory.fxml");
        FXRouter.when("EditGeneral", "FXML/editwork/editgeneral.fxml");
        FXRouter.when("EditForward", "FXML/editwork/editforward.fxml");
        FXRouter.when("EditProject", "FXML/editwork/editproject.fxml");
        FXRouter.when("EditWeekly", "FXML/editwork/editweekly.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}