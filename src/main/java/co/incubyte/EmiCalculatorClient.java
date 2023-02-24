package co.incubyte;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
@Client("https://mocki.io/v1/")

public interface EmiCalculatorClient {
    @Get("7246f814-7759-420a-bf76-cbd750bf776f")
    Emi fetch(@QueryValue int loanAmount,@QueryValue double interestRate, int durationYears);
}
