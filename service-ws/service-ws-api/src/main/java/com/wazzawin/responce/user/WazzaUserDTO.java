package com.wazzawin.responce.user;

import com.wazzawin.responce.contest.ContestDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "wazzaUserDTO")
public class WazzaUserDTO implements Serializable {

    private static final long serialVersionUID = -1863554367428232440L;
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private Date lastLogin;
    private Boolean enabled;
    private ProfileDTO profileDTO;
    private List<ContestDTO> contestDTOList;

    public WazzaUserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    public List<ContestDTO> getContestDTOList() {
        return contestDTOList;
    }

    public void setContestDTOList(List<ContestDTO> contestDTOList) {
        this.contestDTOList = contestDTOList;
    }

    @Override
    public String toString() {
        return "WazzaUserDTO{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", lastLogin=" + lastLogin + ", enabled=" + enabled + ", profileDTO=" + profileDTO + ", contestDTOList=" + contestDTOList + '}';
    }
    
}
