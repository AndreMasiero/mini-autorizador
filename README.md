# Mini Autorizador

VR card transaction validation service

# Tecnologias Utilziadas no back-end
Java 11
<br>
Maven 3.6.1
<br>
SpringBoot 2.7.0
<br>
Spring Data
<br>
Banco MySql
<br>
JPA
<br>
Mockito 1.10.19
<br><br>
Padrão MVC composto por camadas de entidades, serviços, repositories e controllers
<br>
# Comandos para rodar a aplicação
1 - Subir o banco de dados MySql que esta configurado para subir com 
    Docker compose que esta na pasta docker
    
- Comando: docker compose up

2 - No pacote raíz (mini-autorizador)
<br>
- comando: 'mvn package' (será gerado um jar mini-autorizador-1.0.0-SNAPSHOT.jar na pasta ./target)
- Uma vez dentro da pasta target, usar o comando  'java -jar mini-autorizador-1.0.0-SNAPSHOT.jar'
<br>  
Opção utilizando uma IDE
  <br>
- Executar a classe com o main(MiniAutorizadorApplication), irá subir a aplicação na porta 8080
  <br>

# Telas do sistema
- Cadastro de cartão OK
<p align="center">
  <img src="./Documentacao/prints_tela/1 - cadastro_cartao_ok.jpg" alt="accessibility text">
</p>

- Cadastro de cartão Repetido
<p align="center">
  <img src="./Documentacao/prints_tela/2 - cadastro_cartao_existente.jpg" alt="accessibility text">
</p>
<br>

- Visualizar Saldo Cartão
<p align="center">
  <img src="./Documentacao/prints_tela/3 - visualizar_saldo_cartao.jpg" alt="accessibility text">
</p>
<br>

- Transação OK
<p align="center">
  <img src="./Documentacao/prints_tela/4 - transacao_ok.jpg" alt="accessibility text">
</p>
<br>

- Transação cartão não encontrado
<p align="center">
  <img src="./Documentacao/prints_tela/5 - transacao_cartao_nao_encontrado.jpg" alt="accessibility text">
</p>
<br>

- Transação senha inválida
<p align="center">
  <img src="./Documentacao/prints_tela/6 - transacao_cartao_senha_invalida.jpg" alt="accessibility text">
</p>
<br>

- Transação saldo insuficiente
<p align="center">
  <img src="./Documentacao/prints_tela/7 - transacao_saldo_insuficiente.jpg" alt="accessibility text">
</p>
<br>

Banco de dados
<p align="center">
  <img src="./Documentacao/prints_tela/data_base.jpg" alt="accessibility text">
</p>
<br>