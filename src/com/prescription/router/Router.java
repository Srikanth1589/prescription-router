package com.prescription.router;

import com.prescription.pharmacy.*;
import com.prescription.order.*;

import java.util.*;
import java.util.stream.Collectors;

public class Router implements IRouter {
    private List<Pharmacy> sites;

    @Override
    public List<Assignment> assign(Order order) {
        //Get items and their corresponding available pharmacies by checking if
        //pharmacies have enough stock and in allowed jurisdiction
        Map<OrderItem, List<Pharmacy>> orderItemPharmacyMap = order.getItems().stream()
                .collect(Collectors.toMap(
                        orderItem -> orderItem,
                        orderItem -> sites.stream()
                                .filter(site -> site.containsEnoughItems(orderItem) &&
                                                site.isInAllowedJurisdiction(order.getJurisdiction()))
                                .collect(Collectors.toList())
                ));

        //Sort the pharmacies by shipping costs
        orderItemPharmacyMap.forEach((orderItem, pharmacies) -> pharmacies.sort(
                Comparator.comparing(ph -> (ph.estimateShippingForOrderItem(orderItem, order)))));

        //Get the list of item and corresponding top cheap pharmacy
        return orderItemPharmacyMap.entrySet().stream()
                .filter(map -> map.getValue().size() > 0)
                .map(map -> new Assignment(map.getKey(), map.getValue().get(0)))
                .collect(Collectors.toList());
    }

    /*
        Assumptions made : NURX can fullfil the order after estimating the price.
                           So, pharmacy has enough stock is a filter used.
     */
    @Override
    public List<PriceEstimation> calculatePotentialPrice(Order order) {
        //Get items and their corresponding available pharmacies by checking if
        //pharmacies have enough stock and in allowed jurisdiction
        List<PriceEstimation> priceEstimations = new ArrayList<>();
        Map<OrderItem, List<Pharmacy>> orderItemPharmacyMap = order.getItems().stream()
                .collect(Collectors.toMap(
                        orderItem -> orderItem,
                        orderItem -> sites.stream()
                                .filter(site -> site.containsEnoughItems(orderItem) &&
                                        site.isInAllowedJurisdiction(order.getJurisdiction()))
                                .collect(Collectors.toList())
                ));

        //TODO: Add comments --- Correct Insurance cost part
        for (Map.Entry<OrderItem, List<Pharmacy>> entry : orderItemPharmacyMap.entrySet()) {
            Optional<PharmacyCost> pharmacyCostOptional = entry.getValue().stream().map(pharmacy ->
                new PharmacyCost(pharmacy, pharmacy.estimateShippingForOrderItem(entry.getKey(), order))
            ).sorted(Comparator.comparingInt(PharmacyCost::getCost)).findFirst();

            pharmacyCostOptional.ifPresent(pharmacyCost ->
                    priceEstimations.add(new PriceEstimation(
                            new Assignment(entry.getKey(), pharmacyCost.getPharmacy()), pharmacyCost.getCost())));
        }
        return priceEstimations;
    }

    @Override
    public void setSites(List<Pharmacy> sites) {
        this.sites = sites;
    }

    public class PharmacyCost {
        private Pharmacy pharmacy;
        private int cost;

        public PharmacyCost(Pharmacy pharmacy, int cost) {
            this.pharmacy = pharmacy;
            this.cost = cost;
        }

        public Pharmacy getPharmacy() {
            return pharmacy;
        }

        public void setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
