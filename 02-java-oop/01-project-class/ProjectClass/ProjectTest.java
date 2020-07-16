package ProjectClass;
public class ProjectTest{
    public static void main(String[] args) {
        Project project1 = new Project();
        System.out.println("Project Name: " + project1.getName());
        project1.setDescription("This is a description of Project One...");
        System.out.println("Project Description: " + project1.getDescription());
        project1.setInitialCost(500.0);
        System.out.println("Initial Cost: " + project1.getInitialCost());

        Project project2 = new Project("Project Two");
        System.out.println("Project Name: " + project2.getName());
        project2.setDescription("This is a description of Project Two...");
        System.out.println("Project Description: " + project2.getDescription());
        project2.setInitialCost(350.0);
        System.out.println("Initial Cost: " + project2.getInitialCost());

        Project project3 = new Project("Project 3", "This is a description of Project Three...");
        System.out.println("Project Name: " + project3.getName());
        System.out.println("Project Description: " + project3.getDescription());
        project3.setInitialCost(1000.0);
        System.out.println("Initial Cost: " + project3.getInitialCost());

        System.out.println(project3.elevatorPitch());
    }
}