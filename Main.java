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
        Entrepot e1= new Entrepot(5,5,10000);
        e1.recruterchefbrico("paul","jacques");
        e1.recruterchefstock("paulo","jacquot");
        e1.recruterchefstock("paula","jacquass");
        e1.recruterchefbrico("pauli","jacquie");
        System.out.println(e1.chef_equipe.get(0).Nom);
        System.out.println(e1.chef_equipe.size());
       // e1.chef_equipe.get(0).actif=true;
        //e1.chef_equipe.get(1).actif=true;
        //e1.chef_equipe.get(2).actif=true;
        e1.chef_equipe.get(3).actif=true;
        e1.licencierChef(0);
        System.out.println(e1.chef_equipe.size());
        System.out.println(e1.chef_equipe.get(0).Nom);
        System.out.println( e1.chef_equipe.get(2).liste_ouv[1]);
        e1.recruterouvrier("rock","pierre", "cuisine");
        e1.recruterouvrier("roche","caillou", "toilette");;
        System.out.println(e1.chef_equipe.get(0).tailleeq);
        System.out.println(e1.chef_equipe.get(0).liste_ouv[0].Nom);
        System.out.println(e1.chef_equipe.get(0).liste_ouv[1].Nom);
        System.out.println(e1.chef_equipe.get(0).tailleeq);
        e1.licencierOuvrier("toilette");
        System.out.println(e1.chef_equipe.get(0).liste_ouv[0].Nom);
        System.out.println(e1.chef_equipe.get(0).tailleeq);

    }
}