<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index Page</title>
<!-- font awesome cdn link -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<!-- custom css file link -->
<link rel="stylesheet" href="styles.css">
</head>

<body>
	<!-- header section starts -->
	<header class="header">

		<a href="#" class="logo"> <svg xmlns="http://www.w3.org/2000/svg"
				fill="currentColor" class="bi bi-cup-hot" viewBox="0 0 16 16">
                <path fill-rule="evenodd"
					d="M.5 6a.5.5 0 0 0-.488.608l1.652 7.434A2.5 2.5 0 0 0 4.104 16h5.792a2.5 2.5 0 0 0 2.44-1.958l.131-.59a3 3 0 0 0 1.3-5.854l.221-.99A.5.5 0 0 0 13.5 6zM13 12.5a2 2 0 0 1-.316-.025l.867-3.898A2.001 2.001 0 0 1 13 12.5M2.64 13.825 1.123 7h11.754l-1.517 6.825A1.5 1.5 0 0 1 9.896 15H4.104a1.5 1.5 0 0 1-1.464-1.175" />
                <path
					d="m4.4.8-.003.004-.014.019a4 4 0 0 0-.204.31 2 2 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.6.6 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3 3 0 0 1-.202.388 5 5 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 3.6 4.2l.003-.004.014-.019a4 4 0 0 0 .204-.31 2 2 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.6.6 0 0 0-.09-.252A4 4 0 0 0 3.6 2.8l-.01-.012a5 5 0 0 1-.37-.543A1.53 1.53 0 0 1 3 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a6 6 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 4.4.8m3 0-.003.004-.014.019a4 4 0 0 0-.204.31 2 2 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.6.6 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3 3 0 0 1-.202.388 5 5 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 6.6 4.2l.003-.004.014-.019a4 4 0 0 0 .204-.31 2 2 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.6.6 0 0 0-.09-.252A4 4 0 0 0 6.6 2.8l-.01-.012a5 5 0 0 1-.37-.543A1.53 1.53 0 0 1 6 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a6 6 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 7.4.8m3 0-.003.004-.014.019a4 4 0 0 0-.204.31 2 2 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.6.6 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3 3 0 0 1-.202.388 5 5 0 0 1-.252.382l-.019.025-.005.008-.002.002A.5.5 0 0 1 9.6 4.2l.003-.004.014-.019a4 4 0 0 0 .204-.31 2 2 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.6.6 0 0 0-.09-.252A4 4 0 0 0 9.6 2.8l-.01-.012a5 5 0 0 1-.37-.543A1.53 1.53 0 0 1 9 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a6 6 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 10.4.8" />
            </svg>
		</a>

		<nav class="navbar">
			<a href="#home">home</a> <a href="#about">about</a> <a href="#menu">menu</a>
			<a href="#products">products</a> <a href="#review">review</a> <a
				href="#contact">contact</a> <a href="#blogs">blogs</a>
		</nav>

		<div class="icons">
			<a href="<c:url value='registerMember.jsp' />"><div
					class="fas fa-user" id="user-btn"></div></a> <a
				href="<c:url value='/queryAllMembers' />"><div
					class="fas fa-users" id="users-btn"></div></a>

			<div class="fas fa-search" id="search-btn"></div>
			<div class="fas fa-shopping-cart icons-cart" id="cart-btn">
				<span>0</span>
			</div>

			<div class="fas fa-bars" id="menu-btn"></div>
		</div>

		<div class="search-form">
			<input type="search" id="search-box" placeholder="Search anything..."
				autocomplete="off"> <label for="search-box"
				class="fas fa-search"></label>
		</div>

		<div class="cart-items-container">
			<div class="cart-item">
				<span class="fas fa-times"></span> <img
					src="https://placehold.co/400x400" alt="1">
				<div class="content">
					<h3>Cart Item 01</h3>
					<div class="price">15.99</div>
				</div>
			</div>
			<div class="cart-item">
				<span class="fas fa-times"></span> <img
					src="https://placehold.co/400x400" alt="1">
				<div class="content">
					<h3>Cart Item 02</h3>
					<div class="price">16.99</div>
				</div>
			</div>
			<div class="cart-item">
				<span class="fas fa-times"></span> <img
					src="https://placehold.co/400x400" alt="1">
				<div class="content">
					<h3>Cart Item 03</h3>
					<div class="price">17.99</div>
				</div>
			</div>
			<div class="cart-item">
				<span class="fas fa-times"></span> <img
					src="https://placehold.co/400x400" alt="1">
				<div class="content">
					<h3>Cart Item 04</h3>
					<div class="price">18.99</div>
				</div>
			</div>
			<a href="#" class="btn">checkout now</a>
		</div>
	</header>
	<!-- header section ends -->

	<!-- home section starts -->
	<section class="home" id="home">
		<div class="content">
			<h3>heading3</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ex,
				dolorem placeat. Quaerat, sapiente! Culpa inventore dolores libero
				voluptas eius molestiae aspernatur incidunt aut odio! Rerum amet
				unde laudantium eaque nesciunt!</p>
			<a href="#" class="btn">Get Yours Now</a>
		</div>
	</section>
	<!-- home section ends -->

	<!-- about section starts -->
	<section class="about" id="about">
		<h1 class="heading">
			<span>about</span> us
		</h1>
		<div class="row">
			<div class="image">
				<img src="https://placehold.co/400x400" alt="400x400">
			</div>
			<div class="content">
				<h3>what makes our coffee special?</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.
					Molestiae maxime voluptatum ab laudantium repudiandae ullam
					doloremque et, sit incidunt accusamus suscipit repellendus iure,
					fuga facere quo, tenetur veritatis aliquam voluptatem.</p>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
				<a href="#" class="btn">learn more</a>
			</div>
		</div>
	</section>
	<!-- about section ends -->

	<!-- menu section starts -->
	<section class="menu" id="menu">
		<h1 class="heading">
			our <span>menu</span>
		</h1>
		<div class="box-container">

			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>
			<div class="box">
				<img src="https://placehold.co/300x300" alt="300x300">
				<h3>tasty and healthy</h3>
				<div class="price">
					$15.99 <span>20.99</span>
				</div>
				<a href="#" class="btn">add to cart</a>
			</div>

		</div>

	</section>
	<!-- menu section ends -->

	<!-- products section starts -->
	<section class="products" id="products">
		<h1 class="heading">
			our <span>products</span>
		</h1>
		<div class="box-container">

			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-eye"></a>
				</div>
				<div class="image">
					<img src="https://placehold.co/300x300" alt="300x300">
				</div>
				<div class="content">
					<h3>fresh coffee</h3>
					<div class="stars">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star-half-alt"></i>
					</div>
					<div class="price">
						$15.99 <span>$20.99</span>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- products section ends -->

	<!-- review section starts -->
	<section class="review" id="review">
		<h1 class="heading">
			customer's <span>review</span>
		</h1>
		<div class="box-container">
			<div class="box">
				<span class="quote"> <svg xmlns="http://www.w3.org/2000/svg"
						fill="currentColor" class="bi bi-chat-right-quote-fill"
						viewBox="0 0 16 16">
                        <path
							d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h9.586a1 1 0 0 1 .707.293l2.853 2.853a.5.5 0 0 0 .854-.353zM7.194 4.766q.13.188.227.401c.428.948.393 2.377-.942 3.706a.446.446 0 0 1-.612.01.405.405 0 0 1-.011-.59c.419-.416.672-.831.809-1.22-.269.165-.588.26-.93.26C4.775 7.333 4 6.587 4 5.667S4.776 4 5.734 4c.271 0 .528.06.756.166l.008.004c.169.07.327.182.469.324q.128.125.227.272M11 7.073c-.269.165-.588.26-.93.26-.958 0-1.735-.746-1.735-1.666S9.112 4 10.069 4c.271 0 .528.06.756.166l.008.004c.17.07.327.182.469.324q.128.125.227.272.131.188.228.401c.428.948.392 2.377-.942 3.706a.446.446 0 0 1-.613.01.405.405 0 0 1-.011-.59c.42-.416.672-.831.81-1.22z" />
                    </svg>
				</span>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi
					ut maxime explicabo aliquid ratione fugit culpa facere.</p>
				<img src="https://placehold.co/100x100" alt="100x100" class="user">
				<h3>john deo</h3>
				<div class="stars">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i>
				</div>
			</div>
			<div class="box">
				<span class="quote"> <svg xmlns="http://www.w3.org/2000/svg"
						fill="currentColor" class="bi bi-chat-right-quote-fill"
						viewBox="0 0 16 16">
                        <path
							d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h9.586a1 1 0 0 1 .707.293l2.853 2.853a.5.5 0 0 0 .854-.353zM7.194 4.766q.13.188.227.401c.428.948.393 2.377-.942 3.706a.446.446 0 0 1-.612.01.405.405 0 0 1-.011-.59c.419-.416.672-.831.809-1.22-.269.165-.588.26-.93.26C4.775 7.333 4 6.587 4 5.667S4.776 4 5.734 4c.271 0 .528.06.756.166l.008.004c.169.07.327.182.469.324q.128.125.227.272M11 7.073c-.269.165-.588.26-.93.26-.958 0-1.735-.746-1.735-1.666S9.112 4 10.069 4c.271 0 .528.06.756.166l.008.004c.17.07.327.182.469.324q.128.125.227.272.131.188.228.401c.428.948.392 2.377-.942 3.706a.446.446 0 0 1-.613.01.405.405 0 0 1-.011-.59c.42-.416.672-.831.81-1.22z" />
                    </svg>
				</span>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi
					ut maxime explicabo aliquid ratione fugit culpa facere.</p>
				<img src="https://placehold.co/100x100" alt="100x100" class="user">
				<h3>john deo</h3>
				<div class="stars">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i>
				</div>
			</div>
			<div class="box">
				<span class="quote"> <svg xmlns="http://www.w3.org/2000/svg"
						fill="currentColor" class="bi bi-chat-right-quote-fill"
						viewBox="0 0 16 16">
                        <path
							d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h9.586a1 1 0 0 1 .707.293l2.853 2.853a.5.5 0 0 0 .854-.353zM7.194 4.766q.13.188.227.401c.428.948.393 2.377-.942 3.706a.446.446 0 0 1-.612.01.405.405 0 0 1-.011-.59c.419-.416.672-.831.809-1.22-.269.165-.588.26-.93.26C4.775 7.333 4 6.587 4 5.667S4.776 4 5.734 4c.271 0 .528.06.756.166l.008.004c.169.07.327.182.469.324q.128.125.227.272M11 7.073c-.269.165-.588.26-.93.26-.958 0-1.735-.746-1.735-1.666S9.112 4 10.069 4c.271 0 .528.06.756.166l.008.004c.17.07.327.182.469.324q.128.125.227.272.131.188.228.401c.428.948.392 2.377-.942 3.706a.446.446 0 0 1-.613.01.405.405 0 0 1-.011-.59c.42-.416.672-.831.81-1.22z" />
                    </svg>
				</span>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi
					ut maxime explicabo aliquid ratione fugit culpa facere.</p>
				<img src="https://placehold.co/100x100" alt="100x100" class="user">
				<h3>john deo</h3>
				<div class="stars">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i>
				</div>
			</div>
			<div class="box">
				<span class="quote"> <svg xmlns="http://www.w3.org/2000/svg"
						fill="currentColor" class="bi bi-chat-right-quote-fill"
						viewBox="0 0 16 16">
                        <path
							d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h9.586a1 1 0 0 1 .707.293l2.853 2.853a.5.5 0 0 0 .854-.353zM7.194 4.766q.13.188.227.401c.428.948.393 2.377-.942 3.706a.446.446 0 0 1-.612.01.405.405 0 0 1-.011-.59c.419-.416.672-.831.809-1.22-.269.165-.588.26-.93.26C4.775 7.333 4 6.587 4 5.667S4.776 4 5.734 4c.271 0 .528.06.756.166l.008.004c.169.07.327.182.469.324q.128.125.227.272M11 7.073c-.269.165-.588.26-.93.26-.958 0-1.735-.746-1.735-1.666S9.112 4 10.069 4c.271 0 .528.06.756.166l.008.004c.17.07.327.182.469.324q.128.125.227.272.131.188.228.401c.428.948.392 2.377-.942 3.706a.446.446 0 0 1-.613.01.405.405 0 0 1-.011-.59c.42-.416.672-.831.81-1.22z" />
                    </svg>
				</span>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi
					ut maxime explicabo aliquid ratione fugit culpa facere.</p>
				<img src="https://placehold.co/100x100" alt="100x100" class="user">
				<h3>john deo</h3>
				<div class="stars">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i>
				</div>
			</div>
		</div>
	</section>
	<!-- review section ends -->

	<!-- contact section stars -->
	<section class="contact" id="contact">
		<h1 class="heading">
			<span>contact</span> us
		</h1>
		<div class="row">
			<iframe class="map"
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3640.833216537646!2d120.64989696238233!3d24.14249467704755!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x34693d1536df30a5%3A0x9ee138ca9e85abd!2zY2FtYSBjYWbDqSDlj7DkuK3lpKfloqnlupc!5e0!3m2!1szh-TW!2stw!4v1710742220189!5m2!1szh-TW!2stw"
				allowfullscreen="" loading="lazy"
				referrerpolicy="no-referrer-when-downgrade"></iframe>
			<form action="">
				<h3>get in touch</h3>
				<div class="inputBox">
					<span class="fas fa-user"></span> <input type="text"
						placeholder="name">
				</div>
				<div class="inputBox">
					<span class="fas fa-envelope"></span> <input type="email"
						placeholder="email">
				</div>
				<div class="inputBox">
					<span class="fas fa-phone"></span> <input type="number"
						placeholder="number">
				</div>
				<input type="submit" value="contact now" class="btn">
			</form>
		</div>
	</section>
	<!-- contact section ends -->

	<!-- blogs section starts -->
	<section class="blogs" id="blogs">
		<h1 class="heading">
			our <span>blogs</span>
		</h1>
		<div class="box-container">
			<div class="box">
				<div class="image">
					<img src="https://placehold.co/200x200" alt="200x200">
				</div>
				<div class="content">
					<a href="#" class="title">tasty and refreshing coffee</a> <span>by
						admin / 21st may, 2021</span>
					<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.
						Nobis deleniti sit porro officiis quia inventore corrupti
						asperiores blanditiis eveniet dicta id quo facilis repellat iure
						fuga earum quod, impedit reiciendis!</p>
					<a href="#" class="btn">read more</a>
				</div>
			</div>
			<div class="box">
				<div class="image">
					<img src="https://placehold.co/200x200" alt="200x200">
				</div>
				<div class="content">
					<a href="#" class="title">tasty and refreshing coffee</a> <span>by
						admin / 21st may, 2021</span>
					<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.
						Nobis deleniti sit porro officiis quia inventore corrupti
						asperiores blanditiis eveniet dicta id quo facilis repellat iure
						fuga earum quod, impedit reiciendis!</p>
					<a href="#" class="btn">read more</a>
				</div>
			</div>
			<div class="box">
				<div class="image">
					<img src="https://placehold.co/200x200" alt="200x200">
				</div>
				<div class="content">
					<a href="#" class="title">tasty and refreshing coffee</a> <span>by
						admin / 21st may, 2021</span>
					<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.
						Nobis deleniti sit porro officiis quia inventore corrupti
						asperiores blanditiis eveniet dicta id quo facilis repellat iure
						fuga earum quod, impedit reiciendis!</p>
					<a href="#" class="btn">read more</a>
				</div>
			</div>
		</div>
	</section>
	<!-- blogs section ends -->

	<!-- footer section starts -->
	<section class="footer">
		<div class="share">
			<a href="#" class="fab fa-facebook-f"></a> <a href="#"
				class="fab fa-twitter"></a> <a href="#" class="fab fa-instagram"></a>
			<a href="#" class="fab fa-linkedin"></a> <a href="#"
				class="fab fa-pinterest"></a>
		</div>
		<div class="links">
			<a href="#home">home</a> <a href="#about">about</a> <a href="#menu">menu</a>
			<a href="#products">products</a> <a href="#review">review</a> <a
				href="#contact">contact</a> <a href="#blogs">blogs</a>
		</div>
		<div class="credit">
			created by <span>mr. web designer</span> | all rights reserved
		</div>
	</section>
	<!-- footer section ends -->

	<!-- custom js file link -->
	<script src="script.js"></script>
</body>

</html>