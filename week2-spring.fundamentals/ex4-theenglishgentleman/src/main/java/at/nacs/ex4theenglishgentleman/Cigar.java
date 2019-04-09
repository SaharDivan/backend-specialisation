package at.nacs.ex4theenglishgentleman;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cigar {
    boolean lit;

    public Boolean isLit() {
        return lit;
    }

    public void smoke() throws CigarWasNotLitException {
        if (!lit) {
            throw new CigarWasNotLitException();
        }
    }

    public void setLit(Boolean lit) {
        this.lit = lit;
    }
}
