var gulp = require('gulp');
var scss = require('gulp-sass');
var uglify = require('gulp-uglify');
var webpack = require('gulp-webpack');
var babel=require('gulp-babel');
var TARGET_PATH = '../../../../target/classes/static/';

gulp.task('default', function () {
    console.log('Hello,gulp!');
});

gulp.task('scss', function () {
    gulp.src('scss/**/*.scss')
        .pipe(scss())
        .pipe(gulp.dest(TARGET_PATH + 'css'));
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
        .pipe(babel())
        .pipe(uglify())
        .pipe(gulp.dest(TARGET_PATH + 'js'));
});

gulp.task('jswatch', function () {
    gulp.watch('js/**/*.js', ['jscompile']);
});

gulp.task('allwatch',function(){
    gulp.watch('scss/**/*.scss', ['scss']);
    gulp.watch('js/**/*.js', ['jscompile']);
});