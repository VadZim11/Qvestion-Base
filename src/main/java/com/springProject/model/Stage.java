package com.springProject.model;


public class Stage {
    String name;

    private Stage(){
        name = "PrimaryStage";
    }

    private static class StageHolder{
        static Stage stageInstance = new Stage();
    }

    public static Stage getInstance(){
        return StageHolder.stageInstance;
    }

    public String getName() {
        return name;
    }
}
