package emprunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Controller
public class FormController {

    @Autowired
    private EmpruntSimulationCalculator empruntSimulationCalculator;

    @GetMapping("/welcome")
    public String empruntForm(Model model) {
        model.addAttribute("empruntPost", new EmpruntPost());
        return "welcome";
    }

    @PostMapping("/welcome")
    public String empruntSubmit(@ModelAttribute EmpruntPost empruntPost, Model model) {

        Emprunt emprunt = new Emprunt(empruntPost.getCapital(), empruntPost.getTauxAnnuel(), empruntPost.getNombreDeMois());

        model.addAttribute("mensualite", empruntSimulationCalculator.calculerMensualite(emprunt).setScale(2, RoundingMode.HALF_EVEN));

        return "result";
    }


}



