<!DOCTYPE html>
<html>
<head>
    <title>Post Job</title>
    <link rel="stylesheet" href="/css/styles.css">
    <script src="/js/validation.js" defer></script>
</head>
<body>
    <h1>Post a New Job</h1>
    <form id="jobPostForm" action="post-job" method="post">
        <label for="title">Job Title:</label>
        <input type="text" id="title" name="title" required>
        <br>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>
        <br>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>
        <br>

        <label for="salary">Salary (Optional):</label>
        <input type="text" id="salary" name="salary">
        <br>

        <button type="submit">Post Job</button>
    </form>
</body>
</html>
