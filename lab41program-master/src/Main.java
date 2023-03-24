import Behavior.IPlace;
import People.Hatter;
import People.alice;
import People.Tourist;
import Object.*;
import checkException.PushException;
import checkException.TimeException;
import checkException.TransformException;

public class Main {


    public static void main(String[] args){

    	
       alice alice = new alice("Alice","Felmale");
        Hatter Hatter = new Hatter("Hatter","'Male");
        Tourist tourist = new Tourist("Tourist","Male");
        Table table = new Table("table","red",Status.INITIAL_STATE);
        FoldingChair chair = new FoldingChair("Folding Chair","blue",Status.INITIAL_STATE);
        Umbrella umbrella = new Umbrella("Umbrella","green", Status.INITIAL_STATE);
        Tourist.Newperson newperson = tourist.new Newperson("Other man","male"); // Inner class

//        Anonymous class
        IPlace Place = new IPlace() {
            private String location;
            @Override
            public void setLocation(String location) {
                this.location = location;
            }

            public String getLocation(){
                return location;
            }

           @Override
           public void express(){
                System.out.println(getLocation());
            }
        };
        Place.setLocation("IN THE ROOM");
        Place.express();

        alice.Show(tourist.getName(), "a kind of clumsy structure");
        alice.printMessage(alice.getName());
        System.out.println("It's like an " + umbrella.getName());

//        catch unchecked exception
        try {
            alice.Push("the button on the " + umbrella.getName());
        }catch (PushException elex){
            System.out.println(elex.getMessage());
        }

        try{
            alice.doSomethings("else");
        }catch (PushException elex){
            System.out.println(elex.getMessage());
        }

//        catch unchecked exception
        try{
            umbrella.Transform(Status.INITIAL_STATE);
        }catch (TransformException | PushException clex){
            System.out.println(clex.getMessage());
        }

        Hatter.Sitdown(table.getName());
        Hatter.LegBend("in the most unnatural way");


        newperson.Talk(Hatter.getName()," another topic");
        System.out.println("Then");
        Hatter.Leave(table.getName());
        Tourist.AnotherPerson.Present("there");
        System.out.println(Hatter.getName() + " turn around and ");
        Hatter.Ask("that man","somethings new");
        alice.understand(true);
        System.out.println("");
        Hatter.Ask("Please tell me ","what book did you write?");
        alice.didnt("write a single book yet");
        Hatter.think( "It would be nice to come up with a machine that could be a writer");
        alice.agree(Hatter.getName());
    }

}

