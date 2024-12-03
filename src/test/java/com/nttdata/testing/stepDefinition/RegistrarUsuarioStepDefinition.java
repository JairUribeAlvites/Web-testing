package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RegistrarUsuarioStepDefinition {
    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_UP));
    }

    @And("ingresa un nombre de usuario {string} y contrasenia {string}")
    public void ingresaUnNombreDeUsuarioYContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_PASSWORD));
    }

    @When("selecciona el boton registrar")
    public void seleccionaElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_REGISTRAR));
    }

    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        System.out.println("exitoso");
    }

    @When("se registra con un nombre de usuario {string} y contrasenia {string}")
    public void seRegistraConUnNombreDeUsuarioYContrasenia(String usuario, String password) {
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.withData(usuario, password));
    }

//LogearUsuario
    @When("Ingresa con un nombre de usuario {string} y contrasenia {string}")
    public void ingresaConUnNombreDeUsuarioYContrasenia(String usuario, String password) {
        theActorInTheSpotlight().attemptsTo(IngresarUsuario.withData(usuario, password));
    }

//agregar al carrito
    @When("agrega el producto {string} al carrito")
    public void seleccionaElProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(SeleccionarProducto.withData(producto));
    }

    @And("se muestra una notificación con el mensaje {string}")
    public void seMuestraUnaNotificaciónDeQueElProductoSeAgregóExitosamente(String expectedMessage) {
        WebDriver driver = Serenity.getDriver();
        Duration duration1 = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration1);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        assertThat(actualMessage).isEqualTo(expectedMessage);
        alert.accept();
    }

}
