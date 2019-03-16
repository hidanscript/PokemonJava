import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game  {

	public static void main(String[] args) {

		Frame game = new Frame();
		game.setBounds(0,0,850,540);
		game.setVisible(true);
		game.setLocationRelativeTo(null);
		game.setResizable(false);

		//Pokemon( Nombre, Tipo, Vida, Ataque, Ataque especial, Defensa, Defensa especial, Velocidad, Nivel).
		Pokemon pikachu = new Pokemon("Pikachu","Electric","Jolly",20,12,9,10,11,16,5);

		pikachu.damageCalculator("Electric","Water",80,9,9,true);

	}

}