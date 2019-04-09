package at.nacs.ex4theenglishgentleman;

import org.springframework.stereotype.Component;

@Component
public class Lighter {
    private boolean lit;

    public boolean islet() {
        return lit;
    }

    public void lit() {
        this.lit = true;
    }

}
