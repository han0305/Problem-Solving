/* Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.

Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators. For example, the postfix tokens of the expression 4*(5-(7+2)) are represented in the array postfix = ["4","5","7","2","+","-","*"].

The class Node is an interface you should use to implement the binary expression tree. The returned tree will be tested using the evaluate function, which is supposed to evaluate the tree's value. You should not remove the Node class; however, you can modify it as you wish, and you can define other classes to implement it if needed.

A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with two children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).

It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, and all the operations are valid (i.e., no division by zero). */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class ExpressionUtil {
    
    static boolean isOperator(String s) {
        
        if(s.equals("+") ||
          s.equals("-") ||
          s.equals("*") ||
          s.equals("/"))
            return true;
        return false;
    }
    
    static int getNumber(String s) {
        
        return Integer.valueOf(s);
    }
    static int eval(int left, String op,int right) {
        
        if(op.equals("+")) {
            return right + left;
        }
        else if(op.equals("-")) {
            return right-left;
        }
        else if(op.equals("*")) {
            return right*left;
        }
        else {
            return right/left;
        }
        
    }
}
class TreeNode extends Node {
    String value;
    TreeNode left;
    TreeNode right;
    
    TreeNode(String value) {
        this.value = new String(value);
        left = right = null;
    }
    
    public int evaluate() {
        if(ExpressionUtil.isOperator(value)) {
            
            int leftVal = left.evaluate();
            int rightVal = right.evaluate();
            System.out.println(leftVal + " " + value + " " + rightVal);
            return ExpressionUtil.eval(leftVal,value,rightVal);
        }
        else {
            int no  = ExpressionUtil.getNumber(value);
            return no;
        }
    }
}

class TreeBuilder {
    
    Node buildTree(String[] postfix) {
        ArrayDeque<TreeNode> st = new ArrayDeque<TreeNode>();
        for(int i=0;i<postfix.length;i++) {
            
            TreeNode newNode = new TreeNode(postfix[i]);
            if(ExpressionUtil.isOperator(postfix[i])) {
                TreeNode op1 = st.pop();
                TreeNode op2 = st.pop();
                newNode.left = op1;
                newNode.right = op2;
                st.push(newNode);
            }
            else {
               st.push(newNode); 
            }
            
        }
        return st.peek();
    }
};
