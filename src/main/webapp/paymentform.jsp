<html>
<head>
   <style>
        /* Style for headings */
        h2 {
            font-family: 'Sun', sans-serif;
            color: #411656; /* Set heading color */
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
        input[type="text"], input[type="double"], input[type="integer"] {
            font-family: 'Smile', sans-serif;
            padding: 10px; /* Add padding */
            border: none; /* Remove border */
            border-radius: 5px; /* Round input edges */
            margin-top: 10px; /* Add top margin */
            box-shadow: 0px 0px 5px #888; /* Add box shadow */
            transition: box-shadow 0.3s ease-in-out; /* Add transition effect */
        }

        /* Add hover effect on input fields */
        input[type="text"]:hover, input[type="double"]:hover, input[type="integer"]:hover{
            box-shadow: 0px 0px 45px #888;
        }

        /* Style for labels */
        label {
            font-family: 'MagicRainbow', sans-serif;
            display: block; /* Display label in block */
            color: #FFFFF; /* Set label color */
            margin-top: 20px; /* Add top margin */
        }

        /* Center align all content within the body */
        body {
            text-align: center;
            background-image: url('sky4.jpg');
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
<h2>Create Payment</h2>
<form  method="post" action="/api/payments/phoneNumber/amount_paid" >
<label for="playerPhoneNumber">Player PhoneNumber:</label>
  <input type="text" id="playerPhoneNumber" name="playerPhoneNumber">
  <label for="amountPaid">Amount Paid:</label>
  <input type="integer" id="amount_paid" name="amountPaid"><br>
  <button type="submit">Update Amount</button>
</form>

<h2>Get Payment Detail</h2>
<form  method="get" action="/api/payments/phoneNumber" >    
  <label for="phoneNumber:">Player PhoneNumber:</label>
  <input type="integer" id="phoneNumber" name="phoneNumber"><br>
  <button type="submit">Get Payment's</button>
</form>
</body>
</html>
