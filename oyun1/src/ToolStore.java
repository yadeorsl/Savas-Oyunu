public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    @Override
    public boolean onLocation() {
        boolean showMenu=true;
        System.out.println("Mağazaya Hoşgeldiniz!");
       while (showMenu){

           System.out.println("1 Silahlar");
           System.out.println("2 Zırhlar");
           System.out.println("3 Çıkış");
           System.out.print("Seçiminiz:");
           int selectCase= input.nextInt();
           while (selectCase>3|| selectCase<1){
               System.out.println("Geçersiz işlem tekrar giriniz:");
               selectCase= input.nextInt();
           }switch (selectCase){
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("bir daha bekleriz");
                   showMenu=false;
                   break;
           }
       } return true;
    }
    public void printWeapon(){
        System.out.println("Silahlar");
        System.out.println();
        for (Weapon w: Weapon.weapons()){
            System.out.println(w.getId()+" "+w.getName()+ " Para:"+ w.getPrice()+" hasar:"+w.getDamage());
        }
        System.out.println("0-Çıkış");


    }
    public void buyWeapon(){
        System.out.println("Bir silah seçiniz");
        int selectWeaponId=input.nextInt();
        while (selectWeaponId<0||selectWeaponId>Weapon.weapons().length)  {
            System.out.println("Geçersiz değer tekrar dene:");
            selectWeaponId= input.nextInt();
        }
        Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponId);
        if (selectedWeapon!= null){
            if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Paranız yeterli değil");
            }else {
                System.out.println(selectedWeapon.getName()+ " silahını satın aldınız");
                int balance=this.getPlayer().getMoney()- selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız"+ getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("yeni silahınız: "+  this.getPlayer().getInventory().getWeapon().getName() );
            }
        }

    }
    public void printArmor(){
        System.out.println("Zırhlar");
        System.out.println();
       for (Armor a: Armor.armors()){
           System.out.println(a.getId()+" "+a.getName()+" Zırh:"+ a.getBlock()+" Para:"+a.getPrice());
       }
    }
    public void buyArmor(){
        System.out.println("Bir zırh seçiniz");
        int selectArmorId=input.nextInt();
        while (selectArmorId<0||selectArmorId>Armor.armors().length)  {
            System.out.println("Geçersiz değer tekrar dene:");
            selectArmorId= input.nextInt();
        }
       Armor selectedArmor=Armor.getArmorObjById(selectArmorId);
        if (selectedArmor!= null){
            if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Paranız yeterli değil");
            }else {
                System.out.println(selectedArmor.getName()+ " Zırhı satın aldınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalan bakiye:" +getPlayer().getMoney());



            }
        }
    }
}
