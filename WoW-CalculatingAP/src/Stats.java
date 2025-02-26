import java.util.Arrays;
import java.util.Objects;

public class Stats {
    // All private Variables
    private int strength;
    private int agility;
    private int stamina;
    private int intellect;
    private int spirit;
    private String _class;
    private String race;

    public Stats(){
        this.strength = 0;
        this.agility = 0;
        this.stamina = 0;
        this.intellect = 0;
        this.spirit = 0;
    }

    public Stats(int str, int agi, int stam, int intel, int spi, String c, String race){
        this.strength = str;
        this.agility = agi;
        this.stamina = stam;
        this.intellect = intel;
        this.spirit = spi;

        this._class = c.toLowerCase();
        this.race = race.toLowerCase();
    }

    // All setters
    public void setStrength(int str){ this.strength = str; }
    public void setAgility(int agi){ this.agility = agi; }
    public void setStamina(int stam){ this.stamina = stam; }
    public void setIntellect(int intel){ this.intellect = intel; }
    public void setSpirit(int spi){ this.spirit = spi; }
    public void setClass(String c) { this._class = c; }
    public void setRace(String r) { this.race = r; }

    // All getters
    public int getStrength(){ return this.strength; }
    public int getAgility(){ return this.agility; }
    public int getStamina(){ return this.stamina; }
    public int getIntellect() { return this.intellect; }
    public int getSpirit() { return this.spirit; }
    public String get_Class() { return this._class; }
    public String getRace() { return this.race; }

    public double[] getAP(){
        int melee_ap = 0; // initializing melee AP
        int ranged_ap = 0; // initializing ranged AP
        double physical_crit_perc = 0; // initializing melee critical strike percentage
        double spell_crit_perc = 0; // initializing spell critical strike percentage

        switch(_class){
            case "warrior":
                melee_ap += strength * 2; // 1 str = 2 ap
                physical_crit_perc += agility * .05; // 1 agi = 0.05% crit | 1% crit = 20 ap
                melee_ap += (int)(physical_crit_perc * 20);
                break;

            case "rogue":
                melee_ap += strength; // 1 str = 1 ap
                physical_crit_perc = agility  * .03; // 1 agi = 0.03% crit | 1% crit = 27 ap
                melee_ap += (int)(physical_crit_perc * 27);
                break;

            case "paladin":
                melee_ap += strength * 2; // 1 str = 2 ap
                physical_crit_perc = agility * .05;
                melee_ap += (int)physical_crit_perc * 27;

                spell_crit_perc = intellect * .03;
                break;

            case "hunter":
                melee_ap += strength; // 1:1 ap to strength
                melee_ap += agility; // 1:1 ap to agility

                ranged_ap += agility * 2; // 1:2 ap to agility

                physical_crit_perc = agility * .02; // 1 agility = 0.02% crit
                break;

            case "mage":
                melee_ap += strength * 2;

                physical_crit_perc += agility * .05;
                spell_crit_perc += intellect * .02;
                break;

            case "druid":
                melee_ap += strength * 2;
                melee_ap += agility;

                physical_crit_perc += agility * .05;
                spell_crit_perc += intellect * .02;
                break;

            case "warlock":
                melee_ap += strength * 2;

                physical_crit_perc += agility * .05;
                spell_crit_perc += intellect * .02;
                break;

            case "shaman":
                melee_ap += strength * 2;
                melee_ap += agility;

                physical_crit_perc += agility * .05;
                spell_crit_perc += intellect * .02;
                break;

            case "Priest":
                melee_ap += strength * 2;

                physical_crit_perc += agility * .05;
                spell_crit_perc += intellect * .02;
                break;

        }

        double[] ap = {melee_ap, ranged_ap, physical_crit_perc, spell_crit_perc};// initializing array to store AP & crit values

        return ap;
    }

    String header = String.format("| %-10s | %-10s | %-10s | %-10s |\n", " Melee ", " Ranged ", " Physical Crit ", " Spell Crit ");

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append("| ");

        for (int i = 0; i < getAP().length; i++) {
            if (i == 2 || i == 3) {
                sb.append(String.format("%-10s", centerString(String.format("%.1f%%", getAP()[i]), 15)));
            } else {
                sb.append(String.format("%-10s", centerString(String.format("%.1f", getAP()[i]), 10)));
            }

            // Add a separator for all elements except the last one
            if (i < getAP().length - 1) {
                sb.append(" | ");
            }
        }

        sb.append(" |");
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Helper method to center-align text
    private String centerString(String text, int width) {
        int paddingSize = (width - text.length()) / 2;
        String padding = " ".repeat(Math.max(0, paddingSize));
        return padding + text + padding;
    }
}
