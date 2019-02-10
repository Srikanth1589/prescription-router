package com.prescription.router;

import com.prescription.pharmacy.*;
import com.prescription.order.*;

import java.util.*;
import java.util.stream.Collectors;

public class Router implements IRouter {
    private List<Pharmacy> sites;

    @Override
    public List<Assignment> assign(Order order) {
        Map<OrderItem, List<Pharmacy>> orderItemPharmacyMap = getOrderItemPharmacyListMap(order);

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
        Get the predicted cost per order item
        Assumptions made : NURX can fulfill the order after estimating the price.
                           So, pharmacy has enough stock is a filter used.
     */
    @Override
    public List<PriceEstimation> calculatePotentialPriceForOrderItems(Order order) {

        List<PriceEstimation> priceEstimations = new ArrayList<>();
        Map<OrderItem, List<Pharmacy>> orderItemPharmacyMap = getOrderItemPharmacyListMap(order);

        //Find the cheapest order item filling pharmacy and the cost and store it in
        //PriceEstimation object for each Assignment
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

    /*
        Get items and their corresponding available pharmacies by checking if
        pharmacies have enough stock and is in allowed jurisdiction
     */
    private Map<OrderItem, List<Pharmacy>> getOrderItemPharmacyListMap(Order order) {
        return order.getItems().stream()
                    .collect(Collectors.toMap(
                            orderItem -> orderItem,
                            orderItem -> sites.stream()
                                    .filter(site -> site.containsEnoughItems(orderItem) &&
                                            site.isInAllowedJurisdiction(order.getJurisdiction()))
                                    .collect(Collectors.toList())
                    ));
    }

    /*
        Just get the total cost of the order
     */
    @Override
    public int getTotalCostOfTheOrder(Order order) {
        List<PriceEstimation> priceEstimations = calculatePotentialPriceForOrderItems(order);
        return priceEstimations.stream().mapToInt(PriceEstimation::getCost).sum();
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
