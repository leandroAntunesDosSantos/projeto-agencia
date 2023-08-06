programa
{
	
	funcao inicio()
	{
		opcaoMenu : caractere
clientes : vetor [0..9] de caractere
destinos : vetor [0..9] de caractere

procedimento mostrarMenu()
inicio
      escreval(" ")
      Escreval("1- Cadastrar Cliente.")
      Escreval("2- Cadastrar Destino.")
      Escreval("3- Pesquisar Cliente.")
      Escreval("4- Pesquisar Destino.")
      Escreval("5- Para Sair.")
            escreval(" ")
            
      leia(opcaoMenu)
fimprocedimento

procedimento cadastrarCliente()
var
   i : inteiro
inicio

   para i de 0 ate 9 faca
        se clientes[i] = "" entao
           escreval("Nome:")
           leia(clientes[i])
           escreval(" ")
           interrompa
        fimse
   fimpara
fimprocedimento

procedimento cadastrarDestino()
var
   i : inteiro
inicio

   para i de 0 ate 9 faca
        se destinos[i] = "" entao
           escreval("Nome do destino:")
           leia(destinos[i])
           escreval(" ")
           interrompa
        fimse
   fimpara
fimprocedimento

procedimento pesquisarCliente()
var
   i : inteiro
   nomeAPesquisar : caractere
   indice : inteiro
inicio

   escreval("Informe o nome do cliente a ser achado:")
   leia(nomeAPesquisar)

   para i de 0 ate 9 faca
        se clientes[i] = nomeAPesquisar entao
           indice <- i
           interrompa
        fimse
   fimpara
   se indice = -1 entao
      escreval("Cliente não cadastrado!")
   senao
      escreval("Cliente encontrado na posição: ", indice)
      escreval("Nome do cliente: ", clientes[indice])
      escreval(" ")
   fimse
fimprocedimento

procedimento pesquisarDestino()
var
   i : inteiro
   nomeAPesquisar : caractere
   indice : inteiro
inicio

   escreval("Informe o nome do destino a ser achado:")
   leia(nomeAPesquisar)

   para i de 0 ate 9 faca
        se destinos[i] = nomeAPesquisar entao
           indice <- i
           interrompa
        fimse
   fimpara
   se indice = -1 entao
      escreval("Destino não cadastrado!")
   senao
      escreval("Destino encontrado na posição: ", indice)
      escreval("Nome do Destino: ", destinos[indice])
      escreval(" ")
   fimse
fimprocedimento



Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
escreval("Bem vindo(a)a Agência Rota de Férias!")
repita
      mostrarMenu()
      escolha opcaoMenu
          caso "1"
               cadastrarCliente()
          caso "2"
               cadastrarDestino()
          caso "3"
               pesquisarCliente()
          caso "4"
               pesquisarDestino()
          outrocaso
             escreval("Opcao inválida")
     fimescolha
    ate opcaoMenu = "5"

Fimalgoritmo
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 51; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */