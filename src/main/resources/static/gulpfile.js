var gulp = require('gulp');
var scss = require('gulp-sass');
var uglify = require('gulp-uglify');
var webpack = require('gulp-webpack');
var babel = require('gulp-babel');
var plumber = require('gulp-plumber');
var autoPrefixer = require('gulp-autoprefixer');

//PATH
var TARGET_PATH = '../../../../target/classes/static/';
var THYMELEAF_PATH = '../../../../target/classes/templates/';

//command definition
var scssCompile = 'stylesheet';
var jsCompile = 'javascript';
var htmlCopy = 'thymeleaf';
var imgCopy = 'img';
var bower = 'bower';

//config
var config = require('./webpack.config');

gulp.task(scssCompile, function () {
    gulp.src('scss/**/*.scss')
        .pipe(plumber())
        .pipe(scss({
            outputStyle: 'compressed'
        }))
        .pipe(autoPrefixer())
        .pipe(gulp.dest(TARGET_PATH + 'css'))
        .pipe(gulp.dest('css'));
});

gulp.task(jsCompile, function () {
    gulp.src('js/**/*.js')
        .pipe(plumber())
        .pipe(webpack(config.webpack))
        .pipe(babel({
            presets:['es2015']
        }))
        //.pipe(uglify())
        .pipe(gulp.dest(TARGET_PATH + 'dist'))
        .pipe(gulp.dest('dist'));
});

gulp.task(htmlCopy, function () {
    gulp.src('../templates/**/*.html')
        .pipe(gulp.dest(THYMELEAF_PATH));
});

gulp.task(imgCopy, function () {
    gulp.src('img/**/*')
        .pipe(gulp.dest(TARGET_PATH + "img"));
});

gulp.task('default', [scssCompile, jsCompile, htmlCopy, imgCopy, bower]);

gulp.task('watch', function () {
    gulp.watch('scss/**/*.scss', [scssCompile]);
    gulp.watch('js/**/*.js', [jsCompile]);
    gulp.watch('img/**/*', [imgCopy]);
    gulp.watch('../templates/**/*.html', [htmlCopy]);
    gulp.watch('lib/**/*', [bower]);
});

gulp.task(bower, function () {
    gulp.src('bower_components/**/*.min.{js,css}')
        .pipe(gulp.dest('./dist/lib'))
        .pipe(gulp.dest(TARGET_PATH + "dist/lib"));
});