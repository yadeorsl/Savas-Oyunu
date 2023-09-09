import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
     this.obstacle=obstacle;
    this.award=award;
    this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şu an buradasınız:"+ this.getName());
        System.out.println("Dikkatli ol burada "+ obsNumber+" tane "+this.getObstacle().getName() +" yaşıyor");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase=input.nextLine();
        selectCase.toUpperCase();
        if (selectCase.equals("S")){
            if (combat(obsNumber)){
                System.out.println(this.getName()+ " tüm düşmanları yendiniz");
                return true;
            }

        } if (getPlayer().getHealth()<=0){
            System.out.println("öldünüz");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
            playerStats();
            obstacleStats(i);
            while (getPlayer().getHealth()>0&& getObstacle().getHealth()>0){
                System.out.println("<V>ur veya <K>aç");
                String selectCombat=input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz Vurdunuz");
                    this.getObstacle().setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println(this.getObstacle().getName()+" Size vurdu");
                        int obstacleDamage= this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz");
                System.out.println(this.getObstacle().getAward()+ " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız : "+ this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;

    }
    public void afterHit(){
        System.out.println("Canınız :"+ getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" canı "+this.getObstacle().getHealth());
        System.out.println();
    }
    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+ " Değerleri");
        System.out.println("-------------------");
        System.out.println("Ödül "+this.getObstacle().getAward());
        System.out.println("Sağlık "+this.getObstacle().getHealth());
        System.out.println("Hasar "+this.getObstacle().getDamage());
    }
    public void playerStats(){
        System.out.println("oyuncu değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık "+ getPlayer().getHealth());
        System.out.println("Hasar  "+ getPlayer().getTotalDamage());
        System.out.println("Zırh: "+ getPlayer().getInventory().getArmor().getName());
        System.out.println("Para "+ getPlayer().getMoney());
        System.out.println("Bloklama "+ getPlayer().getInventory().getArmor().getBlock());
        if (this.getPlayer().getInventory().getWeapon().getDamage()>0){
            System.out.println("silahınız "+ getPlayer().getInventory().getWeapon().getName());
        }
    }
    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
