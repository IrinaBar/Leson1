public class Elixir {
    private String characteristic;

    public Elixir(String characteristic) {
        this.characteristic = characteristic;
    }

    public int heal(){
        if(characteristic.length()%2==0){
            return(characteristic.length());
        }else{
            return(characteristic.length()*2);
        }
    }

   public boolean makesInvisible() {

        if (characteristic.charAt(0) >= 'M') {
            return true;
        } else {
            return false;
        }
    }

    public String getCharacteristic() {
        return characteristic;
    }

}
