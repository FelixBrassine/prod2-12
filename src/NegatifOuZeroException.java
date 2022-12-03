public class NegatifOuZeroException extends RuntimeException {
    public NegatifOuZeroException (){
        super("Le valeure ne peut être négative ou égale à zéro");
    }
}
