#include <iostream>
using namespace std;

//Cristian Rubens e Thierry Bonato

void insertionSortDuplo(int v[], int tam) {

    // O laço começa em 1 e avança de 2 em 2
    for (int i = 1; i < tam; i += 2) {

        int j = i;       // j aponta para o 1º elemento 
        int k = i + 1;   // k aponta para o 2º elemento 

        // Insere o 1º elemento na posição correta
        // Enquanto v[j] for menor que o elemento a esquerda, troca
        while (j > 0 && v[j] < v[j - 1]) {
            swap(v[j], v[j - 1]);
            j--;
        }

        //Insere o 2º elemento na posição correta
        // Só entra se k for uma posição válida dentro do vetor
        if (k < tam) {
            while (k > 0 && v[k] < v[k - 1]) {
                swap(v[k], v[k - 1]);
                k--;
            }
        }
    }
}

void imprimirVetor(int v[], int tam) {
    for (int i = 0; i < tam; i++)
        cout << v[i] << " ";
    cout << endl;
}

int main() {
    int v[] = {7, 3, 5, 1, 4, 2};

    insertionSortDuplo(v);

    imprimirVetor(v);

    return 0;
}
