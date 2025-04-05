#include<stdio.h>
#include<string.h>
//124 =|
// space= 32
void display(char a[100]) {
    //strlen(a)-2,i = 1
    for(int i=1; i < strlen(a)-2; i++) {
        printf("%c",a[i]);
    }
       printf("\n");

}

void trans(int a,char b[100]) {

    char c= 48 + a,d[100]= {c,' '};
    strcat(b,d);

}
void bound(char a[100]) {
    char kk[100];
    for(int i=0; a[i]!= '\0'; i++) {

        switch(a[i]) {
        case '|':
            kk[i] = '+';
            break;
        case ' ':
            kk[i] = '-';
            break;
        default:
            kk[i] = '-';

            break;

        }
        printf("%c",kk[i]);
    }
    printf("\n");
}
void add_dash(int row,int n,char a[100]) {
    strcat(a,"+");
    // (f-1)*8 + 3
    int f= n-row;
    for (int j = 1; j <= f-1; j++) {
        char b[10] ="--------";
        strcat(a,b);
    }
    strcat(a,"---");
    strcat(a,"+");
}
void add_space(int row,int n, char a[100]) {
    strcat(a,"  ");
    if (row >= n-1 ) {

        row = 2*n-1- row-1;
    }
    else
   { row = row +1;}
    for (int j = 2; j <=row ; j++) {
        strcat(a,"+   ");
    }
    add_dash(row,n,a);
    for (int j = 1; j  <=row ;  j++){
        strcat(a,"   +");
        
    }
}
int main()
{   int i,j,k,n1,l,m;
scanf("%d",&n1);
int n = n1+1;
   
    char gc[100]= "";
    l = 2*n - 1;
    //i = 1,i<l-1
    for ( i = 1; i < l-1; i++ ) {
        k= n;
        m = l-i-1;
        for (j = 0; j <l; j++) {
            if(i <n) {
                if (j < i) {
                  
                    trans(k,gc);
                    k--;
                    trans('|'-48,gc);
                }
                else if(j >= i && j < l-i ) {
                  
                    trans(k,gc);
                    if(j< l-i-1) {
                        trans(' '-48,gc);
                    }
                }
                else if (j>= l-i) {
                 
                    trans('|' -48,gc);
                    trans(k+1,gc);
                    k++;
                }
            }
            else {
                if (j < m) {
                   
                    trans(k,gc);
                    k--;
                    trans('|'-48,gc);
                }
                else if(j >= m && j < l-m ) {
                    
                    trans(k,gc);
                    if(j< l-m-1) {
                        trans(' '-48,gc);
                    }
                }
                else if (j>= l-m) {
                 
                    trans('|'-48,gc);
                    trans(k+1,gc);
                    k++;

                }
            }


        }
          char fatboy[100] = "";
            char str[100]= "";
        if (i == 1){
        add_space(i-1,n,fatboy);
        display(fatboy);
           
        }
        strcpy(fatboy,str);
        display(gc);
     
       
 
   add_space(i,n,fatboy);
   display(fatboy);
   fatboy[100]= {'\0'};
      
        strcpy(gc,str);

    }
    printf("\n");
}


