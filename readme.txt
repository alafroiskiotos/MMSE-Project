MMSE-Project
============

Modern Methods of Software Engineering Project

Authors
=======
Kouzoupis Antonios antkou@kth.se
Anestos Nikolaos-Ektoras anestos@kth.se

Instructions
============

- In order to build the project we need to have installed Java JDK (>= 1.6) and maven building tool.

- To compile write the command "mvn package". It will compile the code, run the unit tests and create a .jar file.

- To run the program, type "java -jar target/CarIns-1.0.jar"

Users
=====

For each role in the program there are already available the following user accounts:

username: finance		password: 1234
username: employeeCDA	password: 1234
username: empolyeeCDB	password: 1234
username: garage		password: 1234

Logging in the system with any of these accounts, will prompt the appropriate views.

Adding an Accident Report
=========================

To add a new accident report, from the initial screen, press "Report an Accident" button and fill the form.

CDA employee
=============

Logging in with the CDA employee account will show the claims that the employee must approve or reject.
He can select a claim from the table and press "Order Payment" or "Reject Payment" which will change the status to the claim accordingly.

He can also press "Check new Accidents" which will show him the Reported accidents (from the customers) which are not yet registered.

CDB employee
=============

Logging in with the CDB employee account will show the the Reported accidents (from the customers) which are not yet registered.
He can select a accident from the table and press "Register Claim" or "Delete Accident" which will register a claim under his name
or delete the accident from the system.


finance employee
================

Logging in with Finance employee will show the claims that are marked (by CDA) to be paid.
He can select a claim from the table and press "Pay" button to pay that claim which changes the claim's status to "Paid"
He can also view the payment history by pressing "View Payment History" button.
Finally he can press "Add Client" button which will open a form and he can add a new client to the system.

===========================
All of the above employees can press "Search" button and search using name, phone, email or license plate of a client to see the history of that client's claims.
At any time, users can press the "Logout" button which will log them out of the system and show the initial view.
===========================

Garage
======

Garage user can login and fill a form (with license plate and cost) to add a cost to a claim.



 


