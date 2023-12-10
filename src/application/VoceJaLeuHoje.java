package application;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import entities.Dia;
import entities.staus.StatusLeitura;

public class VoceJaLeuHoje {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ArrayList<Dia> list = new ArrayList<Dia>();

		System.out.println("Qual a data de início da rotina (DD/MM/AAAA)?");
		Date diaInicio = sdf.parse(sc.next());

		Dia dia = new Dia(diaInicio, StatusLeitura.LEU);
		list.add(dia);

		boolean rotinaLeituras = true;
		System.out.println("Vamos começar s/n?");
		char respostaRotina = sc.next().charAt(0);

		if (respostaRotina == 's') {

			while (rotinaLeituras) {

				dia = new Dia(Dia.adicionarUmDia(dia.getMoment()), StatusLeitura.LEU);

				System.out.println("Você leu hoje? s/n");
				char resposta = sc.next().charAt(0);

				if (resposta == 's') {

					list.add(dia);
				} else if (resposta == 'n') {

					dia.setStatus(StatusLeitura.NAO_LEU);

					list.add(dia);
				} else {
					System.out.println("Digite um caractere válido: s/n");
					resposta = sc.next().charAt(0);
				}

				// validação se quero continuar
				System.out.println("Deseja continuar a rotina? s/n");
				respostaRotina = sc.next().charAt(0);
				if (respostaRotina == 'n') {
					rotinaLeituras = false;
				}
			}

			
		}
		System.out.println("Que pena, não esqueça de persistir");
		System.out.println();
		System.out.println("Rotina de leitura: ");

		for (

		Dia d : list) {
			System.out.println(d.toString());
		}

	}

}
