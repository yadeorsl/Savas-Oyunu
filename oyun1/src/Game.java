import java.util.Scanner;

public class Game {

    Scanner input=new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz");
        System.out.println("Lütfen adınızı giriniz");
      //  String playerName=input.next();
        Player player=new Player("a");
        System.out.println(player.getName()+ " Hoşgeldin ");
        System.out.println("Lütfen bir karakter seçiniz.");
   player.selectChar();
        Location location=null;
   while (true){
       player.printInfo();
       System.out.println("Bölgeler");
       System.out.println("1- Güvenli ev");
       System.out.println("2- Mağaza");
       System.out.println("3- Mağara");
       System.out.println("4- Orman");
       System.out.println("5- Nehir");
       System.out.println("Lütfen seçim yapınız");
       int selectLoc= input.nextInt();
       switch (selectLoc){
           case 0:
               location=null;
               break;
               case 1:
               location=new SafeHouse(player);
               break;
           case 2:
               location=new ToolStore(player);
               break;
           case 3:
               location=new Cave(player);
               break;
           case 4:
               location=new Forest(player);
               break;
           case 5:
               location=new River(player);
               break;
           default:
               location=new SafeHouse(player);
       }if (location==null){
           System.out.println("Oyun Bitti");
           break;
       }
     else if (!location.onLocation())
       {
           System.out.println("GAME OVER");break;
       }

   }
   }
         }

