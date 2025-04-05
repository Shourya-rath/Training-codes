#include <iostream>
#include <vector>
using namespace std;

vector<int> permutation;
bool chosen[4]; // assuming n = 3

void search(int n) {
    if (permutation.size() == n) {
        // process permutation
        for(int i = 0; i < permutation.size(); i++) {
            cout << permutation[i] << " ";
        }
        cout << endl;
    } else {
        for (int i = 1; i <= n; i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            permutation.push_back(i);
            search(n);
            chosen[i] = false;
            permutation.pop_back();
        }
    }
}

int main() {
    int n = 3; // size of the set
    search(n);
    return 0;
}
