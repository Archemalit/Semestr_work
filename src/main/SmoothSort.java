package main;

import java.util.ArrayList;
import java.util.List;


public class SmoothSort {
    public static int [] smoothsort(int [] array) {
        List<Integer> numbers = leonardoNumbers(array.length);
        List<Node> heads = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (heads.size() < 2 || !(numbers.contains(heads.get(heads.size() - 2).count + heads.get(heads.size() - 1).count + 1))) {
                heads.add(new Node(array[i]));
            } else {
                Node head = new Node(array[i]);
                Node node1 = heads.remove(heads.size() - 1);
                Node node2 = heads.remove(heads.size() - 1);
                head.right = node1;
                head.left = node2;
                head.count = node1.count + node2.count + 1;
                heapify(head);
                heads.add(head);
            }
        }

        int [] result = goBack(heads);
        return result;
    }

    public static int[] goBack(List<Node> heads) {
        List<Integer> array = new ArrayList<>();

        while(!heads.isEmpty()) {
            for (int i = 0; i < heads.size() - 1; i++) {
                for (int j = i + 1; j < heads.size(); j++) {
                    if (heads.get(i).value > heads.get(j).value) {
                        int temp = heads.get(i).value;
                        heads.get(i).value = heads.get(j).value;
                        heads.get(j).value = temp;
                        heapify(heads.get(i));
                        heapify(heads.get(j));
                    }
                }
            }
            if (heads.get(heads.size() - 1).left != null) {
                heads.add(heads.get(heads.size() - 1).left);
                heads.add(heads.get(heads.size() - 2).right);
                array.add(heads.remove(heads.size() - 3).value);
            } else {
                array.add(heads.remove(heads.size() - 1).value);
            }
        }



//        int temp = heads.get(0).value;
//        heads.get(0).value = heads.get(heads.size() - 1).value;
//        heads.get(heads.size() - 1).value = temp;

//
//
//        while(!heads.isEmpty()) {
//            if (heads.size() == 1) {
//                if (heads.get(0).left != null) {
//                    heads.add(heads.get(0).left);
//                    heads.add(heads.get(0).right);
//                }
//                array.add(heads.remove(0).value);
//                if (heads.size() > 1) {
//                    heapify(heads.get(0));
//                }
//            } else {
//                if (heads.size() == 2) {
//                    if (heads.get(0).value > heads.get(heads.size() - 1).value) {
//                        int temp = heads.get(0).value;
//                        heads.get(0).value = heads.get(heads.size() - 1).value;
//                        heads.get(heads.size() - 1).value = temp;
//                        heapify(heads.get(0));
////                        heapify(heads.get(1));
//
//                    }
//                } else {
//                    if (heads.get(1).value > heads.get(2).value) {
//                        int temp = heads.get(1).value;
//                        heads.get(1).value = heads.get(2).value;
//                        heads.get(2).value = temp;
//                        heapify(heads.get(1));
//                        heapify(heads.get(2));
//                    }
//
////                    if (heads.get(0).value > heads.get(1).value) {
////                        int temp = heads.get(0).value;
////                        heads.get(0).value = heads.get(1).value;
////                        heads.get(1).value = temp;
////
////                        heapify(heads.get(0));
////                        heapify(heads.get(1));
////
////                    }
//
//                    if (heads.get(0).value > heads.get(heads.size() - 1).value) {
//                        int temp = heads.get(0).value;
//                        heads.get(0).value = heads.get(heads.size() - 1).value;
//                        heads.get(heads.size() - 1).value = temp;
//
//                        heapify(heads.get(0));
//                        heapify(heads.get(heads.size() - 1));
//                    }
//
////                    if (heads.get(1).value > heads.get(2).value) {
////                        int temp = heads.get(1).value;
////                        heads.get(1).value = heads.get(2).value;
////                        heads.get(2).value = temp;
////                    }
//
////                    if (heads.get(0).value > heads.get(heads.size() - 2).value) {
////                        int temp = heads.get(0).value;
////                        heads.get(0).value = heads.get(heads.size() - 2).value;
////                        heads.get(heads.size() - 2).value = temp;
////
////                    }
//                }
//                if (heads.get(heads.size() - 1).left != null) {
//                    heads.add(heads.get(heads.size() - 1).left);
//                    heads.add(heads.get(heads.size() - 2).right);
//                    array.add(heads.remove(heads.size() - 3).value);
////                    heapify(heads.get(0));
////                    heapify(heads.get(1));
//
//
//                } else {
//                    array.add(heads.remove(heads.size() - 1).value);
//                }
//            }
//        }
        int [] result = new int[array.size()];
        for (int i = array.size() - 1; i > -1; i--) {
            result[array.size() - 1 - i] = array.get(i);
        }
        return result;
    }

    public static void heapify(Node node) {
        if (node.left == null || node.right == null) {
            return;
        }
        if (node.left.value >= node.value && node.left.value >= node.right.value) {
            int temp = node.left.value;
            node.left.value = node.value;
            node.value = temp;
            heapify(node.left);
        } else if (node.right.value >= node.value && node.right.value >= node.left.value) {
            int temp = node.right.value;
            node.right.value = node.value;
            node.value = temp;
            heapify(node.right);
        }
    }

    private static List<Integer> leonardoNumbers(int hi) {
        List<Integer> numbers = new ArrayList<>();
        int a = 1, b = 1;
        while (a <= hi) {
            if (a != 1) {
                numbers.add(a);
            }
            int temp = a;
            a = b;
            b = temp + b + 1;
        }
        return numbers;
    }
}

class Node {
    Node parent;
    int value;
    Node left;
    Node right;
    int count = 1;

    public Node(int value) {
        this.value = value;
    }

}