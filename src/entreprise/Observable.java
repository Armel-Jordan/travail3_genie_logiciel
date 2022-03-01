package entreprise;
public interface Observable {
    public void attacher(Observateur obs);
    public void detacher(Observateur obs);
    public void avertir();
}
