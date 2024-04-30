package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitites.Departament;
import entitites.HourContract;
import entitites.Worker;
import entitites.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in).useLocale(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departamentName = sc.nextLine();
		
		System.out.println("Entre com os dados do trabalhador: ");
		
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		System.out.print("Quantos contratos para esse trabalhador? ");
		Integer n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Entre com os dados do contrato #"+i );
			System.out.print("DATE (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora:");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duração do contrato: ");
			int hours = sc.nextInt();		
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.println("Entre com o mês e ano para calcular o salário (MM/AAAA) ");
		String mesAndAno = sc.next();
		int mes = Integer.parseInt(mesAndAno.substring(0, 2));
		int ano = Integer.parseInt(mesAndAno.substring(3));
		System.out.println("Name: "+ worker.getName());
		System.out.println("Departamento: "+ worker.getDepartament().getName());
		System.out.println("Renda em "+ mesAndAno + " foi de: "+ String.format("%.2f", worker.income(ano, mes)));
		sc.close();
	}

}
