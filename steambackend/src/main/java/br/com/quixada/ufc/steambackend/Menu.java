package br.com.quixada.ufc.steambackend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import br.com.quixada.ufc.steambackend.controller.ProfileController;

public class Menu {
  ProfileController control = new ProfileController();
  InputStream is = System.in;
  InputStreamReader isr = new InputStreamReader(is);
  BufferedReader br = new BufferedReader(isr);
  Scanner sc = new Scanner(System.in);

  public void insertProfile() throws IOException, NumberFormatException, NoSuchAlgorithmException{
    System.out.print("\n|----------Cadastrar perfil----------|\n");
    System.out.print("Digite seu nome: ");
    String name = br.readLine();
    System.out.print("Digite seu email: ");
    String email = br.readLine();
    System.out.print("Digite seu nickname: ");
    String nickname = br.readLine();
    System.out.print("Digite seu estado: ");
    String location = br.readLine();
    System.out.println("|------------------------------------|");
    
    Boolean verify = control.insertProfile(name, email, nickname, location);

    if(verify) System.out.println("\nPerfil inserido com sucesso.");
    else System.out.println("\nHouve um erro, realize uma nova tentativa.");
  }

  public void sizeData() throws IOException, NumberFormatException, NoSuchAlgorithmException{
    System.out.println("\nA quantidade de perfis é: " + control.sizeData());
  }

  public void convertToJSON() throws NumberFormatException, IOException, NoSuchAlgorithmException{
    Boolean verify = control.convertToJSON();

    if(verify) System.out.println("\nConversão para JSON realizada com sucesso.");
    else System.out.println("\nHouve um erro, realize uma nova tentativa.");
  }

  public void convertToXML() throws NumberFormatException, IOException, NoSuchAlgorithmException{
    Boolean verify = control.convertToXML();

    if(verify) System.out.println("\nConversão para XML realizada com sucesso.");
    else System.out.println("\nHouve um erro, realize uma nova tentativa.");
  }

  public void compressData() throws NumberFormatException, IOException, NoSuchAlgorithmException{
    Boolean verify = control.compressData();

    if(verify) System.out.println("\nDados comprimidos com sucesso.");
    else System.out.println("\nHouve um erro, realize uma nova tentativa.");
  }

  public void showHash() throws NumberFormatException, IOException, NoSuchAlgorithmException{
    System.out.println("\nO hash dos dados é: " + control.showHash());
  }

  public void start() throws NumberFormatException, IOException, NoSuchAlgorithmException{
    Boolean exec = true;

    do{
      System.out.print("\n|---------------Menu----------------|\n");
      System.out.print("| 1 - Cadastrar perfil              |\n");
      System.out.print("| 2 - Quantidade de perfis          |\n");
      System.out.print("| 3 - Converter os dados em JSON    |\n");
      System.out.print("| 4 - Converter os dados em XML     |\n");
      System.out.print("| 5 - Compactar os dados            |\n");
      System.out.print("| 6 - Mostrar hash SHA256 dos dados |\n");
      System.out.print("| 7 - Sair                          |\n");
      System.out.print("|-----------------------------------|\n\n");
      
      System.out.print("Digite a opção desejada: ");
      int option = sc.nextInt();

      switch(option){
        case 1: insertProfile(); break;
        case 2: sizeData(); break;
        case 3: convertToJSON(); break;
        case 4: convertToXML(); break;
        case 5: compressData(); break;
        case 6: showHash(); break;
        case 7: exec = false; break;
        default: System.out.println("Opção inválida.");
      }
    }while(exec);
  }
}