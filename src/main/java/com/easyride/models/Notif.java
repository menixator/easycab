/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyride.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author miljau_a
 */
public class Notif {

    public enum NotifType {
        CustomerInitialNotif,
        DriverInitialNotif,
        WaitingForCustomerToEnterNotif,
        InProgressNotif,
        RideEndedNotif;

        public static NotifType notifTypeFromString(String type) {
            switch (type.toUpperCase()) {
                case "CUSTOMERINITIALNOTIF":
                    return CustomerInitialNotif;
                case "DRIVERINITIALNOTIF":
                    return DriverInitialNotif;
                case "WAITINGFORCUSTOMERTOENTERNOTIF":
                    return WaitingForCustomerToEnterNotif;
                case "RIDEENDEDNOTIF":
                    return RideEndedNotif;
                case "INPROGRESSNOTIF":
                    return InProgressNotif;
                default:
                    return null;
            }

        }
    }

    private int id;
    private NotifType type;
    private int rideId;
    private String data;
    private Timestamp createdTimestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NotifType getType() {
        return type;
    }

    public void setType(NotifType type) {
        this.type = type;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public static Notif fromResultSet(ResultSet set) throws SQLException {
        Notif notif = new Notif();
        notif.setId(set.getInt("id"));
        notif.setData(set.getString("data"));
        notif.setRideId(set.getInt("rideId"));
        notif.setType(NotifType.notifTypeFromString(set.getString("type")));
        notif.setCreatedTimestamp(set.getTimestamp("createdTimestamp"));
        return notif;
    }

}
