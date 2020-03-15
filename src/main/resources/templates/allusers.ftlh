<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Microgram</title>
</head>
<body>
  <div class="container">
      <div class="days flex flex-wrap">
        <#list users as user>
            <p>---------------------${user.login}-------------------</p>
            <p>Login: ${user.login}</p>
            <p>Email: ${user.email}</p>
            <a href="/publications/${user.id}">My publications ${user.publicationsCount}</a>
            <a href="/otherpublications/${user.id}">Other users publications</a>
            <p>Follows: ${user.subscribtionsCount} Followers: ${user.subscribersCount}</p>
            <p> <a href="/uifollow/${user.id}">Publications my follows</a> </p>
            <p>--------------------------------------------------------</p>
        </#list>
      </div>
    </div>
  </div>
</body>
</html>