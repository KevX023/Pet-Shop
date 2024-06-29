package domain.Pets;

public class Cats extends Pets {
    
    private String eyecolor;
    private Gender gender;
    private boolean pedigri;

    public Cats(int months, String name, String color, String country, String eyecolor, Gender gender,
            boolean pedigri) {
        super(months, name, color, country);
        this.eyecolor = eyecolor;
        this.gender = gender;
        this.pedigri = pedigri;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isPedigri() {
        return pedigri;
    }

    public void setPedigri(boolean pedigri) {
        this.pedigri = pedigri;
    }

    @Override
    public double price(){
        if (getMonths() <= 24 && isPedigri() == false) {
            return 1000 / getMonths();
        } else if (getMonths() <= 24 && isPedigri() == true) {
            return 2 * (1000 / getMonths());
        } else if (getMonths() > 24 && isPedigri() == true) {
            return 70.00;
        } else {
            return 35.00;
        }
    }
}
