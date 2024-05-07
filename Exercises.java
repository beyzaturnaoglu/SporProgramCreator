
public abstract class Exercises {
    protected String exerciseName;
    protected int setCount;
    protected int repeadCount;
    protected int weight;

    Exercises(int repeadCount, int setCount,int weight) {
        this.repeadCount = repeadCount;
        this.setCount = setCount;
        this.exerciseName = "egzersiz";
        this.weight = weight;
    }

    protected String getExercisesName() {
        return exerciseName;
    }

    protected int getExercisesSetCount() {
        return setCount;
    }

    protected int getExercisesrepeadCount() {
        return repeadCount;
    }

    protected int getExercisesweight() {
        return weight;
    }
}
