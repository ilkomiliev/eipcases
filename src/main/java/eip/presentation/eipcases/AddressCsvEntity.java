package eip.presentation.eipcases;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import javax.persistence.*;

/**
 * Created by ilievi on 21.04.2016.
 */
@CsvRecord(crlf = "UNIX", separator = ",", skipFirstLine = true)
@Entity
@Table(name = "ADDRESS")
public class AddressCsvEntity {

    /*
    PLZ VARCHAR(10),
    GKZ VARCHAR(10),
    STR VARCHAR(255),
    NRV VARCHAR(10),
    NRB VARCHAR(10),
    STG VARCHAR(10),
    TOP VARCHAR(10),
    ORT VARCHAR(255),
    POL VARCHAR(255
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DataField(pos = 1)
    private String plz;

    @DataField(pos = 2)
    private String gkz;

    @DataField(pos = 3)
    private String str;

    @DataField(pos = 4)
    private String nrv;

    @DataField(pos = 5)
    private String nrb;

    @DataField(pos = 6)
    private String stg;

    @DataField(pos = 7)
    private String top;

    @DataField(pos = 8)
    private String ort;

    @DataField(pos = 9)
    private String pol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getGkz() {
        return gkz;
    }

    public void setGkz(String gkz) {
        this.gkz = gkz;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getNrv() {
        return nrv;
    }

    public void setNrv(String nrv) {
        this.nrv = nrv;
    }

    public String getNrb() {
        return nrb;
    }

    public void setNrb(String nrb) {
        this.nrb = nrb;
    }

    public String getStg() {
        return stg;
    }

    public void setStg(String stg) {
        this.stg = stg;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressCsvEntity)) return false;

        AddressCsvEntity entity = (AddressCsvEntity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (plz != null ? !plz.equals(entity.plz) : entity.plz != null) return false;
        if (gkz != null ? !gkz.equals(entity.gkz) : entity.gkz != null) return false;
        if (str != null ? !str.equals(entity.str) : entity.str != null) return false;
        if (nrv != null ? !nrv.equals(entity.nrv) : entity.nrv != null) return false;
        if (nrb != null ? !nrb.equals(entity.nrb) : entity.nrb != null) return false;
        if (stg != null ? !stg.equals(entity.stg) : entity.stg != null) return false;
        if (top != null ? !top.equals(entity.top) : entity.top != null) return false;
        if (ort != null ? !ort.equals(entity.ort) : entity.ort != null) return false;
        return !(pol != null ? !pol.equals(entity.pol) : entity.pol != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (plz != null ? plz.hashCode() : 0);
        result = 31 * result + (gkz != null ? gkz.hashCode() : 0);
        result = 31 * result + (str != null ? str.hashCode() : 0);
        result = 31 * result + (nrv != null ? nrv.hashCode() : 0);
        result = 31 * result + (nrb != null ? nrb.hashCode() : 0);
        result = 31 * result + (stg != null ? stg.hashCode() : 0);
        result = 31 * result + (top != null ? top.hashCode() : 0);
        result = 31 * result + (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (pol != null ? pol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressCsvEntity{" +
                "id=" + id +
                ", plz='" + plz + '\'' +
                ", gkz='" + gkz + '\'' +
                ", str='" + str + '\'' +
                ", nrv='" + nrv + '\'' +
                ", nrb='" + nrb + '\'' +
                ", stg='" + stg + '\'' +
                ", top='" + top + '\'' +
                ", ort='" + ort + '\'' +
                ", pol='" + pol + '\'' +
                '}';
    }
}
