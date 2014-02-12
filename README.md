PSD3 Consortium Sprint 1 - Implementation
=============
## Importing the project into Eclipse

1. Download zip folder and unzip
2. Import project to Eclipse as "General > Existing Projects into Workspace"
3. Select the root directory that u have unzip the project
4. Check "Copy projects into workspace" and click on "Finish"
5. From Terminal/Cygwin change directory to the project in your workspace and use the following command
  * ant resolve – Generate library required from build.xml
6. Go back to Eclipse
  * Configure your build path to include all the jar files in to the project
7. You are done importing and setting up the projects!

---

## Generate file for installation
1.	To generate the jar files for installation in ant, use the following commands
  * ant bundles – Generate the jar file for installation in ant using "install file:<jar file name>.jar"
2.	Files to create/edit when creating a new component
  * Update "build.xml"
  * Create ".MF" files in "config/osgi/" folder
