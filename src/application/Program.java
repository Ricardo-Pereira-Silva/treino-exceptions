package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Quarto: ");
        int numero = scanner.nextInt();
        System.out.print("Entrada: (dd/MM/yyyy)");
        Date entrada = fmt.parse(scanner.next());
        System.out.print("Saida: (dd/MM/yyyy)");
        Date saida = fmt.parse(scanner.next());

        if(!saida.after(entrada)) {
            System.out.println("**Erro** Data de saida deve ser depois da data de entrada.");
        }
        else {
            Reserva reserva = new Reserva(numero,entrada,saida);
            System.out.println("Dados da reserva: " + reserva);

            System.out.println();
            System.out.println("Nova reserva: ");
            System.out.println();
            System.out.print("Entrada: (dd/MM/yyyy)");
             entrada = fmt.parse(scanner.next());
            System.out.print("Saida: (dd/MM/yyyy");
             saida = fmt.parse(scanner.next());

             Date agora = new Date();
             if(entrada.before(agora) || saida.before(agora)) {
                 System.out.println("**Cuidade** As reservas deverm conter datas Futuras.");
             }
             else {
                 reserva.atualizaDados(entrada,saida);
                 System.out.println("Nova reserva: ");
                 System.out.println(reserva);
             }

        }
    }
}
