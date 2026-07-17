# Exercício 16 - Sistema de Gerenciamento de Aeroporto

Sistema desenvolvido em Java para gerenciar aeroportos, voos, passageiros e um sistema de fidelidade, simulando operações reais de uma companhia aérea.

## Estrutura do Projeto

```
src/
├── Classes/
│   ├── SistemaFidelidade.java
│   ├── Passageiro.java
│   ├── Voo.java
│   └── Aeroporto.java
├── Gerentes/
│   ├── Gerenciador.java
└── main/
    └── Main.java
```

## Classes

### SistemaFidelidade
Gerencia os pontos de fidelidade acumulados por cada passageiro.

**Atributos:**
- `int pontos`

**Métodos:**
- `adicionarPontos(int pontos)` — adiciona pontos ao saldo do passageiro
- `getSaldoPontos()` — retorna o saldo atual de pontos
- `resgatarPontos(int pontosParaResgate)` — resgata pontos se houver saldo suficiente

---

### Passageiro
Representa um passageiro da companhia aérea, integrado ao sistema de fidelidade.

**Atributos:**
- `String nome`
- `String CPF`
- `SistemaFidelidade fidelidade`

**Métodos:**
- Construtores, getters e setters
- `toString()`
- `equals()` e `hashCode()` — comparação pelo CPF

---

### Voo
Representa um voo com seus passageiros, escalas e estado atual.

**Atributos:**
- `String numVoo`
- `String destino`
- `int capacidadeMaxima`
- `List<Passageiro> passageiros`
- `List<String> escalas`
- `String estadoDoVoo`

**Métodos:**
- `adicionarPassageiros(Passageiro p)` — adiciona passageiro se não existir
- `removerPassageiros(Passageiro p)` — remove passageiro se existir
- `adicionarEscalas(String escala)` — adiciona escala se não existir
- `removerEscalas(String escala)` — remove escala se existir
- `alterarEstado(String estado)` — altera o estado do voo, aceitando: `"Aguardando decolagem"`, `"Voando"` ou `"Concluído"`
- `verificarCapacidade()` — verifica se o voo tem menos de 5 passageiros

---

### Aeroporto
Gerencia os voos do aeroporto e suas operações.

**Atributos:**
- `String nome`
- `String localizacao`
- `List<Voo> voos`

**Métodos:**
- `adicionarVoo(Voo voo)` — adiciona um voo à lista
- `removerVoo(Voo voo)` — remove um voo da lista
- `listarVoos()` — lista todos os voos
- `verificarVoosComPrejuizo()` — identifica voos com menos de 5 passageiros
- `iniciarVoo(Voo voo)` — altera o estado do voo para `"Voando"`

## Funcionalidades

**Voos com Prejuízo:** um voo é considerado com prejuízo quando possui menos de 5 passageiros. O método `verificarVoosComPrejuizo()` identifica e lista todos esses voos.

**Escalas:** cada voo pode ter uma ou várias escalas em cidades intermediárias antes de chegar ao destino final, permitindo simular rotas mais complexas.

**Sistema de Fidelidade:** cada passageiro possui seu próprio sistema de pontos. Os pontos são acumulados a cada voo concluído e podem ser resgatados para obter benefícios.

## Conceitos Utilizados

- Orientação a Objetos (classes, objetos, encapsulamento)
- Composição — `Passageiro` contém `SistemaFidelidade`
- Coleções — `List<Passageiro>`, `List<String>`, `List<Voo>`
- `equals()` e `hashCode()` para comparação de objetos
- Sobrescrita de métodos (`@Override`)

## Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Abra o projeto no NetBeans ou na IDE de sua preferência.

3. Execute a classe `Main`.

## Exemplo de Uso

```java
// Criando passageiros
Passageiro p1 = new Passageiro("Ana Silva", "111.111.111-11");
Passageiro p2 = new Passageiro("Carlos Souza", "222.222.222-22");

// Criando voo e adicionando passageiros
Voo voo1 = new Voo("LA1234", "São Paulo", 150);
voo1.adicionarPassageiros(p1);
voo1.adicionarPassageiros(p2);

// Adicionando escalas
voo1.adicionarEscalas("Brasília");
voo1.adicionarEscalas("Recife");

// Alterando estado do voo
voo1.alterarEstado("Voando");

// Adicionando pontos de fidelidade
p1.getFidelidades().adicionarPontos(100);

// Criando aeroporto
Aeroporto aeroporto = new Aeroporto("Aeroporto Internacional", "Rio de Janeiro");
aeroporto.adicionarVoo(voo1);
aeroporto.verificarVoosComPrejuizo();
```

## Tecnologias

- Java
- NetBeans IDE
