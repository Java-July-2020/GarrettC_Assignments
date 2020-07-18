package ObjectMasterPT2;
public class Human{

        protected int strength;
        protected int stealth;
        protected int intellegence;
        protected int health;

        public Human(int strength, int stealth, int intellegence, int health){
            this.strength = strength;
            this.stealth = stealth;
            this.intellegence = intellegence;
            this.health = health;
        }

        public void setStrength(int str){
            this.strength = str;
        }

        public int getStrength(){
            return this.strength;
        }

        public void setStealth(int stlth){
            this.stealth = stlth;
        }

        public int getStealth(){
            return this.stealth;
        }

        public void setIntellegence(int intel){
            this.intellegence = intel;
        }

        public int getIntellegence(){
            return this.intellegence;
        }

        public void setHealth(int hp){
            this.health = hp;
        }

        public int getHealth(){
            return this.health;
        }

        public int displayHealth(int health){
            this.health = health;
            System.out.println("Current Health: " + health);
            return health;
        }
}