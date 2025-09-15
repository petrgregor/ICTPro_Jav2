rootProject.name = "Jav2_Gradle"
include("src.main.java.cz.ictpro")
include("m01_generics")
include("m01_generics:src.main.java")
findProject(":m01_generics:src.main.java")?.name = "src.main.java"
include("m01_generics.src.main.java.cz.ictpro.generics")
include("m01_generics")
