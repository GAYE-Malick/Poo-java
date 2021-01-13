package players;

import java.util.ArrayList;
import java.util.Scanner;

import games.Game;

public class NegamaxPlayer implements Player
{

	public NegamaxPlayer()
	{

	}

	public int evaluate(Game jeu)
	{
		if(jeu.isOver()==true)
		{
			if(jeu.getWinner() == jeu.getCurrentPlayer())
			{
				return 1;
			}

			else if(jeu.getWinner() == null)
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}
		else
		{

			Integer meilleureValeur =  null;
			Integer meilleurCoup =  null;
			//Integer res = null;
			ArrayList<Integer> maliste = jeu.validMoves();

			for(int i=0;i<maliste.size();i++)
			{
				int action = maliste.get(i);
				Game jeuPrime = jeu.copy();

				jeuPrime.execute(action);
				int v = -this.evaluate(jeuPrime);
				if(meilleureValeur ==  null || v > meilleurCoup)
				{
					//res = v;
					meilleureValeur = action;
					meilleurCoup = v;
				}
			}
			return meilleurCoup;
		}
	}

	public int chooseMove(Game jeu)
	{
		Integer meilleureValeur =  null;

		Integer meilleurCoup = null;

		ArrayList<Integer> maliste = jeu.validMoves();

		for(int i=0;i<maliste.size();i++)
		{
			int action = maliste.get(i);
			Game jeuPrime = jeu.copy() ;

			jeuPrime.execute(action);

			int v = - this.evaluate(jeuPrime);

			if(meilleureValeur == null || v > meilleureValeur)
			{
				meilleureValeur = v;
				meilleurCoup = action;
			}
		}

		return meilleurCoup;
	}
	public String toString()
	{
		return " aleatoire numero " + this.hashCode();
	}

}
