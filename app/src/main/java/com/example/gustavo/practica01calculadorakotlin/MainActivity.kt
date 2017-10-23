package com.example.gustavo.practica01calculadorakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        punto.isEnabled=false
        deactivarBotonOperaciones()
        bol=true
        var rb_decimal : RadioButton
        if(applicationContext.getResources().getBoolean(R.bool.is_landscape)) {
            rb_decimal = findViewById<RadioButton>(R.id.radioButton)
            rb_decimal.isSelected
        }
    }

    var bol=true
    var n1=0.0
    var n2=0.0
    var res=0.0
    var cuent=true
    lateinit var rb_binario : RadioButton
    lateinit var rb_decimal : RadioButton
    lateinit var rb_hexa : RadioButton

    fun numero(v : View){
        val numer=findViewById<Button>(v.id)
        val textnum=numer.text.toString()
        operaciones.text="${operaciones.text.toString()}${textnum}"
        println("arriba")
        println(operaciones.text)
        activarBotonOperaciones()
        println("abajo")
        if (operaciones.text.contains("x") || operaciones.text.contains("÷") || operaciones.text.contains("+") || operaciones.text.contains("-")) {
            deactivarBotonOperaciones()
            igual.isEnabled=true
        }
        if (textnum.equals(".") || bol==false){
            punto.isEnabled=false
            return
        }else
            punto.isEnabled=true
    }

    fun borrar(v : View){
        operaciones.text=""
        deactivarBotonOperaciones()
        punto.isEnabled=false
        n1=0.0
        n2=0.0
        res=0.0
    }

    fun calcular(v : View){
        if(applicationContext.getResources().getBoolean(R.bool.is_landscape)){
            rb_decimal = findViewById<RadioButton>(R.id.radioButton)
            rb_binario = findViewById<RadioButton>(R.id.radioButton2)
            rb_hexa = findViewById<RadioButton>(R.id.radioButton3)
            if(rb_decimal.isChecked){
                var s = calcular2(operaciones.text.toString())
                operaciones.setText(s)
            }
            else
                if (rb_binario.isChecked){
                    calcularBinario(operaciones.text.toString())
                }
                else
                    if (rb_hexa.isChecked){
                        calcularHexa(operaciones.text.toString())
                    }
        }
        else{
            var s = calcular2(operaciones.text.toString())
            operaciones.setText(s)
        }
    }

    fun calcular2(s : String):String{
        if(s.contains("x")){
            n1=s.substring(0, s.lastIndexOf("x")).toDouble()
            n2=s.substring(s.lastIndexOf("x")+1, s.length).toDouble()
            res=n1*n2
            activarBotonOperaciones()
            punto.isEnabled=false
            return res.toString()
        }
        else
            if(s.contains("÷")){
                n1=s.substring(0, s.lastIndexOf("÷")).toDouble()
                n2=s.substring(s.lastIndexOf("÷")+1, s.length).toDouble()
                res=n1/n2
                activarBotonOperaciones()
                punto.isEnabled=false
                return res.toString()
            }
            else
                if(s.contains("+")){
                    n1=s.substring(0, s.lastIndexOf("+")).toDouble()
                    n2=s.substring(s.lastIndexOf("+")+1, s.length).toDouble()
                    res=n1+n2
                    activarBotonOperaciones()
                    punto.isEnabled=false
                    return res.toString()
                }
                else
                    if(s.contains("-")){
                        n1=s.substring(0, s.lastIndexOf("-")).toDouble()
                        n2=s.substring(s.lastIndexOf("-")+1, s.length).toDouble()
                        res=n1-n2
                        activarBotonOperaciones()
                        punto.isEnabled=false
                        return res.toString()
                    }
        activarBotonOperaciones()
        punto.isEnabled=false
        return ""
    }

    fun calcularBinario(s : String){
        if(s.contains("x")){
            var num1=s.substring(0, s.lastIndexOf("x"))
            var num2=s.substring(s.lastIndexOf("x")+1, s.length)
            var num11 = pasarDeBinario(num1)
            var num22 = pasarDeBinario(num2)
            var resultado=num11+"x"+num22
            var nlsr = calcular2(resultado)
            operaciones.text=pasarABinario(nlsr)
        }
        else
            if(s.contains("÷")){
                var num1=s.substring(0, s.lastIndexOf("÷"))
                var num2=s.substring(s.lastIndexOf("÷")+1, s.length)
                var num11 = pasarDeBinario(num1)
                var num22 = pasarDeBinario(num2)
                var resultado=num11+"÷"+num22
                var nlsr = calcular2(resultado)
                operaciones.text=pasarABinario(nlsr)
            }
            else
                if(s.contains("+")){
                    var num1=s.substring(0, s.lastIndexOf("+"))
                    var num2=s.substring(s.lastIndexOf("+")+1, s.length)
                    var num11 = pasarDeBinario(num1)
                    var num22 = pasarDeBinario(num2)
                    var resultado=num11+"+"+num22
                    var nlsr = calcular2(resultado)
                    operaciones.text=pasarABinario(nlsr)
                }
                else
                    if(s.contains("-")){
                        var num1=s.substring(0, s.lastIndexOf("-"))
                        var num2=s.substring(s.lastIndexOf("-")+1, s.length)
                        var num11 = pasarDeBinario(num1)
                        var num22 = pasarDeBinario(num2)
                        var resultado=num11+"-"+num22
                        var nlsr = calcular2(resultado)
                        operaciones.text=pasarABinario(nlsr)
                    }
        activarBotonOperaciones()
    }

    fun calcularHexa(s : String){
        if(s.contains("x")){
            var num1=s.substring(0, s.lastIndexOf("x"))
            var num2=s.substring(s.lastIndexOf("x")+1, s.length)
            var num11 = pasarDeHexa(num1)
            var num22 = pasarDeHexa(num2)
            var resultado=num11+"x"+num22
            var nlsr = calcular2(resultado)
            operaciones.text=pasarAHexa(nlsr)
        }
        else
            if(s.contains("÷")){
                var num1=s.substring(0, s.lastIndexOf("÷"))
                var num2=s.substring(s.lastIndexOf("÷")+1, s.length)
                var num11 = pasarDeHexa(num1)
                var num22 = pasarDeHexa(num2)
                var resultado=num11+"÷"+num22
                var nlsr = calcular2(resultado)
                operaciones.text=pasarAHexa(nlsr)
            }
            else
                if(s.contains("+")){
                    var num1=s.substring(0, s.lastIndexOf("+"))
                    var num2=s.substring(s.lastIndexOf("+")+1, s.length)
                    var num11 = pasarDeHexa(num1)
                    var num22 = pasarDeHexa(num2)
                    var resultado=num11+"+"+num22
                    var nlsr = calcular2(resultado)
                    operaciones.text=pasarAHexa(nlsr)
                }
                else
                    if(s.contains("-")){
                        var num1=s.substring(0, s.lastIndexOf("-"))
                        var num2=s.substring(s.lastIndexOf("-")+1, s.length)
                        var num11 = pasarDeHexa(num1)
                        var num22 = pasarDeHexa(num2)
                        var resultado=num11+"-"+num22
                        var nlsr = calcular2(resultado)
                        operaciones.text=pasarAHexa(nlsr)
                    }
        activarBotonOperaciones()
    }

    fun pasarDeBinario(s : String):String{
        val numero = Integer.parseInt(s, 2)
        return numero.toString()
    }

    fun pasarABinario(s : String):String{
        var binario = 0
        var bin : Double
        var digito : Int
        var exp = 0.0
        var numero = s.toDouble().toInt()
        while(numero != 0){
            digito = numero % 2
            bin = binario + digito * Math.pow(10.0, exp)
            binario = bin.toInt()
            exp++
            numero /= 2
        }
        return binario.toString()
    }

    fun pasarDeHexa(s : String):String{
        var s = s
        val digits = "0123456789ABCDEF"
        s = s.toUpperCase()
        var valor = 0
        for (i in 0 until s.length) {
            var c : Char = s[i]
            var d : Int = digits.indexOf(c)
            valor = 16 * valor + d
        }
        return valor.toString()
    }

    fun letras(n: Int): String {
        var letra = ""
        when (n) {
            10 -> letra = "A"
            11 -> letra = "B"
            12 -> letra = "C"
            13 -> letra = "D"
            14 -> letra = "E"
            15 -> letra = "F"
        }
        return letra
    }

    fun pasarAHexa(s: String):String{
        var decimal= s.toDouble().toInt()
        var resto : Int
        var hexa = ""
        while(decimal>0) {
            resto=(decimal%16)
            if(resto>9)
                hexa = letras(resto)+hexa
            else
                hexa = resto.toString() + hexa
            decimal /= 16
        }
        return hexa
    }

    fun deactivarBotonOperaciones(){
        div.isEnabled=false
        multi.isEnabled=false
        menos.isEnabled=false
        mas.isEnabled=false
        igual.isEnabled=false
    }
    fun activarBotonOperaciones(){
        div.isEnabled=true
        multi.isEnabled=true
        menos.isEnabled=true
        mas.isEnabled=true
        igual.isEnabled=true
    }

    fun activarDecimal(v : View){
        operaciones.text=""
        cero.isEnabled=true
        uno.isEnabled=true
        dos.isEnabled=true
        tres.isEnabled=true
        cuatro.isEnabled=true
        cinco.isEnabled=true
        seis.isEnabled=true
        siete.isEnabled=true
        ocho.isEnabled=true
        nueve.isEnabled=true
        A.isEnabled=false
        B.isEnabled=false
        C.isEnabled=false
        D.isEnabled=false
        E.isEnabled=false
        F.isEnabled=false
    }

    fun activarBinario(v : View) {
        operaciones.text=""
        cero.isEnabled=true
        uno.isEnabled=true
        dos.isEnabled=false
        tres.isEnabled=false
        cuatro.isEnabled=false
        cinco.isEnabled=false
        seis.isEnabled=false
        siete.isEnabled=false
        ocho.isEnabled=false
        nueve.isEnabled=false
        A.isEnabled=false
        B.isEnabled=false
        C.isEnabled=false
        D.isEnabled=false
        E.isEnabled=false
        F.isEnabled=false
    }

    fun activarHexa(v : View){
        operaciones.text=""
        A.isEnabled=true
        B.isEnabled=true
        C.isEnabled=true
        D.isEnabled=true
        E.isEnabled=true
        F.isEnabled=true
    }
}
