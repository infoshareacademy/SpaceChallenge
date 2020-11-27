public class U1 extends Rocket {
    //int carry, carryLimit;

    public boolean launch() {
        double chance = 5.0 * (getCarry() / getCarryLimit());             // random number to see if launch succesfull
        if((Math.random()*100)<=chance) {
            return false;
        }else {
            return true;
        }

    }
    public boolean land(){
        double chance = 1.0 * (getCarry() / getCarryLimit());             // random number to see if landing succesfull
        if((Math.random()*100)<=chance) {
            return false;
        }else {
            return true;
        }
    }
    U1(){
        setCarry(0);                   // rocket constructor
        setCarryLimit(8000);
        setCost(100);
    }
}
