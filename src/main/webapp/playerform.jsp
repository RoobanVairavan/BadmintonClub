<html>
<head>
   <style>
        /* Style for headings */
        h2 {
            font-family: 'Sun', sans-serif;
            color: #70BBED; /* Set heading color */
            margin-top: 30px; /* Add top margin */
        }

        /* Style for buttons */
        button {
        	font-family: 'MagicRainbow', sans-serif;
            background-color: #ff0090; /* Set button color */
            color: white; /* Set text color */
            border-radius: 5px; /* Round button edges */
            padding: 10px 20px; /* Add padding */
            margin-top: 10px; /* Add top margin */
            border: none; /* Remove button border */
            cursor: pointer; /* Add pointer cursor on hover */
        }

        /* Style for input fields */
            input[type="text"], input[type="double"] {
            font-family: 'Smile', sans-serif;
            padding: 10px; /* Add padding */
            border: none; /* Remove border */
            border-radius: 5px; /* Round input edges */
            margin-top: 10px; /* Add top margin */
            box-shadow: 0px 0px 5px #888; /* Add box shadow */
            transition: box-shadow 0.3s ease-in-out; /* Add transition effect */
        }

        /* Add hover effect on input fields */
        input[type="text"]:hover, input[type="double"]:hover {
            box-shadow: 0px 0px 30px #888;
        }

        /* Style for labels */
        label {
            font-family: 'MagicRainbow', sans-serif;
            display: block; /* Display label in block */
            color: #FFFEFF; /* Set label color */
            margin-top: 20px; /* Add top margin */
        }

        /* Center align all content within the body */
        body {
            text-align: center;
            background-image: url('sky2.jpg');
            background-size: cover;
            background-position: center center;
        }
        
		 @font-face{
			font-family: 'Sun';
			src: url('/font/sun.otf');
		}
		 @font-face{
			font-family: 'Smile';
			src: url('/font/YourSmile-yA2V.ttf');
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
<h2>Get All Players</h2>
<form method="GET" action="api/player/all">
    <button type="submit">Get All Players</button>
</form>

<h2>Get Player</h2>
<form method="GET" action="/api/player/phoneNumber">
    <label for="phone_number">Phone Number:</label>
    <input type="text" id="phone_number" name="phoneNumber">
    <button type="submit">Get Player</button>
</form>

<h2>Add Player</h2>
<form action="/api/player/add" method="post" >
  <label for="phone_number">Phone Number:</label>
  <input type="text" id="phone_number" name="phoneNumber">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
  <label for="accountBalance">Balance:</label>
  <input type="double" id="accountBalance" name="accountBalance">
  <button type="submit">Add Player</button>
</form>

</body>
</html>
