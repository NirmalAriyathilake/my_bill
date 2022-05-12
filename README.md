# My Bill

Print restaurant bill    

## Models

- Product :
    - Name : Product name
    - Price : Product price
    - Tax : Product tax. Can be 0. Taxed are calculated per product

- Purchased Item :
    - Item : Purchased product
    - Count : Item qty

- Bill Details :
    - GroupName : Name of the group
    - Count : No of persons in the group. Use in case of split
    - Items : Purchased items. If the bill split individualy items are recorded separately. 
    - Discount : Discount offered. Can be a percentage of the total bill or a fixed amount
    - Transactions : Order of transactions. Types are described below.

## Transaction : 

### Bill split types
- Single : Pay the entire bill by one person
- Individual : Split the bill as per the individuals
- Split : Split the bill equally

### Bill payment types
- Full : Pay the full amount
- Credit : Pay the full amount by credit card
- Other amount (Starts with $) : Pay the amount by cash. ( If the amount is the first transaction, it is considered as remaining amount )

## Bill Printer

Print the bill based on transaction types and bill details.
Split bills are printed separately.
