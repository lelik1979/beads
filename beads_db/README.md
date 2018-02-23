Module beads_db provide database creation using flyway.

Flyway is an open-source database migration tool.
It is based around just 7 basic commands: Migrate, Clean, Info, Validate, Undo, Baseline and Repair.

If you want change command you need added changes in FlywayConfiguration class.
In FLYWAY_BEAN change initMethod variable (initMethod = "YOUR_COMMAND").

If you want create some changes in database you need create new sql script
and put it in resources/db_scripts.

The file name prefix for versioned SQL migrations. (default: V)
Versioned SQL migrations have the following file name structure: prefixVERSIONseparatorDESCRIPTIONsuffix ,
which using the defaults translates to V1_1__My_description.sql