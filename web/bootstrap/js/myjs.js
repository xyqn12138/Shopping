$(document).ready(function() {
    // 为所有具有 'ajax-form' 类的表单绑定提交事件
    $('.myForm').on('submit', function(event) {
        event.preventDefault(); // 阻止表单默认提交行为

        var form = $(this);
        var formData = form.serialize(); // 序列化表单数据
        var formAction = form.attr('action') || window.location.pathname;
        var formMethod = form.attr('method') || 'GET';

        $.ajax({
            url: formAction,
            type: formMethod, // 可以是 'POST' 或者 'GET'
            data: formData,
            success: function(response) {
                console.log('Success:', response);
                // 在这里处理成功响应后的逻辑，可以考虑根据不同的表单执行不同操作
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                // 在这里处理错误逻辑
            }
        });
    });
});


document.getElementById('get-verification-code').addEventListener('click', function(event) {
    event.preventDefault(); // 防止默认行为（例如跳转）

    var countdownElement = document.getElementById('countdown');
    var getVerificationCodeLink = this;

    var count = 60;
    countdownElement.style.display = 'inline';
    getVerificationCodeLink.style.display = 'none'; // 隐藏链接

    var interval = setInterval(function() {
        countdownElement.textContent = '重新发送 (' + count + ')';
        if (--count < 0) {
            clearInterval(interval);
            countdownElement.style.display = 'none';
            getVerificationCodeLink.style.display = 'inline'; // 恢复链接显示
        }
    }, 1000); // 每秒执行一次
});