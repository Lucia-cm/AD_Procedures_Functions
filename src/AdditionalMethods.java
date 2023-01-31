import java.util.InputMismatchException;
import java.util.Scanner;

public class AdditionalMethods {
    static Scanner sc=new Scanner(System.in);

    //COMPROBAR QUE UN INT ES VÁLIDO
    public static int readInteger(){
        int value=0;
        boolean valid=true;

        while(valid)
            try{
                value=sc.nextInt();
                sc.nextLine();
                valid=false;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Esa opción no es válida (entero), introduzca otra:");
            }
        return value;
    }
    public static int checkPossitiveNumber(){
        int number=readInteger();
        while(number<0){
            System.out.println("El número introducido es negativo.\nIntroduzca un número positivo:");
            number=readInteger();
        }
        if(number>0)
            number=number;
        return number;
    }

    //SOLICITAR UN DATO DE TIPO VARCHAR/STRING
    public static String ask_for_varchar(String item){
        System.out.println("Introduzca el "+item+" que desea consultar.");
        String value=sc.next();

        while(value.length()>50){
            System.out.println("La opción indicada posee una longitud mayor a la permitida.");
            System.out.println("Introduzca el "+item+" que desea consultar.");
            value=sc.next();
        }
        return value;
    }

    //SOLICITAR UN DATO DE TIPO INT
    public static int ask_for_int(String item){
        System.out.println("Introduzca el "+item+" que desea consultar.");
        int value=readInteger();

        return value;
    }


}
