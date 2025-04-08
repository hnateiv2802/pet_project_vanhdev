package elearning.constant;

public class URLConst {
    public static final String LOGIN_ADMIN  = "/admin/login";
    public static final String LOGOUT_ADMIN = "/admin/logout/{id}";
    public static final String CREATE_ADMIN = "/admin/create";
    public static final String READ_ADMIN   = "/admin/read";
    public static final String UPDATE_ADMIN = "/admin/update/{id}";
    public static final String DELETE_ADMIN = "/admin/delete/{id}";

    public static final String LOGIN_USER  = "/users/login";
    public static final String LOGOUT_USER = "/users/logout/{id}";
    public static final String CREATE_USER = "/users/create";
    public static final String READ_USER   = "/users/read";
    public static final String UPDATE_USER = "/users/update/{id}";
    public static final String DELETE_USER = "/users/delete/{id}";

    public static final String CREATE_COURSE = "/courses/create";
    public static final String READ_COURSE   = "/courses/read";
    public static final String UPDATE_COURSE = "/courses/update/{id}";
    public static final String DELETE_COURSE = "/courses/delete/{id}";

    public static final String CREATE_CHAPTER = "/chapters/create";
    public static final String READ_CHAPTER   = "/chapters/read";
    public static final String UPDATE_CHAPTER = "/chapters/update/{id}";
    public static final String DELETE_CHAPTER = "/chapters/delete/{id}";

    public static final String CREATE_LESSON = "/lessons/create";
    public static final String READ_LESSON   = "/lessons/read";
    public static final String UPDATE_LESSON = "/lessons/update/{id}";
    public static final String DELETE_LESSON = "/lessons/delete/{id}";

    public static final String CREATE_USER_COURSE = "/users/{userID}/courses/create";
    public static final String READ_USER_COURSE   = "/users/{userID}/courses/read";
    public static final String UPDATE_USER_COURSE = "/users/{userID}/courses/update/{courseID}";
    public static final String DELETE_USER_COURSE = "/users/{userID}/courses/delete/{courseID}";
    public static final String VIEW_COURSE        = "/users/{userID}/courses/view/{courseID}";
    public static final String JOIN_COURSE        = "/users/{userID}/courses/join/{courseID}";
    public static final String RATE_COURSE        = "/users/{userID}/courses/rate/{courseID}";
    public static final String REVIEW_COURSE      = "/users/{userID}/courses/review/{courseID}";

    public static final String CREATE_USER_COURSE_LESSON = "/users/{userID}/courses/{courseID}/lesson/create";
    public static final String READ_USER_COURSE_LESSON   = "/users/{userID}/courses/{courseID}/lesson/read";
    public static final String UPDATE_USER_COURSE_LESSON = "/users/{userID}/courses/{courseID}/lesson/update/{lessonID}";
    public static final String DELETE_USER_COURSE_LESSON = "/users/{userID}/courses/{courseID}/lesson/delete/{lessonID}";
    public static final String START_LESSON              = "/users/{userID}/courses/{courseID}/lesson/start/{lessonID}";
    public static final String STOP_LESSON               = "/users/{userID}/courses/{courseID}/lesson/stop/{lessonID}";
    public static final String FINISH_LESSON             = "/users/{userID}/courses/{courseID}/lesson/finish/{lessonID}";

    private URLConst() {}
}
