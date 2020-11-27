public class Item implements Comparable{
    private String name;
    private int weight;



    Item(String name,int weight){
        this.name=name;
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

  /*  @Override
    public int compareTo(Item compareItem) {
        int compareWeight=((Item)compareItem).getWeight();
        return compareWeight - this.weight;
    }

   */

    @Override
    public int compareTo(Object compareItem) {              //  I don't really understand that but it works :)
                                                            // I guess there is compareTo method in interface Comparable and I have to override it according to my situation
                                                            // becouse there is a lot of possible comparation
        int compareWeight=((Item)compareItem).getWeight();  //get weight for comparation
        return compareWeight - this.weight;                 // ascending sort would be 'this.weight - compareWeight'
    }
}

