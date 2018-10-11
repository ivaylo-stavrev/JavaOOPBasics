package ex08_military_elite;

public class Mission implements IMission{
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        if(("inProgress".equals(state)) || ("Finished".equals(state))) {
            this.state = state;
        } else {
            throw new IllegalArgumentException("Mission state not recognized.");
        }
    }

    @Override
    public void CompleteMission() {
        //System.out.println("CompleteMission executed");
        this.setState("Finished");
    }
}
