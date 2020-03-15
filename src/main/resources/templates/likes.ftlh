<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Microgram</title>
</head>
<body>
  <div class="container">
      <div class="days flex flex-wrap">
          <p> Likes </p>
        <#list likes as like>
            <a href="/profile/${like.likeByUser.login}"> ${like.likeByUser.login} </a>
            <p>--------------------------------------------------------</p>
        </#list>
      </div>
    </div>
  </div>
</body>
</html>