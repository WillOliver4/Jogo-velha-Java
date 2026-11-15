# Atividade — Jogo da Velha em Java

## 1. Objetivo

Desenvolver um **Jogo da Velha em Java**, executado pelo terminal, no qual uma pessoa possa jogar contra o computador.

O projeto deverá partir dos arquivos disponibilizados. O grupo deverá compreender o código recebido, identificar as responsabilidades de cada classe e implementar os métodos necessários para o funcionamento completo do jogo, aplicando os conceitos de programação orientada a objetos estudados na disciplina.

Ao final da atividade, os integrantes deverão ser capazes de explicar a organização do programa, a interação entre os objetos e as decisões adotadas na implementação.

## 2. Estrutura fornecida

O arquivo contém uma implementação incompleta, com comentários que orientam o desenvolvimento:

| Classe ou interface | Responsabilidade                                              |
| ------------------- | ------------------------------------------------------------- |
| Marca               | Representar e validar os símbolos X e O.                      |
| Tabuleiro           | Armazenar as marcas e controlar o acesso às posições do jogo. |
| AnalistaSituacional | Identificar vitória, empate e encerramento da partida.        |
| Jogador             | Definir o contrato comum aos jogadores.                       |
| JogadorHumano       | Receber e executar as jogadas informadas pelo usuário.        |
| JogadorAutomatico   | Escolher e executar as jogadas do computador.                 |
| Velha               | Iniciar o programa e coordenar as partidas.                   |

**A estrutura fornecida deverá ser utilizada como base do projeto.** As classes, a interface e os métodos propostos deverão ser implementados e integrados.

Será permitido criar métodos auxiliares e corrigir problemas existentes no código inicial, incluindo ajustes em construtores, declarações de pacotes, importações e controle da partida. Essas alterações deverão preservar as responsabilidades das classes e ser explicadas na apresentação.

**Atenção:** o arquivo é um esqueleto de desenvolvimento e não está pronto para compilar ou executar.

## 3. Requisitos funcionais

### Tabuleiro e regras da partida

O programa deverá:

- Utilizar um tabuleiro de **3 × 3 posições**.
- Exibir o tabuleiro de forma legível durante a partida.
- Garantir que os jogadores utilizem marcas diferentes.
- Alternar corretamente os turnos.
- Impedir jogadas em posições ocupadas ou fora dos limites do tabuleiro.
- Identificar vitórias em linhas, colunas e nas duas diagonais.
- Identificar empate quando o tabuleiro estiver cheio e não houver vencedor.
- Encerrar a partida assim que houver vitória ou empate.
- Informar o resultado ao usuário.

### Interação com o jogador humano

O programa deverá permitir que o usuário informe suas jogadas pelo teclado.

Entradas inválidas deverão ser tratadas com mensagens claras e uma nova solicitação de entrada, **sem encerrar inesperadamente o programa e sem fazer o jogador perder a vez**.

A escolha das marcas e a definição de quem inicia deverão seguir a lógica proposta no código-base: sorteio do primeiro jogador na primeira partida e alternância de quem começa nas partidas seguintes.

Ao final de cada partida, o usuário deverá poder escolher entre jogar novamente ou encerrar. Uma nova partida deverá começar com o tabuleiro vazio.

### Jogador automático

O computador deverá realizar jogadas válidas, respeitando a seguinte ordem de prioridade:

1. **Vencer:** completar uma linha, coluna ou diagonal quando houver uma jogada que produza vitória imediata.
2. **Bloquear:** impedir uma vitória imediata do adversário, quando não puder vencer naquele turno.
3. **Preparar uma possibilidade de vitória:** escolher, quando possível, uma posição que contribua para formar uma sequência vencedora.
4. **Ocupar uma posição livre:** quando nenhuma das situações anteriores se aplicar.

O grupo deverá definir e explicar o critério utilizado no terceiro item. Não é necessário implementar um jogador invencível.

## 4. Requisitos de implementação

Além do funcionamento do jogo, serão observados:

- **Encapsulamento:** os atributos deverão ser acessados e manipulados pelos métodos apropriados.
- **Interface e polimorfismo:** `JogadorHumano` e `JogadorAutomatico` deverão implementar `Jogador`, permitindo controlar o turno por uma referência desse tipo.
- **Validações e exceções:** os métodos deverão verificar as condições indicadas no código-base e tratar os erros adequadamente.
- **Métodos de Object:** implementar `toString()`, `equals()` e `hashCode()` nas classes em que foram solicitados, mantendo coerência entre igualdade e código hash.
- **Cópia do tabuleiro:** implementar o construtor de cópia e o método `clone()`, de modo que alterações na matriz de um tabuleiro não alterem a matriz da cópia.
- **Organização e legibilidade:** utilizar nomes claros, indentação consistente e métodos com responsabilidades bem definidas.

**O grupo também deverá corrigir o tratamento do resultado da partida para que o empate seja reconhecido sem tentar chamar métodos sobre uma referência nula.**

## 5. Entrega

O grupo deverá entregar um arquivo `.zip` contendo:

- Todos os arquivos-fonte `.java` necessários para compilar e executar o projeto.
- Um arquivo `README` com o nome dos três integrantes, instruções de compilação e execução e uma breve descrição da estratégia do jogador automático.
- A indicação de eventuais limitações ou funcionalidades não concluídas.

Antes da entrega, o grupo deverá testar situações de vitória, derrota, empate, entrada inválida, posição ocupada e reinício de partida.

## 6. Apresentação

Na apresentação de **19/11**, o grupo deverá apresentar em torno de 7 minutos:

- Demonstrar o jogo em funcionamento.
- Mostrar como ocorre a alternância entre os jogadores por meio do polimorfismo.
- Explicar a estratégia utilizada pelo computador.
- Apresentar as principais validações e correções realizadas no código-base.

**Todos os integrantes deverão participar e estar preparados para responder a perguntas sobre o projeto completo.**

## 7. Critérios de avaliação

A avaliação considerará o funcionamento do jogo, o atendimento aos requisitos, o uso adequado dos conceitos de orientação a objetos, a qualidade do código, o tratamento de situações inválidas e o domínio demonstrado pelos integrantes durante a apresentação.

**O objetivo é compreender, completar e integrar a estrutura fornecida, demonstrando como os objetos colaboram para realizar uma partida de Jogo da Velha.**
