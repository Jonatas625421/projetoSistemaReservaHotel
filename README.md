🏨 Sistema de Reserva de Hotel — Projeto TDD

📌 Objetivo

Este projeto implementa um sistema de reservas de quartos de hotel em Java, garantindo que um mesmo quarto não seja reservado por mais de um cliente no mesmo período.
O desenvolvimento segue a prática de TDD (Test Driven Development), ou seja, cada funcionalidade é criada a partir de testes automatizados.

🏗️ Estrutura do Sistema

Entidades principais

Quarto → representa o quarto físico do hotel (ex.: número 101).

Reserva → representa a alocação de um quarto para um cliente em um intervalo de datas.

StatusReserva → enum que define se a reserva está ATIVA ou CANCELADA.

SistemaReserva → gerencia todas as reservas, aplicando as regras de negócio.

📋 Regras de Negócio

Toda reserva deve conter: cliente, quarto, data de entrada, data de saída e status.

Toda reserva inicia com status ATIVA.

A data de saída deve ser posterior à data de entrada.

Não é permitido criar reservas com datas sobrepostas para o mesmo quarto.

Reservas canceladas não bloqueiam o período.

O sistema deve validar disponibilidade de quartos antes de confirmar a reserva.

🔄 Abordagem com TDD

O ciclo de desenvolvimento segue três passos:

Red → escrever um teste que falha.

Green → implementar o mínimo necessário para o teste passar.

Refactor → melhorar o código mantendo os testes passando.

🧪 Cenários de Teste

Os testes automatizados cobrem os seguintes casos:

Criar reserva válida.

Rejeitar datas inválidas.

Rejeitar conflito de reservas.

Permitir reservas em períodos distintos.

Cancelamento deve liberar o quarto.

📂 Estrutura de Pastas

Código
src/
 ├── main/java/
 │    ├── Quarto.java
 │    ├── Reserva.java
 │    ├── StatusReserva.java
 │    └── SistemaReserva.java
 └── test/java/
      └── SistemaReservaTest.java

🚀 Como executar no IntelliJ IDEA

Abra o IntelliJ IDEA e crie um Novo Projeto Java.

Crie as pastas src/main/java e src/test/java.

Insira as classes na pasta main/java.

Insira os testes na pasta test/java.

Adicione a biblioteca JUnit 5:

Vá em File > Project Structure > Libraries > Add JUnit.

Clique com o botão direito no arquivo de teste → Run 'SistemaReservaTest'.

O IntelliJ mostrará os testes passando (verde) ou falhando (vermelho).

📊 Conceitos aplicados

Encapsulamento → atributos privados e métodos públicos para acesso controlado.

Validação de regras de negócio → garantias de integridade (datas válidas, sem conflitos).

Enumeração (Enum) → status da reserva representado de forma clara e restrita.

Coleções (List) → armazenamento de reservas em memória.

TDD → desenvolvimento guiado por testes, garantindo qualidade e segurança.
