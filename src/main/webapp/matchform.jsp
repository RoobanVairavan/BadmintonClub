<html>
<head>
    <style>
        /* Style for headings */
        h2 {
            font-family: 'Sun', sans-serif;
            color: #00a3e0; /* Set heading color */
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
        input[type="text"], input[type="double"],input[type="integer"] {
            font-family: 'Smile', sans-serif;
            padding: 10px; /* Add padding */
            border: none; /* Remove border */
            border-radius: 5px; /* Round input edges */
            margin-top: 10px; /* Add top margin */
            box-shadow: 0px 0px 5px #888; /* Add box shadow */
            transition: box-shadow 0.3s ease-in-out; /* Add transition effect */
        }

        /* Add hover effect on input fields */
        input[type="text"]:hover, input[type="double"]:hover input[type="integer"]:hover{
            box-shadow: 0px 0px 45px #888;
        }

        /* Style for labels */
        label {
            font-family: 'MagicRainbow', sans-serif;
            display: block; /* Display label in block */
            color: #555; /* Set label color */
            margin-top: 20px; /* Add top margin */
        }

        /* Center align all content within the body */
        body {
            text-align: center;
            background-image: url('sky3.jpg');
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
<h2>Start Match</h2>
<form action="/api/match/add" method="post" >
<label for="courtNo">CourtNo:</label>
  <input type="integer" id="courtNo" name="courtNo">
  <label for="player1PhoneNumber">Player One PhoneNumber:</label>
  <input type="text" id="player1PhoneNumber" name="player1PhoneNumber">
  <label for="player2PhoneNumber">Player Two PhoneNumber:</label>
  <input type="text" id="player2PhoneNumber" name="player2PhoneNumber"><br>
  <button type="submit">Start Match</button>
</form>

<h2>End Match</h2>
<form action="/api/match/end" >
<label for="courtNo">CourtNo:</label>
  <input type="integer" id="courtNo" name="courtNo">
  <label for="loserPhoneNumber">LoserPhoneNumber:</label>
  <input type="text" id="loserPhoneNumber" name="loserPhoneNumber"><br>
  <button type="submit">End Match</button>
</form>

<h2>Get Match's Between</h2>
<form method="get" action="/api/match/betweenAll"  >
<label for="startDateTime">StartDateTime:</label>
  <input type="datetime-local" id="startDateTime" name="startDateTime">
  <label for="endDateTime">EndDateTime:</label>
  <input type="datetime-local" id="endDateTime" name="endDateTime"><br>
  <button type="submit">Get Matches</button>
</form>

<h2>Get Match's Between By Player</h2>
<form method="get"  action="/api/match/PlayerAndTime" >
<label for="PlayerPhoneNumber">PlayerPhoneNumber:</label>
  <input type="text" id="PlayerPhoneNumber" name="PlayerPhoneNumber">
<label for="startDateTime">StartDateTime:</label>
  <input type="datetime-local" id="startDateTime" name="startDateTime">
  <label for="endDateTime">EndDateTime:</label>
  <input type="datetime-local" id="endDateTime" name="endDateTime"><br>
  <button type="submit">Get Matches</button>
</form>
</body>
</html>