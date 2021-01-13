package main;

import java.util.Scanner;
import java.util.Random;
import games.*;
import players.Human;
import players.Player;
import players.RandomPlayer;
import plays.Orchestrator;
import players.NegamaxPlayer;

public class Main
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int choix = 1;
		do
		{

				// Choix du jeu
				System.out.println("Jeux disponibles : \n1-Nim \n 2-Morpion Normal \n  3-Morpion avec Aide");

				System.out.println("\nSaisissez un jeu : ");

				int jeuChoisi = Integer.parseInt(scanner.next());


				System.out.println("\nQuel est votre nom ?");
				String moi = scanner.next();

				System.out.println("Voulez-vous jouer avec un humain ou avec l'Ordinateur? \n1-Humain \n 2-Ordinateur(Random) \n  3-Ordinateur(Negamax): ");
				int typeJoueur = Integer.parseInt(scanner.next());


				Human p1 = new Human(moi,scanner);

				if(typeJoueur == 1)
				{
					System.out.println("Quel est son nom ?");
					String adversaire = scanner.next();

					Human p2 = new Human(adversaire,scanner);

					if(jeuChoisi == 1)
					{
						System.out.println("Donner le nombre d'allumettes initial :");
						int nbreInit = Integer.parseInt(scanner.next());
						System.out.println("Donner le tire maximal:");
						int max = Integer.parseInt(scanner.next());
						Nim jeu = new Nim(nbreInit,max, p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}
					if(jeuChoisi == 2)
					{
						TicTacToe jeu = new TicTacToe(p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}
					if(jeuChoisi == 3)
					{
						TicTacToeWithHints jeu = new TicTacToeWithHints(p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}



				}
				else if(typeJoueur == 2)
				{
					Random rand = new Random(100);
					RandomPlayer p2 = new RandomPlayer(rand);

					if(jeuChoisi == 1)
					{
						System.out.println("Donner le nombre d'allumettes initial :");
						int nbreInit = Integer.parseInt(scanner.next());
						System.out.println("\nDonner le tire maximal:");
						int max = Integer.parseInt(scanner.next());
						Nim jeu = new Nim(nbreInit,max, p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}
					if(jeuChoisi == 2)
					{

						TicTacToe jeu = new TicTacToe(p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);


						orchestrator.play();
					}
					if(jeuChoisi == 3)
					{
						TicTacToeWithHints jeu = new TicTacToeWithHints(p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}

				}
				else if(typeJoueur == 3)
				{
					//Random rand = new Random(100);
					Player p2 = new NegamaxPlayer();

					if(jeuChoisi == 1)
					{
						System.out.println("Donner le nombre d'allumettes initial :");
						int nbreInit = Integer.parseInt(scanner.next());
						System.out.println("\nDonner le tire maximal:");
						int max = Integer.parseInt(scanner.next());
						Nim jeu = new Nim(nbreInit,max, p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}
					if(jeuChoisi == 2)
					{

						TicTacToe jeu = new TicTacToe(p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);


						orchestrator.play();
					}
					if(jeuChoisi == 3)
					{
						TicTacToeWithHints jeu = new TicTacToeWithHints(p1, p2);

						Orchestrator orchestrator = new Orchestrator(jeu);

						orchestrator.play();
					}

				}
				System.out.println("\nVoulez-vous : \n1- Rejouer \n2-  Quitter");
				 choix = Integer.parseInt(scanner.next());
			}while(choix==1);
			scanner.close();

		}
	}
