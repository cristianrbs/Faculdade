# Roteiro 02

Projeto acadêmico desenvolvido em Java com o objetivo de representar e manipular figuras geométricas no plano cartesiano por meio de classes e objetos.

## Estrutura do Projeto

```
src/
└── classes/
    ├── Ponto.java
    ├── Triangulo.java
    └── Quadrado.java
```

## Classes

### Ponto
Representa um ponto no plano cartesiano com coordenadas `x` e `y`.

**Atributos:**
- `double x`
- `double y`

**Métodos:**
- `fill()` — lê as coordenadas via console
- `distanciaDoisPontos(Ponto outro)` — calcula a distância entre dois pontos usando Pitágoras
- `Determinante(Ponto pB, Ponto pC)` — calcula o determinante entre três pontos
- `toString()` — retorna a representação textual do ponto

---

### Triangulo
Representa um triângulo formado por três pontos no plano cartesiano.

**Atributos:**
- `Ponto p1, p2, p3`

**Métodos:**
- `fill()` — lê as coordenadas dos três pontos via console
- `imprimir()` — exibe os dados do triângulo
- `isColinear()` — verifica se os três pontos são colineares (não formam um triângulo)
- `area()` — calcula a área usando o Determinante
- `perimetro()` — calcula o perímetro somando os três lados
- `tipo()` — classifica o triângulo em Equilátero, Isósceles ou Escaleno

---

### Quadrado
Representa um quadrado formado por quatro pontos no plano cartesiano.

**Atributos:**
- `Ponto p1, p2, p3, p4`

**Métodos:**
- `fill()` — lê as coordenadas dos quatro pontos via console
- `imprimir()` — exibe os dados do quadrado
- `validarQuadrado()` — verifica se os quatro pontos formam um quadrado usando lados iguais, diagonais iguais e o Teorema de Pitágoras
- `area()` — calcula a área do quadrado
- `perimetro()` — calcula o perímetro do quadrado
- `isQuadrado()` — verifica se é ou não um quadrado

## Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/cristianrbs/Roteiro-02.git
```

2. Abra o projeto no NetBeans ou na IDE de sua preferência.

3. Execute a classe `Main` correspondente ao exercício desejado.

## Exemplo de Uso

```java
// Criando e testando um triângulo
Triangulo t = new Triangulo();
t.fill();
t.imprimir();
System.out.println("Área: " + t.area());
System.out.println("Perímetro: " + t.perimetro());
System.out.println("Tipo: " + t.tipo());
System.out.println("É colinear? " + t.isColinear());

// Criando e testando um quadrado
Quadrado q = new Quadrado();
q.fill();
q.imprimir();
System.out.println("Área: " + q.area());
System.out.println("Perímetro: " + q.perimetro());
System.out.println("É válido? " + q.validarQuadrado());
```

## Tecnologias

- Java
- NetBeans IDE
