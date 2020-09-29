import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() throws Exception {

        visitor1 = new Visitor(18, 180.0, 30.0);
        visitor2 = new Visitor(17, 120.0, 20.0);
        visitor3 = new Visitor(15, 120.0, 20.0);
        visitor4 = new Visitor(15, 150.0, 20.0);

        themePark = new ThemePark("Camelot");
        dodgems = new Dodgems("The Italian Job", 9);
        park = new Park("Burial grounds", 6);
        playground = new Playground("Quicksands",5);
        rollerCoaster = new RollerCoaster("Purple dragon",10);
        candyStall = new CandyflossStall("Dentist's joy","Dr Nick", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Ice'n'Berg's","Walter",ParkingSpot.A3);
        tobaccoStall = new TobaccoStall("Steam Powered","Cid Garr",ParkingSpot.B2);

        themePark.addAttractionOrStall(dodgems);
        themePark.addAttractionOrStall(park);
        themePark.addAttractionOrStall(playground);
        themePark.addAttractionOrStall(rollerCoaster);
        themePark.addAttractionOrStall(candyStall);
        themePark.addAttractionOrStall(iceCreamStall);
        themePark.addAttractionOrStall(tobaccoStall);
        themePark.updateRatingsFromReviewed();

    }

    @Test
    public void hasName(){
        assertEquals("Camelot",themePark.getParkName());
    }

    @Test
    public void hasReviewedItems(){
        assertEquals(7,themePark.getAllReviewed().size());
    }

    @Test
    public void hasRatings(){
        int a = themePark.getRatings().get("The Italian Job");
        assertEquals(9,a);
        int size = themePark.getRatings().size();
        assertEquals(7,size);

    }

    @Test
    public void allowedForVisitorSizeChangesDependingOnVisitorParameter(){
        assertEquals(6,themePark.getAllAllowedFor(visitor1).size());
        assertEquals(4,themePark.getAllAllowedFor(visitor2).size());
        assertEquals(5,themePark.getAllAllowedFor(visitor3).size());
        assertEquals(6,themePark.getAllAllowedFor(visitor4).size());
    }
    @Test
    public void visitingAddsToVisitorsArrayOfVisited(){
         themePark.visit(visitor2,dodgems);
        assertEquals(1,visitor2.getVisitedAttractions().size());
        assertEquals("The Italian Job",visitor2.getVisitedAttractions().get(0).getName());



    }





}
