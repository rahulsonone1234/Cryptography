#include<stdio.h>
#include<process.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>
#include<fstream>

int main()
{
   FILE *fp1, *fp2;
   char a=0;
   fp1 = fopen("plain.txt", "r");

   if (fp1 == NULL)
   {
      puts("cannot open this file");
      exit(1);
   }

   fp2 = fopen("Encrypted.txt", "w");
   if (fp2 == NULL)
   {
      puts("Not able to open this file");
      fclose(fp1);
      exit(1);
   }

   int i=0;
   while (a != EOF)
   {
      i++;
      a = fgetc(fp1);
          if(i>0 && i<=501)
          fputc((a+(4%26)), fp2);

          if(i>501 && i<=1001)
          fputc((a+(6%26)), fp2);

          if(i>1001)
          fputc((a+(32%26)), fp2);
   }
   printf("Encrypting.....Done!");
   fclose(fp1);
   fclose(fp2);
   getch();
}
