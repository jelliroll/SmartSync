package com.smartsync.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by trev on 4/1/17.
 */
@Entity
public class Auth {

    @Id @GeneratedValue
    private Long id;

    private Long userId;

    private Long sessionId;

    private int role;

    public Auth(Long userId, Long sessionId, int role) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.role = role;
    }

    public Auth() {

    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public int getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
