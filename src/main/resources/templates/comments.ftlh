<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Microgram</title>
</head>
<body>
  <div class="container">
      <div class="days flex flex-wrap">
        <#list comments as com>
            <p>----------- Commented by: -${com.commentator.login}-------------------</p>
            <p>Comment: ${com.text}</p>
            <p>--------------------------------------------------------</p>
        </#list>
      </div>
    </div>
  </div>
</body>
</html>