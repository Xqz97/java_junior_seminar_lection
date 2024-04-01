package lection.lection_4.project;


import javax.persistence.*;

@Entity
@Table(name = "test.magic")
public class Magic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "название")
    private String name;
    @Column(name = "повреждение")
    private int damage;
    @Column(name = "атака")
    private int attBonus;

    public Magic() {
    }

    public Magic(String name, int damage, int attBonus) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAttBonus() {
        return attBonus;
    }

    public void setAttBonus(int attBonus) {
        this.attBonus = attBonus;
    }

    @Override
    public String toString() {
        return "Magic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", attBonus=" + attBonus +
                '}';
    }
}
