public enum Operation {
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/");

    Operation(String value){
        this.value = value;
    }
    static Operation getOperationFromString(String o){
        Operation[] array = Operation.values();
        for (int i=0; i<array.length; i++){
            if (array[i].value.equals(o)){
                return array[i];
            }
        }
        return null;
    }
    final String value;
}


