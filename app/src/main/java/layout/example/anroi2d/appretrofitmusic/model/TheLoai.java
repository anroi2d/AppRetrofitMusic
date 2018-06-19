package layout.example.anroi2d.appretrofitmusic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TheLoai {

@SerializedName("Idtheloai")
@Expose
private String idtheloai;
@SerializedName("IdKeyChude")
@Expose
private String idKeyChude;
@SerializedName("TenTheloai")
@Expose
private String tenTheloai;
@SerializedName("HinhTheLoai")
@Expose
private String hinhTheLoai;

public String getIdtheloai() {
return idtheloai;
}

public void setIdtheloai(String idtheloai) {
this.idtheloai = idtheloai;
}

public String getIdKeyChude() {
return idKeyChude;
}

public void setIdKeyChude(String idKeyChude) {
this.idKeyChude = idKeyChude;
}

public String getTenTheloai() {
return tenTheloai;
}

public void setTenTheloai(String tenTheloai) {
this.tenTheloai = tenTheloai;
}

public String getHinhTheLoai() {
return hinhTheLoai;
}

public void setHinhTheLoai(String hinhTheLoai) {
this.hinhTheLoai = hinhTheLoai;
}

}