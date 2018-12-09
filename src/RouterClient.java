import com.prescription.order.Order;
import com.prescription.order.OrderItem;
import com.prescription.pharmacy.Inventory;
import com.prescription.pharmacy.Pharmacy;
import com.prescription.router.Assignment;
import com.prescription.router.IRouter;
import com.prescription.router.Router;

import java.util.Arrays;
import java.util.List;

public class RouterClient {

    public static void main(String[] args) {
        //Set Order Items
        OrderItem oi1 = new OrderItem("Bandaid", 5);
        OrderItem oi2 = new OrderItem("Ointment1", 3);
        OrderItem oi3 = new OrderItem("Ointment2", 3);
        OrderItem oi4 = new OrderItem("Cold Syrup", 1);
        OrderItem oi5 = new OrderItem("Cough Syrup", 2);

        //Set Order
        Order newOrder = new Order();
        newOrder.setItems(Arrays.asList(oi1, oi2, oi3, oi4, oi5));

        //Set Inventory
        Inventory in11 = new Inventory("Bandaid", 10, 1);
        Inventory in12 = new Inventory("Ointment1", 0, 2);
        Inventory in13 = new Inventory("Ointment2", 3, 3);
        Inventory in14 = new Inventory("Cold Syrup", 5, 3);
        Inventory in15 = new Inventory("Cough Syrup", 10, 4);

        Inventory in21 = new Inventory("Bandaid", 10, 1);
        Inventory in22 = new Inventory("Ointment1", 5, 2);
        Inventory in23 = new Inventory("Ointment2", 3, 2);
        Inventory in24 = new Inventory("Cold Syrup", 5, 3);
        Inventory in25 = new Inventory("Cough Syrup", 10, 4);

        Inventory in31 = new Inventory("Bandaid", 10, 1);
        Inventory in32 = new Inventory("Ointment1", 5, 2);
        Inventory in33 = new Inventory("Ointment2", 3, 2);
        Inventory in34 = new Inventory("Cold Syrup", 5, 3);
        Inventory in35 = new Inventory("Cough Syrup", 10, 4);

        Inventory in41 = new Inventory("Bandaid", 10, 1);
        Inventory in42 = new Inventory("Ointment1", 5, 2);
        Inventory in43 = new Inventory("Ointment2", 3, 2);
        Inventory in44 = new Inventory("Cold Syrup", 5, 3);
        Inventory in45 = new Inventory("Cough Syrup", 10, 4);

        //Set Pharmacy
        Pharmacy ph1 = new Pharmacy("PH1");
        ph1.setStock(Arrays.asList(in11, in12, in13, in14, in15));

        Pharmacy ph2 = new Pharmacy("PH2");
        ph2.setStock(Arrays.asList(in21, in22, in23, in24, in25));

        Pharmacy ph3 = new Pharmacy("PH3");
        ph3.setStock(Arrays.asList(in31, in32, in33, in34, in35));

        Pharmacy ph4 = new Pharmacy("PH4");
        ph4.setStock(Arrays.asList(in41, in42, in43, in44, in45));

        //Set Sites
        IRouter router = new Router();
        router.setSites(Arrays.asList(ph1, ph2, ph3, ph4));
        List<Assignment> assignments = router.assign(newOrder);

        System.out.println(assignments);
    }
}
