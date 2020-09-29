package attractions;

import behaviours.IReviewed;
import behaviours.ITicketed;
import people.Visitor;


public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice(){
        return 4.5;
    }

    public double priceFor(Visitor visitor){

        return visitor.getAge()<12 ? defaultPrice()/2: defaultPrice();

//        if (visitor.getAge()<12){
//            return defaultPrice()/2;
//        }
//        return defaultPrice();

    }

}
