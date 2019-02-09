package com.prescription.router;

import com.prescription.order.Order;
import com.prescription.pharmacy.Pharmacy;

import java.util.List;

public interface IRouter {
    List<Assignment> assign(Order o);

    List<Router.PriceEstimation> calculatePotentialPrice(Order order);

    void setSites(List<Pharmacy> sites);
}
