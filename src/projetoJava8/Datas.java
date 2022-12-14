package projetoJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);

		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

//		descobrindo a diferença de anos entre hoje e as olimpiadas do rio 
		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);

//		fazendo calculo com Period
		Period periodo = Period.between(hoje, olimpiadasRio);
		System.out.println("formato original: " + periodo);
		System.out.println("formato dias: " + periodo.getDays());

//		somar 4 anos ao valor de olimpiadas
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);

//		formatadores de datas 
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valor = proximasOlimpiadas.format(formatador);
		System.out.println(valor);

//		formatador com horas
		DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

//		usando localDatetime
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorHoras));

//		classe que faz a busca/associação do mês e do ano desejado 
		YearMonth mes = YearMonth.of(anos, Month.JULY);

//		representa somente a hora
		LocalTime hora = LocalTime.of(15, 30);
		System.out.println(hora);

//		diminuindo datas
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

//		aumentando datas
		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));

//		outras formas de declarar um localdate
		LocalDate data = LocalDate.of(2099, 1, 25);
		LocalDate datae = LocalDate.of(2099, Month.JANUARY, 25);

//		criando um período de entre 2 datas
		LocalDate agoraPeriodo = LocalDate.now();
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
		Period periodoEntre = Period.between(agoraPeriodo, dataFutura);
		System.out.println(
				"periodo intervalo Anos: " + periodoEntre.getYears() +
				" Meses: " + periodoEntre.getMonths() + " Dias: " + periodoEntre.getDays());
		
		
//		Duration caso queira trabalhar com intervalo de horas.

	}

}
