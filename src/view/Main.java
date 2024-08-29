package view;

import java.util.Scanner;

import controller.DistroController;

public class Main {

	public static void main(String[] args) {
		DistroController dControl = new DistroController();
		
		Scanner scan = new Scanner(System.in);
		
		String menu = """
				1 - Mostrar Distro
				9 - Finalizar
				""";
		
		int opc = 0;
		while(opc != 9) {
			System.out.println(menu);
			opc = scan.nextInt();
			switch (opc) {
				case 1:
					dControl.exibeDistro();
					break;
				case 9:
					System.out.println("Finalizando");
					break;
				default:
					System.out.println("Opção Inválida");
			}
		}
		scan.close();
	}

}
