package tasktracking.services;


import tasktracking.models.ForwardWork;
import tasktracking.models.GeneralWork;
import tasktracking.models.ProjectWork;
import tasktracking.models.WeeklyWork;


import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // GeneralWork
    public ArrayList<GeneralWork> readGeneralWork() {
        ArrayList<GeneralWork> allWork = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("information/GeneralInfo.txt")));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                String jobname = data[0];
                String date = data[1];
                String timestart = data[2];
                String timeend = data[3];
                String priority = data[4];
                String category = data[5];
                String status = data[6];
                GeneralWork g = new GeneralWork(jobname, date, timestart, timeend, priority, category, status);
                allWork.add(g);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allWork;
    }

    public void addNewGeneralWork(GeneralWork g) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/GeneralInfo.txt"), true));
            String line = g.getJobname() + "," + g.getDate() + "," + g.getTimestart() + "," + g.getTimeend() + "," + g.getPriority() + "," + g.getCategory() + "," + g.getStatus();
            writer.write(line);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAllGeneralWorkAfterDelete(ArrayList<GeneralWork> generalWorks){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/GeneralInfo.txt")));
            for (GeneralWork g : generalWorks){
                String line = g.getJobname() + "," + g.getDate() + "," + g.getTimestart() + "," + g.getTimeend() + "," + g.getPriority() + "," + g.getCategory() + "," + g.getStatus();
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkFileNameGeneral(String name){
        ArrayList<GeneralWork> allwork = readGeneralWork();
        for (GeneralWork generalWork : allwork){
            if (generalWork.getJobname().equals(name)){
                return true;
            }
        }
        return false;
    }



    //Forward Work
    public ArrayList<ForwardWork> readForwardWork() {
        ArrayList<ForwardWork> allWork = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("information/ForwardInfo.txt")));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                String jobname = data[0];
                String responsiblePerson = data[1];
                String date = data[2];
                String timestart = data[3];
                String timeend = data[4];
                String priority = data[5];
                String category = data[6];
                String status = data[7];
                ForwardWork f = new ForwardWork(jobname, responsiblePerson, date, timestart, timeend, priority, category, status);
                allWork.add(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allWork;
    }

    public void addNewForwardWork(ForwardWork f) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/ForwardInfo.txt"), true));
            String line = f.getJobname() + "," + f.getResponsiblePerson() + "," + f.getDate() + "," + f.getTimestart() + "," + f.getTimeend() + "," + f.getPriority() + "," + f.getCategory() + "," + f.getStatus();
            writer.write(line);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAllForwardWorkAfterDelete(ArrayList<ForwardWork> forwardWorks){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/ForwardInfo.txt")));
            for (ForwardWork f : forwardWorks){
                String line = f.getJobname() + "," + f.getResponsiblePerson()+ "," + f.getDate() + "," + f.getTimestart() + "," + f.getTimeend() + "," + f.getPriority() + "," + f.getCategory() + "," + f.getStatus();
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean checkFileNameForward(String name){
        ArrayList<ForwardWork> allwork = readForwardWork();
        for (ForwardWork forwardWork : allwork){
            if (forwardWork.getJobname().equals(name)){
                return true;
            }
        }
        return false;
    }

    //Project Work
    public ArrayList<ProjectWork> readProjectWork() {
        ArrayList<ProjectWork> allWork = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("information/ProjectInfo.txt")));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                String projectname = data[0];
                String projectsupervisor = data[1];
                String datestart = data[2];
                String dateend = data[3];
                String priority = data[4];
                String category = data[5];
                String status = data[6];
                ProjectWork p = new ProjectWork(projectname, projectsupervisor, datestart, dateend, priority, category, status);
                allWork.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allWork;
    }

    public void addNewProjectWork(ProjectWork p) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/ProjectInfo.txt"), true));
            String line = p.getProjectname() + "," + p.getProjectsupervisor() + "," + p.getDatestart() + "," + p.getDateend() + "," + p.getPriority() + "," + p.getCategory() + "," + p.getStatus();
            writer.write(line);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean checkFileNameProject(String name){
        ArrayList<ProjectWork> allwork = readProjectWork();
        for (ProjectWork projectWork : allwork){
            if (projectWork.getProjectname().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void writeAllProjectWorkAfterDelete(ArrayList<ProjectWork> projectWorks){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/ProjectInfo.txt")));
            for (ProjectWork p : projectWorks){
                String line = p.getProjectname() + "," + p.getProjectsupervisor()+ "," + p.getDatestart() + "," + p.getDateend() + "," + p.getPriority() + "," + p.getCategory() + "," + p.getStatus();
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //WeeklyWork
    public ArrayList<WeeklyWork> readWeeklyWork() {
        ArrayList<WeeklyWork> allWork = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("information/WeeklyInfo.txt")));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                String jobname = data[0];
                String date = data[1];
                String timestart = data[2];
                String timend = data[3];
                String priority = data[4];
                String category = data[5];
                String status = data[6];
                WeeklyWork w = new WeeklyWork(jobname, date, timestart, timend, priority, category, status);
                allWork.add(w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allWork;
    }

    public void addNewWeeklyWork(WeeklyWork w) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/WeeklyInfo.txt"), true));
            String line = w.getJobname() + "," + w.getDate() + "," + w.getTimestart() + "," + w.getTimeend() + "," + w.getPriority() + "," + w.getCategory() + "," + w.getStatus();
            writer.write(line);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean checkFileNameWeekly(String name){
        ArrayList<WeeklyWork> allwork = readWeeklyWork();
        for (WeeklyWork weeklyWork : allwork){
            if (weeklyWork.getJobname().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void writeAllWeeklyWorkAfterDelete(ArrayList<WeeklyWork> weeklyWorks){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("information/WeeklyInfo.txt")));
            for (WeeklyWork w : weeklyWorks){
                String line = w.getJobname() + "," + w.getDate() + "," + w.getTimestart() + "," + w.getTimeend() + "," + w.getPriority() + "," + w.getCategory() + "," + w.getStatus();
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





//    public void updateAllForward(ArrayList<ForwardWork> allWork) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/resources/information/ForwardInfo.txt")));
//            for (ForwardWork f : allWork) {
//                String line = f.getJobname() + "," + f.getResponsiblePerson() + "," + f.getDate() + "," + f.getTimestart() + "," + f.getTimeend() + "," + f.getPriority() + "," + f.getCategory() + "," + f.getStatus();
//                writer.write(line);
//                writer.newLine();
//            }
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
