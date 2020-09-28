
import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private String parkName;
    private ArrayList<IReviewed> reviewedItems;
    private HashMap<String, Integer> ratings;

    public ThemePark(String parkName) {
        this.reviewedItems = new ArrayList<IReviewed>();
        this.parkName = parkName;
        this.ratings = new HashMap<String, Integer>();
    }

    public String getParkName() {
        return parkName;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return reviewedItems;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.setVisitCount(attraction.getVisitCount() + 1);
        visitor.addToAttractions(attraction);
    }


    public HashMap<String, Integer> getRatings() {
        if (ratings.size() == 0){
            updateRatingsFromReviewed();
        }

        return ratings;
    }

    public void addAttractionOrStall(IReviewed iReviewed) {
        this.reviewedItems.add((IReviewed) iReviewed);
    }

    public void updateRatingsFromReviewed() {
        for (IReviewed stallOrAttraction : reviewedItems) {
            String name = stallOrAttraction.getName();
            int rating = stallOrAttraction.getRating();

            ratings.put(name, rating);
        }

    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> toBeReturned = new ArrayList<IReviewed>();

        for (IReviewed stallOrAttraction : reviewedItems) {
            if (stallOrAttraction instanceof ISecurity) {
                if(((ISecurity) stallOrAttraction).isAllowed(visitor)){
                    toBeReturned.add(stallOrAttraction);
                }

            } else {
                toBeReturned.add(stallOrAttraction);
            }
        }
        return toBeReturned;
    }


}
