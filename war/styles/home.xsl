<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet exclude-result-prefixes="xsl" version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output indent="yes" method="html" omit-xml-declaration="yes" />

	<xsl:template match="session">
		<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;
</xsl:text>
		<html lang="en">
			<head>
				<meta charset="utf-8" />
				<meta name="viewport" content="width=300, initial-scale=1" />
				<title>Steven Layton Photography</title>
				<link href="styles/home.css" rel="stylesheet" />
				<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'
					type='text/css' />
					<link href='http://fonts.googleapis.com/css?family=Rouge+Script' rel='stylesheet' type='text/css' />
				<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" />
				<script src="styles/home.js" />
			</head>
			<body>
				<div class="menuselect">
					<img src="menu.png" />
				</div>
				<div class="main flexcontainer hidden">
					
					<div class="albumname flexcontainer">
						Home
						<div class="hidden">
							<div class="home">
								<h1>Steven Laytons Photography</h1>
								<div class='slideshowbob'>
								<div class="slideshowdata hidden">
								
								<xsl:apply-templates select="datastore/albums/Album[Albumname='Slide Show']" />
								
								</div>
								<div class='slideshowview' >
								</div>
								</div>
							</div>
				</div>
							
						</div>  
						<!--  home end -->
						
					
					
					
<div class="albumname flexcontainer">
Contact
<div class="hidden">
	<div class="contact">
	
					<ul>
						<li>Steven Layton</li>
						<li>Email: laytonsound@hotmail.com</li>
						<li>Phone: 1 (403) 360-3602</li>
						
					</ul>
				<div id="fb-root"></div>

<div class="fb-like-box" data-href="https://www.facebook.com/pages/S-Layton-Photography/121599421197706" data-width="500" data-height="1000" data-colorscheme="light" data-show-faces="true" data-header="false" data-stream="true" data-show-border="false"></div>
	</div>
</div>
</div>
					
					<div class="albumname flexcontainer">
						About
						<div class="hidden">
							<div class="about">
								<img class="flexitem" src="http://lh5.googleusercontent.com/-G93tNOsZfX8/T0WtLPEvSxI/AAAAAAAAABQ/-Jfp7Kqa0xc/s300/_DSC4249-Edit.jpg" />
								<p class="flexitem" >Steven Layton was born and raised in a Raymond, Alberta,
									Canada. It was always apparent to others, even before Steven
									knew it, that he was highly into the arts. Throughout his
									school years Steven was involved in drawing, singing, acting,
									choreographing, dance, and music, but it wasn't until he
									bought his first pro camera that his true talents began to
									shine. Almost immediately after diving into the photography
									field, his photos were published commercially for a project
									in 2010. Steven has prided himself in the ability to take
									photos of a small town that show off its natural beauty
									through his artistic view. With a little bit of edge, and his
									love for lighting, he creates photos that the public adores.
									His love for photography extends from nature photography to
									portraits and weddings. It is his personal preference to not
									to pose his subjects, but rather to promote a fun and
									friendly atmosphere where he can capture natural, real
									happiness on print. For more information, please check out
									his website and the testimonials others have shared about
									their experiences with him.</p>
							</div>
						</div>
					</div>
					<div class="albumname flexcontainer">
						Testimonials
						<div class="hidden">
							<div class="testimonials">
								<div class="testimonial">
		<img
			src="https://lh6.googleusercontent.com/-Hefkh_LbCFE/UJ1qG6bmUCI/AAAAAAAAAB4/DgYyzDfrG8s/s450/486880_496824243675220_592478099_n.jpg"
			alt="" />
		<p>Working with Steven was amazing. He is so creative and great to
			work with. We did a shoot for almost 8 hours and I did not feel tired
			or bored at any time because the creativity was amazing and kept the
			shoot fun and awesome. As an upcoming music artist, Images help sell
			your song/views and thanks to Steven for giving me more exposure
			through his pictures. Look forward to more pictures with him.</p>
		<ul>
			<li>Mc soprano</li>
			<li>mcsoprano.tumblr.com www.soundcloud.com/mcsoprano</li>
		</ul>
	</div>
	<div class="testimonial">
		<img
			src="https://lh6.googleusercontent.com/-bG_-q-YgDE4/UJ1qGxJ76OI/AAAAAAAAAB8/A_pDdkGe-vs/s450/473810_453206178037027_496977183_o.jpg"
			alt="" />
		<p>Steven was amazing with my kids. They both are bundles of
			energy who can't sit still. Especially for a camera. I needed a
			family photo fast and knew that a regular sit down session wasn't an
			option. When we got to Steve's studio both girls were not in the mood
			to smile or participate. Steven was so patient and gave great ideas
			and worked with their bad attitude. The result was phenomenal! The
			pictures were more than I ever hoped for. It was hard to choose which
			one I liked best. Steven Layton is the only person I will ever use to
			take any kind of photos I will ever need. I recommend him to
			everyone. Worth every second of time and penny I spent. Very
			reasonable and fast turn around in getting my pictures back. He's
			amazing!!!!</p>
		<ul>
			<li>Marianne Hillyer</li>
		</ul>
	</div>
	<div class="testimonial">
		<img
			src="https://lh6.googleusercontent.com/-2dotC_-yTpw/T0XCFDo0sAI/AAAAAAAAABs/khFcW-vCrWk/s450/_MG_1621.JPG"
			alt="" />
		<p>One year ago, the day before my Wedding, my photographer
			canceled on me. I frantically thought of who I knew that had worked
			in the field, and a childhood friend came to mind. Willing to drop
			everything, Steven came to my rescue and informed me he would take
			care of everything. The next day I received top quality service in a
			very professional manner as well as being impressed by his extensive
			knowledge of techniques. I had hoped the pictures would turn out
			great, but when revealed I was more than amazed! His pictures
			captured just the right light, textures and of course us as clients.
			After he had edited them, they were definitely the best pictures I
			have owned. I am so glad I had Steven pull through for my Wedding, so
			I can now look back at my special day with fond memories and amazing
			pictures. I recommend Steven Layton's Photography to anyone looking
			for a unique and personal picture that has that special touch. And I
			personally can't wait to get more photos done.</p>
		<ul>
			<li>Stacy West</li>
		</ul>
	</div>
	<div class="testimonial">
			<p>You are a fantastic photographer and very easy to work with. As
			a model, your pictures have helped to improve my portfolio and
			increase my fan base and I always look forward to more shoots with
			you!! Thanks for all your help and support!</p>
		<ul>
			<li>Alyssa Mahovlic (Model)</li>
		</ul>
	</div>
	<div class="testimonial">
		<img
			src="https://lh6.googleusercontent.com/-bzK3Z94MSsU/UL0KSP-n_JI/AAAAAAAAACs/RkYK865zGKU/s450/sarah_maternity.jpg"
			alt="" />
		<p>My sister and I were lucky enough to be expecting, at the same
			time. We approached Steven Layton Photography because of the skill,
			creativity and attention to detail we saw on his website and were not
			disappointed by the results! I think what we liked best (aside from
			the stellar photographs we received) was that we were able to bring
			our ideas to him and having him put his creative spin on them, ended
			up with pictures that illustrated our unity as a family, but also our
			difference in styles. The studio setting at his home was both private
			and relaxing where we felt comfortable to express ourselves in the
			way we wanted to. Plus, it was a lot of fun! In reflecting on the
			experience and the end results, we really feel fortunate to have made
			the choice to use his professional services. Without that choice
			being made, we wouldn't have the wonderful memories of our
			pregnancies and growing family in the beautiful pictures we have been
			proud to share with everyone we know! We look forward to recording
			more of our memories with Steven as our photographer! Well worth the
			trip from Calgary to Lethbridge and we'd do it again! Great job!!!</p>
		<ul>
			<li>Sarah Noelle Pearson</li>
		</ul>
	</div>
	<div class="testimonial">
	
		<p>I am completely impressed with the professionalism maintained
			during my very personal shoot. I felt thoroughly at ease and was able
			to collaborate my raw idea with Steven's artistic talent. The result
			was breathtaking, healing, and genuinely a pleasure to pore over.
			Steven's patience in deciding and exploring lighting, poses, and
			angles yielded perfect results, and gave me the opportunity to
			capture exactly the images and emotions I had visualized in my mind.
			Thank you so much for agreeing to go through this process with me; it
			gave me courage, hope, and peace. - Amanda </p>

	</div>
							</div>
						</div>
					</div>
					
					<xsl:apply-templates select="datastore/albums/Album" />
				</div> 
				
				<!--  end main menu -->

<!--  view and inititial contents -->
				<div class="view flexcontainer">
					<div class="home">
								<h1>Steven Laytons Photography</h1>
								<div class='slideshowbob'>
								<div class="slideshowdata hidden">
								bla bla
								<xsl:apply-templates select="datastore/albums/Album[Albumname='Slide Show']/Photos/Photo" />
								
								</div>
								<div class='slideshowview' >
								</div>
								</div>
							</div>
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="Album"> 
	 <xsl:if test="not(Albumname ='Slide Show')"> 
		
		<div class="albumname flexcontainer">
			<xsl:value-of select="Albumname"></xsl:value-of>
			<div class="photos hidden">
				<xsl:apply-templates select="Photos/Photo">
				</xsl:apply-templates>
			</div>
		</div>
		</xsl:if>
	
	</xsl:template>

	<xsl:template match="Photo">
		<div class="photo flexitem">
			<img>
				<xsl:attribute name="src"> <xsl:value-of
					select="Folder" /> 
	<xsl:text>/s450</xsl:text> 
	<xsl:value-of select="File" />
	</xsl:attribute>
			</img>
		</div>
	</xsl:template>


	<!-- <xsl:template match="Photo" > <div class="photo flexitem"> <img> <xsl:attribute 
		name="src"> <xsl:value-of select="Folder"/> <xsl:text>/s100</xsl:text> <xsl:value-of 
		select="File"/></xsl:attribute> </img> </div> </xsl:template> -->
	<xsl:template match="text()|@*" />
</xsl:stylesheet>