# Prescription Router
Prescription Router is a routing program to see how efficiently we can route the prescription drugs across locations. 
Also predict the cost of the order based on certain criterias 

You can run the project by running the class `RouterClient` or by running `java -jar prescription-router.jar` in the project folder

### Assigning the order
   - Check for order items and which pharmacies can fulfill the order item
   - Stream order items and get the cost prediction across pharmacies
   - Sort the cost in ascending order with respect to pharmacy and pick the top one
   - Store the order item and pharmacy in Assignment object

### Predicting the order cost
   - Check for order items and which pharmacies can fulfill the order item
   - Stream order items and get the cost prediction across pharmacies
   - Sort the cost in ascending order with respect to pharmacy and pick the top one
   - Store the order item, pharmacy and the cost in individual Price Estimation object
   
### Total cost of the order
   - Run through the predicting function of the order and add up the individual cost of order item
