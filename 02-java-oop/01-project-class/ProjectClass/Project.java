package ProjectClass;

public class Project{
    private String name;
    private String description;
    private double initialCost;

    public Project(){
    }

    public Project(String name){
        this.name = name;
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void elevatorPitch(String name, String description, Double initialCost){
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setInitialCost(Double initialCost){
        this.initialCost= initialCost;
    }

    public String getInitialCost(){
        return Double.toString(initialCost);
    }

    public String elevatorPitch(){
        return name + " (" + Double.toString(initialCost) +") : " + description;
    }

}