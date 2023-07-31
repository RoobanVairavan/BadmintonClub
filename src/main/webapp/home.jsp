<html>
<head>
    <style>
        /* Style for headings */
         h1 {
            color:000000 ; /* Set heading color */
            margin-top: 30px; /* Add top margin */
            font-family: 'OharaGinka', sans-serif;
            font-size: 100px;
        }

        /* Style for buttons */
      button {
  		font-family: 'MagicRainbow', sans-serif;
 		font-size: 25px;
  		background-color: #E185AD; /* Set button color */
  		color: white; /* Set text color */
  		border-radius: 7px; /* Round button edges */
  		padding: 10px 20px; /* Add padding */
  		margin-top: 10px; /* Add top margin */
  		border: none; /* Remove button border */
  		cursor: pointer; /* Add pointer cursor on hover */
  		transition: background-color 0.3s ease-in-out; /* Add transition effect */
		}
     
        /* Center align all content within the body */
        body {
            text-align: center;
            background-image: url('Sky.jpg');
            background-size: cover;
            background-position: center center;
        }
        
        @font-face {
  		font-family: 'OharaGinka';
  		src: url('/font/OharaGinka-ywR2Y.otf');
		}
		
		 @font-face {
  		font-family: 'MagicRainbow';
  		src: url('/font/MagicRainbow-JRo5j.ttf');
        }
        
    </style>
</head>


<body>
<h1>BADMINTON CLUB</h1>

<form action="/playerform" >
  <button type="submit">Player Action's</button>
</form>
<form action="/matchform" >
  <button type="submit">Match Action's</button>
</form>
<form action="/paymentform" >
  <button type="submit">Payment Action's</button>
</form>

</body>
</html>
