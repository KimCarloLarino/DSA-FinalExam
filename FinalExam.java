import java.util.Scanner;

class nodelist {
    int V;
    nodelist NEXT;
    nodelist() {}
    nodelist(int V) { this.V = V; }
    nodelist(int V, nodelist NEXT) { this.V = V; this.NEXT = NEXT; }
}

public class FinalExam {
    public static nodelist BETWEENREVERSE(nodelist HEAD, int L, int R) {
        nodelist PREV = null;
        nodelist CURRENT = HEAD;
        for (int I = 1; I < L; I++) {
            PREV = CURRENT;
            CURRENT = CURRENT.NEXT;
        }
        nodelist leftNode = PREV;
        nodelist TAIL = CURRENT;
        for (int I = L; I <= R; I++) {
            nodelist nextNode = CURRENT.NEXT;
            CURRENT.NEXT = PREV;
            PREV = CURRENT;
            CURRENT = nextNode;
        }
        if (leftNode == null) {
            HEAD = PREV;
        } else {
            leftNode.NEXT = PREV;
        }
        TAIL.NEXT = CURRENT;
        return HEAD;
    }
    
    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list: ");
        int n = sc.nextInt();
        nodelist HEAD = null;
        nodelist TAIL = null;
        for (int I = 1; I <= n; I++) {
            System.out.println();
            System.out.print("Enter element " + I + ": ");
            int V = sc.nextInt();
            nodelist NODE = new nodelist(V);
            if (HEAD == null) {
                HEAD = NODE;
                TAIL = NODE;
            } else {
                TAIL.NEXT = NODE;
                TAIL = NODE;
            }
        }
        System.out.print("Enter left and right indices (1-indexed): ");
        int L = sc.nextInt();
        int R = sc.nextInt();
        sc.close();
        HEAD = BETWEENREVERSE(HEAD, L, R);
        System.out.println("Linked list after reversing between " + L + " and " + R + ": ");
        nodelist CURRENT = HEAD;
        while (CURRENT != null) {
            System.out.print(CURRENT.V + " ");
            CURRENT = CURRENT.NEXT;
        }
    }
}
