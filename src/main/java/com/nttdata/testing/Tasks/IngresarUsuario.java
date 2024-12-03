package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarUsuario implements Task {
    private final String username,password;

    public IngresarUsuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_LOGIN),
                Enter.theValue(username).into(HomePage.L_USERNAME),
                Enter.theValue(password).into(HomePage.L_PASSWORD),
                Click.on(HomePage.BTN_INGRESAR)
        );
    }
    public static Performable withData(String username, String password) {
        return new IngresarUsuario(username, password);
    }
}
