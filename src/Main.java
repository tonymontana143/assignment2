import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "1.Array list\n" +
                "2.Linked list\n" +
                "3.Break";
        String arrayListMenu = "1. Get size\n" +
                "2. Check if list contains element\n" +
                "3. Add element\n" +
                "4. Add element by index\n" +
                "5. Remove element\n" +
                "6. Remove element by index\n" +
                "7. Clear list\n" +
                "8. Index of object\n" +
                "9. Index of object by the end\n" +
                "10. Sort\n" +
                "11. Get elements";
        String linkedListMenu = "1. Get size\n" +
                "2. Check if list contains element\n" +
                "3. Add element\n" +
                "4. Add element by index\n" +
                "5. Remove element\n" +
                "6. Remove element by index\n" +
                "7. Clear list\n" +
                "8. Index of object\n" +
                "9. Index of object by the end\n" +
                "10. Sort\n" +
                "11. Get elements";
        Scanner scanner = new Scanner(System.in);
        int choice1 = 0;
        do {
            System.out.println(menu);
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    int choice2;
                    MyList<Object> arrayList = new MyArrayList<>();
                    do {
                        System.out.println(arrayListMenu);
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 0:
                                for (int i = 0; i < arrayList.size(); i++) {
                                    System.out.print(arrayList.get(i) + " ");
                                }
                                break;
                            case 1:
                                System.out.println(arrayList.size());
                                break;
                            case 2:
                                Object element = scanner.next();
                                System.out.println(arrayList.contains(element));
                                break;
                            case 3:
                                Object addElement = scanner.next();
                                arrayList.add(addElement);
                                break;
                            case 4:
                                Object addElementAtIndex = scanner.next();
                                int addIndex = scanner.nextInt();
                                arrayList.add(addElementAtIndex, addIndex);
                                break;
                            case 5:
                                Object removeElement = scanner.next();
                                System.out.println(arrayList.remove(removeElement));
                                break;
                            case 6:
                                int removeIndex = scanner.nextInt();
                                arrayList.remove(removeIndex);
                                break;
                            case 7:
                                int clearIndex = scanner.nextInt();
                                System.out.println(arrayList.get(clearIndex));
                                break;
                            case 8:
                                arrayList.clear();
                                break;
                            case 9:
                                arrayList.sort();
                                break;
                            case 10:
                                Object findIndex = scanner.next();
                                System.out.println(arrayList.indexOf(findIndex));
                                break;
                            case 11:
                                Object findLastIndex = scanner.next();
                                System.out.println(arrayList.lastIndexOf(findLastIndex));
                                break;
                            case 12:
                                break;
                            case 13:
                                arrayList.reverse();
                            default:
                                break;
                        }
                    } while (choice2 != 12);
                    break;
                case 2:
                    int choice3;
                    MyList<Object> linkedList = new MyLinkedList();
                    int choise3 = 0;
                    do {
                        System.out.println(linkedListMenu);
                        choice3 = scanner.nextInt();
                        switch (choice3) {

                            case 0:
                                for (int i = 0; i < linkedList.size(); i++) {
                                    System.out.print(linkedList.get(i) + " ");
                                }
                                break;
                            case 1:
                                System.out.println(linkedList.size());
                                break;
                            case 2:
                                Object case2 = scanner.next();

                                System.out.println(linkedList.contains(case2));
                                break;
                            case 3:
                                Object case3 = scanner.next();
                                linkedList.add(case3);
                                break;
                            case 4:
                                Object case4 = scanner.next();
                                int case4Index = scanner.nextInt();
                                linkedList.add(case4, case4Index);
                                break;
                            case 5:
                                Object case5 = scanner.next();
                                System.out.println(linkedList.remove(case5));
                                break;
                            case 6:
                                int case6 = scanner.nextInt();
                                linkedList.remove(case6);
                                break;
                            case 7:
                                int case7 = scanner.nextInt();
                                System.out.println(linkedList.get(case7));
                                break;
                            case 8:
                                linkedList.clear();
                                break;
                            case 9:
                                linkedList.sort();
                                break;
                            case 10:
                                Object case10 = scanner.next();
                                System.out.println(linkedList.indexOf(case10));
                                break;
                            case 11:
                                Object case11 = scanner.next();
                                System.out.println(linkedList.lastIndexOf(case11));
                                break;
                            case 12:
                                break;
                            default:
                                break;
                        }

                    } while (choise3 != 12);
                    break;

                case 3:
                    break;

                default:
                    break;
            }

        } while (choice1 != 3);
    }


}