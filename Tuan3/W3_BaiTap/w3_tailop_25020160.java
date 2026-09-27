import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class w3_tailop_25020160 {
    static int prio(char c) {
        return (c == '+' || c == '-') ? 1 : (c == '*' || c == '/') ? 2 : 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        sc.close();
        if (s.isEmpty()) return;
        String[] tokens = s.replaceAll("([+\\-*/()])", " $1 ").trim().split("\\s+");
        StringBuilder post = new StringBuilder();
        Deque<Character> opStack = new ArrayDeque<>();
        for (String t : tokens) {
            char c = t.charAt(0);
            if (Character.isDigit(c)) {
                post.append(t).append(" ");
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    post.append(opStack.pop()).append(" ");
                }
                opStack.pop();
            } else {
                while (!opStack.isEmpty() && prio(opStack.peek()) >= prio(c)) {
                    post.append(opStack.pop()).append(" ");
                }
                opStack.push(c);
            }
        }
        while (!opStack.isEmpty()) post.append(opStack.pop()).append(" ");
        String postfixStr = post.toString().trim();
        System.out.println(postfixStr);
        Deque<Long> valStack = new ArrayDeque<>();
        for (String t : postfixStr.split("\\s+")) {
            char c = t.charAt(0);
            if (Character.isDigit(c)) {
                valStack.push(Long.parseLong(t));
            } else {
                long b = valStack.pop();
                long a = valStack.pop();
                if (c == '+') valStack.push(a + b);
                else if (c == '-') valStack.push(a - b);
                else if (c == '*') valStack.push(a * b);
                else if (c == '/') valStack.push(a / b);
            }
        }
        System.out.println(valStack.pop());
    }
}