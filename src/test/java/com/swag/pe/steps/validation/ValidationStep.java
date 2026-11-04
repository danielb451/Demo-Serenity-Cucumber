package com.swag.pe.steps.validation;

import com.swag.pe.pages.validations.ValidationPage;
import net.serenitybdd.annotations.Step;
import java.time.Duration;

public class ValidationStep extends ValidationPage {

    @Step("Validar visualizacion del modulo de productos")
    public Boolean titleIsVisible() {
        System.out.println("URL antes de validar: " + getDriver().getCurrentUrl());

        try {
            return lbl_product
                    .withTimeoutOf(Duration.ofSeconds(15))
                    .waitUntilVisible()
                    .isDisplayed();
        } finally {
            System.out.println("URL al finalizar: " + getDriver().getCurrentUrl());
            System.out.println("Titulo del navegador: " + getDriver().getTitle());
        }
    }

    @Step("Validar visualizacion del mensaje de error")
    public Boolean errorMessageIsDisplayed() {
        return lbl_errorMessage
                .withTimeoutOf(Duration.ofSeconds(10))
                .waitUntilVisible()
                .isDisplayed();
    }
}