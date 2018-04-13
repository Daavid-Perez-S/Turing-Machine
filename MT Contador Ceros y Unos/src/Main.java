import java.util.Scanner;
/*
 *  Creado por: David Pérez Sánchez
 *  Matrícula: 163202
 *  Materia: Lenguajes y Autómatas
 *  Universidad Politécnica de Chiapas.
 *  Fecha de Creación: 22/03/2018
 */
      
/**
 * @author David Pérez S.
 */
public class Main {

      public static void main(String[] args) {

            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("\n Ingresa una cadena: ");
            String cadenaUsuario = lecturaTeclado.nextLine();
            String[ ] cinta1 = cadenaUsuario.split("");
            
            System.out.println("\n Transiciones:\n");
            // Llamamos al estado inicial q0
            iniciarAlgoritmoMT(cinta1, 0, cadenaUsuario);
      }
      
      static void iniciarAlgoritmoMT(String[] cinta1, int posicionCinta1, String cadenaUsuario){
            String[ ] cinta2= new String[cinta1.length];
            String[ ] cinta3= new String[cinta1.length];
            for(int m=0; m<cinta2.length; m++) {
                  cinta2[m]= "";
                  cinta3[m]= "";
            }
            int posicionCinta2= 1;
            int posicionCinta3= 1;
            q0(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3, cadenaUsuario);
      }
      
      static void q0(String[ ] cinta1, String[ ] cinta2, String[ ] cinta3, int posicionCinta1, int posicionCinta2, int posicionCinta3, String cadenaUsuario) {
            if(cinta1[posicionCinta1].equals("$") && cinta2[posicionCinta2].equals("") && cinta3[posicionCinta3].equals("") && (cinta1[cinta1.length-1].equals("B") || cadenaUsuario.contains("B"))){
                  System.out.println("Cinta 1: ( q0, $, D, q1 )");
                  System.out.println("Cinta 2: ( q0, , S, q1 )");
                  System.out.println("Cinta 3: ( q0, , S, q1 )\n");
                  cinta1[posicionCinta1] = "$";
                  posicionCinta1++;
                  cinta2[posicionCinta2] = "";
                  cinta3[posicionCinta3] = "";
                  q1(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3);
            }else
                  imprimirError();
      }

      static void q1(String[ ] cinta1, String[ ] cinta2, String[ ] cinta3, int posicionCinta1, int posicionCinta2, int posicionCinta3) {
            if(cinta1[posicionCinta1].equals("0") && cinta2[posicionCinta2].equals("") && cinta3[posicionCinta3].equals("")){
                  System.out.println("Cinta 1: ( q1, 0, D, q1 )");
                  System.out.println("Cinta 2: ( q1, 0, D, q1 )");
                  System.out.println("Cinta 3: ( q1, , S, q1 )\n");
                  cinta1[posicionCinta1] = "0";
                  posicionCinta1++;
                  cinta2[posicionCinta2] = "0";
                  posicionCinta2++;
                  cinta3[posicionCinta3] = "";
                  q1(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3);
            }else if(cinta1[posicionCinta1].equals("1") && cinta2[posicionCinta2].equals("") && cinta3[posicionCinta3].equals("")){
                  System.out.println("Cinta 1: ( q1, 1, D, q1 )");
                  System.out.println("Cinta 2: ( q1, , S, q1 )");
                  System.out.println("Cinta 3: ( q1, 1, D, q1 )\n");
                  cinta1[posicionCinta1] = "1";
                  posicionCinta1++;
                  cinta2[posicionCinta2] = "";
                  cinta3[posicionCinta3] = "1";
                  posicionCinta3++;
                  q1(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3);
            }else if(cinta1[posicionCinta1].equals("B") && cinta2[posicionCinta2].equals("") && cinta3[posicionCinta3].equals("")){
                  System.out.println("Cinta 1: ( q1, B, S, q2 )");
                  System.out.println("Cinta 2: ( q1, , I, q2 )");
                  System.out.println("Cinta 3: ( q1, , I, q2 )\n");
                  cinta1[posicionCinta1] = "B";
                  cinta2[posicionCinta2] = "";
                  posicionCinta2--;
                  cinta3[posicionCinta3] = "";
                  posicionCinta3--;
                  q2(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3);
            }else
                  imprimirError();
      }

      static void q2(String[ ] cinta1, String[ ] cinta2, String[ ] cinta3, int posicionCinta1, int posicionCinta2, int posicionCinta3) {
            if(cinta1[posicionCinta1].equals("B") && cinta2[posicionCinta2].equals("0") && cinta3[posicionCinta3].equals("1")){
                  System.out.println("Cinta 1: ( q2, B, S, q2 )");
                  System.out.println("Cinta 2: ( q2, 0, I, q2 )");
                  System.out.println("Cinta 3: ( q2, 1, I, q2 )\n");
                  cinta1[posicionCinta1] = "B";
                  cinta2[posicionCinta2] = "0";
                  posicionCinta2--;
                  cinta3[posicionCinta3] = "1";
                  posicionCinta3--;
                  q2(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3);
            }else if(cinta1[posicionCinta1].equals("B") && cinta2[posicionCinta2].equals("") && cinta3[posicionCinta3].equals("")){
                  System.out.println("Cinta 1: ( q2, B, S, q3 )");
                  System.out.println("Cinta 2: ( q2, , S, q3 )");
                  System.out.println("Cinta 3: ( q2, , S, q3 )\n");
                  cinta1[posicionCinta1] = "B";
                  cinta2[posicionCinta2] = "";
                  cinta3[posicionCinta3] = "";
                  q3(cinta1, cinta2, cinta3, posicionCinta1, posicionCinta2, posicionCinta3);
            }else
                  imprimirError();
      }

      static void q3(String[ ] cinta1, String[ ] cinta2, String[ ] cinta3, int posicionCinta1, int posicionCinta2, int posicionCinta3) {
            
            System.out.println("Cinta 1: ( q3, ,  )");
            System.out.println("Cinta 2: ( q3, ,  )");
            System.out.println("Cinta 3: ( q3, ,  )");
            System.out.println("\n\n ---------------------------------------------");
            System.out.println(" ** CADENA ACEPTADA **");
            System.out.print("\n Resultado: ");
            for (String letra : cinta1)
                  // Nos detenemos hasta leer una espacio en blaco ( Simulado por una "B" ).
                  if(!letra.equals("B"))
                        System.out.print(letra);
                  else
                        break;
            System.out.print("B");
            System.out.println("\n\n");
      }
      
      static void imprimirError(){
            System.err.println("\n\n ---------------------------------------------");
            System.err.println(" ** CADENA INCORRECTA **\n\n");
            System.exit(0);
      }
}