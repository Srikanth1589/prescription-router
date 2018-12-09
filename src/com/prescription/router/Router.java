package com.prescription.router;

import com.prescription.pharmacy.*;
import com.prescription.order.*;

import java.util.*;
import java.util.stream.Collectors;

public class Router implements IRouter {
    private List<Pharmacy> sites;

    @Override
    public List<Assignment> assign(Order order) {
        Map<OrderItem, List<Pharmacy>> orderItemPharmacyMap = order.getItems().stream()
                .collect(Collectors.toMap(
                        orderItem -> orderItem,
                        orderItem -> sites.stream()
                                .filter(site -> site.containsEnoughItems(orderItem))
                                .collect(Collectors.toList())
                ));

        orderItemPharmacyMap.forEach((orderItem, pharmacies) -> pharmacies.sort(
                Comparator.comparing(ph -> (ph.estimateShippingForOrderItem(orderItem)))));

        return orderItemPharmacyMap.entrySet().stream()
                .filter(map -> map.getValue().size() > 0)
                .map(map -> new Assignment(map.getKey(), map.getValue().get(0)))
                .collect(Collectors.toList());
    }

    @Override
    public void setSites(List<Pharmacy> sites) {
        this.sites = sites;
    }

}
