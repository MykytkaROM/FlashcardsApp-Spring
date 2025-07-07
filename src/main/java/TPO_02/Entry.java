package TPO_02;




public class Entry {
    private String pol;
    private String ger;
    private String eng;

    public Entry(String eng, String ger, String pol) {
        this.pol = pol;
        this.ger = ger;
        this.eng = eng;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getGer() {
        return ger;
    }

    public void setGer(String ger) {
        this.ger = ger;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    @Override
    public String toString() {
        return eng+","+ger+","+pol;
    }
}
