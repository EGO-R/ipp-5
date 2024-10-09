package org.java4me.ipp5.entity;


public enum Role {
    USER, ADMIN;

    @Override
    public String toString() {
        return name();
    }
}
