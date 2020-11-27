public class Rocket implements SpaceShip{
    private int carry, carryLimit, cost;
    public boolean launch(){
        return true;
    }
    public boolean land(){
        return true;
    }
    public boolean canCarry(Item item){                     // check if rocket can carry item from parameter
        if((getCarry()+item.getWeight())<=getCarryLimit()){
            return true;
        } else {
            return false;
        }
    }
    public void carry(Item item){
        setCarry(getCarry()+item.getWeight());
    }       // adding item weight to rocket's carried load

    public void setCarry(int carry) {
        this.carry = carry;
    }

    public void setCarryLimit(int carryLimit) {
        this.carryLimit = carryLimit;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCarry() {
        return carry;
    }

    public int getCarryLimit() {
        return carryLimit;
    }

    public int getCost() {
        return cost;
    }


}

