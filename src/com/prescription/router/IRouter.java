package com.prescription.router;

import com.prescription.order.Order;
import com.prescription.pharmacy.Pharmacy;

import java.util.List;

public interface IRouter {
    List<Assignment> assign(Order o);

    /*
        Assumptions made : NURX can fulfill the order after estimating the price.
                           So, pharmacy has enough stock is a filter used.
     */
    List<PriceEstimation> calculatePotentialPriceForOrderItems(Order order);

    int getTotalCostOfTheOrder(Order order);

    void setSites(List<Pharmacy> sites);
}
