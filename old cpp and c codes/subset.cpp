#include <iostream>
#include <vector>
using namespace std;

vector<int> subset;
int n = 3; // size of the set

void search(int k) {
    if (k == n+1) {
        // process subset
        for(int i = 0; i < subset.size(); i++) {
            cout << subset[i] << " ";
        }
        cout << endl;
    } else {
        // include k in the subset
        subset.push_back(k);
        search(k+1);
        subset.pop_back();
        // don’t include k in the subset
        search(k+1);
    }
}

int main() {
    search(1);
    return 0;
}
