<!DOCTYPE html>
<html>
	<head>
		<title>{:navgoco} Demo Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Demo page js and css files -->
		<link rel="stylesheet" type="text/css" href="demo.css" media="screen" />
		<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="highlight.pack.js"></script>
		<script src="demo.js"></script>

		<!-- Add JQuery cookie plugin (optional) -->
		<script src="../src/jquery.cookie.js"></script>
		<!-- Add navgoco main js and css files  -->
		<script type="text/javascript" src="../src/jquery.navgoco.js"></script>
		<link rel="stylesheet" type="text/css" href="../src/jquery.navgoco.css" media="screen" />

<script type="text/javascript" id="demo1-javascript">
$(document).ready(function() {
	// Initialize navgoco with default options
	$("#demo1").navgoco({
		caretHtml: '',
		accordion: false,
		openClass: 'open',
		save: true,
		cookie: {
			name: 'navgoco',
			expires: false,
			path: '/'
		},
		slide: {
			duration: 400,
			easing: 'swing'
		},
		// Add Active class to clicked menu item
		onClickAfter: function(e, submenu) {
			e.preventDefault();
			$('#demo1').find('li').removeClass('active');
			var li =  $(this).parent();
			var lis = li.parents('li');
			li.addClass('active');
			lis.addClass('active');
		},
	});

	$("#collapseAll").click(function(e) {
		e.preventDefault();
		$("#demo1").navgoco('toggle', false);
	});

	$("#expandAll").click(function(e) {
		e.preventDefault();
		$("#demo1").navgoco('toggle', true);
	});
});
</script>
<script type="text/javascript" id="demo2-javascript">
$(document).ready(function() {
	$("#demo2").navgoco({accordion: true});
});
</script>
	</head>
	<body>
		<a href="https://github.com/tefra/navgoco/"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://s3.amazonaws.com/github/ribbons/forkme_right_red_aa0000.png" alt="Fork me on GitHub"></a>
		<div class="wrapper">
			<h1 class="logo"><a href="http://www.komposta.net/article/navgoco">navgoco</a></h1>
			<section class="description">
				<span class="navgoco">{:<a href="http://www.komposta.net/article/navgoco">navgoco</a>}</span> is a simple JQuery plugin which turns a nested unordered
				list of links into a beautiful vertical multi-level slide navigation,
				with ability to preserve expanded submenus between sessions by using
				cookies and optionally act as an accordion menu.
				<p>
					<iframe src="http://ghbtns.com/github-btn.html?user=tefra&repo=navgoco&type=watch&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="85" height="20"></iframe>
					<iframe src="http://ghbtns.com/github-btn.html?user=tefra&repo=navgoco&type=fork&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="85" height="20"></iframe>
					<a href="https://twitter.com/share" class="twitter-share-button" data-url="http://www.komposta.net/article/navgoco" data-text="Navgoco: JQuery plugin for beautiful vertical multi-level slide menus." data-hashtags="navgoco">Tweet</a>
					<script>!function(d, s, id) {
							var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
							if (!d.getElementById(id)) {
								js = d.createElement(s);
								js.id = id;
								js.src = p + '://platform.twitter.com/widgets.js';
								fjs.parentNode.insertBefore(js, fjs);
							}
						}(document, 'script', 'twitter-wjs');</script>
				</p>
				<p>
					<strong>
						<a href="http://www.komposta.net/article/navgoco">Homepage</a> |
						<a href="https://github.com/tefra/navgoco">GitHub</a> |
						<a href="http://plugins.jquery.com/navgoco/">JQuery</a> |
						<a href="https://github.com/tefra/navgoco/blob/master/README.md">ReadMe</a> |
						<a href="https://github.com/tefra/navgoco/blob/master/CHANGELOG.md">Changelog v0.2.1</a>
					</strong>
				</p>
				<p class="desc">
					- You can also click the caret/arrow on the right to toggle submenus!<br />
					- Parent menu items can be proper clickable links! (*since v0.2.0)<br />
				</p>
			</section>
			<hr />
			<section>
				<ul class="tabs">
					<li class="active"><a href="#">Default Settings</a></li>
					<li><a href="#">Javascript</a></li>
					<li><a href="#">Html</a></li>
				</ul>
				<div class="panes">
					<div id="demo1-html">
<ul id="demo1" class="nav">
	<li><a href="#">Developer Tools</a></li>
	<li><a href="#">Download</a>
		<ul>
			<li><a href="#"> Setting Up the ADT Bundle</a></li>
			<li><a href="#">Setting Up an Existing IDE</a>
				<ul>
					<li><a href="#"> Installing the Eclipse Plugin</a></li>
					<li><a href="#"> Adding Platforms and Packages</a></li>
				</ul>
			</li>
			<li><a href="#">Android Studio</a>
				<ul>
					<li><a href="#"> Migrating from Eclipse</a></li>
					<li><a href="#"> Tips and Tricks</a></li>
					<li><a href="#"> Using the Layout Editor</a></li>
					<li><a href="#"> Building Your Project with Gradle</a></li>
				</ul>
			</li>
			<li><a href="#"> Exploring the SDK</a></li>
			<li><a href="#">Download the NDK</a></li>
		</ul>
	</li>
	<li><a href="#">Workflow</a>
		<ul>
			<li><a href="#">Setting Up Virtual Devices</a>
				<ul>
					<li><a href="#">With AVD Manager</a></li>
					<li><a href="#">From the Command Line</a></li>
					<li><a href="#">Using the Emulator</a></li>
				</ul>
			</li>
			<li><a href="http://www.google.com">Google</a>
				<ul>
					<li><a href="#">USB Drivers</a></li>
				</ul>
			</li>
			<li><a href="#">Setting Up Projects</a>
				<ul>
					<li><a href="#">From Eclipse with ADT</a></li>
					<li><a href="#">From the Command Line</a></li>
					<li><a href="#">Using Code Templates</a></li>
				</ul>
			</li>
			<li><a href="#">Building and Running</a>
				<ul>
					<li><a href="#">From Eclipse with ADT</a></li>
					<li><a href="#">From the Command Line</a></li>
				</ul>
			</li>
			<li><a href="http://www.google.com">Google</a>
				<ul>
					<li><a href="#"> Fundamentals</a></li>
					<li><a href="#"> From Eclipse</a></li>
					<li><a href="#"> What To Test</a></li>
					<li><a href="#"> Activity Testing Tutorial</a></li>
				</ul>
			</li>
			<li><a href="#">Debugging</a>
				<ul>
					<li><a href="#">From Eclipse with ADT</a></li>
					<li><a href="#">From Other IDEs</a></li>
					<li><a href="#">Using the Dev Tools App</a></li>
				</ul>
			</li>
			<li><a href="http://www.google.com">Google</a>
				<ul>
					<li><a href="#">Preparing for Release</a></li>
					<li><a href="#">Versioning Your Apps</a></li>
					<li><a href="#">Signing Your Apps</a></li>
				</ul>
			</li>
		</ul>
	</li>
	<li><a href="#">Support Library</a>
		<ul>
			<li><a href="#">Features</a></li>
			<li><a href="#">Setup</a></li>
		</ul>
	</li>
	<li><a href="#">Tools Help</a>
		<ul>
			<li><a href="#">adb</a></li>
			<li><a href="#">ADT</a></li>
			<li><a href="#">monkey</a></li>
			<li><a href="#">monkeyrunner</a>
				<ul>
					<li><a href="#">MonkeyDevice</a></li>
					<li><a href="#">MonkeyImage</a></li>
					<li><a href="#">MonkeyRunner</a></li>
				</ul>
			</li>
			<li><a href="#">ProGuard</a></li>
			<li><a href="#">SDK Manager</a></li>
			<li><a href="#">Systrace</a></li>
			<li><a href="#">Tracer for OpenGL ES</a></li>
			<li><a href="#">Traceview</a></li>
			<li><a href="#">uiautomator</a>
				<ul>
					<li><a href="#">Configurator</a></li>
					<li><a href="#">IAutomationSupport</a></li>
					<li><a href="#">UiWatcher</a></li>
				</ul>
			</li>
			<li><a href="#">zipalign</a></li>
		</ul>
	</li>
	<li><a href="#">Revisions</a>
		<ul>
			<li><a href="#"> SDK Tools </a></li>
			<li><a href="#"> ADT Plugin </a></li>
		</ul>
	</li>
	<li><a href="http://www.google.com">Google</a>
		<ul>
			<li><a href="#">ADK 2012 Guide</a></li>
			<li><a href="#">ADK 2011 Guide</a></li>
		</ul>
	</li>
</ul>



<p class="external">
	<a href="#" id="collapseAll">Collapse All</a> | <a href="#" id="expandAll">Expand All</a>
</p>
					</div>
					<pre><code class="javascript" data-source="demo1"></code></pre>
					<pre><code class="html" data-source="demo1"></code></pre>
				</div>
			</section>
			<hr />
			<section>
				<ul class="tabs">
					<li class="active"><a href="#">Accordion</a></li>
					<li><a href="#">Javascript</a></li>
					<li><a href="#">Html</a></li>
				</ul>
				<div class="panes">
					<div id="demo2-html">
						<ul id="demo2" class="nav"></ul>
					</div>
					<pre><code class="javascript" data-source="demo2"></code></pre>
					<pre><code class="html" data-source="demo2"></code></pre>
				</div>
			</section>
			<hr />
			<section>
				<textarea id="console"></textarea>
			</section>
			<hr />
		</div>
		<footer class="copyright">
			Copyright � <a href="http://www.komposta.net">Komposta.net</a> 2014 All Rights Reserved
		</footer>
	</body>
</html>