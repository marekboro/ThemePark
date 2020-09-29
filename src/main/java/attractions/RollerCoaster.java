package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowed(Visitor visitor){
        return visitor.getHeight() >=145 && visitor.getAge() >=12;
    }

    public double defaultPrice(){
        return 8.4;
    }
    public double priceFor(Visitor visitor){

       return visitor.getHeight()>=200 ? 2*defaultPrice(): defaultPrice();

//        if(visitor.getHeight()>=200){
//            return 2*defaultPrice();
//        }
//      else return defaultPrice();

    }

}
