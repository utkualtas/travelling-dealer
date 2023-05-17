import kotlinversion.Node;


public class Main {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.appendToEnd(2);
        head.appendToEnd(3);
        head.appendToEnd(4);
        head.appendToEnd(5);
        head.appendToEnd(6);

        printInfo(head);

        for (int i = 1; i < 7; i++) {
            if (head == null) return;
            head = head.deleteNode(head, i);
            printInfo(head);
        }
    }

    private static void printInfo(Node node) {
        if (node == null) {
            System.out.println("Singly Linked List is empty!");
            return;
        }
        node.printNodes();
        System.out.println("\nLength: " + node.length(node));
        System.out.println("Sum: " + node.sumOfNodes() + "\n");
    }

}
