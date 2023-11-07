<!DOCTYPE html>
<html>
<head>
    <title>CKEditor Demo</title>
    <script src="/ckeditor/ckeditor-4.20.js"></script>
</head>
<body>

<textarea name="editor1" id="editor1" rows="10" cols="80">
    This is my editor content.
</textarea>

<script>
    CKEDITOR.replace('editor1', {
        extraPlugins: 'embed',
        embed_provider: '//ckeditor.iframe.ly/api/oembed?url={url}&callback={callback}',
        // other configuration options...
    });
</script>

</body>
</html>

