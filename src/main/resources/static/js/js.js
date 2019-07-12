function hideIfNextEmpty(el) {
    var text = 'textContent' in document ? 'textContent' : 'innerText';
    if (el.nextElementSibling[text].replace(/\s/g, '').length === 0) {
        el.style.display = 'none';
    }
}

hideIfNextEmpty(document.querySelector('dt.hideIfDivEmpty'));