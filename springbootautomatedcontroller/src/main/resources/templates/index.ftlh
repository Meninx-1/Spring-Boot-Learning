<!-- Here we assign current date time value to the now variable. -->
<#assign now = .now>
<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
<!--     We print the date in the short format -->
        <p>Today is: ${now?string.short}</p>
    </body>
</html>