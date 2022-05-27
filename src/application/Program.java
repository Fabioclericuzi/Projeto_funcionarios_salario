package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Employee> lista = new ArrayList<>();
		
		
		
		System.out.println("Quantos funcion�rios v�o ser cadastrados: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <=n; i++) {
			System.out.println();
			System.out.println("Funcion�rio #" + i + ": ");
			
			System.out.println("Id: ");
			int id = sc.nextInt();
			while(hasId(lista, id)) {
				System.out.println("Id j� foi passado, tente outra vez: ");
				id = sc.nextInt();
			}
			System.out.println("Nome: ");
			sc.nextLine();
			String nome  = sc.nextLine();
			System.out.println("Sal�rio: ");
			double salario = sc.nextDouble();
			lista.add(new Employee(id, nome, salario));
		}
		System.out.println();
		System.out.println("Entre com o ID do funcion�rio que ter� o sal�rio incrementado: ");
		int id = sc.nextInt();
		Employee emp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("O ID n�o existe");
		}
		else {
			System.out.println("Entre com a porcentagem do aumento: ");
			double porcentagem = sc.nextDouble();
			emp.incrementoSalario(porcentagem);
		}
		System.out.println();
		System.out.println("Lista de funcion�rios: ");
		for(Employee obj : lista) {
			System.out.println(obj);
		}
		sc.close();
	}
	public static boolean hasId(List<Employee> lista, int id) {
		Employee emp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
