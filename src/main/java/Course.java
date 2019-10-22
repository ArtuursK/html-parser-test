import java.util.Objects;

public class Course extends DtoBase {

    private String course;

    private String location;

    private String lecturer;

    private String time;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        final Course that = (Course) o;
        return Objects.equals(course, that.course)
                && Objects.equals(location, that.location)
                && Objects.equals(lecturer, that.lecturer)
                && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, location, lecturer, time);
    }

    @Override
    protected StringBuilder fieldsToString() {
        final StringBuilder sb = super.fieldsToString();
        appendField(sb, "course", course);
        appendField(sb, "location", location);
        appendField(sb, "lecturer", lecturer);
        appendField(sb, "time", time);
        return sb;
    }
}
