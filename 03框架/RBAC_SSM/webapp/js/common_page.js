$(document).ready(
		function() {
			$(".btn_page").click(
					function() {
						$(":input[name='currentPage']").val(
								$(this).data("page")
										|| $(":input[name='currentPage']")
												.val() || 1);
						$("#searchForm").submit();
					});

			$(":input[name='pageSize']").change(function() {
				$("#searchForm").submit();
			});

			$(".btn_input").click(function() {
				window.location.href = $(this).data("url");
			});
		});