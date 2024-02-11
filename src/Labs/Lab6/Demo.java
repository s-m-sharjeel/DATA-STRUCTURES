package Labs.Lab6;

public class Demo {

    public static void main(String[] args) {

        Game game = new Game();
        game.insertPlayer("player1");
        game.insertPlayer("player2");
        game.insertPlayer("player3");
        game.insertPlayer("player4");
        game.insertPlayer("player5");

        System.out.println(game);
        System.out.println(game.playGame());

        LinkedList<Integer> list1 = new LinkedList<>();

        list1.insert(2);
        list1.insert(4);
        list1.insert(8);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.insert(1);
        list2.insert(7);
        list2.insert(14);
        list2.insert(15);

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println(list.sortedMerge(list1 ,list2));

    }

}
