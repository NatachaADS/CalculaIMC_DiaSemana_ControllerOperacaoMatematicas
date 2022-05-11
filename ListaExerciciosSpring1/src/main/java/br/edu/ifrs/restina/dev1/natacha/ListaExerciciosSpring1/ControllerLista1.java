/*
1) Escreva um controller em spring que receba o peso e a altura de uma pessoa a partir de uma url e gere o seu
IMC (Índice de Massa Corporal). O IMC é calculado através da equação:
url = /imc/{peso}/{altura}
Obs.: Para o spring aceitar números reais utilizar: @RequestMapping("/imc/{peso}/{altura:.+}")
A aplicação deve mostrar também a interpretação do índice, dada pela tabela abaixo:
IMC Classificação
< 18,5 Magreza
18,5 – 24,9 Saudável
25,0 – 29,9 Sobrepeso
30,0 – 34,9 Obesidade Grau I
35,0 – 39,9 Obesidade Grau II (severa)
≥ 40,0 Obesidade Grau III (mórbida)

calculo: IMC = Peso ÷ (Altura × Altura)
*/
package br.edu.ifrs.restina.dev1.natacha.ListaExerciciosSpring1;

//import java.util.Calendar;
//import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerLista1 {

    @RequestMapping("/imc/{peso}/{altura:.+}")
    @ResponseBody
    public String calIMC(@PathVariable float peso, @PathVariable float altura) {
        float imc = (peso / (altura * altura));

        if (imc < 18.5){
            return "IMC: " + imc + " Magreza.";
        } else if (imc > 18.5 && imc < 24.9){
            return "IMC: " + imc + " Saudável.";
        } else if (imc > 25.0 && imc < 29.9){
            return "IMC: " + imc + " Sobrepeso.";
        } else if (imc > 30.0 && imc < 34.9){
            return "IMC: " + imc + " Obesidade Grau I.";
        } else if (imc > 35.0 && imc < 39.9){
            return "IMC: " + imc + " Obesidade Grau II (severa).";
        } else if (imc >= 40.0){
            return "IMC: " + imc + " Obesidade Grau III (mórbida).";
        } else {
            return "IMC= " + Float.toString(imc);
        }          
    }   

    /*2) Escreva um controller em spring que receba dia, mês e ano, retornando o dia da semana:
    url = /diaSemana/{ano}/{mes}/{dia}
    */
    @RequestMapping("/diaSemana/{ano}/{mes}/{dia}")
    @ResponseBody
    public String diaSemana(@PathVariable int ano, @PathVariable int mes,
        @PathVariable int dia, @RequestParam String diaSemana) {

       // Calendar calendario = Calendar.getInstance();
       // calendario.setTime(date);;

        return "dia da semana";

    }

    /* 3) Escreva um controller em spring para executar operações matemáticas com dois números, contendo os
    seguintes comandos:
    url = /calculadora/adicao?n1=numero&n2=numero
    url = /calculadora/subtracao?n1=numero&n2=numero
    url = /calculadora/multiplicacao?n1=numero&n2=numero
    url = /calculadora/divisao?n1=numero&n2=numero
    */

    @RequestMapping("/calculadora/adicao")
    @ResponseBody
    public String adicao(@RequestParam int n1, @RequestParam int n2) {
        return Integer.toString(n1 + n2);
    }

    //url =  / calculadora / subtracao ? n1 = numero & n2 = numero
    @RequestMapping("/calculadora/subtracao")
    @ResponseBody
    public String subtracao(@RequestParam int n1, @RequestParam(required = false, defaultValue = "0") int n2) {
        return Integer.toString(n1 - n2);
    }

    //url =  / calculadora / multiplicacao ? n1 = numero & n2 = numero
    @RequestMapping("/calculadora/multiplicacao")
    @ResponseBody
    public String multiplicacao(@RequestParam int n1, @RequestParam int n2) {
        return Integer.toString(n1 * n2);
    }

    //url =  / calculadora / divisao ? n1 = numero & n2 = numero
    @RequestMapping("/calculadora/divisao")
    @ResponseBody
    public String divisao(@RequestParam int n1, @RequestParam int n2) {
        return Integer.toString(n1 / n2);
    }

}
