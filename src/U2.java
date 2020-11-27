public class U2 extends Rocket{


    public boolean launch() {
        double chance = 4.0 * (getCarry() / getCarryLimit());         // random number to see if launch succesfull
        if((Math.random()*100)<=chance) {
            return false;
        }else {
            return true;
        }

    }
    public boolean land(){
        double chance = 8.0 * (getCarry() / getCarryLimit());         // random number to see if landing succesfull
        if((Math.random()*100)<=chance) {
            return false;
        }else {
            return true;
        }
    }

    U2(){
        setCarry(0);            // rocket constructor
        setCarryLimit(11000);
        setCost(120);
    }
}
