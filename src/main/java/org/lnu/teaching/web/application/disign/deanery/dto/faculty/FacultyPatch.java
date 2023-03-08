package org.lnu.teaching.web.application.disign.deanery.dto.faculty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class FacultyPatch {
    private String name;
    private String website;
    private String email;
    private String phone;
    private String address;
    private String info;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean empty = true;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean isNameUpdated;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean isWebsiteUpdated;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean isEmailUpdated;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean isPhoneUpdated;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean isAddressUpdated;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private boolean isInfoUpdated;

    public void setName(String name) {
        empty = false;
        isNameUpdated = true;

        this.name = name;
    }

    public void setWebsite(String website) {
        empty = false;
        isWebsiteUpdated = true;

        this.website = website;
    }

    public void setEmail(String email) {
        empty = false;
        isEmailUpdated = true;

        this.email = email;
    }

    public void setPhone(String phone) {
        empty = false;
        isPhoneUpdated = true;

        this.phone = phone;
    }

    public void setAddress(String address) {
        empty = false;
        isAddressUpdated = true;

        this.address = address;
    }

    public void setInfo(String info) {
        empty = false;
        isInfoUpdated = true;

        this.info = info;
    }
}
