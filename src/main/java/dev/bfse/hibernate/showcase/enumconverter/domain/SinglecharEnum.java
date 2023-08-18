package dev.bfse.hibernate.showcase.enumconverter.domain;

public enum SinglecharEnum {

    B("first"),
    R("second"),
    O("third"),
    K("fourth"),
    E("fifth"),
    N("sixth");

    private final String item;

    private SinglecharEnum(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
