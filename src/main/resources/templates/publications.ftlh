<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Microgram</title>
</head>
<body>
  <div class="container">
      <div class="days flex flex-wrap">
        <#list publications as publ>
            <p>---------------------${publ.user.login}-------------------</p>
            <p>image: ${publ.image}</p>
            <p>description: ${publ.description}</p>
            <p>likes: <a href="/likes/${publ.id}">${publ.likesCount}</a> comments: <a href="/comments/${publ.id}"> ${publ.commentsCount} </a></p>
            <p>--------------------------------------------------------</p>
        </#list>
      </div>
    </div>
  </div>
</body>
</html>