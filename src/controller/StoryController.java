package controller;

public class StoryController {

    private int[] story;

    public StoryController(){
        story = new int[0];
    }

    public String answer(int answer){
        addStory(answer);
        return getStoryFromTxt();
    }

    private String getStoryFromTxt(){
        String help = "";

        //TODO: Aus Textdatei auslesen.

        return help;
    }

    private void addStory(int a){
        int[] help = new int[story.length+1];
        for(int i = 0; i<story.length; i++){
            help[i] = story[i];
        }
        help[help.length-1] = a;
        story = help;
    }
}
