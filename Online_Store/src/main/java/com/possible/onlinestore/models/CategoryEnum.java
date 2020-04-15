package com.possible.onlinestore.models;

public enum CategoryEnum {
    ELECTRONICS("ELECT"),
    PHONES("PHONES"),
    FASHION("FASH"),
    KITCHEN_UTENSIL("KIT-UT"),
    RECHARGE_CARD("RCARD"),
    BUILDING_MATERIALS("BULD-MA"),
    VEHICLE("VEHCL"),
    BUILDING("BULD");

    private String code;

    CategoryEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
