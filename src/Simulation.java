import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {




    ArrayList loadItems(int phase) throws FileNotFoundException {
        ArrayList itemsList;
        itemsList = new ArrayList();
        String src;                             //directory of txt (phase)
        if(phase == 1){
            src = "phase-1.txt";
        }else {
            src = "phase-2.txt";
        }                            ///////////        later maybe more phases
        File file1 = new File(src);
        Scanner scanner = new Scanner(file1);
            while(scanner.hasNextLine()){
            String line= scanner.nextLine();
            String [] arrOfStr = line.split("=",2) ;        //split lines from txt to get name and weight

            int number = Integer.parseInt(arrOfStr[1]);                 //right string to int (weight)
            Item item = new Item(arrOfStr[0],number );                  //item constructor with name and weight
            itemsList.add(item);                                        //adding item to list
            }
        return itemsList;                                               //returns list of all items from txt
        }
    ArrayList loadU1(ArrayList<Item> itemsList){                        // loading list of items to rockets type U1
        ArrayList uRocketList = new ArrayList();                        // list of rockets after loading all items
        while(itemsList.size()>0){                                      // start if there is any item on list
            U1 uRocket = new U1();                                      // create rocket to load it

            int i=0;                                                    // in this loop i don't want to increment i everytime becouse when item is loaded
                                                         // it is removed from list and next item gets it's index , so in next step of loop next item will be at this index
            while((uRocket.getCarry() < uRocket.getCarryLimit())&&(i< itemsList.size())) {


                if (uRocket.canCarry(itemsList.get(i))) {               // carry item if u can
                    uRocket.carry(itemsList.get(i));
                    itemsList.remove(i);                                // IMPORTANT removing item from list after loading on rocket
                } else i++;                                             //incrementation ony if not loaded item of this index

            }
            uRocketList.add(uRocket);                                   // when there is nothig more to load or rocket is full add rocket to return list
        }

        return uRocketList;                                             // return list of loaded rockets
    }

    ArrayList loadU2(ArrayList<Item> itemsList){                        // redundant to previous type of rocket
        ArrayList uRocketList = new ArrayList();
        while(itemsList.size()>0){
            U2 uRocket = new U2();                                      // only there is diffrence

            int i=0;
            while((uRocket.getCarry() < uRocket.getCarryLimit())&&(i< itemsList.size())) {


                if (uRocket.canCarry(itemsList.get(i))) {
                    uRocket.carry(itemsList.get(i));
                    itemsList.remove(i);
                } else i++;

            }
            uRocketList.add(uRocket);
        }

        return uRocketList;
    }

int runSimulation(ArrayList<Rocket> uRocketList){
        int budget=0;
        for(Rocket uRocket : uRocketList){                      //for each rocket try to launch and land. if failure try again and add cost of lost rocket to budget
            do{
                budget += uRocket.getCost();
            } while ((!(uRocket.launch()&&uRocket.land())));
        }
        return budget;
}

}

