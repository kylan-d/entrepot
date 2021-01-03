Voici les indications pour utiliser notre simulateur d'netrepot biilomo,
Tout d'abord éxécuter le fichier main
puis vous pouvez commencez la simulation en parametrant l'entrepot, vous pouvez choisir sa taile sa tresorerie de base, et sa composition d'equipe avec les spe des ouvriers choisis aléatoirement, la tresorerie est un double le reste sont des entiers.
Attention a ne pas mettre de string quand un int ou un double est demandé. 
Ensuite vous pouvez choisir le tye de simulation que vous voudriez faire.

si vous choisissez le fichier:
le fichier est de base situé directement dans le disque dur, vous pouvez changez directment dans la méthode filesimu() ou alors parcourir le chemin pour accéder aux fichier dans le nom de votre fichie par exemple( "nomdurepertoire\\nomdurepertoire2\\nomdufichier.txt")
 1 ligne correspond à un pas de temps, et commence par un entier, les possibilités de commande sont <id> rien , <id> lot <nom lot> <poids> <prix> <volume>, <id> meuble <nom meuble> <nom piece> <durée construction> <nomlot num x> <volume lot num x>
prix est un double, le poids et le volume sont des entiers, les differents nom ne doivent pas contenir d'espace

la console:

attention, une mauvaise commande entraine un pas de temps ou l'on ne fais rien. 
les differents nom ne doivent pas contenir d'espace

aleatoire:
Suivez le parametrage guidé de l'entrepot, la valeur des pourcentage ne doit pas depacer 100, et etre des entiers


La liste des noms de piece, des noms de lot, des noms de meuble, et des prix des pieces est deja parametré, vous pouvez la modifier à votre guise  dans la class entrepot dans les tableaux correspondant.

Aussi à l'heure actuelles tout les meublles de la simulations aléatoires prennent 3 types de lots de volume compris entre 1 et 10, c'est modifiable en changeant cette partie du code dans la classe menu et dans la methode simu3
                "for (int nblot = 0; nblot < 3; nblot++) {
                    int prob4 = (int) (Math.random() * entrepot.getNompiece().length); //entrepot.nompiece.length
                    int prob5 = 1 + (int) (Math.random() * (10));
                    meubleaj.addcompo(new Paire(prob5, entrepot.getNomPiece(prob4))); //entrepot.nompiece[prob4]
                }"
remplacer le 3 pour le nombre de lot et le 10 pour le volume des lots


Pour chaque simulation, il vous sera demandé de choisir une strategie de ressources humaines et et rangement de lot qui sera parametré si necessaire puis une strategie d'enlèvement de lot qui sera aussi paramétré si necessaire.

Les differentes stratégies sont explicités dans le rapport.

A la fin du simulation, vous pouvez revenir en arriere pour d'autre simulation dans l'entrepot ou changer d'entrepot, 