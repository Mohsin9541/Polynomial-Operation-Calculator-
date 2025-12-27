//import java.util.Scanner;
//
//
//class PolynomialTerm {
//    int coefficient;
//    int exponent;
//    PolynomialTerm next;
//
//    PolynomialTerm(int coefficient, int exponent) {
//        this.coefficient = coefficient;
//        this.exponent = exponent;
//        this.next = null;
//    }
//}
//
//
//class Polynomial {
//    private PolynomialTerm head;
//
//    Polynomial() {
//        head = null;
//    }
//
//
//    public void insertTerm(int coefficient, int exponent) {
//        if (coefficient == 0) return;
//
//        PolynomialTerm newTerm = new PolynomialTerm(coefficient, exponent);
//
//        if (head == null || head.exponent < exponent) {
//            newTerm.next = head;
//            head = newTerm;
//            return;
//        }
//
//        PolynomialTerm current = head;
//        while (current.next != null && current.next.exponent > exponent) {
//            current = current.next;
//        }
//
//        if (current.next != null && current.next.exponent == exponent) {
//            current.next.coefficient += coefficient;
//            if (current.next.coefficient == 0) {
//                current.next = current.next.next;
//            }
//        } else {
//            newTerm.next = current.next;
//            current.next = newTerm;
//        }
//    }
//
//    public int getDegree() {
//        return (head == null) ? 0 : head.exponent;
//    }
//
//    public int getNumberOfTerms() {
//        int count = 0;
//        PolynomialTerm temp = head;
//        while (temp != null) {
//            count++;
//            temp = temp.next;
//        }
//        return count;
//    }
//
//    public static Polynomial add(Polynomial p1, Polynomial p2) {
//        Polynomial result = new Polynomial();
//        PolynomialTerm a = p1.head, b = p2.head;
//
//        while (a != null && b != null) {
//            if (a.exponent == b.exponent) {
//                result.insertTerm(a.coefficient + b.coefficient, a.exponent);
//                a = a.next;
//                b = b.next;
//            } else if (a.exponent > b.exponent) {
//                result.insertTerm(a.coefficient, a.exponent);
//                a = a.next;
//            } else {
//                result.insertTerm(b.coefficient, b.exponent);
//                b = b.next;
//            }
//        }
//
//        while (a != null) {
//            result.insertTerm(a.coefficient, a.exponent);
//            a = a.next;
//        }
//
//        while (b != null) {
//            result.insertTerm(b.coefficient, b.exponent);
//            b = b.next;
//        }
//
//        return result;
//    }
//
//    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
//        Polynomial result = new Polynomial();
//        PolynomialTerm a = p1.head, b = p2.head;
//
//        while (a != null && b != null) {
//            if (a.exponent == b.exponent) {
//                result.insertTerm(a.coefficient - b.coefficient, a.exponent);
//                a = a.next;
//                b = b.next;
//            } else if (a.exponent > b.exponent) {
//                result.insertTerm(a.coefficient, a.exponent);
//                a = a.next;
//            } else {
//                result.insertTerm(-b.coefficient, b.exponent);
//                b = b.next;
//            }
//        }
//
//        while (a != null) {
//            result.insertTerm(a.coefficient, a.exponent);
//            a = a.next;
//        }
//
//        while (b != null) {
//            result.insertTerm(-b.coefficient, b.exponent);
//            b = b.next;
//        }
//
//        return result;
//    }
//
//    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
//        Polynomial result = new Polynomial();
//
//        for (PolynomialTerm a = p1.head; a != null; a = a.next) {
//            for (PolynomialTerm b = p2.head; b != null; b = b.next) {
//                result.insertTerm(
//                        a.coefficient * b.coefficient,
//                        a.exponent + b.exponent
//                );
//            }
//        }
//        return result;
//    }
//
//    public void display() {
//        if (head == null) {
//            System.out.println("0");
//            return;
//        }
//
//        PolynomialTerm temp = head;
//        while (temp != null) {
//            System.out.print(temp.coefficient + "x^" + temp.exponent);
//            if (temp.next != null)
//                System.out.print(" + ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//}
//
//
//public class PolynomialOperations {
//
//    private static Polynomial inputPolynomial(Scanner sc) {
//        Polynomial p = new Polynomial();
//        System.out.print("Enter number of terms: ");
//        int n = sc.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            System.out.print("Coefficient: ");
//            int c = sc.nextInt();
//            System.out.print("Exponent: ");
//            int e = sc.nextInt();
//            p.insertTerm(c, e);
//        }
//        return p;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter Polynomial 1");
//        Polynomial p1 = inputPolynomial(sc);
//
//        System.out.println("\nEnter Polynomial 2");
//        Polynomial p2 = inputPolynomial(sc);
//
//        System.out.println("\nPolynomial 1:");
//        p1.display();
//        System.out.println("Degree: " + p1.getDegree());
//        System.out.println("Number of Terms: " + p1.getNumberOfTerms());
//
//        System.out.println("\nPolynomial 2:");
//        p2.display();
//        System.out.println("Degree: " + p2.getDegree());
//        System.out.println("Number of Terms: " + p2.getNumberOfTerms());
//
//        System.out.println("\nAddition:");
//        Polynomial.add(p1, p2).display();
//
//        System.out.println("\nSubtraction:");
//        Polynomial.subtract(p1, p2).display();
//
//        System.out.println("\nMultiplication:");
//        Polynomial.multiply(p1, p2).display();
//
//        sc.close();
//    }
//}







import javax.swing.*;
import java.awt.*;


class Term {
    int coefficient;
    int exponent;
    Term next;

    Term(int c, int e) {
        coefficient = c;
        exponent = e;
        next = null;
    }
}


class Polynomial {
    private Term head;

    void insert(int c, int e) {
        if (c == 0) return;

        Term node = new Term(c, e);

        if (head == null || head.exponent < e) {
            node.next = head;
            head = node;
            return;
        }

        Term curr = head;
        while (curr.next != null && curr.next.exponent > e)
            curr = curr.next;

        if (curr.next != null && curr.next.exponent == e) {
            curr.next.coefficient += c;
            if (curr.next.coefficient == 0)
                curr.next = curr.next.next;
        } else {
            node.next = curr.next;
            curr.next = node;
        }
    }

    int degree() {
        return head == null ? 0 : head.exponent;
    }

    int numberOfTerms() {
        int count = 0;
        for (Term t = head; t != null; t = t.next) count++;
        return count;
    }

    static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial r = new Polynomial();
        for (Term t = p1.head; t != null; t = t.next)
            r.insert(t.coefficient, t.exponent);
        for (Term t = p2.head; t != null; t = t.next)
            r.insert(t.coefficient, t.exponent);
        return r;
    }

    static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial r = new Polynomial();
        for (Term t = p1.head; t != null; t = t.next)
            r.insert(t.coefficient, t.exponent);
        for (Term t = p2.head; t != null; t = t.next)
            r.insert(-t.coefficient, t.exponent);
        return r;
    }

    static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial r = new Polynomial();
        for (Term a = p1.head; a != null; a = a.next)
            for (Term b = p2.head; b != null; b = b.next)
                r.insert(a.coefficient * b.coefficient,
                        a.exponent + b.exponent);
        return r;
    }

    public String toString() {
        if (head == null) return "0";
        StringBuilder sb = new StringBuilder();
        for (Term t = head; t != null; t = t.next) {
            if (t.coefficient > 0 && sb.length() > 0) sb.append(" + ");
            if (t.coefficient < 0) sb.append(" - ");
            sb.append(Math.abs(t.coefficient))
                    .append("x^")
                    .append(t.exponent);
        }
        return sb.toString();
    }
}


public class PolynomialOperations extends JFrame {

    JTextField p1Field, p2Field;
    JTextArea resultArea;

    public PolynomialOperations() {
        setTitle("Polynomial Operations using Linked List");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color bg = new Color(2, 6, 23);
        Color card = new Color(15, 23, 42);
        Color accent = new Color(34, 211, 238);
        Color text = new Color(229, 231, 235);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(bg);
        add(root);


        JLabel title = new JLabel(
                "Polynomial Operations Calculator",
                JLabel.CENTER
        );
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(accent);
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        root.add(title, BorderLayout.NORTH);


        JPanel cardPanel = new JPanel(new GridLayout(5, 1, 12, 12));
        cardPanel.setBackground(card);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        root.add(cardPanel, BorderLayout.CENTER);

        p1Field = inputField("Polynomial 1 (e.g. 3x^2+4x^1-5x^0)");
        p2Field = inputField("Polynomial 2 (e.g. 2x^3+1x^1)");

        cardPanel.add(p1Field);
        cardPanel.add(p2Field);

        JPanel buttons = new JPanel(new GridLayout(1, 3, 15, 10));
        buttons.setBackground(card);

        buttons.add(actionButton("ADD"));
        buttons.add(actionButton("SUBTRACT"));
        buttons.add(actionButton("MULTIPLY"));

        cardPanel.add(buttons);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setBackground(bg);
        resultArea.setForeground(text);
        resultArea.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(accent),
                        "Result"
                )
        );

        cardPanel.add(new JScrollPane(resultArea));


        JLabel footer = new JLabel(
                "Developed by Mohsin Nawaz",
                JLabel.CENTER
        );
        footer.setForeground(new Color(148, 163, 184));
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10));
        root.add(footer, BorderLayout.SOUTH);


        Component[] comps = buttons.getComponents();
        ((JButton) comps[0]).addActionListener(e -> calculate("add"));
        ((JButton) comps[1]).addActionListener(e -> calculate("sub"));
        ((JButton) comps[2]).addActionListener(e -> calculate("mul"));
    }

    JTextField inputField(String title) {
        JTextField tf = new JTextField();
        tf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tf.setForeground(Color.BLACK);
        tf.setBorder(BorderFactory.createTitledBorder(title));
        return tf;
    }

    JButton actionButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(new Color(34, 211, 238));
        b.setFocusPainted(false);
        return b;
    }

    Polynomial parse(String input) {
        Polynomial p = new Polynomial();
        input = input.replace("-", "+-");
        for (String t : input.split("\\+")) {
            if (t.trim().isEmpty()) continue;
            String[] parts = t.split("x\\^");
            int c = Integer.parseInt(parts[0].trim());
            int e = Integer.parseInt(parts[1].trim());
            p.insert(c, e);
        }
        return p;
    }

    void calculate(String op) {
        try {
            Polynomial p1 = parse(p1Field.getText());
            Polynomial p2 = parse(p2Field.getText());
            Polynomial r;

            if (op.equals("add")) r = Polynomial.add(p1, p2);
            else if (op.equals("sub")) r = Polynomial.subtract(p1, p2);
            else r = Polynomial.multiply(p1, p2);

            resultArea.setText(
                    "Polynomial: " + r +
                            "\nDegree: " + r.degree() +
                            "\nNumber of Terms: " + r.numberOfTerms()
            );
        } catch (Exception e) {
            resultArea.setText("Invalid Input Format");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new PolynomialOperations().setVisible(true)
        );
    }
}
