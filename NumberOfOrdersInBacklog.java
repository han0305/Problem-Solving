/* You are given a 2D integer array orders, where each orders[i] = [pricei, amounti, orderTypei] denotes that amounti orders have been placed of type orderTypei at the price pricei. The orderTypei is:

0 if it is a batch of buy orders, or
1 if it is a batch of sell orders.
Note that orders[i] represents a batch of amounti independent orders with the same price and order type. All orders represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.

There is a backlog that consists of orders that have not been executed. The backlog is initially empty. When an order is placed, the following happens:

If the order is a buy order, you look at the sell order with the smallest price in the backlog. If that sell order's price is smaller than or equal to the current buy order's price, they will match and be executed, and that sell order will be removed from the backlog. Else, the buy order is added to the backlog.
Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog. If that buy order's price is larger than or equal to the current sell order's price, they will match and be executed, and that buy order will be removed from the backlog. Else, the sell order is added to the backlog.
Return the total amount of orders in the backlog after placing all the orders from the input. Since this number can be large, return it modulo 109 + 7. */

class OrderDetails {
    
    int amount;
    int price;
    OrderDetails(int amount,int price) {
        
        this.amount = amount;
        this.price = price;
        
    }
}

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        PriorityQueue<OrderDetails> buy = new PriorityQueue<>((OrderDetails o1,OrderDetails o2) -> o2.price>=o1.price?1:-1);
        PriorityQueue<OrderDetails> sell = new PriorityQueue<>((OrderDetails o1,OrderDetails o2) -> o1.price>=o2.price?1:-1);
        
        for(int i=0;i<orders.length;i++) {
            int currPrice = orders[i][0];
            int currAmount = orders[i][1];
            int currType = orders[i][2];
            if(currType == 0) {
                
                while(!sell.isEmpty() && currAmount>0 && sell.peek().price<=currPrice) {
                    OrderDetails sellOrder = sell.poll();
                    if(sellOrder.amount > currAmount) {
                        sellOrder.amount-=currAmount;
                        currAmount = 0;
                        sell.offer(sellOrder);
                    }
                    else {
                       currAmount-=sellOrder.amount; 
                    }
                    
                }
                
                if(currAmount>0) {
                    buy.offer(new OrderDetails(currAmount,currPrice));
                }
                
                
            }
            
            else {

                while(!buy.isEmpty() && currAmount>0 && buy.peek().price>=currPrice) {
                    OrderDetails buyOrder = buy.poll();
                    
                    if(buyOrder.amount > currAmount) {
                        buyOrder.amount-=currAmount;
                        currAmount = 0;
                        buy.offer(buyOrder);
                    }
                    else {
                       currAmount-=buyOrder.amount; 
                    }
                    
                }
                if(currAmount>0) {
                    sell.offer(new OrderDetails(currAmount,currPrice));
                }
                
            }
            
        }
        int sum = 0;
        while(!buy.isEmpty() || !sell.isEmpty()) {
            
            if(!buy.isEmpty()) {
                sum = (sum+buy.poll().amount)%1000000007;
                
            }
            if(!sell.isEmpty()) {
                sum = (sum+sell.poll().amount)%1000000007;
            }
            
        }
       return sum;
        
        
    }
}