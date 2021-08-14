# motivation-kotlin

Projeto de frases motivacionais

## Tabelas de conteúdos

- Visão geral
  - <a href='#Desafio' > Desafio </a>
  - <a href='#o-que-eu-aprendi' > Aprendizado </a>
  - <a href='#Feature' > Feature </a>

## Visão Geral

## Desafio

- Criar projeto simples para praticar conhecimento me kotlin
- 


## O que eu aprendei

Utilizar recursos do koltin no android,como manipular botões, caixas de texto e logica de usando kotlin


Para referenciar botão existe 3 maneiras, criando uma função com onClick,identificando id ou realizando um contrato com  interface listener.
Método usei foi o último,para isto ser possível precisa referenciar a interface e usar os métodos imposto pela interface


```kotlin
   class MainActivity : AppCompatActivity(), View.OnClickListener {

    buttonCalculete.setOnClickListener(this)
 
    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculete) {
            calculete()
        }

    }
 
}
 
```

Aprendi a usar notificações para usuário caso ocorresse um erro inesperado, garantindo assim usabilidade e experiencia do usuário.
Com try,catch. Eu garanto tratamento dos erros, usei a função Toast.markeText para realizar as notificações


```typeScript
     try {
                val distance = textDistance.text.toString().toFloat()
                val liter = textLiter.text.toString().toFloat()
                val autonomy = textAutomy.text.toString().toFloat()
                val value = (distance * liter) / autonomy
                textValue.text = "R$ ${"%.2f".format(value)} "

            } catch (nrf: NumberFormatException) {

                Toast.makeText(this, getString(R.string.validation_field_correct), Toast.LENGTH_SHORT)
                    .show()
            }

        } else {

            Toast.makeText(this, getString(R.string.validation_empty_field), Toast.LENGTH_SHORT)
                .show()

        }
```

Houve atualização no Kotlin para usar referência direta do id nos componentes precisa adicionar a dependência id. 'kotlin-android-extensions' Precisa ser importada no build.gradle

```gradle
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-android-extensions'
//    extensao importante para referenciar por id
}


```
 

# Feature

- XML
- Funcoes
- Controle de fluxos
