var webpack = require('webpack');


module.exports = {
    webpack: {
        entry: {
            twitter: './js/twitter.js'
        },
        output: {
            filename: '[name].min.js',
            publicPath: './dist/'
        },
        resolve: {
            extensions: ['', '.js']
        },
        plugins: [
            /*new webpack.optimize.UglifyJsPlugin({
                compress: {
                    warnings: false
                }
            }),*/
            new webpack.ProvidePlugin({
                jQuery: "jquery",
                $: "jquery"
            })]
    }
};