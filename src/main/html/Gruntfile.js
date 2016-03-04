'use strict';

module.exports = function(grunt) {

	var pkg = grunt.file.readJSON('package.json');
	var template = require('grunt-cmd-transport').template.init(grunt);

	grunt.initConfig({
		// Metadata.
		pkg: pkg,
		banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' +
			'<%= grunt.template.today("yyyy-mm-dd") %>\n' +
			'<%= pkg.homepage ? "* " + pkg.homepage + "\\n" : "" %>' +
			'* Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author.name %>;' +
			' Licensed <%= _.pluck(pkg.licenses, "type").join(", ") %> */\n',

		//文件合并
		concat: {
			register: {
				options: {
					pkg: pkg,
					separator: ''
						//paths: ['assets']
				},
				files: {
					'dist/<%= pkg.name %>_ctrl.js': ['src/*.js', 'src/**/*.js'],
					'dist/<%= pkg.name %>.css': ['css/*.css', 'css/**/*.css']
				}
			}
		},

		//js文件压缩插件
		uglify: {
			register: {
				options: {
					//banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' + '<%= grunt.template.today("yyyy-mm-dd") %> */',
					report: "gzip", //输出压缩率，可选的值有 false(不输出信息)，gzip
					mangle: false //不混淆变量名
				},
				files: [{
						expand: true,
						cwd: 'dist/', //js目录下
						src: '**/*.js', //所有js文件
						dest: 'dist/', //输出到此目录下
						ext: '.min.js'
					},


				]
			}
		},

		//css压缩插件
		cssmin: {
			options: {

				//compatibility : 'ie8', //设置兼容模式
				noAdvanced: true //取消高级特性
			},
			minify: {
				expand: true,
				cwd: 'dist/',
				src: '**/*.css', //所有css文件
				dest: 'dist/', //输出到此目录下
				ext: '.min.css'
			}
		},

		//压缩HTML
		htmlmin: {
			options: {
				removeComments: true, //去注析
				removeCommentsFromCDATA: true,
				collapseWhitespace: true, //去换行
				collapseBooleanAttributes: true,
				removeAttributeQuotes: true,
				removeRedundantAttributes: true,
				useShortDoctype: true,
				removeEmptyAttributes: true,
				removeOptionalTags: true
			},
			html: {
				files: [{
						expand: true,
						cwd: 'src/templates/', //源文件路径
						src: ['**/*.html'],
						dest: 'dist/templates', //目标文件路径
						ext: '.html'
					},
					// index.html 特殊处理
					{
						expand: true,
						cwd: 'src/index/', //源文件路径
						src: ['index.html'],
						dest: './' //目标文件路径
					}

				]
			}
		},

		copy: {

//			tmpl: {
//				src: 'dist/<%= pkg.name %>_templates.tpl',
//				dest: 'dist/<%= pkg.name %>_templates.js',
//				options: {
//					process: function(content, srcpath) {
//						return "mvc.template = '<div>" + content.replace(/\r/g, " ").replace(/\n/g, " ").replace(/\'/g, "\\'") + "</div>';";
//					},
//				},
//			},
//
//			css: {
//				files: [{
//					expand: true,
//					cwd: 'src/css/',
//					src: ['**/*.css'],
//					dest: 'dist/'
//				}]
//			},
			main: {
				files: [{
					expand: true,
					cwd: 'dist/',
					src: ['**'],
					dest: '../webapp/statics/assets/<%= pkg.family %>/<%= pkg.name %>/<%= pkg.version %>/'
				}]
			}
		},

		combo: {
			options: {
				sourceMap: {
					//sourceRoot: '/src/'
				}
			},
			build: {
				files: [{
					expand: true,
					cwd: 'src/',
					src: '**/*.js',
					dest: 'dist/combo/',
					ext: '.combo.js'
				}]
			}
		},
		//清除
		clean: {
			cleandist: {
				files: [{
					src: 'dist/'
				}]
			}
		},


		nodeunit: {
			files: ['tests/**/*_test.js']
		},
		jshint: {
			options: {
				jshintrc: '.jshintrc'
			},
			gruntfile: {
				src: 'Gruntfile.js'
			},
			lib: {
				options: {
					jshintrc: 'src/.jshintrc'
				},
				src: ['dest/*.js']
			},
			test: {
				src: ['test/**/*.js']
			},
		},

		watch: {
			js: {
				files: ['../js/src/*/*.js', '../js/src/*/*/*.js', '../js/src/*/*/*/*.js'],
				tasks: ['build'],
				options: {
					spawn: true,
					interrupt: true
				}
			},
			css: {
				files: ['../css/src/*.css', '../css/src/*/*.css'],
				tasks: ['build'],
				options: {
					spawn: true,
					interrupt: true
				}
			},
			html: {
				files: ['../html/src/*.html', '../html/src/template/*/*.html'],
				tasks: ['build'],
				options: {
					spawn: true,
					interrupt: true
				}
			}
		}
	});

	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-combopage');
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	grunt.loadNpmTasks('grunt-contrib-nodeunit');
	grunt.loadNpmTasks('grunt-contrib-copy');
	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-contrib-connect');
	grunt.loadNpmTasks('grunt-contrib-qunit');
	grunt.loadNpmTasks('grunt-contrib-htmlmin');



	//grunt.registerTask('default', ['clean']);	

	grunt.registerTask('default', ['clean', 'concat', 'uglify', 'cssmin','copy']);



	//插件安装命令
	//npm install grunt-contrib-htmlmin --save-dev
};