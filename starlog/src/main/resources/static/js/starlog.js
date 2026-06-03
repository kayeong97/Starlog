(() => {
	const storageKey = "starlog.sidebarCollapsed";
	const applyState = () => {
		const collapsed = localStorage.getItem(storageKey) === "true";
		document.body.classList.toggle("sidebar-collapsed", collapsed);
	};

	applyState();

	document.addEventListener("click", (event) => {
		const toggle = event.target.closest(".sidebar-toggle");
		if (!toggle) {
			return;
		}
		const next = !document.body.classList.contains("sidebar-collapsed");
		localStorage.setItem(storageKey, String(next));
		applyState();
	});
})();
