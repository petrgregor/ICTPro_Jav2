rootProject.name = "Jav2_Gradle"
include("src.main.java.cz.ictpro")
include("m01_generics")
include("m01_generics:src.main.java")
findProject(":m01_generics:src.main.java")?.name = "src.main.java"
include("m01_generics.src.main.java.cz.ictpro.generics")
include("m01_generics")
include("m02_collections")
include("m03_inner_classes")
include("m04_functional_programming")
include("m04_functional_programming")
include("m05_streams")
