package controller;

import model.Event;
import model.Story;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StoryController {

    private Story story;
    private File storyTXT;
    private Scanner in;

    private MainController mainController;
    private Event actEvent;

    public StoryController(MainController mainController) {
        storyTXT = new File("story.txt");
        story = new Story();

        this.mainController = mainController;
    }

    public void getStoryFromTxt(){
        try {
            in = new Scanner(storyTXT);
            while(in.hasNext()){
                if(in.next().equals("***")){
                    story.insertNewEvent();
                    story.getAllEvents()[story.getAllEvents().length-1].setIntroduction(in.next());
                }else if(in.next().equals("**")){
                    story.getAllEvents()[story.getAllEvents().length-1].insertNewChoice();
                    story.getAllEvents()[story.getAllEvents().length-1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length-1].getAllChoices().length-1].setChoiceIntro(in.next());
                }else if(in.next().equals("*")){
                    story.getAllEvents()[story.getAllEvents().length-1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length-1].getAllChoices().length-1].setChoiceOutcome(in.next());
                }else if(in.next().equals("#1")){
                    story.getAllEvents()[story.getAllEvents().length-1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length-1].getAllChoices().length-1].setPar1(in.nextInt());
                }else if(in.next().equals("#2")){
                    story.getAllEvents()[story.getAllEvents().length-1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length-1].getAllChoices().length-1].setPar2(in.nextInt());
                }else if(in.next().equals("#3")){
                    story.getAllEvents()[story.getAllEvents().length-1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length-1].getAllChoices().length-1].setPar3(in.nextInt());
                }else if(in.next().equals("#4")){
                    story.getAllEvents()[story.getAllEvents().length-1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length-1].getAllChoices().length-1].setPar4(in.nextInt());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void startNewEvent(){
        actEvent = story.getAllEvents()[(int)(Math.random()*story.getAllEvents().length)];
    }

    public Event getActEvent(){
        return actEvent;
    }
}
