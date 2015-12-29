var gulp = require('gulp');
var scss = require('gulp-sass');

gulp.task('default', function () {
    console.log('Hello,gulp!');
});

gulp.task('scss', function () {
    gulp.src('scss/**/*.scss')
        .pipe(scss())
        .pipe(gulp.dest('css'));
});

gulp.task('scss:watch',function(){
    gulp.watch('scss/**/*.scss',['scss']);
});