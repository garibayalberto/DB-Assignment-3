import sys
import csv

from faker import Faker

if len(sys.argv) == 3:
    if sys.argv[2].isdigit(): #checks if second value in command line is digit
        numRows = int(sys.argv[2]) #sets rows
        with open(sys.argv[1], 'w') as file: #writes to name of file given by user
            faker = Faker() #faker object
            cols = ['SKU', 'Description', 'Sellable On Hand Units', 'Open PO qty', '1 Month Sales', '3 Month Sales',
                    '6 Month Sales', 'Back Order', 'Lead Time/Alarm', 'MOQ', 'Fob SH', 'Packaging Type', 'L "cm"',
                    'W "cm"', 'H "cm"', 'G.W."kg"', 'N.W. "kg"', 'Carton Qty', 'Pallet Size "cm"', 'Pallet Ctns',
                    'Pallet Qty', 'Pallet Weight "kg"'] #Column names

            writer = csv.DictWriter(file, fieldnames=cols) #writes to file with the column names given

            writer.writeheader() #writes header

            while numRows > 0: #beginning loop that begins writing fake data
                writer.writerow({
                'SKU': faker.zipcode(),
                'Description': faker.cryptocurrency_name(),
                'Sellable On Hand Units': faker.pyint(),
                'Open PO qty': faker.pyint(),
                '1 Month Sales': faker.pyint(),
                '3 Month Sales': faker.pyint(),
                '6 Month Sales': faker.pyint(),
                'Back Order': faker.pyint(),
                'Lead Time/Alarm': faker.pyint(),
                'MOQ': faker.pyint(),
                'Fob SH': faker.pyfloat(left_digits=None, right_digits=None, positive=False),
                'Packaging Type': faker.word(ext_word_list=None),
                'L "cm"': faker.pyint(),
                'W "cm"': faker.pyint(),
                'H "cm"': faker.pyint(),
                'G.W."kg"': faker.pyint(),
                'N.W. "kg"': faker.pyint(),
                'Carton Qty': faker.pyint(),
                'Pallet Size "cm"': faker.word(),
                'Pallet Ctns': faker.pyint(),
                'Pallet Qty': faker.pyint(),
                'Pallet Weight "kg"': faker.pyint()
                })
                numRows -= 1
    else:
        print("Your second parameter must be an integer!")
else:
    print("You must have a file name and number of rows as parameters!")