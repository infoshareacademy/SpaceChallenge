import java.util.ArrayList;
import java.util.Collections;


public class main {

    public static void main(String [] args) throws Exception{

        int budget=0;                                       //

        //Collections.sort(itemsList); //                               sorting items list in future

        for(int i=1;i<=2;i++) { //                                  phase 1 and 2 or maybe later 3,4,5...
            Simulation symulate = new Simulation();
            ArrayList<Item> itemsList = new ArrayList();        // arraylist to keep items from txt and send to rocket methods
            ArrayList<Rocket> uRocketList = new ArrayList();    // list to keep loaded rockets and send to launch/land simulation

            itemsList= symulate.loadItems(i);                       //loading items from txt to arraylist , i = phase

            Collections.sort(itemsList);                        // descending sort list of items, this might reduce quantity of rockets needed to carry total load
/*
            for (Item j:itemsList) {
                System.out.println(j.name + " " + j.weight);       // Test loop to check if everything is correct and sorted

            }

 */


            uRocketList = symulate.loadU1(itemsList);           //loading rockets with items from list (removing each item from list after loading on rocket )
            budget += symulate.runSimulation(uRocketList);      //runing launch/land simulation to see what budget we need to send everything

        }
        System.out.println("Budget for U1 = $"+budget+" Million");
        budget = 0;                                             //new budget for another type of rocket
        for(int i=1;i<=2;i++) {                                 // redudndant loop just for another type of rocket, maybe later i figure out somthing to do this smarter
            Simulation symulate = new Simulation();
            ArrayList<Item> itemsList = new ArrayList();
            ArrayList<Rocket> uRocketList = new ArrayList();

            itemsList= symulate.loadItems(i);
            uRocketList = symulate.loadU2(itemsList);
            budget += symulate.runSimulation(uRocketList);

        }
        System.out.println("Budget for U2 = $"+budget+" Million");








    }
}
