import java.util.Scanner;

public class Ejercicios2 {

	static int PedirOpcion(Scanner t)
	{
		int option=0;
		do {
			System.out.print("Introduce el ejercício que deseas realizar [30-42]: ");
			option=t.nextInt();
			t.nextLine();
			if(option<30 || option>42)
				ErrorIntroducido();
		}while(option<30 || option>42);
		
		return option;
	}
	
	static int PedirNumero(Scanner t)
	{
		int numero=0;
		System.out.print("Introducir numero: ");
		numero=t.nextInt();
		t.nextLine();

		return numero;
	}
	
	static int Mayor(int a, int b)
	{
		int mayor=0;
		if(a <= b)
			mayor=b;
		else
			mayor=a;
		
		return mayor;
	}
	
	static int Diferencia(int a, int b)
	{
		int diferencia=0;
		if(a<=b)
			diferencia=b-a;
		else
			diferencia=a-b;
		
		/*if(diferencia<0) //Este método también es válido
		 * diferencia*=-1;
		 */
		
		return diferencia;
	}
	
	static void MostrarNumeros(int a, int b)
	{
		System.out.println("El nummayor es el número: " + a);
		System.out.println("La diferéncia de ambos es: " + b);

		if(b!=0)
		{
			System.out.println("Los números entre ambos son: ");
			for(int i=(a-b)+1; i<a; i++)
			{
				System.out.print(i + " ");
			}
		}
	}
	
	static int Mayor(int a, int b, int c)
	{
		int mayor=0;

		mayor=Mayor(a, b);
		mayor=Mayor(mayor, c);
		
		return mayor;
	}
	
	static void ErrorIntroducido()
	{
		System.out.println("Ha introducido un valor no válido.");
	}
	
	static int PedirHoras(Scanner t, String mensaje)
	{
		int h=0;
		System.out.print("Introduzca el " + mensaje + ": ");
		h=t.nextInt();
		t.nextLine();
		
		return h;
	}
	
	static double Salarios(int a, int b)
	{
		double cobrar=0, precioextras=0;
		int extras=0;
		
		if(a<=40)
			cobrar=a*b;
		else
		{
			extras=a-40;
			precioextras=extras*b*1.5;
			cobrar=Salarios(40, b) + precioextras;
		}
		return cobrar;
	}
	
	static char ApuestaUsuario(Scanner t)
	{
		String mano="";
		char eleccion;
		
		do {
			System.out.print("\nIntroduzca su elección [PIEDRA, PAPEL, TIJERA]: ");
			mano=t.nextLine();
			if(!mano.equals("PIEDRA") && !mano.equals("PAPEL") && !mano.equals("TIJERA"))
				ErrorIntroducido();
		}while(!mano.equals("PIEDRA") && !mano.equals("PAPEL") && !mano.equals("TIJERA"));
		
		System.out.println("\nHas elegido jugar con [" + mano + "].");
		
		switch(mano)
		{
		case "PIEDRA":
			eleccion='p';
			break;
		case "PAPEL":
			eleccion='a';
			break;
		case "TIJERA":
			eleccion='t';
			break;
		default:
			eleccion='x';
			break;
		}
		
		return eleccion;
	}
	
	static char PiedraPapelTijera()
	{
		char eleccion;
		int aleatorio=0;
		
		aleatorio=(int)(Math.random()*3);
		switch(aleatorio)
		{
			case 0:
				eleccion='p';
				break;
			case 1:
				eleccion='a';
				break;
			case 2:
				eleccion='t';
				break;
			default:
				eleccion='x';
				break;
		}
		
		System.out.print("La máquina ha sacado  ");
		switch(eleccion)
		{
			case 'p': 
				System.out.println("[PIEDRA].\n");
				break;
			case 'a':
				System.out.println("[PAPEL].\n");
				break;
			case 't':
				System.out.println("[TIJERA].\n");
				break;
			default:
				System.out.println("ERROR EN ELECCIÓN DE LA MÁQUINA.\n");
				break;
		}
		
		return eleccion;
	}

	static char Ganar(char usuario, char maquina)
	{
		char ganador;
		
		if(usuario==maquina)
		{
			ganador='x';
			System.out.println("Esta ronda ha quedado en empate.");
		}
		else
			if((usuario=='p' && maquina=='t') || (usuario=='a' && maquina=='p') || (usuario=='t' && maquina=='a'))
			{
				ganador='1';
				System.out.println("Esta ronda la ha ganado el jugador.");
			}
			else
			{
				ganador='2';
				System.out.println("Esta ronda la ha ganado la máquina.");
			}
		return ganador;
	}
	
	static String Comprobar(Scanner t)
	{
		String ganador="";
		int rondas=0, puntosJugador=0, puntosMaquina=0;
		char gana='x';
		char jug='x', maq='x';
		
		do {
		jug=ApuestaUsuario(t);
		maq=PiedraPapelTijera();
		gana=Ganar(jug, maq);
		
			switch(gana)
			{
				case '1':
				{
					rondas++;
					puntosJugador++;
					System.out.println("Enhorabuena!, has ganado esta ronda. ");
					break;
				}
				case '2':
				{
					rondas++;
					puntosMaquina++;
					System.out.println("Ohhh!, has perdido esta ronda. ");
					break;
				}
				case 'x':
				{	
					rondas++;
					System.out.println("Ohhh!, habéis empatado.");
					break;
				}
			}
			System.out.println("\nSe han efectuado " + rondas + " rondas y la puntuación queda de la siguiente forma: ");
			System.out.println("[JUGADOR]      [MAQUINA]");
			System.out.println("    " + puntosJugador + "              " + puntosMaquina);
		}while(puntosJugador<3 && puntosMaquina<3);
		
		if(puntosJugador==3)
			ganador="[EL JUGADOR]";
		else
			ganador="[LA MÁQUINA]";
		
		System.out.print("\nSe ha llegado al final de la partida, ");
		
		return ganador;
	}
	
	static int SacaN(int a, int b)
	{
		int n=0;
		
		if(a>b)
			n=CalcularModulo(a,b)+1;
		else
			n=b-a;
		
		System.out.println("modulo " + n);
		return n;
	}
	
	static int CalcularModulo(int a, int b)
	{
		int n=0;
		n=a%b;
		return n;
	}
	
	static int BuscarAleatorio()
	{
		int a=0;
		
		a=(int)(Math.random()*100);
		
		return a;
	}
	
	static int ComprobarRango(int a, int b)
	{
		int random=0;
		boolean encontrado=false;
		for(int i=0; i<1000 && !encontrado; i++)
		{
			random=BuscarAleatorio();
			if(random>=a && random<=b)
				encontrado=true;
			else
				random=-1;
		}
		return random;
	}
	
	static float PedirNotas(Scanner t, int a)
	{
		float nota=-1;
		
			System.out.print("Introduzca la nota del exámen número [" + a + "]: ");
			nota=t.nextFloat();
			t.nextLine();
		
		return nota;
	}
	
	static int PedirNotas(Scanner t)
	{
		float nota1=-1, nota2=-1, nota3=-1, nota4=-1, nota5=-1;
		String cantidad="";
		int notafinal=0;
		
		System.out.print("Introduzca la nota del primer exámen: ");
		nota1=t.nextFloat();
		t.nextLine();
		System.out.print("Introduzca la nota del segundo exámen: ");
		nota2=t.nextFloat();
		t.nextLine();
		System.out.println("Introducir mas notas? [s/S]");
		cantidad=t.nextLine();
		if(cantidad.equals("s") || cantidad.equals("S"))
		{
			System.out.print("Introduzca la nota del tercer exámen: ");
			nota3=t.nextFloat();
			t.nextLine();
			System.out.println("Introducir mas notas? [s/S]");
			cantidad=t.nextLine();
			if(cantidad.equals("s") || cantidad.equals("S"))
			{
				System.out.print("Introduzca la nota del cuarto exámen: ");
				nota4=t.nextFloat();
				t.nextLine();
				System.out.println("Introducir mas notas? [s/S]");
				cantidad=t.nextLine();
				if(cantidad.equals("s") || cantidad.equals("S"))
				{
					System.out.print("Introduzca la nota del quinto exámen: ");
					nota5=t.nextFloat();
					t.nextLine();
					notafinal=CalcularNotaFinal(nota1, nota2, nota3, nota4, nota5);
				}
				else {
					notafinal=CalcularNotaFinal(nota1, nota2, nota3, nota4);
				}
			}
			else {
				notafinal=CalcularNotaFinal(nota1, nota2, nota3);
			}
		}
		else {
			notafinal=CalcularNotaFinal(nota1, nota2);
		}
		return notafinal;
	}
	
	static int CalcularNotaFinal(float a, float b)
	{
		float nota=0;
		
		if(a<5)
			nota=a;
		else
			if(b<5)
				nota=b;
			else {
				nota=(a+b)/2;
			}
		
		return Math.round(nota);
	}
	
	static int CalcularNotaFinal(float a, float b, float c)
	{
		float nota=0;
		
		if(a<5 || b<5 || c<5)
		{
			if(a<b && a<c)
				nota=a;
			else 
				if(b<a && b<c)
					nota=b;
				else nota=c;
		}
		else
			nota=(a+b+c)/3;
		
		return Math.round(nota);
	}

	static int CalcularNotaFinal(float a, float b, float c, float d)
	{
		float nota=0;
		
		if(a<5 || b<5 || c<5 || d<5)
		{
			if(a<b && a<c && a<d)
				nota=a;
			else 
				if(b<a && b<c && b<d)
					nota=b;
				else 
					if(c<a && c<b && c<d)
						nota=c;
					else
						nota=d;
		}
		else
			nota=(a+b+c+d)/4;
		
		return Math.round(nota);
	}
	
	static int CalcularNotaFinal(float a, float b, float c, float d, float e)
	{
		float nota=0;
		
		if(a<5 || b<5 || c<5 || d<5 || e<5)
		{
			if(a<b && a<c && a<d && a<e)
				nota=a;
			else 
				if(b<a && b<c && b<d && b<e)
					nota=b;
				else 
					if(c<a && c<b && c<d && c<e)
						nota=c;
					else
						if(d<a && d<b && d<c && d<e)
							nota=d;
						else 
							nota=e;
		}
		else
			nota=(a+b+c+d+e)/5;
		
		return Math.round(nota);
	}
	
	static String ObtenerNombreNota(float a)
	{
		String calificar="";
		
		if(a<5)
			calificar="INSUFICIENTE";
		else
			if(a>=5 && a<6)
				calificar="SUFICIENTE";
			else
				if(a>=6 && a<7)
					calificar="BIEN";
				else
					if(a>=7 && a<9)
						calificar="NOTABLE";
					else
						calificar="SOBRESALIENTE";
		
		return calificar;
	}
	
	static double Distancia(double x1, double x2, double y1, double y2)
	{
		double distancia=0, p1=0, p2=0;
		
		p1=Math.pow(x1-x2, 2);
		p2=Math.pow(y1-y2, 2);
		distancia=Math.sqrt(p1+p2);
		
		return distancia;
	}
	
	static long CalcularSegundos(int dias, int horas, int minutos)
	{
		long seg=0, m=0, h=0, d=0;
		
		m=minutos*60;
		h=horas*60*60;
		d=dias*60*60*24;
		seg=m+h+d;
		
		return seg;
	}
	
	static long CalcularMin(int horas1, int minutos1, int horas2, int minutos2)
	{
		long segundos1=0, segundos2=0, minutostotales=0, segundostotales=0;
		
		segundos1=CalcularSegundos(0, horas1, minutos1);
		segundos2=CalcularSegundos(0, horas2, minutos2);
		
		segundostotales=Math.abs(segundos1-segundos2);
		minutostotales=segundostotales/60;
		
		return minutostotales;
	}
	
	static long CalcularSeg(int horas1, int minutos1, int horas2, int minutos2)
	{
		long segundos1=0, segundos2=0, segundostotales=0;
		
		segundos1=CalcularSegundos(0, horas1, minutos1);
		segundos2=CalcularSegundos(0, horas2, minutos2);
		
		segundostotales=Math.abs(segundos1-segundos2);
		
		return segundostotales;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		
		int opcion=0;
		
		opcion=PedirOpcion(teclado);
		
		switch(opcion)
		{
			case 30:
			{
				int num1=0, num2=0, num3=0, nummayor=0, dife=0;
				
				System.out.println("\n-----EJERCICIO 30-----EJERCICIO 5 EXAMEN 17 MAYO-----\n\n");
				
				num1=PedirNumero(teclado);
				num2=PedirNumero(teclado);
				num3=PedirNumero(teclado);
				
				nummayor=Mayor(num1, num2, num3);
				
				dife=Diferencia(num1, num2);
				
				MostrarNumeros(nummayor, dife);
				break;
			}
			case 31:
			{
				double salario=0;
				int horas=0, preciohora=0;
				
				System.out.println("\n-----EJERCICIO 31-----CALCULO DE SALARIO CON HORAS EXTRAS-----\n");
				horas=PedirHoras(teclado, "número de horas trabajadas");
				preciohora=PedirHoras(teclado, "precio por hora (€/h)");
				salario=Salarios(horas, preciohora);
				System.out.println("\nEl salario es: " + salario + " euros.");
				break;
			}
			case 32:
			{
				String vencedor="";
				String continuar="";
				int partidasJ=0, partidasM=0;
				
				System.out.println("\n-----EJERCICIO 32-----JUEGO DE PIEDRA/PAPEL/TIJERA-----\n");
				do {
					vencedor=Comprobar(teclado);
					if(vencedor=="[EL JUGADOR]")
						partidasJ++;
					else
						partidasM++;
					System.out.println(" el vencedor es: " + vencedor);
					System.out.print("\n¿Desea volver a jugar? [s/S | n/N]:");
					continuar=teclado.nextLine();
				}while(continuar.equals("s") || continuar.equals("S"));
				System.out.println("\nEl resultado de las partidas queda: ");
				System.out.println("[JUGADOR]   |   [MAQUINA]");
				System.out.println("    " + partidasJ + "                " + partidasM);
				break;	
			}
			case 33:
			{
				int num1=0, num2=0, modulo=0, numero=0;
				int resultado;
				
				System.out.println("\n-----EJERCICIO 33-----NUMEROS A SUMAR PARA QUE SEA DIVISIBLE ENTRE OTRO-----\n");
				num1=PedirNumero(teclado);
				num2=PedirNumero(teclado);
				modulo=SacaN(num1, num2);
				numero=num1+modulo;
				resultado=(num1+modulo)/num2;
				System.out.println("Hay que sumar " + modulo + " al número.");
				System.out.println(num1 + " + " + modulo + " = " + numero);
				System.out.println(numero + " / " + num2 + " = " + resultado);
				break;
			}
			case 34:
				int num1=0, num2=0, modulo1=0, modulo2=0;
				
				System.out.println("\n-----EJERCICIO 34-----NUMEROS DIVISIBLES ENTRE DOS DADOS-----\n");
				num1=PedirNumero(teclado);
				num2=PedirNumero(teclado);
			
				System.out.println("\nLos números comprendidos entre 1 y 100 divisibles por " + num1 + " y " + num2 + " son: ");
				for(int i=1; i<=100; i++)
				{
						modulo1=CalcularModulo(num1,i);
						modulo2=CalcularModulo(num2,i);
						if(modulo1==0 && modulo2==0)
							System.out.print(i + " ");
				}
				break;
			case 35:
			{
				int nume1=0, nume2=0, ordenar=0, aleatorio=-1;
				
				System.out.println("\n-----EJERCICIO 35-----NUMEROS ALEATORIOS DENTRO DE UN RANGO-----\n");
				nume1=PedirNumero(teclado);
				nume2=PedirNumero(teclado);
				
				if(nume1>nume2)
				{
					ordenar=nume1;
					nume1=nume2;
					nume2=ordenar;
				}
				
				aleatorio=ComprobarRango(nume1, nume2);

				if(aleatorio==-1)
					System.out.println("\nNo hemos podido hayar un número aleatorio dentro de ese rango.");
				else
					System.out.println("\nEl número aleatorio hallado es: " + aleatorio);
				break;
			}
			case 36:
			{
				float nota1=-1, nota2=-1;
				int notafinal=-1;
				
				System.out.println("\n-----EJERCICIO 36------MEDIA DE NOTAS DE EXÁMEN-----\n");
				System.out.print("Introduzca la nota del primer exámen: ");
				nota1=teclado.nextFloat();
				teclado.nextLine();
				System.out.print("Introduzca la nota del segundo exámen: ");
				nota2=teclado.nextFloat();
				teclado.nextLine();
				
				notafinal=CalcularNotaFinal(nota1, nota2);
				
				System.out.println("La nota final de la asignatura es: [" + notafinal + "]");
				break;
			}
			case 37:
			{
				int notafin=-1;
				
				System.out.println("\n-----EJERCICIO 37------MEDIA DE NOTAS DE EXÁMEN-----\n");
				notafin=PedirNotas(teclado);
				System.out.println("La nota final de la asignatura es: [" + notafin + "]");
				break;
			}
			case 38:
			{
				float nota=0;
				String calificacion="";
				
				System.out.println("\n-----EJERCICIO 38------CALIFICACIÓN DEL EXÁMEN EJERCICIO 8-----\n");
				
				System.out.print("Introduzca la nota del exámen para comprobar si el alumno está aprobado: ");
				nota=teclado.nextFloat();
				teclado.nextLine();
				
				calificacion=ObtenerNombreNota(nota);
				
				System.out.println("El alumno ha obtenido una calificación de [" + calificacion + "].");
				
				break;
			}
			case 39:
			{
				int cantidad=0, notafinal=0;
				float nota=-1, nota1=-1, nota2=-1, nota3=-1, nota4=-1, nota5=-1;
				String calificacionfinal="";
				
				System.out.println("\n-----EJERCICIO 39------CALIFICACIÓN DE ALUMNOS (USO DE PROFESORES)-----\n");
				do {
					System.out.print("Cuántos exámenes se han realizado? [2-5]: ");
					cantidad=teclado.nextInt();
					teclado.nextLine();
					if(cantidad<2 || cantidad>5)
						System.out.println("Error! El dato introducido está fuera del rango pedido.");
				}while(cantidad<2 || cantidad>5);
				
				for(int i=1; i<=cantidad; i++)
				{
					nota=PedirNotas(teclado, i);
					
					switch(i)
					{
						case 1:
							nota1=nota;
							break;
						case 2:
							nota2=nota;
							break;
						case 3:
							nota3=nota;
							break;
						case 4:
							nota4=nota;
							break;
						case 5:
							nota5=nota;
							break;
					}
				}
				
				if(cantidad==2)
					notafinal=CalcularNotaFinal(nota1, nota2);
				else
					if(cantidad==3)
						notafinal=CalcularNotaFinal(nota1, nota2, nota3);
					else
						if(cantidad==4)
							notafinal=CalcularNotaFinal(nota1, nota2, nota3, nota4);
						else
							notafinal=CalcularNotaFinal(nota1, nota2, nota3, nota4, nota5);

				calificacionfinal=ObtenerNombreNota(notafinal);
				System.out.println("La nota media final del alumno es: " + notafinal + " y su calificación es: " + calificacionfinal);
				break;
			}
			case 40:
			{
				double x1=0, x2=0, y1=0, y2=0;
				double distancia=0;
			
				System.out.println("\n-----EJERCICIO 40------DISTANCIA ENTRE DOS PUNTOS-----\n");
				System.out.print("Introduzca la coordenada 'X' del primer punto (x1): ");
				x1=teclado.nextDouble();
				teclado.nextLine();
				System.out.print("Introduzca la coordenada 'Y' del primer punto (y1): ");
				y1=teclado.nextDouble();
				teclado.nextLine();
				System.out.print("Introduzca la coordenada 'X' del segundo punto (x2): ");
				x2=teclado.nextDouble();
				teclado.nextLine();
				System.out.print("Introduzca la coordenada 'Y' del segundo punto (y2): ");
				y2=teclado.nextDouble();
				teclado.nextLine();
				
				distancia=Distancia(x1, x2, y1, y2);
				
				System.out.println("\nLa distáncia euclídea entre dos puntos es: " + distancia);
				
				break;
			}
			case 41:
			{
				int dias=0, horas=0, minutos=0;
				long segundos=0;
				
				System.out.println("\n-----EJERCICIO 41------CALCULO DE SEGUNDOS-----\n");
				
				System.out.print("Introduzca el número de días: ");
				dias=teclado.nextInt();
				teclado.nextLine();
				System.out.print("Introduzca el número de horas: ");
				horas=teclado.nextInt();
				teclado.nextLine();
				System.out.print("Introduzca el número de minutos: ");
				minutos=teclado.nextInt();
				teclado.nextLine();
				
				segundos=CalcularSegundos(dias, horas, minutos);
				
				System.out.println("El número total de segundos en [" + dias + "] dias, [" + horas + "] horas y [" + minutos + "] minutos es: [" + segundos + "] segundos.");
								
				break;
			}
			case 42:
			{
				int horas1=0, horas2=0, minutos1=0, minutos2=0;
				long minutostotales=0, segundostotales=0;
				
				System.out.println("\n-----EJERCICIO 42------CALCULO DE MINUTOS Y SEGUNDOS ENTRE DOS INSTANTES DADOS-----\n");
				
				System.out.print("Introduzca las horas del primer instante de tiempo: ");
				horas1=teclado.nextInt();
				teclado.nextLine();
				System.out.print("Introduzca los minutos del primer instante de tiempo: ");
				minutos1=teclado.nextInt();
				teclado.nextLine();
				System.out.print("Introduzca las horas del segundo instante de tiempo: ");
				horas2=teclado.nextInt();
				teclado.nextLine();
				System.out.print("Introduzca los minutos del segundo instante de tiempo: ");
				minutos2=teclado.nextInt();
				teclado.nextLine();
				
				minutostotales=CalcularMin(horas1, minutos1, horas2, minutos2);
				segundostotales=CalcularSeg(horas1, minutos1, horas2, minutos2);
				
				System.out.println("La cantidad de minutos totales entre los dos instantes de tiempo es: [" + minutostotales + "] minutos.");
				
				System.out.println("La cantidad de segundos totales entre los dos instantes de tiempo es: [" + segundostotales + "] segundos.");
				break;
			}
			default:
				ErrorIntroducido();
				break;
		}
		System.out.println("\n\n\n---FIN DE PROGRAMA---");
	}

}
