import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    Scanner input=new Scanner(System.in);
    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public void selectChar() {
        GameChar[] charlist = {new Samurai(), new Knight(), new Archer()};
        for (GameChar gameChar : charlist) {
            System.out.println("id"+gameChar.getId()+"Karakter:" + gameChar.getName() + "\t Hasar:"+gameChar.getDamage()+"\t Sağlık:"+gameChar.getHealth()+"\t Para:"+ gameChar.getMoney());
        }
        System.out.println("lütfen bir karakter giriniz");
        int selectChar=input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Knight());
                break;
            case 3:
                initPlayer(new Archer());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println("karakter: "+this.getCharName()+" hasar: "+this.getDamage()+" sağlık: "+ this.getHealth()+" para:"+this.getMoney());
    }


    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
this.setDamage(gameChar.getDamage());
this.setMoney(gameChar.getMoney());
this.setOrijinalHealth(gameChar.getHealth());
this.setHealth(gameChar.getHealth());
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }

    public void printInfo(){
        System.out.println("Silahınız:" +this.getInventory().getWeapon().getName()+
                "Zırh:"+this.getInventory().getArmor().getName()+
                "Hasarınız: " +this.getTotalDamage()+ " paranız:" +this.getMoney()+
                "Sağlık:"+this.getHealth());
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public String getCharName() {
        return charName;
    }

    public String getName() {
        return name;
    }



}
