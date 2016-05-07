package training.maventest.project1.annotationtest;

public @interface Annotation1 {
	int    id();
    String synopsis();
    String engineer() default "[unassigned]"; 
    String date()   default "[unimplemented]"; 
}
