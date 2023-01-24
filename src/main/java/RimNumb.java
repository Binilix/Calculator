public enum RimNumb {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    RimNumb(int value) {
        this.value = value;
    }

    static RimNumb getRimNumb(String o) {
        RimNumb[] array = RimNumb.values();
        for (int i = 0; i < array.length; i++) {
            if (array[i].name().equals(o)) {
                return array[i];
            }
        }
        return null;
    }

    int value;
}
