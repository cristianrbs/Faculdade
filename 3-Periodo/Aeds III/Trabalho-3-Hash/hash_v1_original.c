#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


//! compilar: gcc -O2 -o hash_v1 hash_v1_original.c
//!executar: ./has_v1

#define TAMANHO_TABELA 1009

typedef struct Node {
    char ip[16];
    int frequencia;
    struct Node* proximo;
} Node;

Node* tabela[TAMANHO_TABELA];

unsigned int funcao_hash(char* ip) {
    unsigned int hash = 0;
    // usa caracteres ASCII do IP
    for (int i = 0; ip[i] != '\0'; i++) {
        hash += ip[i];
    }
    return hash % TAMANHO_TABELA;
}

void inserir(char* ip) {
    unsigned int indice = funcao_hash(ip);
    Node* atual = tabela[indice];

    while (atual != NULL) {
        if (strcmp(atual->ip, ip) == 0) {
            atual->frequencia++;
            return;
        }
        atual = atual->proximo;
    }

    // aloca memória para novo nó
    Node* novo = (Node*)malloc(sizeof(Node));
    if (novo == NULL) {
        printf("Erro: Falha na alocação de memória.\n");
        exit(1);
    }
    // dados do novo nó
    strcpy(novo->ip, ip);
    novo->frequencia = 1;
    novo->proximo = tabela[indice];
    // tabela tem novo nó como referência
    tabela[indice] = novo;
}

// ------------------------------------------------------------
// Estatísticas da tabela hash
// ------------------------------------------------------------
void imprimir_estatisticas(double tempo_ms) {
    int total_unicos = 0;
    int maior_lista = 0;
    int posicoes_vazias = 0;

    for (int i = 0; i < TAMANHO_TABELA; i++) {
        int comprimento = 0;
        Node* atual = tabela[i];

        while (atual != NULL) {
            comprimento++;
            total_unicos++;
            atual = atual->proximo;
        }

        if (comprimento == 0) {
            posicoes_vazias++;
        }
        if (comprimento > maior_lista) {
            maior_lista = comprimento;
        }
    }

    double fator_carga = (double)total_unicos / TAMANHO_TABELA;

    printf("\n===== ESTATISTICAS DA TABELA HASH =====\n");
    printf("Tamanho da tabela:         %d\n", TAMANHO_TABELA);
    printf("Total de IPs unicos:       %d\n", total_unicos);
    printf("Fator de carga (alpha):    %.4f\n", fator_carga);
    printf("Maior lista (colisoes):    %d\n", maior_lista);
    printf("Posicoes vazias:           %d\n", posicoes_vazias);
    printf("Tempo de execucao:         %.2f ms\n", tempo_ms);
    printf("=========================================\n");
}

int main() {
    // inicializa a tabela com NULL
    for (int i = 0; i < TAMANHO_TABELA; i++) {
        tabela[i] = NULL;
    }

    FILE* arquivo = fopen("dados_ips.txt", "r");
    if (arquivo == NULL) {
        printf("Erro: nao foi possivel abrir dados_ips.txt\n");
        return 1;
    }

    char linha[16];

    clock_t inicio = clock();

    while (fgets(linha, sizeof(linha), arquivo)) {
        // remove a quebra de linha '\n'
        linha[strcspn(linha, "\n")] = '\0';
        inserir(linha);
    }

    clock_t fim = clock();
    double tempo_ms = ((double)(fim - inicio) / CLOCKS_PER_SEC) * 1000;

    fclose(arquivo);

    imprimir_estatisticas(tempo_ms);

    return 0;
}
