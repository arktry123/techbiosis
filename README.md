# sorting balls
---------------
Assumptions and Facts:

1. The code is not thread safe.
2. Assumes that the Rack does have to sort only the ints . SO did not bother to parameterize the Rack.
   If needed we could have defined as IRack<T> instead of IRack.
3. Defined the interface as a best practice for API, though not needed for the problem statement.
4. Followed Single Responsibility principle. Added a class for Validation, it may look as if it is an over kill, but a good practise.
4. Followed Open Closed Principle as below.
   I see that there could be two changes to the business in the future:
   i) the requirement can be changed to display the balls in the descending order, instead of ascending order.
      In such case, we can add something like DescRack to define the algorithm, without modifying the existing code.
   ii) The number of balls can be increased. So min number and max number are made part of the constructor.
5. It is assumed that the add method is always called with unique number every time. So did not consider to validate the duplicates case.
6. Did not add much documentation, instead tried to maintain clean code.

# spell out the number
-----------------------
1. Single responsibility - Added validation class - same as above
2. Open -closed principle:
   Tried to make the logic more generic.
   I see that there could be a change in the ask to consider the max number as trillion, instead of a billion.
   In that case, the enum could be modified without touching the actual logic.
3. Considered longs , instead of int, though billion falls in integer range. (for the same above reason)