#include <iostream>
#include<iomanip>
#include<math.h>
using namespace std;

double f(double x) {
    return x * x * x - x - 2;
}

double encontra_raiz(float low, float high){
    double middle = (low + high) / 2;

    //item 3 das instruções 
    if (fabs(f(middle)) < 0.0001){
        return middle;
    }

    //item 4 das instruções 
    if (f(middle) * f(low) < 0){
        return encontra_raiz(low, middle);
    }
    //item 4 das instruções
    else{
        return encontra_raiz(middle, high);
    }
}

int main(){
    float low  = 20;
    float high = -20;

    double raiz = encontra_raiz(low, high);
    cout << setprecision(6) << raiz << endl;

    return 0;
}