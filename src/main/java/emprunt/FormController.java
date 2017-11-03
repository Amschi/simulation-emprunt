package emprunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.math.RoundingMode;


@Controller
public class FormController {

    @Autowired
    private EmpruntSimulationCalculator empruntSimulationCalculator;

    @GetMapping("/")
    public String empruntForm(Model model) {
        model.addAttribute("empruntPost", new EmpruntPost());
        return "welcome";
    }


    @PostMapping("/welcome")
    public String checkFormInfo(@Valid EmpruntPost empruntPost, BindingResult bindingResult, Model model) {

        if (!bindingResult.hasErrors()) {
            Emprunt emprunt = new Emprunt(empruntPost.getCapital(), empruntPost.getTauxAnnuel(), empruntPost.getNombreDeMois());
            model.addAttribute("mensualite", empruntSimulationCalculator.calculerMensualite(emprunt).setScale(2, RoundingMode.HALF_EVEN));
            model.addAttribute("coutTotal", empruntSimulationCalculator.calculerCoutTotal(emprunt).setScale(2, RoundingMode.HALF_EVEN));
            return "result";

        } else {
            return "welcome";
        }
    }
}





