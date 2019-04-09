package at.nacs.ex4theenglishgentleman;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class EnglishGentleman {
    private Monocle monocle;
    private Lighter lighter;
    private boolean smoked;
    private boolean read;

    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        //cigar.setLit(true);
        cigar.smoke();
       smoked = true;
    }

    public void read(Newspaper newsPaper) {
       read = newsPaper.hasRead();
    }


    public boolean isHasSmoked() {
        return smoked;
    }

    public boolean isHasRead() {
       return read;
    }

    public Boolean hadAGoodDay() {
        return isHasSmoked() && isHasRead();

    }
}
