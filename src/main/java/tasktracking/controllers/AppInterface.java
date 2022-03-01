package tasktracking.controllers;

import javafx.fxml.FXML;
import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppInterface {

    @FXML
    public void handleGeneralWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("GeneralWork");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า generalwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleWeeklyWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("WeeklyWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า WeeklyWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleForwardWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("ForwardWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ForwardWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleProjectWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("ProjectWork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า ProjectWork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleProfile(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("Profile");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Profile ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML public void initialize() {
        String fs = File.separator;
        String dir = System.getProperty("user.dir") + fs + "information";
        String filename = dir + fs + "GeneralInfo.txt";
        String filename2 = dir + fs + "WeeklyInfo.txt";
        String filename3 = dir + fs + "ForwardInfo.txt";
        String filename4 = dir + fs + "ProjectInfo.txt";
        File file = new File(dir);
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
                File myFile1 = new File(filename);
                File myFile2 = new File(filename2);
                File myFile3 = new File(filename3);
                File myFile4 = new File(filename4);
                myFile1.createNewFile();
                myFile2.createNewFile();
                myFile3.createNewFile();
                myFile4.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(filename));
                bufferedWriter.write("General01,03-20-21,10.30,11.30,1,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("General02,03-20-21,11.30,12.30,2,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("General03,03-19-21,9.30,9.45,3,physic,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("General04,03-23-21,10.30,10.45,2,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("General05,03-22-21,15.30,16.30,4,Eng,not finish");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                bufferedWriter = new BufferedWriter(new FileWriter(filename2));
                bufferedWriter.write("Weekly01,04-20-21,10.30,11.30,1,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Weekly02,05-20-21,11.30,12.30,2,java,finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Weekly03,06-19-21,9.30,9.45,4,physic,finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Weekly04,07-23-21,10.30,10.45,2,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Weekly05,08-22-21,15.30,16.30,4,Eng,not finish");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                bufferedWriter = new BufferedWriter(new FileWriter(filename3));
                bufferedWriter.write("Forward01,Bangpun,03-20-21,10.30,11.30,1,java,finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Forward02,Kasin,03-21-21,11.30,12.30,1,eng,finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Forward03,Korn,03-22-21,9.30,11.30,2,math,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Forward04,Non,03-19-21,8.30,11.30,3,physic,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Forward05,Earth,03-18-21,10.30,11.30,2,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                bufferedWriter = new BufferedWriter(new FileWriter(filename4));
                bufferedWriter.write("Project01,Raksit,03-20-21,03-21-21,1,java,finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Project02,Kasin,03-21-21,04-23-21,1,eng,finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Project03,Sipakorn,03-22-21,03-24-21,2,math,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Project04,Arnon,03-19-21,03-30-21,3,physic,not finish");
                bufferedWriter.newLine();
                bufferedWriter.write("Project05,Earth,03-18-21,03-25-21,2,java,not finish");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if (bufferedWriter != null) bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
