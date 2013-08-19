/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "profileDTO")
public class ProfileDTO implements Serializable {

    private static final long serialVersionUID = -4664410111453699139L;
    //
    private Long id;
    //
    private Date birthDate;
    //
    private String city;
    //
    private int coinBalance;
    //
    private List<ActivityDTO> activityList;
    //
    private List<PlaceDTO> placeList;
    //
    private List<String> interestList;

    public ProfileDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(int coinBalance) {
        this.coinBalance = coinBalance;
    }

    public List<ActivityDTO> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityDTO> activityList) {
        this.activityList = activityList;
    }

    public List<PlaceDTO> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<PlaceDTO> placeList) {
        this.placeList = placeList;
    }

    public List<String> getInterestList() {
        return interestList;
    }

    public void setInterestList(List<String> interestList) {
        this.interestList = interestList;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" + "id=" + id + ", birthDate=" + birthDate + ", city=" + city + ", coinBalance=" + coinBalance + ", activityList=" + activityList + ", placeList=" + placeList + ", interestList=" + interestList + '}';
    }

    public static class PlaceDTO implements Serializable {

        private static final long serialVersionUID = -4796038133908769244L;
        private String city;
        //
        private String address;
        //
        private String type;
        //
        private long latitude;
        //
        private long longitude;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getLatitude() {
            return latitude;
        }

        public void setLatitude(long latitude) {
            this.latitude = latitude;
        }

        public long getLongitude() {
            return longitude;
        }

        public void setLongitude(long longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "PlaceDTO{" + "city=" + city + ", address=" + address + ", type=" + type + ", latitude=" + latitude + ", longitude=" + longitude + '}';
        }
    }
}
