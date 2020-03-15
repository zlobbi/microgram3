<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Microgram</title>
</head>
<body>
  <div class="container">
      <div class="days flex flex-wrap">
            <p>---------------------${user.login}-------------------</p>
            <p>Login: ${user.login}</p>
            <p>Email: ${user.email}</p>
            <a href="/publications/${user.id}">My publications ${user.publicationsCount}</a>
            <p>--------------------------------------------------------</p>
      </div>
    </div>
  </div>
</body>
</html>