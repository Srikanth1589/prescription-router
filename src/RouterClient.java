import com.prescription.order.Item;
import com.prescription.order.Order;
import com.prescription.order.OrderItem;
import com.prescription.pharmacy.Inventory;
import com.prescription.pharmacy.Pharmacy;
import com.prescription.pharmacy.Price;
import com.prescription.router.Assignment;
import com.prescription.router.IRouter;
import com.prescription.router.Router;

import java.util.Arrays;
import java.util.List;

public class RouterClient {

    public static void main(String[] args) {
        //Items
        Item it1 = new Item("Bandaid", "Bandaid", true);
        Item it2 = new Item("Hansaplast", "Bandaid", false);
        Item it3 = new Item("StickIt", "NewBandaid", false);
        Item it4 = new Item("Ointment1", "OFormula1", false);
        Item it5 = new Item("Ointment2", "OFormula1", true);

        Item it6 = new Item("Ointment3", "OFormula2", false);
        Item it7 = new Item("Ointment4", "OFormula2", true);
        Item it8 = new Item("Ointment5", "OFormula2", false);
        Item it9 = new Item("Cold1", "ColdFormula1", false);
        Item it10 = new Item("Cold2", "ColdFormula1", false);

        Item it11 = new Item("Cold3", "ColdFormula1", true);
        Item it12 = new Item("Cold4", "ColdFormula2", false);
        Item it13 = new Item("Cold5", "ColdFormula2", false);
        Item it14 = new Item("Cold6", "ColdFormula2", false);
        Item it15 = new Item("Cough Syrup1", "Cough Syrup1", false);

        Item it16 = new Item("Cough Syrup2", "Cough Syrup2", false);
        Item it17 = new Item("Cough Syrup3", "Cough Syrup2", true);
        Item it18 = new Item("Cough Syrup4", "Cough Syrup3", false);
        Item it19 = new Item("Antibiotic1", "AntibioticFormula1", false);
        Item it20 = new Item("Antibiotic2", "AntibioticFormula2", false);

        Item it21 = new Item("Antibiotic3", "AntibioticFormula2", false);
        Item it22 = new Item("Antibiotic4", "AntibioticFormula3", false);
        Item it23 = new Item("Antibiotic5", "AntibioticFormula3", true);


        //Set Order Items
        OrderItem oi1 = new OrderItem(it2, 5);
        OrderItem oi2 = new OrderItem(it6, 3);
        OrderItem oi3 = new OrderItem(it11, 3);
        OrderItem oi4 = new OrderItem(it16, 1);
        OrderItem oi5 = new OrderItem(it23, 2);

        //Set Order
        Order newOrder = new Order();
        newOrder.setItems(Arrays.asList(oi1, oi2, oi3, oi4, oi5));
        newOrder.setJurisdiction("CA");
        newOrder.setPayer("Blue Shield");

        //Set Inventory

        Inventory in11 = new Inventory(it1, 10, 1, Arrays.asList(new Price("Blue Shield", 2), new Price("United", 1)));
        Inventory in12 = new Inventory(it2, 0, 2, Arrays.asList(new Price("United", 2), new Price("Aetna", 1)));
        Inventory in13 = new Inventory(it4, 3, 3, Arrays.asList(new Price("Care First", 2), new Price("Aflac", 5)));
        Inventory in14 = new Inventory(it12, 5, 3, Arrays.asList(new Price("Aflac", 3), new Price("Care First", 1)));
        Inventory in15 = new Inventory(it17, 10, 4, Arrays.asList(new Price("Aflac", 4), new Price("Blue Shield", 4)));
        Inventory in16 = new Inventory(it22, 10, 4, Arrays.asList(new Price("United", 2), new Price("Aetna", 1)));
        Inventory in17 = new Inventory(it23, 5, 4, Arrays.asList(new Price("Aflac", 2), new Price("Care First", 3)));

        Inventory in21 = new Inventory(it2, 10, 1, Arrays.asList(new Price("Care First", 2), new Price("Aflac", 1)));
        Inventory in22 = new Inventory(it4, 5, 2, Arrays.asList(new Price("Aetna", 2), new Price("Care First", 2)));
        Inventory in23 = new Inventory(it5, 3, 2, Arrays.asList(new Price("Aetna", 2), new Price("Blue Shield", 1)));
        Inventory in24 = new Inventory(it15, 5, 3, Arrays.asList(new Price("Care First", 5), new Price("United", 3)));
        Inventory in25 = new Inventory(it12, 10, 4, Arrays.asList(new Price("United", 2), new Price("Blue Shield", 5)));
        Inventory in26 = new Inventory(it20, 10, 4, Arrays.asList(new Price("Blue Shield", 2), new Price("Care First", 1)));
        Inventory in27 = new Inventory(it21, 10, 4, Arrays.asList(new Price("Blue Shield", 2), new Price("Aetna", 1)));

        Inventory in31 = new Inventory(it2, 10, 1, Arrays.asList(new Price("Aetna", 2), new Price("Care First", 1)));
        Inventory in32 = new Inventory(it3, 5, 2, Arrays.asList(new Price("Aflac", 2), new Price("United", 1)));
        Inventory in33 = new Inventory(it8, 3, 2, Arrays.asList(new Price("Aetna", 2), new Price("Blue Shield", 4)));
        Inventory in34 = new Inventory(it13, 5, 3, Arrays.asList(new Price("Care First", 2), new Price("Blue Shield", 1)));
        Inventory in35 = new Inventory(it16, 10, 4, Arrays.asList(new Price("Aetna", 2), new Price("Aflac", 2)));
        Inventory in36 = new Inventory(it17, 10, 4, Arrays.asList(new Price("Blue Shield", 2), new Price("United", 3)));
        Inventory in37 = new Inventory(it9, 10, 4, Arrays.asList(new Price("Aflac", 2), new Price("Care First", 1)));

        Inventory in41 = new Inventory(it6, 10, 1, Arrays.asList(new Price("Aetna", 2), new Price("Care First", 3)));
        Inventory in42 = new Inventory(it7, 5, 2, Arrays.asList(new Price("Care First", 2), new Price("Aflac", 1)));
        Inventory in43 = new Inventory(it13, 3, 2, Arrays.asList(new Price("Care First", 2), new Price("Blue Shield", 1)));
        Inventory in44 = new Inventory(it14, 5, 3, Arrays.asList(new Price("Blue Shield", 2), new Price("United", 4)));
        Inventory in45 = new Inventory(it18, 10, 4, Arrays.asList(new Price("Aflac", 2), new Price("Aetna", 1)));
        Inventory in46 = new Inventory(it19, 5, 4, Arrays.asList(new Price("Blue Shield", 2), new Price("Aetna", 1)));
        Inventory in47 = new Inventory(it10, 10, 4, Arrays.asList(new Price("United", 2), new Price("Care First", 5)));

        //Set Pharmacy
        Pharmacy ph1 = new Pharmacy("PH1");
        ph1.setAllowedJurisdictions(Arrays.asList("CA", "MD", "NY", "VA", "OR", "WA"));
        ph1.setStock(Arrays.asList(in11, in12, in13, in14, in15, in16, in17));

        Pharmacy ph2 = new Pharmacy("PH2");
        ph2.setAllowedJurisdictions(Arrays.asList("NJ", "MD", "NY", "VA", "OR", "SC"));
        ph2.setStock(Arrays.asList(in21, in22, in23, in24, in25, in26, in27));

        Pharmacy ph3 = new Pharmacy("PH3");
        ph3.setAllowedJurisdictions(Arrays.asList("CA", "MA", "VE", "NC", "OR", "WA"));
        ph3.setStock(Arrays.asList(in31, in32, in33, in34, in35, in36, in37));

        Pharmacy ph4 = new Pharmacy("PH4");
        ph4.setAllowedJurisdictions(Arrays.asList("CA", "MI", "NY", "VA", "OR", "TX", "SC", "NC"));
        ph4.setStock(Arrays.asList(in41, in42, in43, in44, in45, in46, in47));

        //Set Sites
        IRouter router = new Router();
        router.setSites(Arrays.asList(ph1, ph2, ph3, ph4));

        //Price Estimations
        List<Router.PriceEstimation> priceEstimations = router.calculatePotentialPrice(newOrder);
        System.out.println("PRICE ESTIMATION ::");
        int totalCost = 0;
        for (Router.PriceEstimation priceEstimation : priceEstimations) {
            totalCost += priceEstimation.getCost();
            System.out.println(priceEstimation);
        }
        System.out.println("Total Cost of the order: " + totalCost);
        //Assignments
        List<Assignment> assignments = router.assign(newOrder);
        System.out.println("ASSIGNMENT ::");
        assignments.forEach(assignment -> System.out.println(assignment));
    }
}
