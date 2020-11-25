package projet;
public class Main{
    public static void main(String[] args) {
        Rangee a= new Rangee(7);
        a.place[1]=new LotPiece("vis",5.5,4.0,2);
        System.out.println(a.place[1]);
        a.place[1]=null;
        System.out.println(a.place[1]);
        double f;
        f=54412.2;
        int c=412;
        f=f-c;
        System.out.println(f);
    }
}