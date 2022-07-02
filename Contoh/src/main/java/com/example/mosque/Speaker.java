package com.example.mosque;

import java.io.Serializable;

public class Speaker implements Serializable {


    private static final long serialVersionUID = 1L;
    public int id;
    public String speakerName;
    public String speakerPhone;
    public String  speakerPic;
    public String speakerEdu;

    public Speaker(int id, String name, String phone, String education) {}

    public Speaker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerPhone() {
        return speakerPhone;
    }

    public void setSpeakerPhone(String speakerPhone) {
        this.speakerPhone = speakerPhone;
    }

    public String getSpeakerPic() {
        return speakerPic;
    }

    public void setSpeakerPic(String speakerPic) {
        this.speakerPic = speakerPic;
    }

    public String getSpeakerEdu() {
        return speakerEdu;
    }

    public void setSpeakerEdu(String speakerEdu) {
        this.speakerEdu = speakerEdu;
    }


}