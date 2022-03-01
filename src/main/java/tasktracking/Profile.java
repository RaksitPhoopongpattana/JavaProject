package tasktracking;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class Profile {
    @FXML
    public void handleUseBackToInterface(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("AppInterface");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า AppInterface ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
