drop user hbstudent;
create user hbstudent with password 'password';
alter default privileges grant all on tables to hbstudent;
alter default privileges grant all on sequences to hbstudent;