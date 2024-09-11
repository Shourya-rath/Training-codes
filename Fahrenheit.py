#include <stdio.h>
int arr[10][10][10][10];
int dim[4];

int main() {
  int x,y,z,w,value ;
  char choice;
  printf("Enter the dimensions of the 4D array:\n");
  printf("Dimension 1:");
  scanf("%d",&dim[0]);
  printf("Dimension 2:");
  scanf("%d",&dim[1]);
  printf("Dimension 3:");
  scanf("%d",&dim[2]);
  printf("Dimension 4:");
  scanf("%d",&dim[3]);
  for(int i = 0 ; i< dim[0] ;i++){
      for(int j = 0 ; j< dim[1] ;j++)
        for(int k = 0 ; k< dim[2] ;k++)
        for(int i = 0 ; i< dim[0] ;i++)
        arr[i][j][k][l] = 0 ;
        }
do{
printf("Enter position(x,y,z,w)and value to insert(format: x,y,z,w value)");
scanf("%d %d %d %d %d ",&x,&y,&z,&w,&value) ;
if(x >= dim[0]||y >= dim[1]||z >= dim[2]||w >= dim[3]||x<0||y<0||   z<0||w<0){
    printf("Error : position out of bounds.\n");
}

else{
  arr[x][y][z][w] = value ;
  printf("Value %d inserted at position [%d][%d][%d][%d]\n",value,x,y,z,w);
}
printf("Do you want to insert another element?(y/n):");
scanf("%c",&choice);
}while(choice == 'y'|| choice == 'Y'){
    printf("Arraycontents: \n");
    
}

  
    return 0;
}
