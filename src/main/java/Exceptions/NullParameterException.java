package Exceptions;

public class NullParameterException extends Exception{
    public NullParameterException(){}

    public NullParameterException(String msg){
        super(msg);
    }

    @Override
    public String toString() {
        return "NullParameterException: as a result, empty parameters were used";
    }
}
