# motivation-kotlin

Projeto de frases motivacionais

## Tabelas de conteúdos

- Visão geral
  - <a href='#Desafio' > Desafio </a>
  - <a href='#o-que-eu-aprendi' > Aprendizado </a>
  - <a href='#Feature' > Feature </a>

## Visão Geral

## Desafio

- Projeto frases aleatorias,motivacionais


## O que eu aprendei

Utilizar recursos do koltin no android,como manipular listas, storage do celular,estilos ripple.


Por padrão as activy do kottlin possui um header,alguns celulares não possui esse suporte, maneira de evitar esses comportamentos e manter estilo único para todos os celulares.
Eu decidi retirar, usando código abaixo.
Algo interessante observar que para kotlin entender que você deseja lidar com símbolo diferente e usando dois == e um sinal !.
Quando deseja que sua activy perca o histórico ou seja, usuário não consiga voltar, utiliza a palavra reservada finish()


```kotlin
    if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    
     
  //------------------------------//   
     
     if(name != " ") {
          val intent =  Intent(this,MainActivity::class.java)
          startActivity(intent)
          finish()

       } 
 
```

Utilizei recurso do android sharedPreferences,conceito e armazenar os dados localmente no celular do usuário. </br>
No exemplo abaixo utilizei um operador especial do kotlin ?: conhecido como elvis, caso o valor seja nulo vou retornar o valor do lado direito

```kotlin
       private val mSharedPreferences =  context.getSharedPreferences("motivation",Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key,value).apply()
    }

    fun getString(key:String): String{
      return mSharedPreferences.getString(key, " ")  ?: ""
```

Utilizei recurso de classe abstrata para não precisar instanciar meus objetos, neste objetos centralizei meus casos de uso como o nome do usuário e o id das imagens que estavam selecionadas

```kotlin
class MotivationConstants private constructor(){

    object Key {
       const val PERSON_NAME = "name"
    }

    object  Phrase {
        const val HAPPY = 1
        const val ALL  = 2
        const val SUM = 3

    }

}

```

SharedPreferences precisa do contexto da activy, porem este contexto e só criado apos as primeiras linhas de estâncias serem criadas, no meu caso de uso eu instanciei primeiramente ela usando a palavra reservada lateinit, ou seja estou dizendo ao kotlin para aguardar meu contexto ser criado.</br>
Caso instancio sem utilizar essa palavra reservada iria gerar erro, porque como mencionado anteriormente meu sharedPreferences precisa de um contexto.
E depois em sharedPrefences eu literalmente instancio minha classe usando sharedPreferences = SecurtySharedPreferences(this). Recordando que esse this e o contexto da aplicação.  </br>
Se desejo instanciar uma classe que não precisa do contexto em si, posso realizar no topo da aplicação sem problema exemplo   mPhaserFilter: Int = MotivationConstants.Phrase.ALL.  Esta minha constante esta instanciando a classe  MotivationConstants.


```kotlin
  private lateinit var sharedPreferences: SecuritySharedPreferences
  private var mPhaserFilter: Int = MotivationConstants.Phrase.ALL



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNewPhrase.setOnClickListener(this)
        imgAll.setOnClickListener(this)
        imgHappy.setOnClickListener(this)
        imgSum.setOnClickListener(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        sharedPreferences = SecuritySharedPreferences(this)
        val name = sharedPreferences.getString(MotivationConstants.Key.PERSON_NAME)
        textName.text = "Ola  $name !"
        imgAll.setColorFilter(resources.getColor(R.color.purple_200))
        generateNewPhrase()

    }

```
Utilizei um recurso muito interessante do kotlin para criar  listas de frases.</br>
Realizando um data class, tenho nas mãos recursos das funções do paradigma funcional: filter,reduce e map. No caso usei filter para retornar uma lista conforme o id selecionado e caso não possui retornava tudo. Repara que na função  filter o contrato e com  data class, inclusive mesmo contrato  serve para lifOf, aí consigo acessar it.description. It e uma palavra reservada e quem interage na lista,description e contrata do data class

```kotlin

data class Phrase(val description: String, val category: Int)
private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", MORNING),
        Phrase("Você perde todas as chances que você não aproveita.", MORNING),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", MORNING),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", MORNING),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", MORNING),
        Phrase("Se você acredita, faz toda a diferença.", MORNING),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", MORNING)
    )
    
    
     val filtered = mListPhrases.filter { it.category == categoryId || categoryId == ALL }


```
Por fim utilizei recursos de navegação entre telas. No exemplo abaixo estou armazenando  nome no local storage do celular do usuário, e  com startActivy estou redirecionando para screen que desejo. No caso essa screen tem nome de  MainAcitivity 


```kotlin
 sharedPreferences.storeString(MotivationConstants.Key.PERSON_NAME, name)
 val intent = Intent(this, MainActivity::class.java)
 startActivity(intent)
 finish()

```
 

# Feature

- XML
- Funcoes
- Controle de fluxos
- Shared Preferences
- Navegacao
