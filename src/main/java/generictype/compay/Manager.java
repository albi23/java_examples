package generictype.compay;

public class Manager extends Employee {

    private float bonus;

    public Manager(String name, String lastName, Float salary, Float bonus) {
        super(name, lastName, salary);
        this.bonus = bonus;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    @Override
    public Float getSalary() {
        return super.getSalary()+bonus;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s.substring(0, s.length()-1)+", bonus=" + bonus+'}';
    }
}
