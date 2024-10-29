package Model;

public class InsufficientKitsException extends Exception{
    private Integer kits;

    public InsufficientKitsException(Integer kits) {
        this.kits = kits;
    }

    public Integer getKits() {
        return kits;
    }

    public void setKits(Integer kits) {
        this.kits = kits;
    }
    // la cantidad(en caso de que si tengan mas) se tomaria dentro del metodo, para el caso esta hardcodeado.
    public Integer incrementKits(Boolean answer,Integer qty){
        System.out.println("dispone de mas kits?"); // por input iria si tiene o no
        if(answer){
            //Integer Qty...
            //aca iria un scanner que tome la cantidad y la guardaria en qty
            return qty;
        }
        else{
            return 0;
        }

    }
}
