const fs = require('fs');
const path = require('path');
const webpack = require('webpack');
const OptimizeCSSAssetsPlugin = require("optimize-css-assets-webpack-plugin");
const TerserJSPlugin = require("terser-webpack-plugin");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const autoprefixer = require('autoprefixer');
const FaviconsWebpackPlugin = require('favicons-webpack-plugin')

const isProd = process.env.NODE_ENV === 'production';
// const hash6 = '.[hash:6]';
const hash6 = '';

module.exports = {
  mode: isProd ? 'production' : 'development',
  entry: {
    index: './src/views/index/index.js',
    bicycleList: './src/views/bicycle-list/bicycle-list.js',
    myOrders: './src/views/my-orders/my-orders.js',
    bicyclePage: './src/views/bicycle-page/bicycle-page.js'
  },
  output: {
    path: path.resolve(__dirname, '../src/main/resources/static/'),
    filename: 'js/[name]'+hash6+'.js',
    publicPath: '/'
  },

  //для webpack-dev-server
  devServer: {
    contentBase: path.resolve(__dirname, '../src/main/resources/static/'),
    writeToDisk: true,
    allowedHosts: [
      'localhost',
      '127.0.0.1'
    ],
    host: '0.0.0.0', // разрешаем доступ всем
    port: 3000
    // quiet: true // если true, не пишет подробные логи в консоль
    // hot: true,
    // stats: 'errors-only'
  },

  optimization: {
    splitChunks: {
      cacheGroups: {
        vendors: {
          name: 'vendors',
          test: /[\\/]node_modules[\\/]/,
          chunks: 'all',
          enforce: true
        }
      }
    },
    minimizer: [
      new OptimizeCSSAssetsPlugin({
        assetNameRegExp: /\.css$/g,
      }),
      new TerserJSPlugin({
        terserOptions: {
          output: {
            comments: false,
          },
        },
      })
    ]
  },

  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        loader: 'babel-loader'
      },

      {
        test: /\.html$/i,
        use: [
          {
            loader: 'html-loader',
            options: {
              // attributes: false,
              // esModule: false,

              preprocessor: (content, loaderContext) => {
                const replacer = (content, loaderContextPath) => {
                  return content.replace(
                    // replace <include src="..." /> tag
                    /<include src="(.+)"\s*\/?>(?:<\/include>)?/gi,
                    (inc, src) => {
                      const filePath = path.resolve(loaderContextPath, src)
                      loaderContext.dependency(filePath)
                      return replacer(
                        fs.readFileSync(filePath, 'utf8'),
                        path.dirname(filePath)
                      )
                    }
                  )
                }
                return replacer(content, path.resolve(loaderContext.context))
              }

            }

          }
        ]
      },

      {
        test: /\.(sa|sc|c)ss$/,
        use: [
          isProd ? {
            loader: MiniCssExtractPlugin.loader,
            options: {
              publicPath: '/css/',
            }
          } : 'style-loader',
          {
            loader: 'css-loader', // translates CSS into CommonJS modules
          },
          {
            loader: 'postcss-loader', // Run postcss actions
            options: {
              postcssOptions: {
                // postcss plugins, can be exported to postcss.config.js
                plugins: () => [autoprefixer()]
              }
            }
          },
          {
            loader: 'sass-loader',
            options: {
              sassOptions: {
                includePaths: ['./node_modules']
              }
            }
          }]
      },

      {
        test: /\.(jpe?g|png|svg|gif|ico|webp)$/i,
        // exclude: /node_modules/,
        loader: 'file-loader',
        options: {
          name: '[name]'+hash6+'.[ext]',
          outputPath: '../static/img',
          publicPath: '/img'
        }
      },

      {
        test: /\.(woff|woff2|eot|ttf)$/,
        loader: 'file-loader',
          options: {
            outputPath: '../static/fonts',
            publicPath: '/fonts'
          }
      }
    ]
  },
  plugins: [

    new MiniCssExtractPlugin({
      // Options similar to the same options in webpackOptions.output
      // both options are optional
      filename: 'css/[name]'+hash6+'.css',
    }),

    new webpack.ProvidePlugin({
      'window.jQuery': 'jquery',
      $: 'jquery',
      jQuery: 'jquery'
    }),

    new FaviconsWebpackPlugin({
      logo: './assets/images/logos/icon.png',
      prefix: 'img/',
    }),

    new HtmlWebpackPlugin({
      filename: '../templates/index.html',
      template: './src/views/index/index.html',
      chunks: ['vendors', 'index']
    }),

    new HtmlWebpackPlugin({
      filename: '../templates/bicycle-list.html',
      template: './src/views/bicycle-list/bicycle-list.html',
      chunks: ['vendors', 'bicycleList']
    }),

    new HtmlWebpackPlugin({
      filename: '../templates/my-orders.html',
      template: './src/views/my-orders/my-orders.html',
      chunks: ['vendors', 'myOrders']
    }),
    new HtmlWebpackPlugin({
      filename: '../templates/bicycle-page.html',
      template: './src/views/bicycle-page/bicycle-page.html',
      chunks: ['vendors', 'bicyclePage']
    })

  ]
};
