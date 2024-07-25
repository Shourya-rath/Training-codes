
# print("MADE BY SHOURYA DEV SINGH RATHORE XII A")
import csv
import os
import calendar
import datetime
from prettytable import PrettyTable
import os

# Clearing the Screen
os.system('cls')


# from prettytable import ALL

print("\nMY TO DO LIST")
instructions ='''\nEnter:\n0:C to view calendar\n1:A to add.\n2:D to delete.\n3:E to exit program
4:U to update \n5:V to view \n6:I to view instructions
WHILE ADDING DATES ENTER IN FORMAT(YYYY/M/D) for ex:2021/3/14, 2021/12/1,etc. '''
print(instructions)
to_doist = []
calen = []      
x= PrettyTable()

# x.vertical_char = '|'
# x.horizontal_char = '='
# x.junction_char = '+'
# x.hrules = ALL
# megarun = 0 
if os.path.isfile('eventj.csv'):
    file = open('eventj.csv','r+')
    file.seek(0)
    reader = csv.reader(file)
    for row in reader:
        if len(row) != 0 :
        
            to_doist.append(row[0])
            calen.append(row[1])

else:
    file = open('eventj.csv','w+')
    
    writer = csv.writer(file)
    writer.writerow(['event or task','date'])
    file.close()
# megarun = 0
# while megarun == 0 :    
def my_list():
        file = open('eventj.csv','r+')
        
        reader = csv.reader(file)
        to_doist.clear()
        calen.clear()
        
        
        
        for row in reader:
            if len(row) != 0 :
            
                to_doist.append(row[0])
                calen.append(row[1])
    
        x.field_names = ['S No.',"event or task","date"]
        if len(calen)!= 0:
            for i in range(1,len(to_doist)):
                
                x.add_row([i,to_doist[i],calen[i]])
        elif len(calen)== 0:
           print('no entry in dates')
           for i in range(1,len(to_doist)):
               x.add_row([to_doist[i]])
        
        print(x.get_string(title="TO DO LIST"))
        x.clear_rows()
my_list()
running= True
while running:
            u_input=input("what to do(c,a,d,u,e,v,i):").lower()
            if u_input == "a":
                dew=input("enter tasks or events: ").lower()
                new = dew.split('\\')
                newlen = len(new)
                dateask=input("do you want to assign date?(y/n)").lower()
                if dateask == "y":
                    runn = True
                    while runn:
                    
                        yeandmo=input('enter month/year...(mm/yyyy:)')
                        splitter = ' '
                        for g in yeandmo:
                            if g.isnumeric() == False:
                                splitter = g
                        year1= yeandmo.split(splitter)
                        print(year1)
                        if len(yeandmo) < 8  : 
                            if year1[0].isnumeric() and year1[1].isnumeric() \
                                and int(year1[0]) in range(1,13) \
                                    and int(year1[1]) in range(1,10000):
                                ye = int(year1[1])
                                mo = int(year1[0])
                                print("-----------------------")
                                print(calendar.month(ye,mo))
                                print("-----------------------")
                                da=int(input("which day?: "))
                                g= datetime.date(ye,mo,da)
                                print(g)
                                calen.extend([g.strftime("%A,%B %d,%Y")]*newlen)
                                print(g.strftime("%A,%B %d,%Y"))
                                # print(calen)
                                runn = False
                            else :
                                
                                print("write month/year properly like eg")    
                        else:
                            
                            print("value given isnt correct")

                elif dateask == "n":
                    a= "NA"
                    calen.extend([a]*newlen)
                print("\n LIST HAS BEEN UPDATED.")
                to_doist.extend(new)
            elif u_input == "d":
                items =input("what to delete?(choose s.no./s.nos. separated by commas) ").lower()
                dup = items.split(',')
                dup.sort(reverse=True)
                choice=input("Sure(Y/N)").lower()
                for item_name in dup:
                            
                            if item_name.isnumeric():
                                
                                if int(item_name) in range(1,len(to_doist)):
                                    
                                    if choice == "y":
                                        index= int(item_name)
                                        index2 = int(item_name)
                                        calen.pop(index2)
                                        to_doist.remove(to_doist[index])
                                        
                                        print("LIST UPDATED")
                                    else:
                                        print('okay')
                                else:
                                        print("ITEM NOT FOUND")
                            else:
                                print("SOMETHING WENT WRONG")
            elif u_input == "u":
                item_name =input("what to UPDATE?").lower()
                if item_name.isnumeric():        
                    if int(item_name) in range(1,len(to_doist)):
                        choice=input("Sure(Y/N)").lower()
                        if choice == "y":
                            update_name =input(" new name? ").lower()
                            index= int(item_name)
                            to_doist[index] = update_name 
                            inpu=input("do you want to change date?(y/n)").lower()
                            if inpu=="n":
                                a=calen[index]
                                calen.append(a)
                            elif inpu=="y":
                                ye=int(input("year: "))
                                mo=int(input("month: "))
                                print("-----------------------")
                                print(calendar.month(ye,mo))
                                print("-----------------------")
                                da=int(input("which day?: "))
                                a= datetime.date(ye,mo,da)
                                print(a)
                                calen[index]=a.strftime("%A,%B %d,%Y")
                                print(calen[index])
                    else:
                            print('item not found')
                else:
                            print("something went wrong")
            elif u_input == "e":
                ask_user= input("ARE YOU SURE ?(Y/N)").lower()
                if ask_user == "y":
                    running = False
                    # global megarun
                    # megarun = 1
                    
            elif u_input == "v":
                full = input('to view all enter any key(except n)').lower()
                if full != 'n': 
                    my_list()
                else:
                    
                    runn = True
                    while runn:
                    
                        notfull=input('enter date...(dd/mm/yyyy:)')
                        splitter = ' '
                        for g in notfull:
                            if g.isnumeric() == False:
                                splitter = g
                        year1= notfull.split(splitter)
                        print(year1)
                        if len(notfull) < 11  : 
                            if year1[0].isnumeric() and year1[1].isnumeric() \
                                and year1[2].isnumeric()\
                                and int(year1[0]) in range(1,32) \
                                    and int(year1[1]) in range(1,13) \
                                    and int(year1[2]) in range(1,10000):
                                ye = int(year1[2])
                                mo = int(year1[1])
                                dy = int(year1[0])
                                g= datetime.date(ye,mo,dy)
                                print(g)
                                print(g.strftime("%A,%B %d,%Y"))
                                for i in range(1,len(calen)) :
                                    if calen[i] == g.strftime("%A,%B %d,%Y"):
                                        
                                        x.add_row([i,to_doist[i],calen[i]])
                                
                                
                                print(x.get_string(title="TO DO LIST"))
                                x.clear_rows()
                                
                                # print(calen)
                                runn = False
                            else :
                                
                                print("write month/year properly like eg")    
                        else:
                            
                            print("value given isnt correct")
            elif u_input == "c":
                w=input("calendar for year or month(y/m)?:").lower()
                if w == "y":
                  Q=int(input("tell year (yyyy)"))
                  print(calendar.calendar(Q))
                elif w == "m":
                    q,m= int(input("year:")),int(input ("month:"))
                    print(calendar.month(q,m))
                else:
                     print("PLEASE ENTER VALID VALUE")   
            elif u_input == " " :
                print("PLEASE ENTER SOME VALUE")
            elif u_input == "i":
                print(instructions)
            else:
                print("PLEASE ENTER VALID VALUE")

            if os.path.isfile('eventj.csv'):
                file = open('eventj.csv','w+')
                
                writer = csv.writer(file)
                writer.writerow(['event or task','date'])
                for i in range(len(to_doist)-1):
                    writer.writerow([to_doist[i+1],calen[i+1]])
               
            
                
                file.close()
                        
my_list()
print('''program is saved in\n    eventj.csv''' )
