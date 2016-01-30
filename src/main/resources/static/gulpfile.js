var gulp = require('gulp');
var scss = require('gulp-sass');
var uglify = require('gulp-uglify');
var webpack = require('gulp-webpack');

gulp.task('default', function () {
    console.log('Hello,gulp!');
});

gulp.task('scss', function () {
    gulp.src('scss/**/*.scss')
        .pipe(scss())
        .pipe(gulp.dest('css'));
});

gulp.task('scss:watch', function () {
    gulp.watch('scss/**/*.scss', ['scss']);
});

gulp.task('jscompile', function () {
    gulp.src('js/**/twitter.js')
        .pipe(webpack({
            output: {
                filename: 'twitter.min.js'
            }
        }))
        .pipe(uglify())
        .pipe(gulp.dest('../../../../target/classes/static/js'));
});

gulp.task('jswatch', function () {
    gulp.watch('js/**/*.js', ['jscompile']);
});