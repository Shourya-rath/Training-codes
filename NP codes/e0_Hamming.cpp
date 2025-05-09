/*
Step 1 : main function
- get the data bits
    - get the number of digits 
- calculate the parity bits
-> dbit , pbits
- calculate total_bits
- make array a_digits

Step 2 :func position(totl_bits , dbits , pbits , a_digits[total_bits] )
- make all the parity indexes 0
- enter all the data bits in -1 pos (reset k = 0)
- now configure the parity positions

Step 3 : p_configure( int i ,int  a_digits[7] )
- int ar_db_p[4] , k = 0,  l = 0 , j = i ;  
- count ones and then set it as 0 for even parity and 1 for odd parity 
*/
#include <cmath>
using namespace std;
// func to find the number of digits in the given data bits
int digit(int n ){
    int count = 0;
    while(n>0){
        count++ ;
        n = n/10;    
    }
    return count;
}
// func to count number of parity bits
// int parity(){
    
// }

//
void printArray(int a_digits[7]){
 for(int i = 0 ; i < 7 ;i++){
     cout << a_digits[i] <<" " ;
 }
 cout<< endl ;
}
int count_one(int ar_db_p[4]){
    int count = 0 ;
    for(int i = 0 ; i < 4 ;i++ ){
        if(ar_db_p[i] == 1){
            count++ ;
        }
    }
    return count ;
}
int p_configure( int i ,int  a_digits[7]){
    int ar_db_p[4] ; 
    int k = 0 ;
    int l = 0 ;
    int j = i ;  
    /* 
    start from i ,
    take i number of elements ;
    then leave i number of elements 
    */
    for(int j = i ; j <= 7 ;  ){
        if(k<i){
            ar_db_p[l] = a_digits[j-1] ;
            l++ ;
            k++ ;
            j++ ;
        }
        else{
            k = 0 ;
            j = j + i ;
        }
        
    }
    int num_one = count_one(ar_db_p);
    if ( (num_one % 2) == 0 ){
        cout<<"parity bit set to 0 at " << i <<endl ;
        return 0 ;
    }
    else {
        cout<<"parity bit set to 1 at " << i <<endl ;
        return 1 ;
    }
}
int position(int total_hm,int p_bits,int a_digits[7], int db){
    int k = 0 ;
    // made all parity elements 0
    for(int i = 1; i <= total_hm && k < p_bits  ;i++ )
    {
        if( i == pow(2,k) ){
            a_digits[i-1] = 0 ;
            k++ ;
            
        }
        
    }
    printArray(a_digits) ;
    // enter all the data bits in -1 pos
    int db_temp = db ;
    for(int i = total_hm - 1 ; i >= 0  ; i-- )
    {
        if( a_digits[i] == -1 ){
            a_digits[i] = db_temp%10 ;
            db_temp = db_temp/10 ;
            
        }
    }
    printArray(a_digits) ;
    k = 0 ;
    // now configure the parity positions
    for(int i = 1; i <= total_hm && k < p_bits  ;i++ )
    {
        if( i == pow(2,k) ){
            a_digits[i-1] = p_configure( i , a_digits) ;
            k++ ;
            
        }
        
    }
    printArray(a_digits) ;
    
    return 1 ;
}

int main() {
    int db;
    int a_digits[7] = {-1,-1,-1,-1,-1,-1,-1};
    
    cout<<"enter the data bits"<<endl;
    cin>>db ;
    int db_digits = digit(db );
    
    // cout<< db_digits ;
    int p_bits = 3 ;
    int total_hm = p_bits + db_digits ;
    position(total_hm, p_bits, a_digits , db) ;
    
    return 0;
}