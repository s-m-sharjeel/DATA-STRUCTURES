package Labs.Lab7;

public class Driver {

    public static void main(String[] args) {

        // task 1:
        ArrayStack<Integer> arr = new ArrayStack<>(3);
        arr.push(5);
        arr.push(4);
        arr.push(3);
        arr.push(2);
        System.out.println(arr.pop());
        System.out.println(arr.pop());
        System.out.println(arr.pop());
        System.out.println(arr.pop());

        // task 2:
        LinkedStack<Integer> arr2 = new LinkedStack<>();
        arr2.push(5);
        arr2.push(4);
        arr2.push(3);
        arr2.push(2);
        System.out.println(arr2.pop());
        System.out.println(arr2.pop());
        System.out.println(arr2.pop());
        System.out.println(arr2.pop());

        // task 3:
        System.out.println(validate("{[]}()"));

        // task 4:

        // question 1:
        System.out.println(infixToPostfix("[(A+B)/B+A-C+(B-C)]"));

        // question 2:
        System.out.println(evaluatePostfix("AB+B/A+C-BC-+", 3, 2, 1));

    }


    public static boolean validate (String s) {

        ArrayStack<Character> stack = new ArrayStack<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char sym = s.charAt(i);
            if (sym == '(' || sym == '{' || sym == '[')
                stack.push(sym);
            else if (sym == ')' || sym == '}' || sym == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char item = stack.pop();
                    switch (sym) {
                        case ')' : {
                            if (item != '(') return false;
                            break;
                        }
                        case '}' : {
                            if (item != '{') return false;
                            break;
                        }
                        case ']' : {
                            if (item != '[') return false;
                            break;
                        }
                    }
                }
            }
        }

        return stack.isEmpty();

    }

    public static String infixToPostfix(String infix) {

        ArrayStack<Character> stack = new ArrayStack<>(infix.length());
        String output = "";

        for (int i = 0; i < infix.length(); i++) {

            char sym = infix.charAt(i);

            // opening bracket pushed into stack
            if (sym == '(' || sym == '{' || sym == '[')
                stack.push(sym);

            // closing bracket found
            else if (sym == ')' || sym == '}' || sym == ']') {
                char item;

                // sending all values between the left and right parenthesis to the output
                switch (sym) {
                    case ')': {
                        do {
                            item = stack.pop();
                            output += item;
                        } while (item != '(');
                        output = output.substring(0, output.length() - 1); // discarding the left parenthesis
                        break;
                    }
                    case '}': {
                        do {
                            item = stack.pop();
                            output += item;
                        } while (item != '{');
                        output = output.substring(0, output.length() - 1); // discarding the left parenthesis
                        break;
                    }
                    case ']': {
                        do {
                            item = stack.pop();
                            output += item;
                        } while (item != '[');
                        output = output.substring(0, output.length() - 1); // discarding the left parenthesis
                        break;
                    }
                }

            } else if (sym == '+' || sym == '-' || sym == '*' || sym == '/') {

                // an operator is being scanned

                // checking precedence and popping/pushing with respect to that
                switch (sym) {
                    case '+' : {
                        while (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/') {
                            output += stack.pop();
                        }
                        stack.push('+');
                        break;
                    }
                    case '-' : {
                        while (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/') {
                            output += stack.pop();
                        }
                        stack.push('-');
                        break;
                    }
                    case '*' : {
                        while (stack.peek() == '+' || stack.peek() == '-') {
                            output += stack.pop();
                        }
                        stack.push('*');
                        break;
                    }
                    case '/' : {
                        while (stack.peek() == '+' || stack.peek() == '-') {
                            output += stack.pop();
                        }
                        stack.push('/');
                        break;
                    }
                }

            } else {
                // operand is directly sent to the output
                output += sym;
            }

        }

        // send all the remaining elements in the stack to the output
        while (!stack.isEmpty())
            output += stack.pop();

        return output;

    }

    public static double evaluatePostfix(String postfix, double A, double B, double C) {

        ArrayStack<Double> stack = new ArrayStack<>(10);

        for (int i = 0; i < postfix.length(); i++) {

            char sym = postfix.charAt(i);

            if (sym == 'A')
                stack.push(A);
            else if (sym == 'B')
                stack.push(B);
            else if (sym == 'C')
                stack.push(C);
            else {

                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double value;

                switch (sym) {

                    case '+' : {
                        value = operand1 + operand2;
                        break;
                    }

                    case '-' : {
                        value = operand1 - operand2;
                        break;
                    }

                    case '*' : {
                        value = operand1 * operand2;
                        break;
                    }

                    case '/' : {
                        value = operand1 / operand2;
                        break;
                    }

                    default:
                        throw new IllegalStateException("Unexpected value: " + sym);
                }

                stack.push(value);

            }

        }

        return stack.pop();

    }

}
