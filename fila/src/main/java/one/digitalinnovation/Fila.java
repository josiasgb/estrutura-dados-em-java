package one.digitalinnovation;

public class Fila<T> {

    private No<T> refNoentradaFila;

    public Fila() {
        this.refNoentradaFila = null;
    }

    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoentradaFila);
        refNoentradaFila = novoNo;
    }

    public T first(){
        if (!this.isEmpty()){
            No primeiroNo = refNoentradaFila;
            No noAuxiliar = refNoentradaFila;
            while (true){
                if (primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }
    public T dequeue(){
        if (!this.isEmpty()){
            No primeiroNo = refNoentradaFila;
            while (true){
                if (primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoentradaFila == null? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoentradaFila;
        if (refNoentradaFila != null){
            while (true){
                stringRetorno += "[No{objeto = " + noAuxiliar.getObject() + "}]---->";
                if(noAuxiliar.getRefNo() != null){
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        }else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}
